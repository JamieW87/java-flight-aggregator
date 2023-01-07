package org.deblock.exercise.controller;


import org.deblock.exercise.model.rest.DeblockRequest;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(value = "/flights")
public class DeblockFlightsController {
//    @Autowired
//    private SupplierService supplierService;

    @PostMapping
    public void fetchFlights(@RequestBody @Valid DeblockRequest deblockRequest) {

        System.out.println(deblockRequest.toString());

    }
}
