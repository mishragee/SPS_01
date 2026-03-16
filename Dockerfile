# Use the standard JDK 17 image (more compatible than Alpine)
FROM eclipse-temurin:17-jdk

WORKDIR /app

# The JAR_FILE argument helps find your sps01 jar specifically
ARG JAR_FILE=target/sps01-*.jar
COPY ${JAR_FILE} app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
