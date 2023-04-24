package com.smolnikov.planesale.Repository;

import com.smolnikov.planesale.Entity.MessageEntity;
import com.smolnikov.planesale.Entity.ReservationEntity;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepo extends CrudRepository<ReservationEntity, Integer> {
    Iterable<ReservationEntity> findAllByUser_Username(String user_username);

    void deleteAllByUser_Username(String user_username);
}
