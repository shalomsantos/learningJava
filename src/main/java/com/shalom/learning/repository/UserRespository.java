package com.shalom.learning.repository;

import com.shalom.learning.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRespository extends JpaRepository<User, Long> {}