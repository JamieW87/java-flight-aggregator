package org.deblock.exercise.model.rest.crazyair;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class CrazyAirRequest {

    @JsonProperty("origin")
    public String origin;

    @JsonProperty("destination")
    public String destination;

    @JsonProperty("departureDate")
    private LocalDate departureDate;

    @JsonProperty("returnDate")
    private LocalDate returnDate;

    @JsonProperty("passengerCount")
    public Integer passengerCount;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Integer getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(Integer passengerCount) {
        this.passengerCount = passengerCount;
    }
}
