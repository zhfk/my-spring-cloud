# mvn clean && mvn compile && mvn package
SERVER_DIR='root@121.196.26.240:~/spring-cloud-jars'
echo "上传 eureka-client jar ->"
scp eureka-client/target/eureka-client-0.0.1-SNAPSHOT.jar ${SERVER_DIR}
echo "上传 eureka-server jar ->"
scp eureka-server/target/eureka-server-0.0.1-SNAPSHOT.jar ${SERVER_DIR}
echo "上传 dockerfile ->"
scp eureka-client/eureka-client.dockerfile ${SERVER_DIR}
scp eureka-server/eureka-server.dockerfile ${SERVER_DIR}
echo "上传 docker-compose ->"
scp docker-compose.yml ${SERVER_DIR}
echo "上传 完成 ！"