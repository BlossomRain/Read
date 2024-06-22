# MongoDB权威指南

- [ ] 书籍作者：Kristina Chodorow
- [ ] 笔记时间：2021.7.7

## 第一部分 MongoDB介绍

### 第1章 MongoDB简介

- 非关系型,使用文档,JSON格式存储
- 具有二级索引,尽力保持关系型数据库
  - 索引允许多种快速查询,提供唯一索引,复合索引、地理空间索引、全文索引
  - 聚合、特殊的集合类型（具有时间限制）、文件存储
- 具有横向扩展的能力

### 第2章 MongoDB基础知识

- 集合对应数据库,每个文档都有一个特殊键“_id”

#### 2.1 文档

- 文档就是键值对的一个有序集
- mongodb 区分类型和大小写

#### 2.2 集合

- 动态模式 文档没有格式限制,集合里面可以放完全不相关的两个文档
- 命名 不能以 system. 或者一些特殊符号开头,可以使用 . 进行分割子集合

#### 2.3 数据库

多个集合组成数据库,名字会有更严格的限制,最终对应文件名

- 保留数据库
  - admin 身份验证
  - local 永远不可以复制,本机所有数据都可以存储到这里
  - config 用于分片设置

#### 2.4 启动MongoDB

```shell
mongod
# 默认数据目录在 /data/db 下,默认 27017 是连接端口,28017 是web端口
```

#### 2.5 MongoDB shell简介

- 输入 mongo 即可启动shell,是一个功能完备的js解释器,可以运行任意js代码,比如 运算,函数定义,函数调用等
- shell 还是一个独立的客户端,自动连接Mongodb服务器
- 常见命令
  - db 查看当前数据库
  - use 选择/创建数据库
  - 集合名.insert 插入一个文档
  - 集合.find 查询一个文档, findOne 只查询一个.查询可以接受参数
  - update 更新一个文档,默认是对象替换
  - remove 删除

#### 2.6 数据类型

- null   布尔  数值 （整型和浮点）  日期  正则  数组

- 内嵌文档  对象id   二进制数据  代码

- _id 集合内唯一,ObjectId 是其默认类型,12字节长,

  ![image--20210707232627868](images/image--20210707232627868.png)

#### 2.7 使用MongoDB shell

- shell 是可以连接到任何MongoDB实例的
- 可以配合脚本执行,可以将脚本添加到 .mongorc.js 文件里
- 访问数据库集合支持中括号

### 第三章 创建、更新和删除文档

#### 3.1 插入并保存文档

- 批量插入 batchInsert 已经过时,直接insert即可,mongodb 一次接收的消息长度有限
- 数据校验 文档小于16Mb,不同版本可能会变,检查id等

#### 3.2 删除文档

- remove 传入选择条件即可,删除集合直接 drop 速度更快

#### 3.3 更新文档

- 更新具有原子性 ,可以使用变量保存查询出来的数据,修改完成后替换原来的数据

- 部分更新

  -  $inc 自增,可以指定步长

  - $set 创建/修改字段 ,$unset可以删除字段 

  - $push 可以往数组添加一个元素/创建数组

    - $each 可以遍历一个数组,配合上者使用
    - $slice 限制数组的长度,最后添加的会挤掉之前的
    - $sort 排序后再删除,保留前十个
    - $ne 查询时候条件不满足时命中,使用 $addToSet 可以排重

  - $pop 类似堆栈,可以指定头尾(±1), $pull 可以删除匹配项

  - 定位操作符"$",用来定位查询文档已经匹配的数组元素,并进行更新

  - > 当部分更新时候可能导致文档存储位置发生变化,当mongodb移动文档的时候会修改填充因子,填充因子是MongoDB为每个新文档预留的增长空间. db.coll.stats() 可以查看

- upsert 更新或插入,update 的第三个参数

- save 可以快捷创建文档

- update 第四个参数,可以对多个匹配文档更新,可以获取更新了多少条数据 db.runcommand({getLastError:1})

- findAndModify命令可以方便返回修改文档,配置项很多,使用时候再学

  

#### 3.4 写入安全机制

- 默认应方式写入,shell只显示最后一个操作的应答,所以使用 getLastError() 可以强制显示上次错误

#### 3.5 请求和连接

mongodb 为每个数据库连接创建一个队列,所以不同连接的数据可能不能及时看到.

### 第4章 查询

#### 4.1 find简介

- 返回部分键值对,可以使用第二个参数限定,1表示要,0表示不要
- 查询需要使用常量,代码可以使用变量

#### 4.2 查询条件

- "$lt"、"$lte"、"$gt"和"$gte"就是全部的比较操作符
- $ne  $in  $nin $or $not ,需要注意 $and 不会进行优化

#### 4.3 特定类型的查询

- $exists 配合 $in 实现 $eq,用于查询 null. 
- 接受正则表达式,可以匹配正则
- 数组可以部分匹配
  - $all 包含查询条件才匹配
  - 支持用 .下标 进行匹配
- $size 查询特定长度,也可以自定义个size键
- $slice 返回查询结果的部分,负数表示从后往前
- $elemMatch 可以用于排除数组部分匹配情况; 建立过索引可以使用 min 和  max
- 内嵌文档 可以使用.进行特定键值查询

#### 4.4 $where查询

- 尽量少用,不适用. 可以执行任意js,使用作用域传递变量

#### 4.5 游标

- 将查询结果赋值给一个变量,内部自动迭代,可以调用 next() 和 hasNext() ,自然也可以用 forEach , sort等操作,这些操作只是构建查询
- limit skip sort 一看就懂
- 避免跳过过多数据,一般利用上次查询结果进行分页
- 随机文档查询,可以插入数据时候增加一个随机键,查询时候随机数大于小于的第一条
- 遍历时候,假如插入数据可能导致无限循环,所以可以使用快照功能,但是性能有点问题
- 

#### 4.6 数据库命令

- 特殊的数据库查询,默认在 $cmd 集合上面执行

- 
  
  ```shell
  {
  	"connectionId" : 466,
  	"n" : 0,
  	"syncMillis" : 0,
  	"writtenTo" : null,
  	"writeConcern" : {
  		"w" : 1,
  		"wtimeout" : 0
  	},
  	"err" : null,
  	"ok" : 1 #返回结果0代表失败,还会带有 errmsg描述失败原因
  }
  
  ```
  
  

## 第二部分 设计应用

### 第5章 索引

#### 5.1 索引简介

- 查询时候可以使用 explain 查看执行细节,比如索引使用等
- 集合最多只能有64个索引,使用 ensureIndex,可以创建复合索引.考虑复合索引的排序,mongodb 可以将热门数据放在内存里
- 内嵌文档索引没什么差别,为排序创建索引
- $操作符使用索引情况
  - 低效率 $exists $ne $not  $nin ,索引使用范围应该由小到大
  - $or  可以使用多个索引,本质是多次查询再处理

- 对数组建立索引会对数组每个元素建立索引,可以对嵌套元素建立索引

#### 5.2 唯一索引

- 创建索引时候,传入第二个参数 unique 和 dropDups
- mongodb 支持稀疏索引,只是不需要将每个文档都作为索引条目。

#### 5.3 explain 和 hint

- 索引explain查看时候需要参照文档,使用B树索引
- 如果发现MongoDB使用了非预期索引,可以使用hint强制使用.正常情况下用不到
- $nature 可以强制全表扫描

#### 5.4 索引管理

- 索引元信息存储在 system.indexes 里面,创建索引时候可以增加 background 选项后台进行 `db.col.getIndexes()`可以查看

- 删除索引可以使用 `db.runCommand({"dropIndexes":"foo","index":"*"})`

  或者 `db.col.dropIndex(name)`

#### 5.5 地理控件索引

- 为坐标平面提供索引,建立索引需要提供一个二维参数“2d”,可以限制该参数的大小
- 查询时候使用 $near : [x,y]  进行查询点周围.甚至可以查询指定形状范围内的文档,比如圆形和矩形
- 配合普通索引可以生成复合索引,比如用户周围所有咖啡店
- 对于地球经纬度等球体的数据,可以使用投影进行处理

### 第6章 特殊的索引和集合

#### 6.1 固定集合

- 类似循环队列队列,默认没有索引,会删除较早文档假如空间不够,且必须手动创建 .支持插入排序

#### 6.2 TTL索引

- 允许超时就删除文档,传入参数 expireAfterSecs,可以更新lastUpdate防止被删除,cllMod命令可以更改过期时间

#### 6.3 全文本索引

- 可以快速搜索文本,使用时候需要创建一个 text 索引,使用text命令进行搜索
- 配合前缀后缀可以优化查询时间

#### 6.4 地理空间索引

- 支持地理控件查询  `ensureIndex({"tile":"2dsphere"})`,查询时,需要将希望查找的内容指定为形如`{"$geometry" :geoJsonDesc}`的GeoJSON对象。
  - 使用"$within"查询完全包含在某个区域的文档
  - 使用"$near"查询附近的位置,会自动排序
  - 配合其他索引可以实现如 附近咖啡店 的索引
- 2d 索引,用于非球面 `ensureIndex({"tile":"2d"})`,可以指定索引边界
  - 支持 $within 和 $near,还可以指定形状 $box 和 $center,甚至$polygon

#### 6.5 使用GridFS存储文件

- 一种存储机制,用来存储大型二进制文件.会自动平衡已有的复制或者为MongoDB设置的自动分片.不支持修改,性能较低(大数据特点)
- 使用mongofiles工具,本质是将大文件分割为多个比较大的块,将每个块作为独立的文档进行存储
  - GridFS中的块会被存储到专用的集合中。块默认使用的集合是fs.chunks
  - 每个文件的元信息被保存在一个单独的集合中,默认情况下这个集合是fs.files

### 第7章 聚合

#### 7.1 聚合框架

- 基本上,可以用多个构件创建一个管道（pipeline）,用于对一连串的文档进行处理。这些构件包括筛选（filtering）、投射（projecting）、分组（grouping）、排序（sorting）、限制（limiting）和跳过（skipping）。

- ```shell
  # 每一步对应一个操作
  db.articles.aggregate({
  	{"$project":{"author":1}},
  	{"$group":{"_id":$author,"count":{"$count":1}}},
  	{"$sort":{"count":--1}},
  	{"$limit":5}
  })
  ```

#### 7.2 管道操作符

- $match 文档筛选,尽量放前面可以利用索引和过滤
- $project 可以从子文档中提取字段,可以重命名字段
  - 可以使用数学表达式 $add 等,加减乘除取余
  - 支持日期表达式 "$year"、"$month"、"$week"、"$dayOfMonth"、"$dayOfWeek"、"$dayOfYear"、"$hour"、"$minute"和"$second"
  - 一些字符串操作 "$substr" "$concat" 等
  - 逻辑表达式 "$cmp" "$strcasecmp" "$eq"/"$ne"/"$gt"/"$gte"/"$lt"/"$lte"
- $group 不支持流式处理
  - 支持"$sum " "$avg"  等

- $unwind 可以将数组中的每一个值拆分为单独的文档

#### 7.3 MapReduce

- 非常慢,自定义map和reduce

- ```shell
  map=function(){
  	#通过this可以拿到当前对象
  	emit(key,{count:1});#返回需要的值
  }
  
  reduce=function(key,emits){
  	#规约处理
  	return {"count":count};#返回需要的值
  }
  ```

- 可选项

  - "finalize"可以将reduce的结果发送给这个键,这是整个处理过程的最后一步
  - "keeptemp"  保存临时结果集
  - "out" 输出集合的名称
  - "query" 提前过滤再mp

#### 7.4 聚合命令

- count 文档属,增加查询条件变慢
- distinct 用来找出给定键的所有不同值
- group 可以执行更复杂的聚合
- $keyf 函数作为key使用
- ![image--20210711142831259](images/image--20210711142831259.png)

### 第8章 应用程序设计

#### 8.1 范式化与反范式化

- 范式化（normalization）是将数据分散到多个不同的集合,不同集合之间可以相互引用数据
- 反范式化（denormalization）与范式化相反：将每个文档所需的数据都嵌入在文档内部
- 例子 频繁更新建议范式
  - 用户与住址,显然住址不会经常更换,所以用反范式更好
  - 用户首选项 内嵌
  - 最近活动 取决于频繁程度,如果是固定长度字段可以内嵌
  - 好友 引用
  - 用户产生的内容 引用
- 基数 一个集合中包含的对其他集合的引用数量叫做基数
- 粉丝订阅问题 不是名人可以采用内嵌,名人使用引用

#### 8.2 优化数据操作

- 优化增长,如果知道文档会增大多少,可以提前预留空间(填充足够的字符串等)
- 删除旧数据
  - 固定集合,密集插入导致存活期过短
  - TTL  对写入量很大的数据可能不够快
  - 使用多个集合,程序处理较为复杂

#### 8.3 数据库和集合的设计

- mongodb不支持连接,一般将相似数据放在同一集合
- 数据库一般不允许将数据从一个数据库导入另一个

#### 8.4 一致性管理

- 服务器为每个数据库连接维护一个请求队列
- 一致性问题
  - 可以直接读取主数据库
  - 设置一个脚本自动检测副本集是否落后于主数据库 

#### 8.5 模式迁移

- MongoDB允许使用动态模式,以避免执行迁移.需要保证所有文档都更新,因为多文档更新不具有原子性

#### 8.6 不适合使用MongoDB的场景

- 不支持事务
- 在多个不同维度上对不同类型的数据进行连接

## 第三部分 复制

#### 第9章 创建副本集

#### 9.1 复制简介

- 主从

#### 9.2 建立副本集

- ```shell
  mongo ----nodb #启动shell,不连接数据库
  replicaSet=new ReplSetTest({"nodes":3})#创建副本
  replicaSet.startSet();#启动三个mongod进程
  replicaSet.initiate();#配置复制功能,默认运行在31000,31001,31002
  conn1 = new Mongo("localhost:30000")#连接到数据库
  ```

- 使用连接变量可以获取数据库等操作,

- 具备故障转移功能

#### 9.3 配置副本集

- ```shell
  mongod ----replSet spock --f mongod.conf ----fork #定义一个副本集
  #登录其他主机,也是进行上面的操作
  # 创建配置,并发送给其中一台机器
  config={
  	"_id":"spock",
  	"members":[
  		{"_id":0,"hoset":"server--1:27017"},
  		{"_id":1,"hoset":"server--2:27017"}
  	]
  }
  # 连接到一台主机后进行如下操作
  db=(new Mongo("server--1:27017")).getDB("test")
  rs.initiate(config)
  ```

- rs辅助函数,是一个全局变量

#### 9.4 修改副本集配置

- ```shell
  rs.add("server--4:27017")
  s.remove("server--4:27017")
  rs.config()
  rs.reconfig(config)
  ```

#### 9.5 设计副本集

- 超过半数可用

#### 9.6 成员配置选项

- 仲裁者(arbiter) 唯一作用就是参与选举,仲裁者并不保存数据.最多只能有一个,
- 启动仲裁者与启动普通mongod的方式相同,使用"----replSet副本集名称"和空的数据目录。可以使用rs.addArb()辅助函数将仲裁者添加到副本集中
- 优先级 默认是1(取值0~100),0永远不能成为主节点
- 隐藏成员,客户端不会向隐藏成员发送请求,设置其hidden
- 延迟备份节点 slaveDelay要求优先级0
- 创建索引 备份节点并不一定要索引,"buildIndexs" : false可以禁止创建索引,要求优先级0

### 第10章 副本集的组成

- 同步 使用操作日志oplog实现的,oplog是主节点的local数据库中的一个固定集合,包含每一次的写操作
- 初始化同步
  - 准备工作 选择某个成员作为同步源,在local.me中为自己创建一个标识符,删除所有已存在的数据库
  - 克隆
  - oplog同步第一步,克隆中所有操作写入oplog
  - 将第一个oplog同步中的操作记录下来。
  - 创建索引
  - 创建索引期间操作同步
  - 完成,切换普通同步状态
- 处理陈旧数据 备份节点远远落后于同步源当前的操作,为了避免陈旧备份节点的出现,让主节点使用比较大的oplog保存足够多的操作日志是很重要的

#### 10.2 心跳

- 每2s同步一次,告诉其他成员自己状态
  - STARTUP 启动转台,尝试加载副本集配置
  - STARTUP2 整个初始化同步过程都处于这个状态
  - RECOVERING 暂时不能处理读取请求,启动时做一些检查;处理耗时操作,断线重连
  - ARBITER 仲裁者状态
  - DOWN    成员处于不可达状态
  - UNKONWN  一个成员无法到达其他任何成员,其他成员将其报告为该状态
  - REMOVED 移出副本
  - ROLLBACK 回滚状态,回滚结束转为RECOVERING状态
  - FATAL  发生了不可挽回的错误,也不再尝试恢复正常

#### 10.3 选举

- 一个成员无法达到主节点,开始申请选举,向能到达的成员发送通知.
  - 如果候选人数据落后副本集,或者已经有一个主节点,不理会
  - 若没有反对理由,便开始投票
    - 投票超过半数,成为新主节点.旧主节点重新加入会退位
- 选举过程几毫秒就可完成 ,但是网络原因导致超时,心跳超时20s,成员需要等待30s才能接着选举.

#### 10.4 回滚

- 如果主节点执行了一个写请求之后挂了,但是备份节点还没来得及复制这次操作,那么新选举出来的主节点就会漏掉这次写操作。
- ![image--20210712101617680](images/image--20210712101617680--1626056179825.png)
  - A 和 B之间126数据不同,两者就会进入回滚状态.会定位到125,将125之后的操作撤销
  - 将受操作影响的文档写入一个 .bson 文件,保存在数据目录下的 rollback 目录中.
- 如果要将被回滚的操作应用到当前主节点,首先使用mongorestore命令将它们加载到一个临时集合
- 如果回滚失败(内容太多,大于300MB或者超过30min),就要重新同步

### 第11章 从应用程序连接副本集

#### 11.1 客户端到副本集的连接

- 连接副本集与连接单台服务器非常像,提供一个 副本集种子列表
- 通常,驱动程序没有办法判断某次操作是否在服务器崩溃之前成功处理,但是应用程序可以自己实现相应的解决方案

#### 11.2 等待写入复制

- 参数"w"会强制要求getLastError等待,一直到给定数量的成员都执行完了最后的写入操作

- ```shell
  db.runCommand({"getLastError":1,"w":"majority","wtimeout":1000})
  ```

- 通常"w"用于控制写入速度,因为写入太快导致同步跟不上

- 错误原因

  - 回滚操作写入到特殊文件,不能自动应用,需要手动应用到主节点.写入时指定majority可以避免这种情况的发生

- "w"其他值

  - 其他整数 如果希望写操作被复制到n个备份节点

  #### 11.3 自定义复制保证规则

  - 保证复制到每个数据中心的一台服务器上,需要在写之前保证写操作保存到每个数据中心里

  - 实现这种操作现需要一下操作

    1. 按照数据中心对成员分类,副本集配置添加一个tab字段 

       ```shell
       var config = rs.config()
       config.members[0].tags={"dc":"us--east"}
       ```

    2. 创建按自己的规则 配置中创建 getLastErrorMode 字段实现

       ```shell
       config.settings={}
       config.settings.getLastErrorModes=[{"eachDC":{"dc":2}}]
       rs.reconfig(config)
       ```

    3. 应用规则

       ```shell
       db.runCommand({"getLastError":1,"w":"eachDC","wtimeout":1000})
       ```

       

- 保证可见大多数写入
  - 操作同上,忽略隐藏节点
- 规则创建
  - 使用键值对设置成员的 tags 字段,用于分组
  - 基于分组创建规则
  - getLastError 应用规则即可

#### 11.4 将读请求发送到备份节点

- 通过设置驱动程序的读取首选项（read preferences）配置其他选项。
- 不建议原因
  - 一致性问题,通常会落后主节点几毫秒
  - 如果读取自己的写操作 
  - 负载均衡可能导致其他节点一起崩溃
- 适合情况
  - 主节点挂掉能提供读服务,将读选项配置为Nearest ,可以读取多个数据中心最低演出吃的同一个文档
  - 使用Secondary 会把请求发给备份节点

### 第12章 管理

#### 12.1 以单机模式启动成员

- ```shell
  db.serverCmdLineOpts() #查看服务器命令行参数
  #重启时不添加 replSet 参数就是单机模式
  ```

#### 12.2 副本集配置

- 保存在 local.system.replSet集合中,应该使用rs辅助函数或者replSetReconfig命令修改副本集配置。
- 创建副本集,启动所有服务器,然后调用 rs.initialte 将配置文件传入即可
- 修改使用 rs.add
- 创建比较大的的副本集,默认12个,需要将多余的投票输俩个改为0
- 强制重新配置,在reconfig的参数传入 force

#### 12.3 修改成员状态

-  re.stepDown,主节点降级,可以指定时间
- rs.freeze 阻止其他选举
- 通过执行replSetMaintenanceMode命令强制一个成员进入维护模式

#### 12.4 监控复制

- rs.status 状态获取,字段释义查看文档

- 备份节点上运行rs.status(),会有一个 syncingTo表示从那个成员处进行复制

  使用 rs.syncFrom() / replSetSyncFrom 可以指定复制源

- 复制循环 假如复制链出现了环,需要仔细查看 rs.status()的输出信息,一般自动选取是不会发生的

- 禁用复制链,强制要求每个成员都从主节点进行复制,只需要将"allowChaining"设置为false即可

- 计算延迟lag  是主节点和备份节点最后一次操作时间戳的差值

- 调整 oplog 大小,每一个可能成为主节点的服务器都应该拥有足够大的oplog,以预留足够的时间窗用于进行维护

  1. 当前是主节点,退位

  2. 关闭服务器

  3. 单机启动

  4. 临时将oplog的  最后一条insert操作保存到其他集合中

     ```shell
     use local
     var cursor = db.oplog.rs.find({"op":"i"})
     var lastInsert = cursor.sort({"$natural":--1}).limit(1).next()
     db.tempLastOp.save(lastInsert)
     ```

     

  5. 删除当前oplog

      ```shell 
      db.oplog.rs.drop
      ```

  6. 创建一个新的oplog 

     ```shell
     db.createCollection("oplog.rs",{"capped":true,"size":10000})
     ```

  7. 将最后一条操作写回oplog

     ```shell
     var temp = db.tempLastOp.findeOne()
     db.oplog.rs.insert(temp)
     db.oplog.rs.findOne() #确保插入成功
     ```

  8. 将当前服务器作为副本集成员重新启动

- 从 延迟备份节点回复
  - 关闭所有其他成员--删除其他成员数据目录所有数据--重启所有成员
  - 关闭所有成员--删除其他成员数据目录--延迟备份节点数据文件复制到其他服务器--重启所有成员
- 创建索引--希望成员逐个创建索引
  - 关闭一个备份节点服务器,单机启动,创建索引,重新加入,逐个重复

- 主节点跟踪延迟 
  - 维护一个local.slaves集合,可以删除,会自动生成

#### 12.5 主从模式

- 启动时加入参数 ----master 或者 ----slave ----source xxx

## 第四部分 分片

### 第13章 分片

#### 13.1 分片简介

- 分片 sharding,将数据拆分,分散到不同机器.也会使用 patitioning 表示
- 几乎所有机器都可以手动分片,mongodb支持自动分片

#### 13.2 理解集群的组件

- 复制是拥有所有数据的一个副本,分片是数据子集,所以需要先执行一次mongos路由过程

#### 13.3 快速建立一个简单的集群

- 创建3个分片,端口从30000开始往后,在30999启动mongos

  ```shell
  mongo ----nodb
  cluster = new ShardingTest({"shards":3,"chunksize":1})
  db = (new Mongo("localhost:30999")).getDB("test");
  #####################
  sh.status() #可以看到分片信息
  sh.enableSharding("test") #对集合开启分片
  db.users.ensureIndex({"username":1})# 分片上创建索引
  db.shardCollection("test.users",{"username":1}); # 开启分片
  ```

- 定向查询--包含片键的查询能够直接被发送到目标分片或者是集群分片的一个子集

  分散-聚集查询--必须被发送到所有分片

### 第14章 配置分片

#### 14.1 何时分片

- 数据量达到单台无法处理可以开始考虑

#### 14.2 启动服务器

- 配置服务器--集群的大脑,必须启用日志,最好位于单独的物理机

  mongos会使用两阶段提交给所有配置服务器发送写请求

  ```shell
  #server-config-1
  mongod --configsvr --dbpath /var/lib/mongodb -f /var/lib/config/mongod.conf 
  ```

- mongos 进程 

  ```shell
  mongos --configdb   config-1:27019, config-2:27019 -f /var/lib/mongos.conf
  ```

- 副本集切换为分片

  - ```shell
    sh.addShard("spock/server-1:27017,server-2:27017")
    ```

- 增加集群容量 -- 可以通过增加分片

- 数据分片 -- 默认不会对数据自动拆分,需要手动指定

  ```shell
  db.enableSharding("music") #允许对数据库music进行分片
  sh.shardcollection("music.artists",{"name":1})#对键分片
  ```

  

#### 14.3 MongoDB如何追踪集群数据

- 将文档组织为块,块内是一定范围的文档,一个块只存在一个分片上
  - 当块过大会自动拆分,根据片键确定分拆点,mongos不断重复发起拆分请求却无法进行拆分的过程，叫做拆分风暴（split storm）
  - 可使用块包含的文档范围来描述块,默认是两个无穷,$minKey 和 $maxKey
  - 快信息存储在 config.chunks,可在启动mongos时指定--nosplit选项，从而关闭块的拆分。

#### 14.4 均衡器

- mongos 有时会扮演,查看 config.locks 集合可以确定

  ```shell
  db.locks.findOne({"_id":"balancer"})
  ```

  

### 第15章 选择片键

#### 15.1 检查使用情况

- 对集合进行分片时，要选择一或两个字段用于拆分数据。这个键（或这些键）就叫做片键。
- 需要考虑一些情景
  - 计划多少分片
  - 分片是为了减少读写延迟吗
  - 分片是为了增加读写吞吐量吗
  - 分片是为了增加系统资源吗

#### 15.2 数据分发

- 升序片键 -- 很少出现,比如_id等

- 随机分发片键 -- 用户名等没有规律的键,唯一弊端随机访问超出RAM的数据效率不高

- 基于位置片键 -- IP/经纬度等,对分片添加tag,为块指定对应tag

  ```shell
  sh.addShardTag("shard00","USPS")
  sh.addTagRange("test.ips",{"ip":"56.0.0.0"},{"ip":"57.0.0.0"},"USPS")#添加规则
  ```

#### 15.3 片键策略

- 散列片键 -- 数据加载很快,无法范围查询

  ```shell
  db.users.ensureIndex({"username":"hashed"})
  sh.shardCollection("app.users",{"username":"hashed"})
  ```

- GridFS的散列片键 -- GridFS集合适合做分片,如果在"files_id"字段上创建散列索引，则每个文件都会被随机分发到集群中,必须在{"files_id" : "hashed"}上创建新的索引

  ```shell
  db.fs.chunks.ensureIndex({"files_id":"hashed"})
  sh.shardCollection("test.fs.chunks",{"files_id":"hashed"})
  ```

- 流水策略 -- 让某些分片支持更多的块,为分片添加标签,指定id范围

- 多热点 -- 使用复合片键

#### 15.4 片键规则和指导方针

- 不可以是数组
- 片键的势,选择一个会变化的键很重要

#### 15.5 控制数据分发

- 让某些分片占有有价值的数据,可以建立独立的集群,或者将数据保存位置明确指定给mongodb

  ```shell
  sh.addShardTag("shard00","high")
  sh.addTagRange("super.inportant",{"shardKey":MinKey},{"shardKey":MaxKey},"high")
  ```

- 手动分片 -- 关闭均衡器,使用moveChunk命令进行数据迁移 

### 第16章 分片管理

#### 16.1 检查集群状态

- sh.status() 查看分片/集群的各种信息
- use config 
  - db.shards.findOne() 记录分片信息
  - databases 数据库信息
  - chunks  collections  tags settings
  - changelog 拆分/迁移信息

#### 16.2 查看网络连接

- connPoolStats 查看mongos和mongod的连接信息

- 限制连接数量(一个客户端连接到mongos就会有一个连接)

  >
  >
  >maxConns = 20000 - mongos\*3 - repl\*3 - N
  >
  >mongos 会为每个mongod进程创建3个连接,转发请求,追踪错误,监控副本
  >
  >repl 主节点-备份节点 备份节点-主节点\*2
  >
  >N 其他连接
  >
  >

#### 16.3 服务器管理

- 可随时添加mongos,只要保证 --configdb 正确
- 修改分片的服务器 -- 直连该节点,对副本集重新配置
- 删除分片 -- 均衡器开启,执行removeShard即可
- 修改配置服务器 -- 建议备份,关闭所有mongos,重启所有mongos进程

#### 16.4 数据均衡

- 均衡器 几乎所有数据库管理操作都需要先关闭. 均衡器是不管历史操作
- 修改块大小 -- config.settings
- 移动块 -- sh.moveChunk,块过大需要先手动拆分(splitAt)再移动
- 特大块  -- 分发特大快,先关闭均衡器,临时调最大块大小,移动,拆分,复原
- 刷新配置 -- flushRouterConfig命令

## 第五部分 应用管理

### 第17章 了解应用的动态

#### 17.1 了解正在进行的操作

- db.currentOp() ,可以添加过滤条件
  - opid 唯一标识符
  - active 正在运行
  - secs_running 已经执行时间
  - desc 与log信息联系起来,日志中与此连接相关的每一条记录都会以[conn3]为前缀，因此可以此来筛选相关的日志信息。
- 有问题的操作,可以通过client字段查看
- db.killOp(id) 终止某个操作,一般只有交出锁的进程才能被终止
- 所有local.oplog.rs中的长时间运行请求，以及所有回写监听命令，都可以被忽略掉。
- 幽灵操作,mongodb在使用非应答式写入时候,操作可能堆积在缓存区,当连接结束时还会接着处理.最好使用应答式处理方式

#### 17.2 使用系统分析器

- 可利用系统分析器（system profiler）来查找耗时过长的操作。系统分析器可记录特殊集合system.profile中的操作

  ```shell
  db.setProfilingLevel(2)
  #可将分析器的分析级别设为1，即只显示长耗时操作
  #0表示关闭分析器
  db.getProfilingLevel()
  ```

#### 17.3 计算空间消耗

- 文档 -- Object.bsonsize()
- 集合 -- db.boards.stats()
- 数据库 -- db.stats()

#### 17.4 使用mongotop和monogostat

- mongotop类似于UNIX中的top工具，可概述哪个集合最为繁忙。可通过运行mongotop-locks，从而得知每个数据库的锁状态。
- mongostat提供有关服务器的信息

### 第18章 数据管理

#### 18.1 配置身份验证

- admin 和 local 是两个特殊数据库,其中的用户可以对任何数据库操作 
- 启动数据库时候添加 --auth , 连接进数据库就需要使用 db.auth进行认证
- 在admin数据库建立用户前,本地客户可对数据库读写,分片时,信息保存在配置服务器,因此monogod并不知道它的存在
- 原理: 用户作为文档存储在 system.users 集合里面,自然也可以对用户增删改查

#### 18.2 建立和删除索引

- 独立服务器建立索引,可以在后台执行
- 副本集建立索引,建议手动关停-建立索引-重新加入
- 分片集群建立索引,和上者步骤类似,需要关闭均衡器
- 建立索引时如果mongod突然消失,检查/var/log/messages文件，其中记录了OOM Killer的输出信息

#### 18.3 预热数据

- 如需将数据库移至内存中，可使用UNIX中的dd工具，从而在启动mongod前载入数据文件

  ```shell
  for file in /data/db/brains.* # brain 修改为需要的数据库
  do
  	dd if=$file of = /dev/null
  done
  ```

- mongoDB 可以使用touch预热数据

- 自定义预热

  - 加载一个特定索引 可以先进行覆盖查询
  - 加载最近更新的文档 可以查询更新日期,假如有的话
  - 加载最近创建的文档 可以修改ObjectId的时间部分实现时间范围的文档加载
  - 重放应用使用记录 diagLogging 命令

#### 18.4 压缩数据

- compact 命令,会消耗大量资源,不会减少集合大小,只是将文档挤在一起
- repair 命令可以回收磁盘空间

#### 18.5 移动集合

- 可使用cloneCollection命令将一个集合移动到另一个不同的mongod中。这一命令只能用于服务器间的集合移动。

#### 18.6 预分配数据文件

```shell
#! /bin/bash
if test $# -lt 2 || test $# -gt 3
then 
	echo "$0 <db> <num-of-files>"
fi
db=$1
num=$2
for i in {0..$num}
do
	echo "Preallocating $db.$i"
	head -c 2146435072 /dev/zero > $db.$i
done
#########脚本执行#######
preallocate test 100
preallocate local 4
```

### 第19章 持久性

#### 19.1 日记系统的用途

- MongoDB会在进行写入时建立一条日志（journal），日记中包含了此次写入操作具体更改的磁盘地址和字节，默认60s输入磁盘一次，/data/db/journal 中可以看到

- 默认 100ms 或者达到几MB就会写入日志，批量提交更改。可以通过向getLastError传递j选项，来确保写入操作的成功

  ```shell
  db.runCommand({"getLastError":1,"j":true})
  # 会导致一秒只能写入33次数据
  ```

- 运行setParameter命令，设定journalCommitInterval的值可以设定提交时间间隔

#### 19.2 关闭日记系统

- 无法保证崩溃后数据恢复,可以提高写入速度.有几种方式恢复
  - 替换数据文件,直接删除旧文件
  - 修复数据,耗时较长,效果较差
- mongod.lock 文件,在正常退出时会被清除.假如没有被清除,mongod会启动不了,不要为了启动直接删除,而是数据修复

#### 19.3 MongoDB无法保证的事项

- MongoDB的安全性与其所基于的系统相同，MongoDB无法避免硬件或文件系统导致的数据损坏

#### 19.4 检验数据损坏

- validate 命令,检验损坏

#### 19.5 副本集中的持久性

- ```shell
  db.runCommand({"getLastError":1,"j":true,"w":"majority"})
  ```

## 第六部分 服务器管理

### 第20章 启动和停止MongoDB

#### 20.1 从命令行启动

- --dbpath 指定数据目录,默认 /data/db/
- --port 指定端口
- --fork 后台运行,可能会被挂起,配合 --logpath
- --config 配置
- local.startup_log集合回家记录mongoDB的版本,系统等信息

#### 20.2 停止MongoDB

- ```shell
  user admin
  db.shutdownServer()
  ####
  db.runCommmand({"shutdown":1,"force":true)}
  ```

#### 20.3 安全性

- --bind_ip  指定监听端口,可以拒绝外网,但是分片有问题
- --nohttpinterface 启动微型服务器,提供信息
- 连接默认不加密,支持使用SSL,可以自己下载一个版本支持或者编译启动

#### 20.4 日志

- 尽量不要使用 --quiet ,可以把日志级别提高减少不必要的信息
- 设置一个计划任务分割日志文件,用到 logRotate 命令

### 第21章 监控MongoDB

#### 21.1 监控内存使用状况

- 常驻内存 比如查询文档
- MongoDB为映射内存中的每个页面，都额外维护了一个虚拟地址，以供日记（journaling）使用
- 缺页中断
- 减少索引不命中现象
- IO延迟

#### 21.2 计算工作集的大小

- 数据集在内存中约多速度越快

#### 21.3 跟踪监测性能状况

- 可通过队列中的请求数量，判断是否发生了阻塞
- 可将队列长度和锁比例（lock percentage）两个指标结合起来，锁比例指MongoDB处于锁定中的时间

#### 21.4 监控副本集

- 对副本集中的落后（lag）和oplog（operation log）长度进行跟踪监测十分重要。

### 第22章 备份

#### 22.1 对服务器进行备份

- 文件系统快照,需要本身支持以及开启日志系统
- 复制文件数据 可以使用 fsynclock 命令做到.不要同时使用fsyncLock和mongodump
- mongodump 备份和恢复的速度较慢，在处理副本集时存在一些问题
  - 使用mongodump和mongorestore来转移集合和数据库
  - 管理唯一索引带来的混乱,唯一索引复制期间不发生可能破坏唯一索引的条件,恢复时候需要做一些预处理

#### 22.2 对副本集进行备份

- 可以使用之前提到的三种方法,第三种需要进行一些处理,需要将其变成独立服务器启动再处理.

#### 22.3 对分片集群进行备份

- 不可能得到完美分片备份,操作都应该先关闭均衡器
- 集群很小时候可以使用 通过mongos运行mongodump
- 备份单独分片可以参考前面的处理

#### 22.4 使用mongooplog进行增量备份

### 第23章 部署MongoDB

#### 23.1 设计系统结构

- SSD / RAID
- 禁止内存过度分配,vm.overcommit_memory的值可以设置为2

#### 23.3 系统配置

- 禁用NUMA,每个CPU都具有自己“本地”内存的结构，叫做NUMA（Non-uniformMemory Architecture，非一致内存结构）
- 禁用zone_reclaim_mode选项。可把该选项认定为“超级NUMA”
- 预读数据,检查MongoDB驻留集（resident set）的大小，并与系统的总内存容量进行比较。判断预读是否过大.预读一般设置 16-256
- 禁用大内存页面
- 选择一种调度算法
- 不要记录访问时间
- 修改 线程数量 和文件描述符的限制

#### 23.4 网络配置

![image-20210715104327527](images/image-20210715104327527.png)

#### 23.5 系统管理

- 同步时钟误差不超过1s是最为安全的
- OOM Killer 终止一个mongos进程,重启它即可
- 关闭定期任务

