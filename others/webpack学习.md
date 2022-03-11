# WebPack学习

## 1.简介

- 构建工具（编译器管理），打包工具（将依赖整体输出为一个bundle）
- 基本概念
  - Entry 入口，开始打包，构建依赖图起点
  - Output 输出格式控制
  - Loader 识别处理非JS文件
  - Plugins 执行范围更广的任务，打包优化压缩等
  - Mode 内置开发和生产模式，默认开启插件不同
- 安装`webpack webpack-cli`，默认只能处理js和json资源
- 指令
  - 开发环境 `webpack ./src/index.js -o ./build/built.js --mode=development`
  - 生产环境改为 production

## 2.打包各种资源

- 使用`loader`进行处理，需要在` webpack.config.js `进行配置，基于nodejs，使用的是模块化默认使用commonjs，
- 配置格式
  - loader 直接在 module 里面使用 test 和 use 进行配置
  - plugins 需要引入再配置

### 2.1 处理CSS资源

- css-loader 将css文件变成commonjs文件加载到js文件
- style-loader 将js中的样式资源进行插入，添加到head
- less-loader 处理less文件，编译成css文件（需要配合 less）

### 2.2处理HTML资源

- html-webpack-plugin 默认创建空HTML，默认引入打包的所有资源（CSS/JS），可以传入参数配置

### 2.3 处理图片资源

- url-loader 和 file-loader，配置时候可以设置文件大小限制。处理不了html的图片资源。默认采用ES6解析，关闭es6
- html-loader 解决html直接引入图片问题。默认采用commonjs解析，关闭es6

### 2.4 其他资源处理

- 字体
- loader的可选配置可以设置输出为单独路径

## 3.DevServer

- 自动打包，自动构建 webpack.config.js 里面配置 devServer，指定根目录，端口等
- 安装 webpack-dev-server，命令

## 4.生产模式配置

### 4.1提取css

- mini-css-extract-plugin，用该插件提供的loader替换 style-loader，可以提供 filename 配置输出文件
- 利用 postcss postcss-loader postcss-preset-env 进行兼容处理
  - 在loader里面配置插件，需要设置node的环境变量，`process.env.NODE_ENV=development`
- optimize-css-assets-webpack-plugin 压缩css

### 4.2 ES语法检查

- eslint eslint-loader，需要排除其他js代码，只检查自己的。同时在package.json 中设置 eslintConfig，推荐 airbnb 规则
- eslint-config-airbnb-base 需要 eslint-plugin-import
- babel-loader @babel/core @babel/preset-env  进行 js兼容性处理，不能处理Promise情况
- @babel/polyfill 直接引入即可使用，用于提供新特性，简单粗暴
- corejs 按需加载
- 生产环境下自动压缩js文件，html压缩可以通过配置html-webpack-plugin 进行控制（移除空格和注释）
- 可以配置loader环境为浏览器或者nodejs环境

## 5.优化webpack配置

### 5.1 开发环境

- 打包速度，默认会全部重新打包， HMR（hot module replacement）模块热替换。devServer 配置 hot 为 true

  - js 和 html 不支持 HMR，js代码需要修改令其支持

    ```js
    if(module.hot){
        module.hot.accept('./target.js',function(){
            // do something
        })
    }
    ```

- 调试代码，webpack.config.js 配置 devtool:'source-map'

- oneOf 处理规则时候指定只能由一个处理

- 缓存 babel-loader 可以开启缓存，资源缓存会有一致性问题，利用 输出文件命名修改 可以解决，使用内容哈希

- TreeShaking 去除无用代码，需要使用ES6模块化和production环境。在package.json 配置sideEffects：false 可能会把css等文件处理掉，可以填写不需要处理的文件类型

- 输出多个文件

  - 使用多入口，不要形成依赖

  - webpack.config.js 设置 optimization | splitChunks | chunks:'all'

  - 使用js代码打包单独文件， import 动态导入，

    ```js
    /* webpackChunkName : 'test'*/该注释可以命名单独打包文件
    ```

    

- 懒加载和预加载

  - 使用 import 动态加载，放在函数当中，还可以设置预加载

    ```js
    /* webpackPrefrech:true */
    ```

- PWA 渐进式网络开发应用程序，离线可访问，具有兼容性问题

  - workbox --> workbox-webpack-plugin，用于生成sw配置文件
  - 对 serviceWorker 进行注册

- 多线程打包  thread-loader,通常给babel使用

- externals 忽略打包，需要手动在html引入，一般用CDN

- dll （动态连接库），入口文件设置，引入webpack.DllPlugin插件，可以单独打包指定库

  ```js
  entry:{jquery:['jquery']}
  output:{library：'[name]_[hash]'}
  ```

  - add-asset-html-webpack-plugin 将在HTML引入之前打包的文件

