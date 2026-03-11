package com.shalom.learning.repository;

import com.shalom.learning.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRespository extends JpaRepository<Usuario, Long> {}