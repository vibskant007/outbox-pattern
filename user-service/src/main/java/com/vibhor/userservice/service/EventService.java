package com.vibhor.userservice.service;

import com.vibhor.userservice.model.Outbox;
import com.vibhor.userservice.model.OutboxEvent;
import com.vibhor.userservice.repository.OutboxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class EventService {

    @Autowired
    OutboxRepository outboxRepository;


    @EventListener
    public void listenEvent(OutboxEvent outboxEvent) {
        Outbox outbox = new Outbox();
        outbox.setAggregateId(outboxEvent.getAggregateId());
        outbox.setEventType(outboxEvent.getEventName());
        outbox.setPayload(outboxEvent.getPayload().toString());
        outbox.setCreatedOn(new Date());
        outbox.setUuid(UUID.randomUUID().toString());

        //save the outbox entity
        outboxRepository.save(outbox);


    }
}
