package org.deblock.exercise.model.rest.toughjet;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;
import java.time.LocalDate;

public class ToughJetResponse {

    @JsonProperty("carrier")
    private String carrier;

    @JsonProperty("basePrice")
    private Float basePrice;

    @JsonProperty("tax")
    private Float tax;

    @JsonProperty("discount")
    private Integer discount;

    @JsonProperty("departureAirportName")
    private String departureAirportCode;

    @JsonProperty("arrivalAirportName")
    private String destinationAirportCode;

    @JsonProperty("outboundDateTime")
    private Instant outboundDateTime;

    @JsonProperty("inboundDateTime")
    private Instant inboundDateTime;

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public Float getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Float basePrice) {
        this.basePrice = basePrice;
    }

    public Float getTax() {
        return tax;
    }

    public void setTax(Float tax) {
        this.tax = tax;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public void setDepartureAirportCode(String departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    public String getDestinationAirportCode() {
        return destinationAirportCode;
    }

    public void setDestinationAirportCode(String destinationAirportCode) {
        this.destinationAirportCode = destinationAirportCode;
    }

    public Instant getOutboundDateTime() {
        return outboundDateTime;
    }

    public void setOutboundDateTime(Instant outboundDateTime) {
        this.outboundDateTime = outboundDateTime;
    }

    public Instant getInboundDateTime() {
        return inboundDateTime;
    }

    public void setInboundDateTime(Instant inboundDateTime) {
        this.inboundDateTime = inboundDateTime;
    }
}
