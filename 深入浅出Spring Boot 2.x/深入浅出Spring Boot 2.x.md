# 深入浅出Spring Boot 2.x

- [ ] 书籍作者: 杨开振
- [ ] 笔记时间: 2021.02.13

## 第1章 Spring Boot来临　

### 1.1 Spring 的历史

Spring 架没有开发出来时， Java EE 是以 sun 公司所制定的EJB(Enterprise Java Bean)为标准.

1. 开发需要大量接口和配置
2. EJB运行在EJB容器,而servlet和jsp运行在Web容器

Rod Johnson 提出并实现了Spring 1.0,出现了IoC,AOP,等众多强大功能.

### 1.2 注解还是 XML

Spring 1.x时候Java还不支持注解,当JDK5的时候,注解开始逐步使用.尤其是Servlet3.0出来,已经可以完全使用注解,尤其是Springboot,就是为了解放配置

### 1.3 Spring Boot 的优点

- 基于Spring
- 内嵌服务器容器
- 尽可能自动配置Spring

### 1.4 传统 SpringMVC Spring Boot 的对比