package com.dean.note.redis.service;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONObject;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RedisPubSub {

    @Resource(name = "RedisTemplate")
    private RedisTemplate<String, Object> redisTemplate;

    private ChannelTopic topic = new ChannelTopic("/redis/pubsub");

    //@Scheduled(initialDelay = 5000, fixedDelay = 10000)
    public void schedule() {

        publish("admin", "hey you must go now!");
    }

    /**
     * 推送消息
     *
     * @param publisher
     */
    public void publish(String publisher, String content) {

        JSONObject json = new JSONObject();
        json.put("a", System.currentTimeMillis());
        json.put("b", "abc");

        redisTemplate.convertAndSend(topic.getTopic(), json.toJSONString());
    }

    public void push(ChannelTopic topic, String msg) {
        redisTemplate.convertAndSend(topic.getTopic(), msg);
    }

    public void push(String topic, String msg) {
        redisTemplate.convertAndSend(topic, msg);
    }
}
