# 第一行代码-Android

- [ ] 书籍作者：郭霖
- [ ] 笔记时间：2021.8.8

## 第 1 章　开始启程，你的第一行Android代码

### 1.1　了解全貌，Android王国简介

- 架构分为四层
  - Linux内核层 -- Android系统是基于Linux内核的，这一层为Android设备的各种硬件提供了底层的驱动
  - 系统运行库层 -- 通过一些C/C++库为Android系统提供了主要的特性支持
  - 应用框架层 -- 主要提供了构建应用程序时可能用到的各种API
  - 应用层 -- 所有安装在手机上的应用程序都是属于这一层
  - ![](images/epub_37683759_2)
  - 查看[最新数据](http://developer.android.google.cn/about/dashboards)

- 四大组件
  - Activity -- 是所有Android应用程序的门面
  - Service -- 会在后台默默地运行，即使用户退出了应用
  - BroadcastReceiver -- 允许应用接收来自各处的广播消息
  - ContentProvider -- 为应用程序之间共享数据提供了可能