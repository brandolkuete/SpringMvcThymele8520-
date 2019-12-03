package com.brandolkuete.springmvc.repository;

import com.brandolkuete.springmvc.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,String> {
    Role findByName(String name);
}
