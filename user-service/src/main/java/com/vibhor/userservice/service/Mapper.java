package com.vibhor.userservice.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vibhor.userservice.model.Outbox;
import com.vibhor.userservice.model.OutboxEvent;
import com.vibhor.userservice.model.User;

import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public static final ObjectMapper objectMapper = new ObjectMapper();

    public OutboxEvent mapUserToOutboxEvent(User user) {
        JsonNode jsonNode = objectMapper.convertValue(user, JsonNode.class);
        OutboxEvent outboxEvent = new OutboxEvent();
        outboxEvent.setEventName("USER_CREATED");
        outboxEvent.setAggregateId(user.getId());
        outboxEvent.setPayload(jsonNode);
        return outboxEvent;
    }
}
