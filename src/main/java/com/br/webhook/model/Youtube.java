package com.br.webhook.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "youtube")
public class Youtube {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "url", length = Integer.MAX_VALUE)
    private String url;

    @Column(name = "idusuario")
    private Integer idusuario;
}