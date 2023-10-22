package com.example.lineBot.Handler;

import com.linecorp.bot.client.LineMessagingClient;
import com.linecorp.bot.model.PushMessage;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.model.response.BotApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
public class LineBotService implements EventService{
    private final LineMessagingClient lineMessagingClient;
    @Override
    public void SendTextMessage(String userId, String message) {
        TextMessage textMessage = new TextMessage(message);
        pushMessage(userId,textMessage);
    }
    public void pushMessage(String userId, Message message){
        PushMessage pushMessage = new PushMessage(userId, message);
        System.out.println(pushMessage.getTo()+"\n"+pushMessage.getMessages());
        BotApiResponse response = null;
        try {
            response = lineMessagingClient.pushMessage(pushMessage).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
