package org.deblock.exercise.service.impl;

import org.deblock.exercise.model.rest.DeblockRequest;
import org.deblock.exercise.model.rest.DeblockResponse;
import org.deblock.exercise.model.rest.crazyair.CrazyAirRequest;
import org.deblock.exercise.model.rest.crazyair.CrazyAirResponse;
import org.deblock.exercise.model.rest.toughjet.ToughJetRequest;
import org.deblock.exercise.model.rest.toughjet.ToughJetResponse;
import org.deblock.exercise.service.SupplierService;
import org.deblock.exercise.transformer.crazyair.CrazyAirTransformer;
import org.deblock.exercise.transformer.toughjet.ToughJetTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Qualifier("crazyair")
public class CrazyAirService implements SupplierService {

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
                "https://www.CrazyAir.com/api/flights",
                HttpMethod.POST,
                request,
                CrazyAirResponse.class
        );

        //Status code checks
        //Null checks
        DeblockResponse dResp = transformer.toDResponse(response.getBody());

        return dResp;

    }
}
