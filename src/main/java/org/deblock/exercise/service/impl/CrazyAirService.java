package org.deblock.exercise.service.impl;

import org.deblock.exercise.exception.ClientErrorException;
import org.deblock.exercise.exception.NoDataFoundException;
import org.deblock.exercise.model.rest.DeblockRequest;
import org.deblock.exercise.model.rest.DeblockResponse;
import org.deblock.exercise.model.rest.crazyair.CrazyAirRequest;
import org.deblock.exercise.model.rest.crazyair.CrazyAirResponse;
import org.deblock.exercise.service.SupplierService;
import org.deblock.exercise.transformer.crazyair.CrazyAirTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Qualifier("crazyair")
public class CrazyAirService implements SupplierService {

    @Value("${crazyair.baseURL}")
    private String crazyairUrl;

    @Autowired
    private CrazyAirTransformer transformer;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public DeblockResponse GetFlightData(DeblockRequest dRequest){

        CrazyAirRequest req = transformer.toCARequest(dRequest);
        System.out.println(req.toString());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<CrazyAirRequest> request = new HttpEntity<>(req, headers);

        ResponseEntity<CrazyAirResponse> response = restTemplate.exchange(
                crazyairUrl + "/api/flights",
                HttpMethod.POST,
                request,
                CrazyAirResponse.class
        );

        if (response.getStatusCode() != HttpStatus.OK)  {
            throw new ClientErrorException();
        }
        if (response.getBody() == null) {
            throw new NoDataFoundException();
        }

        DeblockResponse dResp = transformer.toDResponse(response.getBody());

        return dResp;

    }
}
