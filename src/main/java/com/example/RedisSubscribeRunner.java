package com.example;

import redis.clients.jedis.Jedis;

public class RedisSubscribeRunner implements Runnable {
    private final String channel;
    private final RedisSubscriber subscriber;

    public RedisSubscribeRunner(String channel, RedisSubscriber subscriber) {
        this.channel = channel;
        this.subscriber = subscriber;
    }

    @Override
    public void run() {
        try (Jedis jedis = new Jedis("localhost", 6379)) {
            jedis.subscribe(subscriber, channel);
        }
    }
}
