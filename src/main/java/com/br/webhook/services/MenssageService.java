package com.br.webhook.services;


import com.br.webhook.controller.WebHookOutController;
import com.br.webhook.dto.Message;
import com.br.webhook.repositorys.YoutubeRepository;
import com.br.webhook.shareds.Phases;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MenssageService {

    private final WebHookOutController webHookOutController;
    private final ChatService chatService;
    private final DownloadService downloadService;
    private final YoutubeService youtubeService;

    private Message message;

    public void listeningMenssage(Message message){
        this.message = message;
        verifyOpMenssage();

    }

    public void verifyOpMenssage(){
        String oldMessage = this.chatService.returnOldMessageChat(this.message.from());
        String chatId = this.message.from();

        if (this.message.body().contains("youtube.com") || this.message.body().contains("youtu.be")) {
            this.sendMessage(Phases.WAIT_PROCESS);
            this.downsloadFile();
            return;
        }
        switch (oldMessage) {
            case "" :
                this.sendMessage(Phases.NEW_USER);
                this.sendMessage(Phases.MESSAGE_MENU);
                break;
            case Phases.MESSAGE_MENU:
                if (Objects.equals(this.message.body(), "1")) {
                    this.sendMessage(Phases.DOWNLOAD_MUSIC);
                    break;
                }
                this.sendMessage(Phases.OPTION_NOT_AVAILABLE);
                this.sendMessage(Phases.MESSAGE_MENU);
                break;
            default :
                this.sendMessage(Phases.TRY_AGAIN);
                this.sendMessage(Phases.MESSAGE_MENU);
                break;
        }

    }


    private void downsloadFile(){
        String dataBase64 = this.downloadService.downloadFile(message.from(), this.message.body());
        if (!dataBase64.isEmpty()) {
            this.webHookOutController.sendFile(this.message.from(), "audio.mp3", dataBase64);
            this.sendMessage(Phases.MESSAGE_FINISH);
            this.youtubeService.save(this.message);
        } else {
            this.sendMessage(Phases.TRY_AGAIN);
        }
    }


    private void sendMessage(String messageForSend){
        chatService.insertOldMessageChat(this.message, messageForSend);
        webHookOutController.sendMessage(this.message, messageForSend);

    }
}
