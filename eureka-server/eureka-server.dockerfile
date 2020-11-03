FROM openjdk:8
ARG profile
COPY eureka-server-0.0.1-SNAPSHOT.jar /root
WORKDIR /root
RUN echo "profile=>${profile}"
ENTRYPOINT java $JAVA_OPTS -jar -Dspring.profiles.active=${profile} eureka-server-0.0.1-SNAPSHOT.jar