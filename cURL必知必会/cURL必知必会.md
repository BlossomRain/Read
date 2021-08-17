# cURL必知必会

- [ ] 书籍作者：丹尼尔·斯坦伯格
- [ ] 笔记时间：2021.08.07

## 第1章 cURL项目

- 团队实际上是由一些致力于软件开发的个人志愿者组成的
- 目标是使用网络协议进行可靠的数据传输，并提供任何人都可以使用的免费代码。

### 1.1 它是如何开始的

- 最早是HttpGet小工具，后来支持FTP，改名为curl，时间是1998

### 1.2 命名问题

- see url

### 1.3 curl可以做什么

- 命令行工具curl，和C API的libcurl库

## 第2章 命令行基础

- 一般不提供二进制文件，可以自己编译

### 2.1 命令行选项

- v详细模式，d指定文件，A指定agent字符串，

### 2.3 URL

- 支持的不仅仅URL，而是URI。

  ```shell
  curl "ftp://user:password@example.com:8080/;type=A" # 可以告诉ftp文件类型是ASCII文件
  ```

- 浏览器用的一般是IRI，是URI的超集，会进行一些字符规范处理。

- --next 可以写入下一个命令

- curl在内部维护着一个连接池，连接池中的连接可以在curl运行期间保持活跃状态，但最好还是在同一个命令行中完成多次传输，而不是单独运行多个curl命令行。

### 2.4 URL通配

- 可以使用中括号/花括号来指定范围，-连接，冒号指定步进
- o 可以使用输出文件名变量。通过 ’#[num]’ 来引用，即在 ’#’ 后面跟上与通配对应的数字，从1（对应第一个通配）开始，以最后一个通配结束。
- --manual可以查看[教程](https://curl.haxx.se/docs/manpage.html)

### 2.6 配置文件

- K 指定配置文件，默认查找 .curlrc（显示主目录，CURL_HOME，之后是HOME环境变量，之后是当前用户主目录）

### 2.7 密码和窥探

- 可以使用u参数，不指定密码
- http默认明文传输，尝试使用加密连接HTTPS，或者使用身份凭证

### 2.8 进度指示器

- q可以取消，#可以开启，默认显示字节数

## 第3章 使用curl

### 3.1 详细模式

- v会显示HTTP头部信息
- --trace和--trace-ascii 可以将完整的跟踪信息保存在指定的文件中
- 使用HTTP/2进行文件传输时，curl将发送和接收被压缩的标头信息。

- --write-out （-w）会在传输任务完成后打印一些信息，可以在字符串里面打印变量使用%获取变量值

### 3.2 持久连接

- 在建立TCP连接时，curl将保留旧连接一段时间

### 3.3 下载

- O使用URL的文件名，J使用响应体的推荐文件名
- 字符集可能需要转换，iconv
- --compressed 可以压缩
- --remote-name-all选项。这让-O成为所有给定URL的默认操作方式
- --limit-rate限制速度，--max-filesize 限制文件大小

### 3.4 上传

- T 发送某个要上传的文件，PUT请求，也可以用于FTP
- 发送电子邮件其实也是一种“上传”，也是使用-T

### 3.5 连接

- ```shell
  curl -H "Host:www.example.com" http://localhost #指定请求的主机名
  curl --resolve example.com:80:127.0.0.1 http://example.com # 提供自定义IP
  curl --interface eht1 http://www.example.com #指定网卡
  # --local-port 指定端口获取
  # keepalive默认打开，可以使用 --no-keepalive
  # --connect-timeout 允许链接最大时长
  # --speed-time 速率低于阈值一段时间就甘比
  ```

### 3.7 .netrc

- -n告诉curl查找该文件

### 3.8 代理

- PAC 代理自动配置（Proxy Auto Config, PAC），curl不支持

- x可以指定HTTP代理，HTTPS则可以使用通道。MITM是Man-In-The-Middle（中间人）的简写。
- 可以通过-p或--proxytunnel选项让curl穿过HTTP代理。
- curl支持SOCKS 4和SOCKS 5
- 可以使用-U user:password或--proxy-user user:password选项来设置代理身份验证的用户名和密码：

### 3.9 退出状态

### 3.10 FTP

- curl支持的两种传输模式是“ASCII”和“BINARY”

- u可以身份验证，冒号分隔
- 可以通过curl -P [arg]（长格式为--ftp-port）选项请求进行主动传输
- --ftp-method multicwd 遍历目录，nocwd速度更快

- 如果用第三方库libssh2来构建curl，那么它就可以支持SCP和SFTP协议。

- 支持邮件POP3和SMTP

### 3.13 TLS

- 可以使用--ssl选项的所有协议都支持这种方法
- 可以用--cacert选项指定要在TLS握手中使用的CA捆绑包

### 3.14 SSLKEYLOGFILE

### 3.15 复制为curl命令

- 需要使用-F选项时，复制为curl命令行这一功能生成的命令行并不好用，于是curl提供了--data-binary选项，这个选项可以包含mime分隔符分隔的字符串等。

## 第4章 用curl执行HTTP操作

### 4.1 协议基础

- 默认方法是GET, -d或-F选项对应POST方法，-I对应HEAD方法，-T对应PUT方法。

- 为了防止curl在将这些字符串发送到服务器前压缩它们，可以使用--path-as-is选项。

### 4.2 响应

- Content-Length：标头，可以知道大小
- 通过--tr-encoding选项请求服务器进行压缩传输编码
- --raw不解码

### 4.3 HTTP身份验证

- --user 可以验证，--anyauth 自动使用curl所知道的最安全的身份验证方法

### 4.4 HTTP区间

- -r 可以获取区间字节，

### 4.6 HTTP POST

- -d指定内容，@filename指定文件，-H指定内容类型
- 支持URL编码
- -G或--get选项，它将-d选项指定的数据附加到URL右边，并使用“? ”分隔，然后让curl用GET方法发送数据。
- 可以使用分块传输

### 4.7 HTTP multipart formpost

- -F发送表单，

### 4.9 重定向

- 可以通过-L或--location选项让它遵循HTTP重定向。通过--max-redirs选项修改最大重定向次数。

### 4.10 修改HTTP请求

- 可以在-X或--request选项后面跟上方法名，让curl使用其他方法
- 可以在curl中用-e或--referer选项来设置referer标头
- 默认不适用cookie，-L -b可以获取，-c指定输出

## 第5章 构建和安装

### 5.1 安装预构建的二进制包

- apt，yum，homebrew等

### 5.3 依赖项

- zlib、 c-ares、libssh2、nghttp2、openldap、librtmp。。。

### 5.4 TLS库

## 第6章 libcurl基础

### 6.1 easy句柄

### 6.2 “驱动”传输

### 6.3 连接重用

### 6.4 回调

### 6.5 清理

### 6.6 代理

### 6.7 传输后的信息

### 6.8 API兼容性

### 6.9 curl --libcurl

### 6.10 头文件

### 6.11 全局初始化

### 6.12 libcurl多线程

### 6.13 curl easy选项

### 6.14 CURLcode返回码

### 6.15 详细操作

## 第7章 用libcurl执行HTTP操作