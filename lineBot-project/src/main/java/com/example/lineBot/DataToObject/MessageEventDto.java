package com.example.lineBot.DataToObject;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageEventDto{
    private String message;
    private UserData imUserData;
}