package org.deblock.exercise.model.rest.toughjet;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;
import java.time.LocalDate;

public class ToughJetResponse {

    @JsonProperty("carrier")
    public String carrier;

    @JsonProperty("basePrice")
    public Float basePrice;

    @JsonProperty("tax")
    public Float tax;

    @JsonProperty("discount")
    public Integer discount;

    @JsonProperty("departureAirportName")
    public String departureAirportCode;

    @JsonProperty("arrivalAirportName")
    public String destinationAirportCode;

    @JsonProperty("outboundDateTime")
    public Instant outboundDateTime;

    @JsonProperty("inboundDateTime")
    public Instant inboundDateTime;
}
