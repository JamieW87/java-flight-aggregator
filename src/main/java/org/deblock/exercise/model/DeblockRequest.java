package org.deblock.exercise.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class DeblockRequest {

    private static final int MAX_FIELD_LENGTH = 3;
    public static final int MAX_VALUE = 4;

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

    @NotBlank
    @JsonProperty("numberOfPassengers")
    @Size(max = MAX_FIELD_LENGTH)
    @Max(message = "Can only book for up to 4 passengers", value = MAX_VALUE)
    @Positive
    private String numberOfPassengers;


}



//| Name | Description |
//        | ------ | ------ |
//        | origin | 3 letter IATA code(eg. LHR, AMS) |
//        | destination | 3 letter IATA code(eg. LHR, AMS) |
//        | departureDate | ISO_LOCAL_DATE format |
//        | returnDate | ISO_LOCAL_DATE format |
//        | numberOfPassengers | Maximum 4 passengers |