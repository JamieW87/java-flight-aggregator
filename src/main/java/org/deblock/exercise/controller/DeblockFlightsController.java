package org.deblock.exercise.controller;


import org.deblock.exercise.model.rest.DeblockRequest;

import javax.validation.Valid;

import org.deblock.exercise.model.rest.DeblockResponse;
import org.deblock.exercise.service.DeblocksFlightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@RestController
@RequestMapping(value = "/flights")
public class DeblockFlightsController {

    @Autowired
    private DeblocksFlightsService service;

    @PostMapping
    public void fetchFlights(@RequestBody @Valid DeblockRequest deblockRequest) {

        DeblockResponse[] response = service.FetchFlightData(deblockRequest);

        //Handle Errors
        //Return response


        System.out.println(Arrays.toString(response));



    }
}
