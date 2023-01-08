package org.deblock.exercise.service.impl;

import org.deblock.exercise.model.rest.DeblockRequest;
import org.deblock.exercise.model.rest.DeblockResponse;
import org.deblock.exercise.service.SupplierService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("crazyair")
public class CrazyAirService implements SupplierService {

    @Override
    public DeblockResponse GetFlightData(DeblockRequest request){

        //Transform DRequest to CARequest
        //Send via HTTP to CA
        //Transform response to DResponse
        //Return

        System.out.println("CrazyAir babbbyyy!");

    }
}
