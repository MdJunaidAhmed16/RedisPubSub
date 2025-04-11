package com.example;

import redis.clients.jedis.Jedis;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       RedisSubscriber alice = new RedisSubscriber("Alice", 2);
       RedisSubscriber bob = new RedisSubscriber("Bob", 10);

       Thread aliceThread = new Thread(new RedisSubscribeRunner("sports", alice));
       Thread bobThread = new Thread(new RedisSubscribeRunner("tech", bob));
    
       aliceThread.start();
       bobThread.start();

       try{
        Thread.sleep(1000); // waiting so that all subscribers connect
       }
       catch(InterruptedException e){
        e.printStackTrace();
       }
       try(Jedis publisher = new Jedis("localhost", 6379)){
        publisher.publish("sports", "Cricket match");
        publisher.publish("tech", "S24");
        publisher.publish("sports", "FootBall match");
        publisher.publish("sports", "Baseball match");
        Thread.sleep(1000);
       }
       catch (Exception e){
        e.printStackTrace();
       }
    }
}
