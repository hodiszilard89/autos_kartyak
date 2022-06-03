FROM openjdk:17-jdk-alpine3.14

COPY "./target/autoskartyak.jar" "/application/autoskartyak.jar"

CMD ["java", "-jar", "/application/autoskartyak.jar"]
