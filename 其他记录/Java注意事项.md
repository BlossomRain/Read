# Java 开发过程遇到的一些注意事项

## 1 . Netty

- 服务器接收类型一般继承 ChannelInboundHandlerAdapter ,在于不会自动释放各种 Buffer,方便后续处理
- 类型需要注意一致,不一致会导致接收不到

## 2.Springboot

- 使用Nacos时候yml文件需要注意一些问题，比如logging配置可能导致启动报错
- Nacos需要web模块
- 版本不要使用JDK11等高版本，依赖会不稳定，使用nacos之类的框架会有明确的版本限制，最好查看官网再使用

