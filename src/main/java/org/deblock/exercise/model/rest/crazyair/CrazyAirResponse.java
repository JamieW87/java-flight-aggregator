package org.deblock.exercise.model.rest.crazyair;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class CrazyAirResponse {

    @JsonProperty("airline")
    private String airline;

    @JsonProperty("price")
    private Float price;

    @JsonProperty("cabinClass")
    private String cabinClass;

    @JsonProperty("departureAirportCode")
    private String departureAirportCode;

    @JsonProperty("desinationAirportCode")
    private String destinationAirportCode;

    @JsonProperty("departureDate")
    private LocalDate departureDate;

    @JsonProperty("arrivalDate")
    private LocalDate arrivalDate;

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getCabinClass() {
        return cabinClass;
    }

    public void setCabinClass(String cabinClass) {
        this.cabinClass = cabinClass;
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

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
}
