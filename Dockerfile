FROM openjdk:17

WORKDIR /
COPY lineBot-project/target/lineBot-0.0.1-SNAPSHOT.jar /

CMD ["java","-jar","lineBot-0.0.1-SNAPSHOT.jar"]
