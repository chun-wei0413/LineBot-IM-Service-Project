FROM openjdk:17

WORKDIR /
COPY lineBot/target/linebot.jar /

CMD ["java","-jar","linebot.jar"]