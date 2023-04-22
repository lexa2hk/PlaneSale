package com.smolnikov.planesale.Service;

import com.smolnikov.planesale.Entity.MessageEntity;
import com.smolnikov.planesale.Repository.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Autowired
    private MessageRepo messageRepo;

    public String getMessage(String message){
        return messageRepo.findByMessage(message).getMessage();
    }


    public Iterable<MessageEntity> findAll(){
        checkOverflow();
        return messageRepo.findAll();
    }

    public void setMessage(String message){
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setMessage(message);
        messageRepo.save(messageEntity);
        checkOverflow();
    }

    public void deleteMessage(String message){
        messageRepo.delete(messageRepo.findByMessage(message));
    }

    public int countRows(){
        return (int) messageRepo.count();
    }

    public void checkOverflow(){
        if(countRows() > 20){
            deleteMessage(messageRepo.findAll().iterator().next().getMessage());
        }
    }

    public void eraseAll(){
        messageRepo.deleteAll();
    }


}
