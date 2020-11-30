# mvn clean && mvn compile && mvn package

server='root@121.196.26.240'
dir='/root/spring-cloud-jars'
SERVER_DIR="${server}:${dir}"

echo "开始编译 --->"
./mvnw clean compile package

echo "上传jars --->"
for model in $(ls)
do
  if [ -d "${model}" ] && [ -d "${model}/target" ]; then
    scp ${model}/target/*.jar ${SERVER_DIR}
  fi
done

echo "清理文件 --->"
./mvnw clean

echo "上传 dockerfile ->"
scp Dockerfile ${SERVER_DIR}
echo "上传 docker-compose ->"
scp docker-compose.yml ${SERVER_DIR}
echo "上传 完成 ！"

echo "重启springcloud -->"
ssh ${server} "cd ${dir} && docker rmi -f springcloud:latest && docker-compose down && docker-compose up -d"