package com.example.testcrudSpringBootMustache.controller;

import com.example.testcrudSpringBootMustache.domain.Message;
import com.example.testcrudSpringBootMustache.domain.User;
import com.example.testcrudSpringBootMustache.repos.MessageRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MessageController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MessageRepo messageRepo;


    @GetMapping("/messages")
    public String messages( Map<String, Object> model) {
        Iterable<Message> messages = messageRepo.findAll();


        model.put("messages", messages);

        return "messages";
    }

    @PostMapping("/messages")
    public String addProduct(
            @AuthenticationPrincipal User user,
            @RequestParam String text,
            @RequestParam String tag,
            Map<String, Object> model) {

        Message message  = new Message(text, tag, user);

        messageRepo.save(message);
        Iterable<Message> messages = messageRepo.findAll();

        model.putIfAbsent("messages", messages);

        return "messages";
    }

}
