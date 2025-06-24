package com.br.webhook.repositorys;

import com.br.webhook.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    Usuario findByName(String name);

    Usuario findByNumber(String number);
}