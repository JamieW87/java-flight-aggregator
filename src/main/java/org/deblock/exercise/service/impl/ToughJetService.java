package org.deblock.exercise.service.impl;

import org.deblock.exercise.model.rest.DeblockRequest;
import org.deblock.exercise.service.SupplierService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("toughjet")
public class ToughJetService implements SupplierService {

    @Override
    public void GetFlightData(DeblockRequest request){

        //Transform DRequest to CARequest
        //Send via HTTP to CA
        //Transform response to DResponse
        //Return
        System.out.println("Toughjet babbbyyy!");

    }
}
