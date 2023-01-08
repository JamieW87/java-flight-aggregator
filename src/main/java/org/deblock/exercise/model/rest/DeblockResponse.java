package org.deblock.exercise.model.rest;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class DeblockResponse {

    @JsonProperty("airline")
    private String airline;

    @JsonProperty("supplier")
    private String supplier;

    @JsonProperty("fare")
    private Float fare;

    @JsonProperty("departureAirportCode")
    private String departureAirportCode;

    @JsonProperty("destinationAirportCode")
    private String destinationAirportCode;

    @JsonProperty("departureDate")
    private Date departureDate;

    @JsonProperty("arrivalDate")
    private Date arrivalDate;

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Float getFare() {
        return fare;
    }

    public void setFare(Float fare) {
        this.fare = fare;
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

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
}
