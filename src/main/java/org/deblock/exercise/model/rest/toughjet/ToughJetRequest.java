package org.deblock.exercise.model.rest.toughjet;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class ToughJetRequest {

    @JsonProperty("from")
    private String from;

    @JsonProperty("to")
    private String to;

    @JsonProperty("outboundDate")
    private LocalDate outboundDate;

    @JsonProperty("inboundDate")
    private LocalDate inboundDate;

    @JsonProperty("numberOfAdults")
    private Integer numberOfAdults;

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

    @Override
    public String toString() {
        return "ToughJetRequest{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", outboundDate=" + outboundDate +
                ", inboundDate=" + inboundDate +
                ", numberOfAdults=" + numberOfAdults +
                '}';
    }
}
