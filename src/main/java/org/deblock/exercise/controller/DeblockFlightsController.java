package org.deblock.exercise.controller;


import org.deblock.exercise.model.rest.DeblockRequest;

import javax.validation.Valid;

import org.deblock.exercise.model.rest.DeblockResponse;
import org.deblock.exercise.service.DeblocksFlightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping(value = "/flights")
public class DeblockFlightsController {

    @Autowired
    private DeblocksFlightsService service;

    @PostMapping
    public ResponseEntity fetchFlights(@RequestBody @Valid DeblockRequest deblockRequest) {

        DeblockResponse[] response = service.FetchFlightData(deblockRequest);

        //Remove this
        System.out.println(Arrays.toString(response));

        return ResponseEntity.ok(response);

    }
}
