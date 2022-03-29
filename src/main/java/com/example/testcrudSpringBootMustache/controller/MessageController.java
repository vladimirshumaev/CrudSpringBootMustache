package com.example.testcrudSpringBootMustache.controller;

import com.example.testcrudSpringBootMustache.domain.Message;
import com.example.testcrudSpringBootMustache.domain.User;
import com.example.testcrudSpringBootMustache.repos.MessageRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MessageController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MessageRepo messageRepo;


    @GetMapping("/messages")
    public String messages(Map<String, Object> model
            , @RequestParam(required = false, defaultValue = "") String filter
//            , @AuthenticationPrincipal User user
    ) {

        Iterable<Message> messages = messageRepo.findAll();
        if (filter != null && !filter.isEmpty()) {
            messages = messageRepo.findByText(filter);
        } else {
            messages = messageRepo.findAll();
        }

        model.put("messages", messages);
//        model.put("user", user);
        model.put("filter", filter);

        return "messages";
    }

    @PostMapping("/messages")
    public String addMessage(
//            @AuthenticationPrincipal User user,
            @RequestParam String text,
            @RequestParam String tag,
            Map<String, Object> model) {

        Message message = new Message(text, tag, null);

        messageRepo.save(message);
        Iterable<Message> messages = messageRepo.findAll();

        model.putIfAbsent("messages", messages);

        return "messages";
    }

    @GetMapping(value = {"/messages/{Id}/edit"})
    public String showEditMessage(Model model, @PathVariable long Id) {
        Message message = null;
        try {
            message = messageRepo.findById(Id);
        } catch (Exception ex) {
            model.addAttribute("errorMessage", ex.getMessage());
        }
        model.addAttribute("message", message);
        return "message-edit";
    }

    @PostMapping(value = {"/messages/{Id}/edit"})
    public String editMessage(
            Model model,
            @PathVariable long Id,
            @RequestParam String text,
            @RequestParam String tag
    ) {
        Message message = null;
        try {
            message = messageRepo.findById(Id);
            message.setText(text);
            message.setTag(tag);
            messageRepo.save(message);
        } catch (Exception ex) {
            model.addAttribute("errorMessage", ex.getMessage());
        }
        Iterable<Message> messages = messageRepo.findAll();
        model.addAttribute("messages", messages);
        return "messages";
    }

    @PostMapping(value = {"/messages/{Id}/delete"})
    public String deleteMessage(Model model, @PathVariable long Id) {
        Message message = null;
        try {
            message = messageRepo.findById(Id);
            messageRepo.delete(message);
        } catch (Exception ex) {
            model.addAttribute("errorMessage", ex.getMessage());
        }
        Iterable<Message> messages = messageRepo.findAll();
        model.addAttribute("messages", messages);
        return "messages";
    }


}
