package org.deblock.exercise.model.rest.crazyair;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class CrazyAirResponse {

    @JsonProperty("airline")
    public String airline;

    @JsonProperty("price")
    public Float price;

    @JsonProperty("cabinClass")
    public String cabinClass;

    @JsonProperty("departureAirportCode")
    public String departureAirportCode;

    @JsonProperty("desinationAirportCode")
    public String destinationAirportCode;

    @JsonProperty("departureDate")
    public LocalDate departureDate;

    @JsonProperty("arrivalDate")
    public LocalDate arrivalDate;
}
