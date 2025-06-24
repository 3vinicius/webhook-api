package com.br.webhook.services;

import com.br.webhook.dto.Message;
import com.br.webhook.model.Usuario;
import com.br.webhook.model.Youtube;
import com.br.webhook.repositorys.UsuarioRepository;
import com.br.webhook.repositorys.YoutubeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class YoutubeService {
    private final YoutubeRepository youtubeRepository;
    private final UsuarioRepository usuarioRepository;

    public void save(Message message) {

        Usuario usuario = usuarioRepository.findByNumber(message.from());
        if (usuario == null) {
            usuario = new Usuario();
            usuario.setNumber(message.from());
            usuario.setName(message.nameUser());
            usuarioRepository.save(usuario);
        }

        Youtube youtube = new Youtube();
        youtube.setUrl(message.body());
        youtube.setIdusuario(usuario.getId());
        youtubeRepository.save(youtube);

    }

}
