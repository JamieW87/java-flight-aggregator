package org.deblock.exercise.controller;


import org.deblock.exercise.model.rest.DeblockRequest;

import javax.validation.Valid;

import org.deblock.exercise.service.SupplierService;
import org.deblock.exercise.service.impl.CrazyAirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping(value = "/flights")
public class DeblockFlightsController {

    private final SupplierService CAService;
    private final SupplierService TJService;

    @Autowired
    public DeblockFlightsController(@Qualifier("crazyair") SupplierService CAservice,
                                    @Qualifier("toughjet") SupplierService TJService) {
        this.CAService = CAservice;
        this.TJService = TJService;
    }


    @PostMapping
    public void fetchFlights(@RequestBody @Valid DeblockRequest deblockRequest) {

        // Instantiate new array of deblock response

        //-Parallelize these
        CAService.GetFlightData(deblockRequest);
        TJService.GetFlightData(deblockRequest);

        //Services return DeblockResponse
        //Append returns to deblockResponseArray
        //Return array

        System.out.println(deblockRequest.toString());



    }
}
