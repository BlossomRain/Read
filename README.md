# 读书笔记

介绍: 从2020年开始的读书笔记,本项目收集自己阅读的书籍笔记,以后后续查阅快速定位(在GitHub图片不能正常显示,应该是我网速原因,~~所以链接都是gitee~~,GitHub也会有一样的文件)

环境: Typora + idea +  Java11 + CentOS7(虚拟机) + python3.9 + pycharm + Win10 

语言: Java / Python / C# / C++ / Javascript

> 2022.5.19更新:由于gitee代码需要审核才能公开,链接不再使用gitee

## 目录

### 1 知识掌握

#### 1.1 简介

- 涉及到基础代码知识,框架 ,由于最初是学习Java入门,此处便以Java开头

  Java学习了基本语法和Spring全家桶,同时也要学多线程和高并发的相关知识

  数据库方面主要学习SQL(MySQL,也用到了SQLite)和NoSQL(redis和mongoDB)

  C/C++/Python学习了基本使用,并未深入目的是使用OpenCV相关API,C#只学习了WPF(工作用到)

  JavaScript 学习了基本的语法和框架(vue/angular)

  (待补充)数学方面主要是 微积分/线性代数/统计与概率

  

#### 1.2 Java框架

- Spring家族 中间件

##### 1.2.0 基础知识

- [Java8实战](https://github.com/BlossomRain/Read/blob/master/Java8%E5%AE%9E%E6%88%98/Java8%E5%AE%9E%E6%88%98%20%E7%AC%94%E8%AE%B0.md)
- [Java8并发编程实战](https://github.com/BlossomRain/Read/blob/master/Java%E5%B9%B6%E5%8F%91%E7%BC%96%E7%A8%8B%E5%AE%9E%E6%88%98/Java%E5%B9%B6%E5%8F%91%E7%BC%96%E7%A8%8B%E5%AE%9E%E6%88%98%20%E7%AC%94%E8%AE%B0.md)
- [Java核心技术 卷Ⅰ](https://github.com/BlossomRain/Read/blob/master/Java%E6%A0%B8%E5%BF%83%E6%8A%80%E6%9C%AF_%E5%8D%B71/Java%E6%A0%B8%E5%BF%83%E6%8A%80%E6%9C%AF_%E5%8D%B71.md)
- [Java核心技术 卷Ⅱ](https://github.com/BlossomRain/Read/blob/master/Java%E6%A0%B8%E5%BF%83%E6%8A%80%E6%9C%AF_%E5%8D%B72/Java%E6%A0%B8%E5%BF%83%E6%8A%80%E6%9C%AF_%E5%8D%B72_%E9%AB%98%E7%BA%A7%E7%89%B9%E6%80%A7.md)
- [HeadFirst设计模式](https://github.com/BlossomRain/Read/blob/master/HeadFirst%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F/HeadFirst%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F.md)

##### 1.2.1 Spring家族

- [Spring实战](https://github.com/BlossomRain/Read/blob/master/Spring%E5%AE%9E%E6%88%98/Spring%E5%AE%9E%E6%88%98.md)

- [Spring源码深度解析](https://github.com/BlossomRain/Read/blob/master/Spring%E6%BA%90%E7%A0%81%E6%B7%B1%E5%BA%A6%E8%A7%A3%E6%9E%90/Spring%E6%BA%90%E7%A0%81%E6%B7%B1%E5%BA%A6%E8%A7%A3%E6%9E%90.md)

##### 1.2.2 高并发

- [Netty实战](https://github.com/BlossomRain/Read/blob/master/Netty%E5%AE%9E%E6%88%98/Netty%E5%AE%9E%E6%88%98.md)
- [深入理解Nginx模块开发与架构解析](https://github.com/BlossomRain/Read/blob/master/%E6%B7%B1%E5%85%A5%E7%90%86%E8%A7%A3Nginx%E6%A8%A1%E5%9D%97%E5%BC%80%E5%8F%91%E4%B8%8E%E6%9E%B6%E6%9E%84%E8%A7%A3%E6%9E%90/%E6%B7%B1%E5%85%A5%E7%90%86%E8%A7%A3Nginx%E6%A8%A1%E5%9D%97%E5%BC%80%E5%8F%91%E4%B8%8E%E6%9E%B6%E6%9E%84%E8%A7%A3%E6%9E%90.md)

##### 1.2.3 大数据

- [Hadoop权威指南](https://github.com/BlossomRain/Read/blob/master/Hadoop%E6%9D%83%E5%A8%81%E6%8C%87%E5%8D%97/Hadoop%E6%9D%83%E5%A8%81%E6%8C%87%E5%8D%97.md)

##### 1.2.4 ORM

- [MyBatis技术内幕](https://github.com/BlossomRain/Read/blob/master/MyBatis%E6%8A%80%E6%9C%AF%E5%86%85%E5%B9%95/MyBatis%E6%8A%80%E6%9C%AF%E5%86%85%E5%B9%95.md)

#### 1.3 数据库

##### 1.3.1 SQL

- [MySQL是怎样运行的：从根儿上理解MySQL](https://github.com/BlossomRain/Read/blob/master/MySQL%E6%98%AF%E6%80%8E%E6%A0%B7%E8%BF%90%E8%A1%8C%E7%9A%84%EF%BC%9A%E4%BB%8E%E6%A0%B9%E5%84%BF%E4%B8%8A%E7%90%86%E8%A7%A3MySQL/MySQL%E6%98%AF%E6%80%8E%E6%A0%B7%E8%BF%90%E8%A1%8C%E7%9A%84-%E4%BB%8E%E6%A0%B9%E5%84%BF%E4%B8%8A%E7%90%86%E8%A7%A3MySQL.md)

##### 1.3.2 NoSQL

- [MongoDB权威指南](https://github.com/BlossomRain/Read/blob/master/MongoDB%E6%9D%83%E5%A8%81%E6%8C%87%E5%8D%97/MongoDB%E6%9D%83%E5%A8%81%E6%8C%87%E5%8D%97.md)
- [Redis设计与实现](https://github.com/BlossomRain/Read/blob/master/Redis%E8%AE%BE%E8%AE%A1%E4%B8%8E%E5%AE%9E%E7%8E%B0/Redis%E8%AE%BE%E8%AE%A1%E4%B8%8E%E5%AE%9E%E7%8E%B0.md)



#### 1.4 数学

##### 1.4.1 微积分

##### 1.4.2  线性代数

##### 1.4.3 概率论

##### 1.4.4 杂项

- [程序员的数学1](https://github.com/BlossomRain/Read/blob/master/%E7%A8%8B%E5%BA%8F%E5%91%98%E7%9A%84%E6%95%B0%E5%AD%A6/%E7%A8%8B%E5%BA%8F%E5%91%98%E7%9A%84%E6%95%B0%E5%AD%A6.md)



#### 1.5 Python语言

- [HeadFirstPython](https://github.com/BlossomRain/Read/blob/master/HeadFirstPython/HeadFirstPython.md)

#### 1.6 C/C++/C#语言

- [WPF编程宝典](https://github.com/BlossomRain/Read/blob/master/WPF%E7%BC%96%E7%A8%8B%E5%AE%9D%E5%85%B8/WPF%E7%BC%96%E7%A8%8B%E5%AE%9D%E5%85%B8.md) 
- [C Primer Plus](https://github.com/BlossomRain/Read/blob/master/C-Primer-Plus/C%20Primer%20Plus.md)
- [精通C#](https://github.com/BlossomRain/Read/blob/master/%E7%B2%BE%E9%80%9AC%23/%E7%B2%BE%E9%80%9AC%23.md)
- [Qt5.9C++开发指南](https://github.com/BlossomRain/Read/blob/master/Qt5.9C++%E5%BC%80%E5%8F%91%E6%8C%87%E5%8D%97/Qt5.9C++%E5%BC%80%E5%8F%91%E6%8C%87%E5%8D%97.md)
- [CPP-Primer](https://github.com/BlossomRain/Read/blob/master/CPP-Primer/C++%20Primer.md)

#### 1.7 JavaScript基础/框架

- [JavaScript高级程序设计](https://github.com/BlossomRain/Read/blob/master/JavaScript%E9%AB%98%E7%BA%A7%E7%A8%8B%E5%BA%8F%E8%AE%BE%E8%AE%A1/JavaScript%E9%AB%98%E7%BA%A7%E7%A8%8B%E5%BA%8F%E8%AE%BE%E8%AE%A1.md)
- [Web前端精品开发课：HTML5Canvas开发详解](https://github.com/BlossomRain/Read/blob/master/Web%E5%89%8D%E7%AB%AF%E7%B2%BE%E5%93%81%E5%BC%80%E5%8F%91%E8%AF%BE%EF%BC%9AHTML5Canvas%E5%BC%80%E5%8F%91%E8%AF%A6%E8%A7%A3/Web%E5%89%8D%E7%AB%AF%E7%B2%BE%E5%93%81%E5%BC%80%E5%8F%91%E8%AF%BE%EF%BC%9AHTML5Canvas%E5%BC%80%E5%8F%91%E8%AF%A6%E8%A7%A3.md)

-  [深入浅出Vue.js](https://github.com/BlossomRain/Read/blob/master/%E6%B7%B1%E5%85%A5%E6%B5%85%E5%87%BAVue.js/%E6%B7%B1%E5%85%A5%E6%B5%85%E5%87%BAVue.js.md)
-  [~~Vue企业开发实战~~ -- 不推荐](https://github.com/BlossomRain/Read/blob/master/Vue%E4%BC%81%E4%B8%9A%E5%BC%80%E5%8F%91%E5%AE%9E%E6%88%98/Vue%E4%BC%81%E4%B8%9A%E5%BC%80%E5%8F%91%E5%AE%9E%E6%88%98.md) 
-  [Vue.js快跑：构建触手可及的高性能Web应用](https://github.com/BlossomRain/Read/blob/master/Vue.js%E5%BF%AB%E8%B7%91%EF%BC%9A%E6%9E%84%E5%BB%BA%E8%A7%A6%E6%89%8B%E5%8F%AF%E5%8F%8A%E7%9A%84%E9%AB%98%E6%80%A7%E8%83%BDWeb%E5%BA%94%E7%94%A8/Vue.js%E5%BF%AB%E8%B7%91%EF%BC%9A%E6%9E%84%E5%BB%BA%E8%A7%A6%E6%89%8B%E5%8F%AF%E5%8F%8A%E7%9A%84%E9%AB%98%E6%80%A7%E8%83%BDWeb%E5%BA%94%E7%94%A8.md)
-  [WebGL编程指南](https://github.com/BlossomRain/Read/blob/master/WebGL%E7%BC%96%E7%A8%8B%E6%8C%87%E5%8D%97/WebGL%E7%BC%96%E7%A8%8B%E6%8C%87%E5%8D%97.md)
-  [ES6 /node / webpack / ts / angular / less ](https://github.com/BlossomRain/Read/tree/master/front-end-others)

### 2 技能提升

- Java底层原理以及优化  操作系统原理  图像处理  深度学习
- TODO: 西瓜书/南瓜书/花书  龙书/虎书/鲸书

#### 2.1 JVM

- [深入理解Java虚拟机](https://github.com/BlossomRain/Read/blob/master/%E6%B7%B1%E5%85%A5%E7%90%86%E8%A7%A3Java%E8%99%9A%E6%8B%9F%E6%9C%BA/%E6%B7%B1%E5%85%A5%E7%90%86%E8%A7%A3Java%E8%99%9A%E6%8B%9F%E6%9C%BA.md)

#### 2.2 Java优化

- [Effective Java](https://github.com/BlossomRain/Read/blob/master/Effective%20Java/Effective%20Java.md)

#### 2.3 Linux

- [Linux命令行与shell脚本编程大全/Linux命令行与shell脚本编程大全](https://github.com/BlossomRain/Read/blob/master/Linux%E5%91%BD%E4%BB%A4%E8%A1%8C%E4%B8%8Eshell%E8%84%9A%E6%9C%AC%E7%BC%96%E7%A8%8B%E5%A4%A7%E5%85%A8/Linux%E5%91%BD%E4%BB%A4%E8%A1%8C%E4%B8%8Eshell%E8%84%9A%E6%9C%AC%E7%BC%96%E7%A8%8B%E5%A4%A7%E5%85%A8.md)
- [cURL必知必会](https://github.com/BlossomRain/Read/blob/master/cURL%E5%BF%85%E7%9F%A5%E5%BF%85%E4%BC%9A/cURL%E5%BF%85%E7%9F%A5%E5%BF%85%E4%BC%9A.md)
- [UNIX环境高级编程](https://github.com/BlossomRain/Read/blob/master/Unix%E7%8E%AF%E5%A2%83%E9%AB%98%E7%BA%A7%E7%BC%96%E7%A8%8B/Unix%E7%8E%AF%E5%A2%83%E9%AB%98%E7%BA%A7%E7%BC%96%E7%A8%8B.md)
- [图解HTTP](https://github.com/BlossomRain/Read/blob/master/%E5%9B%BE%E8%A7%A3HTTP/%E5%9B%BE%E8%A7%A3HTTP.md)

#### 2.4 机器学习

- [Sklearn 与 TensorFlow 机器学习实用指南第二版](https://github.com/BlossomRain/Read/blob/master/Sklearn%20%E4%B8%8E%20TensorFlow%20%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%E5%AE%9E%E7%94%A8%E6%8C%87%E5%8D%97%E7%AC%AC%E4%BA%8C%E7%89%88/Sklearn%20%E4%B8%8E%20TensorFlow%20%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%E5%AE%9E%E7%94%A8%E6%8C%87%E5%8D%97%E7%AC%AC%E4%BA%8C%E7%89%88.md)
- [吴恩达深度学习](https://github.com/BlossomRain/Read/blob/master/%E5%90%B4%E6%81%A9%E8%BE%BE%E6%B7%B1%E5%BA%A6%E5%AD%A6%E4%B9%A0/%E5%90%B4%E6%81%A9%E8%BE%BE%E6%B7%B1%E5%BA%A6%E5%AD%A6%E4%B9%A0.md)

#### 2.5 图像处理

- [学习OpenCV3](https://github.com/BlossomRain/Read/blob/master/%E5%AD%A6%E4%B9%A0OpenCV3/%E5%AD%A6%E4%B9%A0OpenCV3.md)
- [数字图像处理](https://github.com/BlossomRain/Read/blob/master/%E6%95%B0%E5%AD%97%E5%9B%BE%E5%83%8F%E5%A4%84%E7%90%86/%E6%95%B0%E5%AD%97%E5%9B%BE%E5%83%8F%E5%A4%84%E7%90%86.md)
- [OpenCV 3计算机视觉 Python语言实现](https://github.com/BlossomRain/Read/blob/master/OpenCV%203%E8%AE%A1%E7%AE%97%E6%9C%BA%E8%A7%86%E8%A7%89%20Python%E8%AF%AD%E8%A8%80%E5%AE%9E%E7%8E%B0/OpenCV%203%E8%AE%A1%E7%AE%97%E6%9C%BA%E8%A7%86%E8%A7%89%20Python%E8%AF%AD%E8%A8%80%E5%AE%9E%E7%8E%B0.md)

#### 2.6 操作系统与网络

- 深入理解计算机系统
- [计算机网络](https://github.com/BlossomRain/Read/blob/master/%E8%AE%A1%E7%AE%97%E6%9C%BA%E7%BD%91%E7%BB%9C/%E8%AE%A1%E7%AE%97%E6%9C%BA%E7%BD%91%E7%BB%9C%E8%87%AA%E9%A1%B6%E5%90%91%E4%B8%8B%E6%96%B9%E6%B3%95.md)

### 3 杂项

- 记录一些 环境搭建/工具使用/问题 

#### 3.1 工具

- [maven实战](https://github.com/BlossomRain/Read/blob/master/maven%E5%AE%9E%E6%88%98/maven%E5%AE%9E%E6%88%98.md)
- [深入浅出Docker](https://github.com/BlossomRain/Read/blob/master/%E6%B7%B1%E5%85%A5%E6%B5%85%E5%87%BADocker/%E6%B7%B1%E5%85%A5%E6%B5%85%E5%87%BADocker.md)
- [~~跟老男孩学Linux运维：Shell编程实战~~ -- 不推荐](https://github.com/BlossomRain/Read/blob/master/%E8%B7%9F%E8%80%81%E7%94%B7%E5%AD%A9%E5%AD%A6Linux%E8%BF%90%E7%BB%B4%EF%BC%9AShell%E7%BC%96%E7%A8%8B%E5%AE%9E%E6%88%98/%E8%B7%9F%E8%80%81%E7%94%B7%E5%AD%A9%E5%AD%A6Linux%E8%BF%90%E7%BB%B4%EF%BC%9AShell%E7%BC%96%E7%A8%8B%E5%AE%9E%E6%88%98.md)
- [~~跟老男孩学Linux运维：核心系统命令实战~~ -- 不推荐](https://github.com/BlossomRain/Read/tree/master/%E8%B7%9F%E8%80%81%E7%94%B7%E5%AD%A9%E5%AD%A6Linux%E8%BF%90%E7%BB%B4%EF%BC%9A%E6%A0%B8%E5%BF%83%E7%B3%BB%E7%BB%9F%E5%91%BD%E4%BB%A4%E5%AE%9E%E6%88%98)

#### 3.2 

- 

#### 3.3 视频学习

##### 3.3.1 尚硅谷

- [B站](https://space.bilibili.com/302417610)

#### 3.4 其他

- [从零开始学架构 照着做，你也能成为架构师](https://github.com/BlossomRain/Read/blob/master/%E4%BB%8E%E9%9B%B6%E5%BC%80%E5%A7%8B%E5%AD%A6%E6%9E%B6%E6%9E%84%20%E7%85%A7%E7%9D%80%E5%81%9A%EF%BC%8C%E4%BD%A0%E4%B9%9F%E8%83%BD%E6%88%90%E4%B8%BA%E6%9E%B6%E6%9E%84%E5%B8%88/%E4%BB%8E%E9%9B%B6%E5%BC%80%E5%A7%8B%E5%AD%A6%E6%9E%B6%E6%9E%84%20%E7%85%A7%E7%9D%80%E5%81%9A%EF%BC%8C%E4%BD%A0%E4%B9%9F%E8%83%BD%E6%88%90%E4%B8%BA%E6%9E%B6%E6%9E%84%E5%B8%88.md)

- [其他记录](https://github.com/BlossomRain/Read/tree/master/%E5%85%B6%E4%BB%96%E8%AE%B0%E5%BD%95)
  - [Docker启动容器](https://github.com/BlossomRain/Read/blob/master/%E5%85%B6%E4%BB%96%E8%AE%B0%E5%BD%95/Docker%E5%90%AF%E5%8A%A8%E5%AE%B9%E5%99%A8.md)
  - [Java注意事项](https://github.com/BlossomRain/Read/blob/master/%E5%85%B6%E4%BB%96%E8%AE%B0%E5%BD%95/Java%E6%B3%A8%E6%84%8F%E4%BA%8B%E9%A1%B9.md)
  - [centos7操作](https://github.com/BlossomRain/Read/blob/master/%E5%85%B6%E4%BB%96%E8%AE%B0%E5%BD%95/centos7.md)
  - [C++开发注意事项](https://github.com/BlossomRain/Read/blob/master/%E5%85%B6%E4%BB%96%E8%AE%B0%E5%BD%95/C%2B%2B%E5%BC%80%E5%8F%91%E6%B3%A8%E6%84%8F%E4%BA%8B%E9%A1%B9.md)
  - [Java注意事项](https://github.com/BlossomRain/Read/blob/master/%E5%85%B6%E4%BB%96%E8%AE%B0%E5%BD%95/Java%E6%B3%A8%E6%84%8F%E4%BA%8B%E9%A1%B9.md)
  - [搭建Opencv环境](https://github.com/BlossomRain/Read/blob/master/%E5%85%B6%E4%BB%96%E8%AE%B0%E5%BD%95/Ubuntu%E4%B8%8BOpencv%E7%8E%AF%E5%A2%83%E6%90%AD%E5%BB%BA.md)
  - [linux编辑操作](https://github.com/BlossomRain/Read/blob/master/%E5%85%B6%E4%BB%96%E8%AE%B0%E5%BD%95/linux%E7%BC%96%E8%BE%91%E9%AB%98%E7%BA%A7%E6%93%8D%E4%BD%9C.md)
  - [WPF开发经验.md](https://github.com/BlossomRain/Read/blob/master/%E5%85%B6%E4%BB%96%E8%AE%B0%E5%BD%95/WPF%E5%BC%80%E5%8F%91%E7%BB%8F%E9%AA%8C.md)
