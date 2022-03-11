# electron学习笔记

- [ ] 笔记时间: 2021.7.16



## 1. 简介

### 1.1 前置条件

- 了解 nodejs 和 web 页面开发
- Electron是一个使用 JavaScript、HTML 和 CSS 构建桌面应用程序的框架。嵌入了 chromium 和 nodejs

### 1.2 hello-world

- 环境搭建 nodejs ，安装 electron ，配置 package.json,其中main设置为 main.js
- 任何 Electron 应用程序的入口都是 `main` 文件。 这个文件控制了**主进程**，它运行在一个完整的Node.js环境中，负责控制您应用的生命周期，显示原生界面，执行特殊操作并管理渲染器进程。

- 不能直接在主进程中编辑DOM，因为它无法访问渲染器文档上下文。 它们存在于完全不同的进程！预加载脚本在渲染器进程加载之前加载，并有权访问两个 渲染器全局 (例如 `window` 和 `document`) 和 Node.js 环境。
- 最快捷的打包方式是使用 Electron Forge。`npm install --save-dev @electron-forge/cli`

## 2. 基本概念

### 2.1 流程模型

- 继承来自Chromium的多进程架构,非常相似现代网页浏览器.Electron 应用开发控制主进程和渲染器
- 主进程 -- 应用程序入口,在Nodejs环境运行
  - 窗口管理 -- 主进程的主要目的是使用 BrowserWindow 模块创建和管理应用程序窗口。每个实例对应一个窗口,且在单独渲染器进程中加载网页,可以通过主进程用window的 `webContent`与网页内容交互
  - 注册事件,使用原生API(菜单,对话框,托盘等)

- 渲染进程 -- 每个窗口都在一个独立的渲染进程
  - 无权直接访问node的API
  - 预加载脚本 -- 预加载（preload）脚本包含了那些执行于渲染器进程中，且先于网页内容开始加载的代码 。可以附加在主进程的 `webPreferences`选项
  - 可以使用 `contextBridge` 进行交互,可以通过 `ipcRenderer`进程间通信

### 2.2 功能

| 模块               | 功能               | 渲染进程 | 主进程 |
| ------------------ | ------------------ | -------- | ------ |
| Notification       | 系统通知           | √        | √      |
| addRecentDocument  | 添加最近使用文件   |          | √      |
| win.setProgressBar | 显示任务栏进度     |          | √      |
| app.setUserTasks   | 任务栏右键弹出列表 |          | √      |
|                    |                    |          |        |

### 2.3 模板和命令行界面

- electron-forge 用来构建应用的工具
- electron-build 完备的应用打包和分发工具

### 2.4 应用框架

- 使用Node原生模块，需要为Electron重新编译，使用` electron-rebuild`包
- `node-pre-gyp` 工具 提供一种部署原生 Node 预编译二进制模块的方法， 许多流行的模块都是使用它
- 性能 -- 学问,[`检查列表`](https://www.electronjs.org/docs/tutorial/performance#%E6%A3%80%E6%9F%A5%E5%88%97%E8%A1%A8)
  - 任务繁重的任务可以延迟加载
  - 谨慎加载模块,某些依赖可能很多
  - 阻塞主进程在任何情况都不应该长时间,尽可能避免使用同步IPC 和 `remote` 模块
  - 阻塞渲染进程
  - 确保不会polyfill包含在Electron 中的特性
  - 减少不必要的网络请求

