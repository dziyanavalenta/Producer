FROM openjdk:16
#copies content of the target/spring-boot-producer.jar folder to app.jar folder
ADD target/spring-boot-producer.jar app.jar
#we are giving instruction to Docker how to run this application
EXPOSE 8087
ENTRYPOINT ["java","-jar","/app.jar"]


