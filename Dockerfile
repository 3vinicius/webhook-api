FROM python:3.9-slim

LABEL authors="vinicius"

# Instala Java, ffmpeg e dependências
RUN apt-get update && apt-get install -y \
    ffmpeg \
    && rm -rf /var/lib/apt/lists/*

# Instala o yt-dlp
RUN pip install --no-cache-dir yt-dlp

WORKDIR /download

ENTRYPOINT ["/bin/bash"]
