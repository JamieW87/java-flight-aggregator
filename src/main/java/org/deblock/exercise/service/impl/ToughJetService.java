package org.deblock.exercise.service.impl;

import org.deblock.exercise.exception.ClientErrorException;
import org.deblock.exercise.exception.NoDataFoundException;
import org.deblock.exercise.model.rest.DeblockRequest;
import org.deblock.exercise.model.rest.DeblockResponse;
import org.deblock.exercise.model.rest.toughjet.ToughJetRequest;
import org.deblock.exercise.model.rest.toughjet.ToughJetResponse;
import org.deblock.exercise.service.SupplierService;
import org.deblock.exercise.transformer.toughjet.ToughJetTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Qualifier("toughjet")
public class ToughJetService implements SupplierService {

    @Value("${toughjet.baseURL}")
    private String toughjetUrl;

    @Autowired
    private ToughJetTransformer transformer;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public DeblockResponse GetFlightData(DeblockRequest dRequest){

        ToughJetRequest req = transformer.toTJRequest(dRequest);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<ToughJetRequest> request = new HttpEntity<>(req, headers);

        ResponseEntity<ToughJetResponse> response = restTemplate.exchange(
                toughjetUrl + "/api/flights",
                HttpMethod.POST,
                request,
                ToughJetResponse.class
        );
        if (response.getStatusCode() != HttpStatus.OK)  {
            throw new ClientErrorException();
        }
        if (response.getBody() == null) {
            throw new NoDataFoundException();
        }

        return transformer.toDResponse(response.getBody());

    }
}
