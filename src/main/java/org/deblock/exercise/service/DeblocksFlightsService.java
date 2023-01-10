package org.deblock.exercise.service;

import org.deblock.exercise.model.rest.DeblockRequest;
import org.deblock.exercise.model.rest.DeblockResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeblocksFlightsService {

    private final List<SupplierService> supplierServices;

    @Autowired
    public DeblocksFlightsService(List<SupplierService> supplierServices) {
        this.supplierServices = supplierServices;
    }

    public DeblockResponse[] FetchFlightData(DeblockRequest deblockRequest) {

        List<DeblockResponse> responseList = new ArrayList<>();

        supplierServices.parallelStream().forEach(svc -> {
            DeblockResponse resp = svc.GetFlightData(deblockRequest);
            responseList.add(resp);
        });

        return responseList.toArray(new DeblockResponse[responseList.size()]);
    }
}
