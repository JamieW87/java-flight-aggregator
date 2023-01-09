package org.deblock.exercise;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.extension.responsetemplating.ResponseTemplateTransformer;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import org.deblock.exercise.controller.DeblockFlightsController;
import org.deblock.exercise.model.rest.DeblockRequest;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@WireMockTest(httpPort = 8089)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ExerciseApplicationIT {

    String mockTJReq = "{\n" +
            "  \"from\":\"LHR\",\n" +
            "  \"to\": \"MIA\",\n" +
            "  \"outboundDate\": [ 2024, 11, 12 ],\n" +
            "  \"inboundDate\": [ 2023, 12, 11 ],\n" +
            "  \"numberOfAdults\":3\n" +
            "}";

    String mockCAReq = "{\n" +
            "  \"origin\":\"LHR\",\n" +
            "  \"destination\": \"MIA\",\n" +
            "  \"departureDate\": [ 2024, 11, 12 ],\n" +
            "  \"returnDate\": [ 2023, 12, 11 ],\n" +
            "  \"passengerCount\":3\n" +
            "}";

    @Value("${mock.base.url}")
    String mockBaseUrl;

    @Autowired
    private DeblockFlightsController controller;

    // **** Wiremock setup Start
    private static WireMockServer wireMockServer;

    @BeforeAll
    static void startWireMock() {
        wireMockServer = new WireMockServer(
                WireMockConfiguration.wireMockConfig()
                        .port(9090)
                        .extensions(new ResponseTemplateTransformer(true))
        );
        wireMockServer.start();
    }

    @AfterAll
    static void stopWireMock() {
        wireMockServer.stop();
    }

    @BeforeEach
    void clearWireMock() {
        System.out.println("Stored stubbings: " + wireMockServer.getStubMappings().size());
        wireMockServer.resetAll();
        System.out.println("Stored stubbings after reset: " + wireMockServer.getStubMappings().size());
    }

    @Test
    @DisplayName("Tests the successful retrieval of flight data")
    public void testValidResponseBodyReturnsDataFromSuppliers() {

        DeblockRequest debReq = new DeblockRequest();
        debReq.setOrigin("LHR");
        debReq.setDestination("MIA");
        debReq.setDepartureDate(LocalDate.parse("2024-11-12"));
        debReq.setReturnDate(LocalDate.parse("2023-12-11"));
        debReq.setNumberOfPassengers(3);

        String urlPathTJ = "/api/flights";
        wireMockServer.stubFor(WireMock.post(WireMock.urlEqualTo(urlPathTJ)).withRequestBody(equalToJson(mockTJReq))
                .willReturn(
                        aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                                .withBodyFile("mock-api/toughJetResponse.json"))
        );

        String urlPathCA = "/api/caflights";
        wireMockServer.stubFor(WireMock.post(WireMock.urlEqualTo(urlPathCA)).withRequestBody(equalToJson(mockCAReq))
                .willReturn(
                        aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                                .withBodyFile("mock-api/crazyairResponse.json"))
        );

        ResponseEntity response = controller.fetchFlights(debReq);

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode().is2xxSuccessful());
        assertThat(response.hasBody());

//        assertThat(response.getData().getUuid()).isNotNull();
//        assertThat(response.getData().getCreationDate()).isNotNull();
//        assertThat(response.getData().getFirstName()).isNotNull();
//        assertThat(response.getData().getLastName()).isNotNull();
    }
}
