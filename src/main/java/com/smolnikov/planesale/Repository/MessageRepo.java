package com.smolnikov.planesale.Repository;

import com.smolnikov.planesale.Entity.MessageEntity;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepo extends CrudRepository<MessageEntity, Integer> {
    MessageEntity findByMessage(String message);
}
