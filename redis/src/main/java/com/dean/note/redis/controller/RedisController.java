package com.dean.note.redis.controller;

import com.alibaba.fastjson.JSON;

import com.dean.note.redis.cache.Cache;
import com.dean.note.redis.service.RedisPubSub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value = "/notes/redis")
@Controller
public class RedisController {

    @Autowired
    RedisPubSub redisPubSub;

    private ChannelTopic topic = new ChannelTopic("/redis/pubsub");

    @RequestMapping("/push")
    @ResponseBody
    public String push(@RequestParam(value = "msg") String msg) {
        redisPubSub.push(topic, msg);
        return "scuuess";
    }


    @RequestMapping("/pushWithTopic")
    @ResponseBody
    public String push(@RequestParam(value = "topic") String topic,
        @RequestParam(value = "msg") String msg) {
        redisPubSub.push(topic, msg);
        return "scuuess";
    }

    @RequestMapping("/get")
    @ResponseBody
    public String get() {
        String str = JSON.toJSONString(Cache.msgList) + JSON.toJSON(Cache.tiList);

        return str;
    }
}
