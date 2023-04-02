package com.mistressfilth.spring.controller;

import com.mistressfilth.spring.entity.Message;
import com.mistressfilth.spring.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MessageController {
    @Autowired
    MessageService messageService;

    @GetMapping("/message")
    public String getAllMessage(Model model){
        List<Message> messageList = messageService.allMessage();
        model.addAttribute("messageList", messageList);
        return "messageList";
    }
    @PostMapping("/addMessage")
    public String addMessage(@ModelAttribute Message message){
        messageService.addMessage(message);
        return "redirect:/message";
    }

}
