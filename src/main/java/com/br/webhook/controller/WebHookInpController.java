package com.br.webhook.controller;


import com.br.webhook.dto.Message;
import com.br.webhook.services.MenssageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Log4j2
@RequiredArgsConstructor
public class WebHookInpController {

    private final MenssageService menssageService;


    @PostMapping(value = "/webhook")
    public void login(@RequestBody Message message) {

        System.out.println(message);
        menssageService.listeningMenssage(message);
    }


}
