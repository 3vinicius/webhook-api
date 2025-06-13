package com.br.webhook.controller;


import com.br.webhook.dto.PayloadDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;


@RestController
public class Awebhook {

    @Value(value = "${wahaa.url}")
    String url;


    public Awebhook() {
        System.out.println(this.url);
    }

    @PostMapping(value = "/webhook")
    public void login(@RequestBody PayloadDto payload) throws IOException, InterruptedException {



        if (!payload.payload().from().contains("status@broadcast")) {
            System.out.println(payload);
        }
        RestTemplate restTemplate = new RestTemplate();

        String url = this.url+"/api/sendText";
        //    /api/sendSeen
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("accept", "application/json");

        String jsonBody = """
        {
          "session": "default",
          "chatId": "5587999777777@c.us",
          "text": "Hi there!"
        }
        """;

        HttpEntity<String> request = new HttpEntity<>(jsonBody, headers);

        //ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

//        System.out.println("Status code: " + response.getStatusCode());
//        System.out.println("Response body: " + response.getBody());



         }



}




class Teste {
      String chatId = "558299572271@c.us";
      String text = "Hi there!";
      String session = "default";

    public String getChatId() {
        return chatId;
    }

    public String getText() {
        return text;
    }

    public String getSession() {
        return session;
    }

    @Override
    public String toString() {
        return "Teste{" +
                "chatId='" + chatId + '\'' +
                ", text='" + text + '\'' +
                ", session='" + session + '\'' +
                '}';
    }
}