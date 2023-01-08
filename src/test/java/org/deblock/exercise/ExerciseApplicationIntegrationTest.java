package org.deblock.exercise;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import org.deblock.exercise.model.rest.DeblockRequest;
import org.junit.jupiter.api.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

@WireMockTest(httpPort = 8089)
public class ExerciseApplicationIntegrationTest {


    DeblockRequest mockDebReq = new DeblockRequest();


    @Test
    public void testValidResponseBodyReturnsDataFromSuppliers() {


        stubFor(post("/flights")
                .withRequestBody(equalToJson("{'name':'jamie'}"))
                .willReturn(ok("{}")));


    }
}
