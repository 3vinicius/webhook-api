package com.br.webhook.repositorys;

import com.br.webhook.model.Youtube;
import org.springframework.data.jpa.repository.JpaRepository;

public interface YoutubeRepository extends JpaRepository<Youtube, Integer> {
}