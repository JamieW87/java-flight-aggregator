package org.deblock.exercise.transformer.crazyair;


import org.deblock.exercise.model.rest.DeblockRequest;
import org.deblock.exercise.model.rest.DeblockResponse;
import org.deblock.exercise.model.rest.crazyair.CrazyAirRequest;
import org.deblock.exercise.model.rest.crazyair.CrazyAirResponse;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.util.Date;

@Component
public class CrazyAirTransformer {

    public CrazyAirRequest toCARequest(DeblockRequest dReq) {

        CrazyAirRequest caReq = new CrazyAirRequest();

        caReq.setOrigin(dReq.getOrigin());
        caReq.setDestination(dReq.getDestination());
        caReq.setDepartureDate(dReq.getDepartureDate());
        caReq.setReturnDate(dReq.getReturnDate());
        caReq.setPassengerCount(dReq.getNumberOfPassengers());
        return caReq;

    }

    public DeblockResponse toDResponse(CrazyAirResponse caResp) {

        DeblockResponse dResp = new DeblockResponse();

        Date depDate = Date.from(caResp.getDepartureDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date arrDate = Date.from(caResp.getArrivalDate().atStartOfDay(ZoneId.systemDefault()).toInstant());

        dResp.setAirline(caResp.getAirline());
        dResp.setSupplier("CrazyAir");
        dResp.setFare(caResp.getPrice());
        dResp.setDepartureAirportCode(caResp.getDepartureAirportCode());
        dResp.setDestinationAirportCode(caResp.getDestinationAirportCode());
        dResp.setDepartureDate(depDate);
        dResp.setArrivalDate(arrDate);

        return dResp;
    }
}
