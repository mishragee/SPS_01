# Use )
FROM FROM eclipse-temurin:17-jdk

WORKDIR /app

# Using the wildcard * ensures it finds your sps01 jar 
# even if the version number changes.
COPY target/sps01-*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
