package com.vibhor.userservice.service;

import com.vibhor.userservice.model.OutboxEvent;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class EventPublish implements ApplicationContextAware {


    private ApplicationContext applicationContext;

    @Autowired
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void publishEvent(OutboxEvent outboxEvent) {
        this.applicationContext.publishEvent(outboxEvent);
    }


}
