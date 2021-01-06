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

