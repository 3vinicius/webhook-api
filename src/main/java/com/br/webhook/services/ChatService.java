package com.br.webhook.services;

import com.br.webhook.dto.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final UsuarioService usuarioService;
    private LocalDateTime dateCreateChat = LocalDateTime.now();
    private HashMap<String, String> listOpenChat = new HashMap<>();


    private Boolean listChatOutTime() {

        return dateCreateChat.getDayOfMonth() > LocalDateTime.now().getDayOfMonth();
    }

    private boolean chatIsOpen(String chatId) {
        verifyListChatValid();
        if (!listOpenChat.isEmpty()) {
            return listOpenChat.containsKey(chatId);
        }
        return false;
    }

    private void verifyListChatValid(){
        if (listChatOutTime()) {
            resetListChat();
        }
    }

    private void resetListChat() {
        listOpenChat = new HashMap<>();
        dateCreateChat = LocalDateTime.now();
    }

    public void insertOldMessageChat(Message message, String oldMessage) {
        String chatId = message.from();
        if (chatIsOpen(chatId)) {
            listOpenChat.replace(chatId, oldMessage);
        } else {
            listOpenChat.put(chatId, oldMessage);
            usuarioService.save(message);
        }
    }

    public String returnOldMessageChat(String chatId) {
        verifyListChatValid();
        if (chatIsOpen(chatId)) {
            return listOpenChat.get(chatId);
        }
        return "";
    }
}


