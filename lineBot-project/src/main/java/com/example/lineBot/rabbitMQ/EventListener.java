package com.example.lineBot.rabbitMQ;


import com.example.lineBot.DataToObject.SendingServiceDto;
import com.example.lineBot.Handler.EventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.example.lineBot.rabbitMQ.MQConfig.*;

@Slf4j
@RequiredArgsConstructor
@Component
public class EventListener {
    private final EventService imService;
    @RabbitListener(queues={LINE_QUEUE})
    public void receive(SendingServiceDto sendingServiceDto) {
        try {
            log.info("Sending Service: {}",sendingServiceDto);
            for (String userId:sendingServiceDto.getUserIdList())
                imService.SendTextMessage(userId, sendingServiceDto.getMessage());
        }catch (Exception e){
            log.info("Something go wrong: {}",e.getMessage(),e);
        }
    }
}
