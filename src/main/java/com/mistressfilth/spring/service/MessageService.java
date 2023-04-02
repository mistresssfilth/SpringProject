package com.mistressfilth.spring.service;

import com.mistressfilth.spring.entity.Message;
import com.mistressfilth.spring.repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    MessageRepo messageRepo;

    public List<Message> allMessage(){
        return messageRepo.findAll();
    }
    public Message addMessage(Message message){
        return messageRepo.save(message);
    }
    public void removeMessage(Long id){
        messageRepo.deleteById(id);
    }


}
