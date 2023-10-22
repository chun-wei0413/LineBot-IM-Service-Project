package com.example.lineBot.rabbitMQ;

import com.example.lineBot.DataToObject.MessageEventDto;

public interface EventPublisher {
    void publishEvent(MessageEventDto event);

}