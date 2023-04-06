package com.jakeespinosa.fruitbackend.dao;

import com.jakeespinosa.fruitbackend.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, String> {

}
