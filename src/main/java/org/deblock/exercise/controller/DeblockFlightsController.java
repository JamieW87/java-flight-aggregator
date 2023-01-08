package org.deblock.exercise.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    private static final Logger logger = LogManager.getLogger(DeblockFlightsController.class);

    @Autowired
    private DeblocksFlightsService service;

    @PostMapping
    public ResponseEntity fetchFlights(@RequestBody @Valid DeblockRequest deblockRequest) {
        logger.info("Request received");

        logger.debug(String.format("Passing request to suppliers: %s", deblockRequest.toString()));
        DeblockResponse[] response = service.FetchFlightData(deblockRequest);

        logger.info("Successfully processed request, returning response");
        return ResponseEntity.ok(response);

    }
}
