# Docker启动容器

## MySQL

```shell
docker run \
    -p 3306:3306 \
    -e MYSQL_ROOT_PASSWORD=123456 \
    -v ~/docker/mysql/data:/var/lib/mysql \
    -v ~/docker/mysql/conf:/etc/mysql/conf.d \
    -v ~/docker/mysql/logs:/logs \
    --name mysql \
    -d mysql
```

## MongoDB

```shell
docker run \
	--name mongo \
    -v ~/docker/mongo/data:/data/db \
    -v ~/docker/mongo/backup:/data/backup \
    -v ~/docker/mongo/conf:/data/configdb \
    -p 27017:27017 
    -d mongo \
    --auth
```

## Redis

```shell
docker run \
	--name kris-redis \
	-v ~/docker/redis/redis.conf:/etc/redis/redis.conf \
    -v ~/docker/redis/data:/data \
    -p 6379:6379\
    -d redis \
    redis-server /etc/redis/redis.conf \
    --appendonly yes
```

## RabbitMQ

```shell
docker run \
 	--name rabbitmq	\
	-p 15672:15672\
    -p 5672:5672\
    --privileged=true \
    -v ~/docker/rabbitmq/conf:/etc/rabbitmq \
    -v ~/docker/rabbitmq/data:/var/lib/rabbitmq \
    -v ~/docker/rabbitmq/log:/var/log/rabbitmq \
    -d rabbitmq:management
    
    ############可能出现没有权限创建文件#########
    chmod a+rwx -R conf #将本地的文件夹权限开放
    ############出现端口无法访问的问题#########
    docker exec -it rabbitmq  bash
    rabbitmq-plugins enable rabbitmq_management
```

