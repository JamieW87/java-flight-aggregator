package org.deblock.exercise.model.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class DeblockRequest {

    private static final int MAX_FIELD_LENGTH = 3;
    private static final int MAX_VALUE = 4;

    @NotBlank(message = "origin_missing")
    @JsonProperty("origin")
    @Size(max = MAX_FIELD_LENGTH, message = "origin_max_field_length_exceeded")
    private String origin;

    @NotBlank(message = "destination_missing")
    @JsonProperty("destination")
    @Size(max = MAX_FIELD_LENGTH, message = "destination_max_field_length_exceeded")
    private String destination;

    @NotNull(message = "departure_date_missing")
    @JsonProperty("departureDate")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Future(message = "departure_date_must_be_in_future")
    private LocalDate departureDate;

    @NotNull(message = "return_date_missing")
    @JsonProperty("returnDate")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Future(message = "return_date_must_be_in_future")
    private LocalDate returnDate;

    @NotNull(message = "numberOfPassengers_missing")
    @JsonProperty("numberOfPassengers")
    @Max(message = "numberOfPassengers_exceeded_max", value = MAX_VALUE)
    @Positive
    private Integer numberOfPassengers;

    //Validate Departure is before return
    @AssertTrue(message = "departure_date_after_return_date")
    public boolean isValidRange() {
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