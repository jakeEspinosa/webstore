package com.jakeespinosa.fruitbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jakeespinosa.fruitbackend.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

}
