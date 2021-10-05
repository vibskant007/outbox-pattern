package com.vibhor.userservice.model;

import com.fasterxml.jackson.databind.JsonNode;


public class OutboxEvent {

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Integer getAggregateId() {
        return aggregateId;
    }

    public void setAggregateId(Integer aggregateId) {
        this.aggregateId = aggregateId;
    }

    public JsonNode getPayload() {
        return payload;
    }

    public void setPayload(JsonNode payload) {
        this.payload = payload;
    }

    private String eventName;
    private Integer aggregateId;
    private JsonNode payload;
}
