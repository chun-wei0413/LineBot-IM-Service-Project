package com.example.lineBot.DataToObject;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserData {
    private String platform;
    private String userId;
}
