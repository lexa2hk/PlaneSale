package com.smolnikov.planesale.Repository;

import com.smolnikov.planesale.Entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo  extends CrudRepository<OrderEntity, Integer> {

}
