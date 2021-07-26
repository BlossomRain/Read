# Java 开发过程遇到的一些注意事项

## 1 . Netty

- 服务器接收类型一般继承 ChannelInboundHandlerAdapter ,在于不会自动释放各种 Buffer,方便后续处理
- 类型需要注意一致,不一致会导致接收不到