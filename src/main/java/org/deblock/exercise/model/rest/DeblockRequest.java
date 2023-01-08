package org.deblock.exercise.model.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class DeblockRequest {

    private static final int MAX_FIELD_LENGTH = 3;
    private static final int MAX_VALUE = 4;

    @NotBlank(message = "Must supply an origin")
    @JsonProperty("origin")
    @Size(max = MAX_FIELD_LENGTH)
    private String origin;

    @NotBlank(message = "Must supply your destination")
    @JsonProperty("destination")
    @Size(max = MAX_FIELD_LENGTH)
    private String destination;

    @NotNull
    @JsonProperty("departureDate")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Future
    private LocalDate departureDate;

    @NotNull
    @JsonProperty("returnDate")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Future
    private LocalDate returnDate;

    @NotNull
    @JsonProperty("numberOfPassengers")
    @Max(message = "Can only book for up to 4 passengers", value = MAX_VALUE)
    @Positive
    private Integer numberOfPassengers;

    //Validate Departure is before return
    //TO DO Implement func
    @AssertTrue public boolean isValidRange() {
        // TODO: null checks
        return !departureDate.isBefore(returnDate);
    }

    @Override
    public String toString() {
        return "DeblockRequest{" +
                "origin=" + origin +
                ", date='" + departureDate + '\'' +
                '}';
    }

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

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public Integer getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(Integer numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }
}