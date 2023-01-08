package org.deblock.exercise.transformer.toughjet;

import org.deblock.exercise.model.rest.DeblockRequest;
import org.deblock.exercise.model.rest.DeblockResponse;
import org.deblock.exercise.model.rest.toughjet.ToughJetRequest;
import org.deblock.exercise.model.rest.toughjet.ToughJetResponse;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ToughJetTransformer {

    public ToughJetRequest toTJRequest(DeblockRequest dRequest) {

        ToughJetRequest tjReq = new ToughJetRequest();

        tjReq.setFrom(dRequest.getOrigin());
        tjReq.setTo(dRequest.getDestination());
        tjReq.setOutboundDate(dRequest.getDepartureDate());
        tjReq.setInboundDate(dRequest.getReturnDate());
        tjReq.setNumberOfAdults(dRequest.getNumberOfPassengers());

        return tjReq;

    }

    public DeblockResponse toDResponse(ToughJetResponse tjResp) {

        DeblockResponse dResp = new DeblockResponse();

        //Assuming discount percentage is supplied by toughjet as a whole integer ( 10% would be 10)
        int discount = tjResp.getDiscount() / 100;
        float fare = tjResp.getBasePrice() + tjResp.getTax();
        if (discount != 0) {
            fare = fare - discount * fare;
        }

        Date departure = new Date(tjResp.getOutboundDateTime().toEpochMilli());
        Date arrival = new Date(tjResp.getInboundDateTime().toEpochMilli());

        dResp.setAirline(tjResp.getCarrier());
        dResp.setSupplier("ToughJet");
        dResp.setFare(fare);
        dResp.setDepartureAirportCode(tjResp.getDepartureAirportCode());
        dResp.setDestinationAirportCode(tjResp.getDestinationAirportCode());
        dResp.setDepartureDate(departure);
        dResp.setArrivalDate(arrival);

        return dResp;
    }
}
