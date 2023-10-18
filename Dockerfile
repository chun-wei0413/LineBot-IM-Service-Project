FROM openjdk:17

WORKDIR /
COPY target/linebot.jar /

CMD ["java","-jar","linebot.jar"]