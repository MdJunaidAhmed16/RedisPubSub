package com.example;

import redis.clients.jedis.JedisPubSub;

public class RedisSubscriber extends JedisPubSub {
    
    private final String name;
    private final int maxMessages;
    private int received = 0;

    public RedisSubscriber(String name, int maxMessages){
        this.name = name;
        this.maxMessages = maxMessages;
    }


    
    @Override
    public void onMessage(String channel, String message){
        received+=1;
        System.out.println(name + " received on ["+channel+"]: "+message);
        
        if(received >= maxMessages){
            System.out.println(name + " reached max limit. Unsubscribing from channel "+channel);
            unsubscribe(channel);
            // redis delays the unsubscribing as this is a asynchronous operation
            // thus it is better to ignore the messages triggered after the limit is reached or just make a check before receiving another msg
        }
    }
}
