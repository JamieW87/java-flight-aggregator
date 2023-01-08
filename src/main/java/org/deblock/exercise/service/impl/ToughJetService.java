package org.deblock.exercise.service.impl;

import org.deblock.exercise.model.rest.DeblockRequest;
import org.deblock.exercise.model.rest.DeblockResponse;
import org.deblock.exercise.model.rest.toughjet.ToughJetRequest;
import org.deblock.exercise.model.rest.toughjet.ToughJetResponse;
import org.deblock.exercise.service.SupplierService;
import org.deblock.exercise.transformer.toughjet.ToughJetTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Qualifier("toughjet")
public class ToughJetService implements SupplierService {

    @Autowired
    private ToughJetTransformer transformer;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public DeblockResponse GetFlightData(DeblockRequest dRequest){

        ToughJetRequest req = transformer.toTJRequest(dRequest);
        System.out.println(req.toString());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<ToughJetRequest> request = new HttpEntity<>(req, headers);

        ResponseEntity<ToughJetResponse> response = restTemplate.exchange(
                "https://www.toughjetSzs/api/flights",
                HttpMethod.POST,
                request,
                ToughJetResponse.class
        );

        //Status code checks
        //Null checks
        DeblockResponse dResp = transformer.toDResponse(response.getBody());



        return dResp;

    }
}
