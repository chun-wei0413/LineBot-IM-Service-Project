package com.example.lineBot.Handler;

import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.example.lineBot.rabbitMQ.EventPublisher;
import com.example.lineBot.DataToObject.*;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RequiredArgsConstructor
@LineMessageHandler
public class LineBotHandler {
    private final EventPublisher EventPublisher;
    @EventMapping
    public void handleTextMessageEvent(MessageEvent<TextMessageContent> event) {
        log.info("event: " + event);
        final String text = event.getMessage().getText();
        final String userId = event.getSource().getUserId();
        EventPublisher.publishEvent(
                MessageEventDto.builder()
                        .imUserData(
                                UserData.builder()
                                        .platform("LINE")
                                        .userId(userId)
                                        .build()
                        )
                        .message(text)
                        .build()
        );
    }
}
