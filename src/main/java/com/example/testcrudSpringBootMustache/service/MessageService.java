package com.example.testcrudSpringBootMustache.service;

import com.example.testcrudSpringBootMustache.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    MessageRepo messageRepo;


}
