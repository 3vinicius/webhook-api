package com.br.webhook.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.HashMap;


@Slf4j
@Service
@RequiredArgsConstructor
public class ObserverService {
    
    File[] arquivos;

    public HashMap<String, String> returnListFiles() {
        File pasta = new File("download");

        if (pasta.isDirectory()) {
            this.arquivos = pasta.listFiles();

            if (arquivos != null && arquivos.length > 0) {
                log.info(arquivos.length + " files searched");
                return this.getFileNames();
            } else {
                log.info("Folder is empty.");
            }
        } else {
            log.error("Not Searching folder.");
        }

        return new HashMap<>();
    }


    public HashMap<String, String> getFileNames() {

        HashMap<String, String> mapFileNames = new HashMap<>();

        for (File arquivo : this.arquivos) {

            String[] listNameFile = arquivo.getName().split("\\.");
            mapFileNames.put(listNameFile[0], listNameFile[1]);

            System.out.println(listNameFile[0]);
        }

        return mapFileNames;

    }


}
