package org.deblock.exercise.service.impl;

import org.deblock.exercise.model.rest.DeblockRequest;
import org.deblock.exercise.model.rest.DeblockResponse;
import org.deblock.exercise.model.rest.toughjet.ToughJetRequest;
import org.deblock.exercise.model.rest.toughjet.ToughJetResponse;
import org.deblock.exercise.transformer.toughjet.ToughJetTransformer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ToughJetServiceTest {

    @Mock
    private ToughJetTransformer transformer;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private ToughJetService toughJetService;

    //Happy :)
    @Test
    void testGetFlightDataSuccess() {

        DeblockRequest dRequest = new DeblockRequest();
        ToughJetRequest req = new ToughJetRequest();
        ToughJetResponse tjr = new ToughJetResponse();
        DeblockResponse expected = new DeblockResponse();


        when(transformer.toTJRequest(dRequest)).thenReturn(req);
        when(restTemplate.exchange(anyString(), any(HttpMethod.class), any(HttpEntity.class), eq(ToughJetResponse.class)))
                .thenReturn(new ResponseEntity<>(tjr, HttpStatus.OK));
        when(transformer.toDResponse(tjr)).thenReturn(expected);

        DeblockResponse actual = toughJetService.GetFlightData(dRequest);

        assertEquals(expected, actual);
        verify(transformer).toTJRequest(dRequest);
        verify(restTemplate).exchange(
                anyString(), any(HttpMethod.class), any(HttpEntity.class), eq(ToughJetResponse.class));
        verify(transformer).toDResponse(tjr);
    }
}
