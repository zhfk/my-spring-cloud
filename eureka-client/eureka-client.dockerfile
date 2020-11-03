FROM openjdk:8
COPY eureka-client-0.0.1-SNAPSHOT.jar /root
WORKDIR /root
ENTRYPOINT java $JAVA_OPTS -jar eureka-client-0.0.1-SNAPSHOT.jar