package com.jakeespinosa.fruitbackend.dao;

import com.jakeespinosa.fruitbackend.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
