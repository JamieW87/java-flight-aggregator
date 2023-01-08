package org.deblock.exercise.service.impl;

import org.deblock.exercise.exception.ClientErrorException;
import org.deblock.exercise.exception.NoDataFoundException;
import org.deblock.exercise.model.rest.DeblockRequest;
import org.deblock.exercise.model.rest.DeblockResponse;
import org.deblock.exercise.model.rest.crazyair.CrazyAirRequest;
import org.deblock.exercise.model.rest.crazyair.CrazyAirResponse;
import org.deblock.exercise.transformer.crazyair.CrazyAirTransformer;
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
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CrazyAirServiceTest {

    @Mock
    private CrazyAirTransformer transformer;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private CrazyAirService crazyAirService;

    //Happy :)
    @Test
    void testGetFlightDataSuccess() {

        DeblockRequest dRequest = new DeblockRequest();
        CrazyAirRequest req = new CrazyAirRequest();
        CrazyAirResponse car = new CrazyAirResponse();
        DeblockResponse expected = new DeblockResponse();


        when(transformer.toCARequest(dRequest)).thenReturn(req);
        when(restTemplate.exchange(anyString(), any(HttpMethod.class), any(HttpEntity.class), eq(CrazyAirResponse.class)))
                .thenReturn(new ResponseEntity<>(car, HttpStatus.OK));
        when(transformer.toDResponse(car)).thenReturn(expected);

        DeblockResponse actual = crazyAirService.GetFlightData(dRequest);

        assertEquals(expected, actual);
        verify(transformer).toCARequest(dRequest);
        verify(restTemplate).exchange(
                anyString(), any(HttpMethod.class), any(HttpEntity.class), eq(CrazyAirResponse.class));
        verify(transformer).toDResponse(car);
    }

    //Client error exception :(
    @Test
    void testGetFlightDataClientErrorExc() {

        DeblockRequest dRequest = new DeblockRequest();
        CrazyAirRequest req = new CrazyAirRequest();
        CrazyAirResponse car = new CrazyAirResponse();

        when(transformer.toCARequest(dRequest)).thenReturn(req);
        when(restTemplate.exchange(
                anyString(), any(HttpMethod.class), any(HttpEntity.class), eq(CrazyAirResponse.class)))
                .thenReturn(new ResponseEntity<>(car, HttpStatus.BAD_REQUEST));

        assertThrows(ClientErrorException.class, () -> crazyAirService.GetFlightData(dRequest));
        verify(transformer).toCARequest(dRequest);
        verify(restTemplate).exchange(
                anyString(), any(HttpMethod.class), any(HttpEntity.class), eq(CrazyAirResponse.class));
    }

    //NoDataException :(
    @Test
    void testGetFlightDataNoData() {

        DeblockRequest dRequest = new DeblockRequest();
        CrazyAirRequest req = new CrazyAirRequest();
        CrazyAirResponse car = null;

        when(transformer.toCARequest(dRequest)).thenReturn(req);
        when(restTemplate.exchange(
                anyString(), any(HttpMethod.class), any(HttpEntity.class), eq(CrazyAirResponse.class)))
                .thenReturn(new ResponseEntity<>(car, HttpStatus.OK));

        assertThrows(NoDataFoundException.class, () -> crazyAirService.GetFlightData(dRequest));
        verify(transformer).toCARequest(dRequest);
        verify(restTemplate).exchange(
                anyString(), any(HttpMethod.class), any(HttpEntity.class), eq(CrazyAirResponse.class));
    }
}

