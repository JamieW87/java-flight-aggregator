package org.deblock.exercise.service;

import org.deblock.exercise.model.rest.DeblockRequest;
import org.deblock.exercise.model.rest.DeblockResponse;

public interface SupplierService {
    DeblockResponse GetFlightData(DeblockRequest request);
}
