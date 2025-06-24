package com.br.webhook.controller;

import com.br.webhook.dto.Message;
import com.br.webhook.dto.MessageMedia;
import com.br.webhook.dto.MessageSend;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@RequiredArgsConstructor
public class WebHookOutController {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value(value = "${wahaa.url}")
    private String url;


    // Separe methods send In new class
    public void sendMessage(Message message, String messageForSend)  {

        String url = this.url+ "/api/sendText";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("accept", "application/json");

        MessageSend messageSend = new MessageSend(message.from(), messageForSend);

        HttpEntity<MessageSend> request = new HttpEntity<MessageSend>(messageSend, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
    }




    public void sendFile(String chatId, String fileName, String base64) {
        String url = this.url + "/api/sendMedia";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("accept", "application/json");

        MessageMedia messageMedia = new MessageMedia("audio/ogg; codecs=opus", base64, chatId);
        try {
            HttpEntity<MessageMedia> request = new HttpEntity<MessageMedia>(messageMedia, headers);
            ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
            log.info(response.getBody());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }


}