FROM openjdk:8-alpine
RUN echo "http://mirrors.ustc.edu.cn/alpine/latest-stable/main" > /etc/apk/repositories && \
    echo "http://mirrors.ustc.edu.cn/alpine/latest-stable/community" >> /etc/apk/repositories
RUN apk update && \
    apk --no-cache add tzdata && \
    ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && \
    echo "Asia/Shanghai" > /etc/timezone && \
    apk del tzdata && \
    apk add --no-cache curl busybox-extras
COPY common/target/common-0.0.1-SNAPSHOT.jar /root/common-SNAPSHOT.jar
COPY eureka-server/target/eureka-server-0.0.1-SNAPSHOT.jar /root/eureka-server.jar
COPY eureka-client/target/eureka-client-0.0.1-SNAPSHOT.jar /root/eureka-client.jar
COPY user-service/target/user-service-0.0.1-SNAPSHOT.jar /root/user-service.jar
COPY ribbon-service/target/ribbon-service-0.0.1-SNAPSHOT.jar /root/ribbon-service.jar
WORKDIR /root
ENTRYPOINT echo "Prepared Done!"