package org.deblock.exercise.service;

import org.deblock.exercise.model.rest.DeblockRequest;
import org.deblock.exercise.model.rest.DeblockResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeblocksFlightsService {

    private final SupplierService CAService;
    private final SupplierService TJService;

    @Autowired
    public DeblocksFlightsService(@Qualifier("crazyair") SupplierService caService,
                                  @Qualifier("toughjet") SupplierService tjService) {
        this.CAService = caService;
        this.TJService = tjService;
    }

    public DeblockResponse[] FetchFlightData(DeblockRequest deblockRequest) {

        List<DeblockResponse> responseList = new ArrayList<>();

        DeblockResponse caResponse = CAService.GetFlightData(deblockRequest);
        DeblockResponse tjResponse = TJService.GetFlightData(deblockRequest);

        responseList.add(caResponse);
        responseList.add(tjResponse);

        return responseList.toArray(new DeblockResponse[responseList.size()]);

    }
}
