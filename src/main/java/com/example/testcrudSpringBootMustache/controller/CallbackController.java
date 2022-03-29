
package com.example.testcrudSpringBootMustache.controller;

import com.example.testcrudSpringBootMustache.domain.Message;
import com.example.testcrudSpringBootMustache.domain.User;
import com.example.testcrudSpringBootMustache.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class CallbackController {

    @Autowired
    MessageRepo messageRepo;

    @GetMapping("/test")
    public String test() {
        Iterable<Message> messages = messageRepo.findAll();
//        List List.of(messages);
        return messages.toString();
    }

    @PostMapping("/callback")
    public String addMessage(@RequestBody Map<String, String> callbackParams) {
        String json = "{ \n";
        for (Map.Entry entry : callbackParams.entrySet()) {
            System.out.println(entry);
            json = json + "\"" + entry.getKey() + "\":\"" + entry.getValue() + "\"," ;
        }
        json = json.substring(0, json.length() - 1);
        json = json + " }";

        Message message = new Message(json, "tag", null);

        messageRepo.save(message);

        return "OK";
    }

}