package com.wr.movies.model;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @JmsListener(destination = "mailbox", containerFactory = "myFactory")
    public void receiveMessage(Email email){
        if(email.getTo() == null || email.getBody() == null){
            throw new RuntimeException("Invalid email!");

        }
        System.out.println("Received email from queue<" + email + ">");
    }
    @JmsListener(destination = "topic.mailbox", containerFactory = "topicListenerFactory")
    public void receiveMessageFromTopic(Email email){
        System.out.println("Received mail from topic<" + email + ">");
    }
}
