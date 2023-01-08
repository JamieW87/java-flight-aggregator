package org.deblock.exercise.model.rest.toughjet;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class ToughJetRequest {

    @JsonProperty("from")
    public String from;

    @JsonProperty("to")
    public String to;

    @JsonProperty("outboundDate")
    public LocalDate outboundDate;

    @JsonProperty("inboundDate")
    public LocalDate inboundDate;

    @JsonProperty("numberOfAdults")
    public Integer numberOfAdults;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public LocalDate getOutboundDate() {
        return outboundDate;
    }

    public void setOutboundDate(LocalDate outboundDate) {
        this.outboundDate = outboundDate;
    }

    public LocalDate getInboundDate() {
        return inboundDate;
    }

    public void setInboundDate(LocalDate inboundDate) {
        this.inboundDate = inboundDate;
    }

    public Integer getNumberOfAdults() {
        return numberOfAdults;
    }

    public void setNumberOfAdults(Integer numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }
}
