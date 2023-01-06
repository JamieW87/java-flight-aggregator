package org.deblock.exercise.controller;


import org.deblock.exercise.model.DeblockRequest;
import org.deblock.exercise.model.DeblockResponse;
import org.deblock.exercise.service.SupplierService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(value = "/flights")
public class DeblockFlightsController {
    @Autowired
    private SupplierService supplierService;

    @PostMapping
    public void fetchFlights(@RequestBody @Valid DeblockRequest deblockRequest) {

    }
}
