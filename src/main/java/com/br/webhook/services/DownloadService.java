package com.br.webhook.services;

import com.br.webhook.controller.WebHookOutController;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

@Service
@Slf4j
@RequiredArgsConstructor
public class DownloadService {

    private final WebHookOutController webHookOutController;
    private final ShellExecutor shellExecutor;
    private final ObserverService observerService;


    public String downloadFile(String chatId, String url) {
        log.info("Starting download for chatId: " + chatId + " from URL: " + url);

        String fileName = chatId + ".mp3";
        this.shellExecutor.downlaod(chatId, url);
        String base64 = convertForBase64(fileName);
        this.removeFile(fileName);
        return base64;
    }

    private String convertForBase64(String fileName) {
        try {
            log.info("Converting file to Base64: " + fileName);


            String os = System.getProperty("os.name").toLowerCase();

            File file = new File(fileName);
            if (os.contains("win")) {
                file = new File("download/" + fileName);
            }


            byte[] fileBytes = Files.readAllBytes(file.toPath());
            return Base64.getEncoder().encodeToString(fileBytes);

        } catch (IOException e) {
            log.error("Error converting file to Base64: " + e.getMessage());
        }
        return "";
    }

    private void removeFile(String fileName) {
        File file = new File("download/" + fileName);
        if (file.exists()) {
            if (file.delete()) {
                log.info("File " + fileName + " deleted successfully.");
            } else {
                log.error("Failed to delete file " + fileName + ".");
            }
        } else {
            log.error("File " + fileName + " does not exist.");
        }
    }

}
