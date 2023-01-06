package org.deblock.exercise.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class DeblockRequest {

    @NotNull
    @JsonProperty("origin")
    private String origin;
}
