package com.dean.note.redis.service;

import com.dean.note.redis.cache.Cache;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiveHandler {

    public void messagePush(String message){
        System.out.println("----------收到消息了message："+message);

        Cache.msgList.add(message);
    }
}
