package com.br.webhook.services;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class ShellExecutor {

    public void downlaod(String chatId, String url) {

        try {
            ProcessBuilder builder = this.selectBuilder(chatId, url);

            Process process = builder.start();
            int exitCode = process.waitFor();

            if (exitCode != 0) {
                log.error("Error executing command: " + builder.command());
            } else {
                log.info("Command executed successfully: " + builder.command());
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


    private ProcessBuilder selectBuilder(String chatId, String url) {
        String os = System.getProperty("os.name").toLowerCase();

        String command = "ydlp yt-dlp -x -o " + chatId + " --audio-format mp3 " + url;

        if (os.contains("win")) {
            return new ProcessBuilder("powershell.exe", "-Command", "docker exec "+ command);
        }
        return new ProcessBuilder("/bin/bash", "-c", command);
    }


    
}
