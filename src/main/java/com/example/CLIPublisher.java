package com.example;

import java.util.Scanner;

import redis.clients.jedis.Jedis;

public class CLIPublisher {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try(Jedis jedis = new Jedis("localhost", 6379)){
            System.out.println("Welcome to Redis CLI Publisher !!");
            System.out.println("Enter the topic/channel name :");

            String channel = scanner.nextLine();

            System.out.println("Start typing messages (type 'exit' to stop)");

            while(true){
                System.out.println("Message :");
                String msg = scanner.nextLine();

                if(msg.equals("exit")) break;

                jedis.publish(channel, msg);
                System.out.println("✅ Message published to ["+channel+"]");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            scanner.close();
        }
        System.out.println("Publisher exited");
    }
}
