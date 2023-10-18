FROM openjdk:17

WORKDIR /
COPY lineBot/target/lineBot.jar /

CMD ["java","-jar","lineBot.jar"]