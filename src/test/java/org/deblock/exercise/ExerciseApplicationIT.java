//package org.deblock.exercise;
//
//import com.github.tomakehurst.wiremock.WireMockServer;
//import com.github.tomakehurst.wiremock.client.WireMock;
//import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
//import com.github.tomakehurst.wiremock.extension.responsetemplating.ResponseTemplateTransformer;
//import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo;
//import com.github.tomakehurst.wiremock.junit5.WireMockTest;
//import org.deblock.exercise.model.rest.DeblockRequest;
//import org.deblock.exercise.model.rest.DeblockResponse;
//import org.deblock.exercise.service.impl.CrazyAirService;
//import org.deblock.exercise.service.impl.ToughJetService;
//import org.junit.jupiter.api.*;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//
//import static com.github.tomakehurst.wiremock.client.WireMock.*;
//import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
//
//@WireMockTest(httpPort = 8089)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class ExerciseApplicationIT {
//
//    @Value("/api/flights")
//    String mockBaseUrl;
//
//    @Mock
//    private DeblockRequest deblockReq;
//
//    @Autowired
//    private CrazyAirService crazyAirService;
//
//    @Autowired
//    private ToughJetService toughJetService;
//
//    // **** Wiremock setup Start
//    private static WireMockServer wireMockServer;
//
//    @BeforeAll
//    static void startWireMock() {
//        wireMockServer = new WireMockServer(
//                WireMockConfiguration.wireMockConfig()
//                        .port(9999)
//                        .extensions(new ResponseTemplateTransformer(true))
//        );
//        wireMockServer.start();
//    }
//
//    @AfterAll
//    static void stopWireMock() {
//        wireMockServer.stop();
//    }
//
//    @BeforeEach
//    void clearWireMock() {
//        System.out.println("Stored stubbings: " + wireMockServer.getStubMappings().size());
//        wireMockServer.resetAll();
//        System.out.println("Stored stubbings after reset: " + wireMockServer.getStubMappings().size());
//    }
//
//    @Test
//    @DisplayName("Tests the successful retrieval of flight data")
//    public void testValidResponseBodyReturnsDataFromSuppliers() {
//
//        String urlPath = "/api/flights";
//        wireMockServer.stubFor(WireMock.post(WireMock.urlEqualTo(urlPath))
//                .willReturn(
//                        aResponse()
//                                .withStatus(200)
//                                .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
//                                .withBodyFile("mock-api/student_response.json"))
//        );
//
//        DeblockResponse response = crazyAirService.GetFlightData(deblockReq);
//
//        assertThat(response).isNotNull();
//        assertThat(response).isEqualTo(deblockReq);
//
//
//
//
//    }
//}
