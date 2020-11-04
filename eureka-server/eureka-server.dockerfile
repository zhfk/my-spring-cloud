FROM openjdk:8-alpine
RUN echo "http://mirrors.ustc.edu.cn/alpine/latest-stable/main" > /etc/apk/repositories && \
    echo "http://mirrors.ustc.edu.cn/alpine/latest-stable/community" >> /etc/apk/repositories
RUN apk update && \
    apk --no-cache add tzdata && \
    ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && \
    echo "Asia/Shanghai" > /etc/timezone && \
    apk del tzdata && \
    apk add --no-cache curl busybox-extras
COPY eureka-server-0.0.1-SNAPSHOT.jar /root/eureka-server.jar
WORKDIR /root
ENTRYPOINT java -jar eureka-server.jar