package org.deblock.exercise.model.rest;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class DeblockResponse {

    @JsonProperty("airline")
    public String airline;

    @JsonProperty("supplier")
    public String supplier;

    @JsonProperty("fare")
    public Float fare;

    @JsonProperty("departureAirportCode")
    public String departureAirportCode;

    @JsonProperty("destinationAirportCode")
    public String destinationAirportCode;

    @JsonProperty("departureDate")
    public LocalDate departureDate;

    @JsonProperty("arrivalDate")
    public LocalDate arrivalDate;
}
