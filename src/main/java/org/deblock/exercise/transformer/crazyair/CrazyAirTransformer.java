package org.deblock.exercise.transformer.crazyair;


import org.deblock.exercise.model.rest.DeblockRequest;
import org.deblock.exercise.model.rest.DeblockResponse;
import org.deblock.exercise.model.rest.crazyair.CrazyAirRequest;
import org.deblock.exercise.model.rest.crazyair.CrazyAirResponse;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CrazyAirTransformer {

    public CrazyAirRequest toCARequest(DeblockRequest dRequest) {

        CrazyAirRequest caReq = new CrazyAirRequest();

        return caReq;

    }

    public DeblockResponse toDResponse(CrazyAirResponse caResp) {

        DeblockResponse dResp = new DeblockResponse();

        return dResp;
    }
}
