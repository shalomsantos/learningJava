package com.shalom.learning.service;

import com.shalom.learning.entity.Usuario;
import com.shalom.learning.repository.UsuarioRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsuarioService {
    @Autowired
    private UsuarioRespository usuarioRespository;

    public List<Usuario> all() {
        return usuarioRespository.findAll();
    }
}
