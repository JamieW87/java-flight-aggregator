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
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(value = "/flights")
public class CrazyAirController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping
    public DeblockResponse fetchRecords(@RequestBody @Valid DeblockRequest deblockRequest) {

    }
}
