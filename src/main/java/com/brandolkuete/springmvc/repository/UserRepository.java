package com.brandolkuete.springmvc.repository;

import com.brandolkuete.springmvc.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    User findByUsername(String username);
}
