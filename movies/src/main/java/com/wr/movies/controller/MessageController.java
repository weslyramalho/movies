package com.wr.movies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private JmsTemplate jmsTemplate;

    @PostMapping
    public void sendMessage(@RequestBody final Email email){
        System.out.println("Sending an email message. ");
        jmsTemplate.convertAndSend("mailbox", email);
    }

    @PostMapping("/topic")
    public void sendMessageTopic(@RequestBody final Email email){
        System.out.println("Sending an email to topic. ");
        jmsTemplate.convertAndSend("topic.mailbox", email);
    }
}
