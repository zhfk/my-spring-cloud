FROM openjdk:8
RUN apt-get update && \
    apt-get install -y curl telnet net-tools
ARG JAVA_OPTS
ARG profile=master
COPY eureka-server-0.0.1-SNAPSHOT.jar /root/eureka-server.jar
WORKDIR /root
ENTRYPOINT java $JAVA_OPTS -jar -Dspring.profiles.active=${profile} eureka-server.jar