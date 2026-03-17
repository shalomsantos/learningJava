package com.shalom.learning.repository;

import com.shalom.learning.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRespository extends JpaRepository<User, Long> {}