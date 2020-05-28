package com.dean.note.redis.service;

import com.dean.note.redis.cache.Cache;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Component;

@Component
public class RedisSubscriber extends MessageListenerAdapter {

    @Override
    public void onMessage(Message message, byte[] pattern) {
        System.out.println("???");
        System.out.println(message);

        Cache.tiList.add(message.toString());
    }
}
