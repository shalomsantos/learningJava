package com.shalom.learning.repository;

import com.shalom.learning.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRespository extends JpaRepository<User, Long> 
{
  Optional<User> findByEmail(String email);
}