package com.br.webhook.dto;

public record PayloadDto (String id,
                          String event,
                          String timestamp,
                          Payload payload) {
}


