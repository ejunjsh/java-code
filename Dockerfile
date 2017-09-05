FROM maven:3.3.9-jdk-8

WORKDIR /root

COPY . /root

RUN mvn install
