package com.dean.note.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageReceive {

    @Autowired
    private MessageReceiveHandler messageReceiveHandler;
    /**接收消息的方法*/
    public void receiveMessage(String message){
        //System.out.println(message);

        messageReceiveHandler.messagePush(message);
    }

}

