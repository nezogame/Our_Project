FROM openjdk:20
COPY target/social-network-0.0.1-SNAPSHOT.jar social-network-backend.jar
ENTRYPOINT ["java","-jar","social-network-backend.jar"]
EXPOSE 8080
# in terminal type
# docker build -t java-docker .