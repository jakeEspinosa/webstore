package com.jakeespinosa.fruitbackend.dao;

import com.jakeespinosa.fruitbackend.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
}
