FROM azul/zulu-openjdk:11.0.10

LABEL maintainer="Jonathan Henrique Medeiros"

RUN apt-get update && \
    rm -rf /var/lib/apt/lists/*

RUN mkdir /app

ADD /target/obot-1.0-shaded.jar /app/obot-1.0-shaded.jar

WORKDIR /app

ENTRYPOINT ["java", "-jar", "obot-1.0-shaded.jar"]

EXPOSE 80
