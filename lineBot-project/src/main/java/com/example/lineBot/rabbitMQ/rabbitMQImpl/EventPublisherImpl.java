package com.example.lineBot.rabbitMQ.rabbitMQImpl;

import com.example.lineBot.DataToObject.MessageEventDto;
import com.example.lineBot.rabbitMQ.EventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static com.example.lineBot.rabbitMQ.MQConfig.*;

@Service
@RequiredArgsConstructor
public class EventPublisherImpl implements EventPublisher {

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void publishEvent(MessageEventDto event) {
        rabbitTemplate.convertAndSend(IMUI_IBC_EXCHANGE, IM_USER_MESSAGE_QUEUE, event);
    }
}
