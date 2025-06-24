package com.br.webhook.services;

import com.br.webhook.dto.Message;
import com.br.webhook.model.Usuario;
import com.br.webhook.repositorys.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public void save(Message message) {

        Usuario usuario = usuarioRepository.findByNumber(message.from());
        if (usuario == null) {
            usuario = new Usuario();
            usuario.setNumber(message.from());
            usuario.setName(message.nameUser());
            usuarioRepository.save(usuario);
        }

    }

    public Usuario findById(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public void deleteById(Integer id) {
        usuarioRepository.deleteById(id);
    }

}
