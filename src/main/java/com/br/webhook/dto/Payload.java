package com.br.webhook.dto;

public record Payload (String from,
                       String fromMe,
                       String source,
                       String to,
                       String participant,
                       String body,
                       Boolean hasMedia,
                       Media media,
                       String author

) {

}
