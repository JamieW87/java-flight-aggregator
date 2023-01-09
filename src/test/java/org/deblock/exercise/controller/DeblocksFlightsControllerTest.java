package org.deblock.exercise.controller;

import org.deblock.exercise.model.rest.DeblockRequest;
import org.deblock.exercise.model.rest.DeblockResponse;
import org.deblock.exercise.service.DeblocksFlightsService;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@Tag("UNIT")
public class DeblocksFlightsControllerTest {

    @Mock
    private DeblocksFlightsService service;

    @InjectMocks
    private DeblockFlightsController controller;

    @Test
    public void testFetchFlights() {
        DeblockRequest deblockRequest = new DeblockRequest();
        DeblockResponse[] expectedResponse = new DeblockResponse[0];
        when(service.FetchFlightData(deblockRequest)).thenReturn(expectedResponse);

        ResponseEntity<DeblockResponse[]> actualResponse = controller.fetchFlights(deblockRequest);

        assertEquals(expectedResponse, actualResponse.getBody());
        assertEquals(200, actualResponse.getStatusCodeValue());
    }
}
