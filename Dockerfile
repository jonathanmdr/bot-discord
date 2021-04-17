FROM maven:3.6.2-jdk-12 AS builder

LABEL maintainer="Jonathan Henrique Medeiros"

COPY . /build

RUN cd /build && \
    mvn clean install

RUN mkdir /app && \
    mv /build/target/obot-1.0-shaded.jar /app/obot.jar

FROM azul/zulu-openjdk:11.0.10

RUN apt-get update && \
    rm -rf /var/lib/apt/lists/*

RUN mkdir /app

COPY --from=builder /app/* /app

WORKDIR /app

ENTRYPOINT ["java", "-jar", "obot.jar"]
