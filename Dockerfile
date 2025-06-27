FROM openjdk:21-jdk-slim
LABEL authors="vinicius"

RUN apt-get update && apt-get install -y \
    ffmpeg \
    python3 \
    python3-pip \
    && rm -rf /var/lib/apt/lists/*

RUN pip install --no-cache-dir --break-system-packages yt-dlp

WORKDIR /download

COPY cookies.txt /download

EXPOSE 8080
COPY ./target/webhook-0.0.1-SNAPSHOT.jar ../app.jar
ENTRYPOINT ["java","-jar","../app.jar"]
