FROM azul/zulu-openjdk-alpine:11-jre
ADD ["build/libs/*.jar", "app.jar"]
EXPOSE 8080

HEALTHCHECK CMD curl -k --silent --show-error "http://localhost:8080/actuator/health"

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar /app.jar" ]
