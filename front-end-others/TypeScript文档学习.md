# TypeScript文档学习

- [ ] 笔记时间：2021.06.15
- [ ] [文档地址](https://www.tslang.cn/docs/home.html)

## 1. 基本概念

### 1.1 安装

1. 直接npm安装即可，使用tsc进行编译，之后运行
2. 使用 `npx tsc 文件路径` 进行执行，本质是将TS文件编译成js文件。

### 1.2 基础类型和变量声明

1. 看一下就懂了

### 1.3 接口，类

1. 接口不仅可以限制方法，还可以限制字段或者属性
2. 可以有可选属性，只需要添加？
3. 属性使用 readonly，字段使用 const
4. 字段支持索引类型

## 2.编译器设置

- -w 自动监控当前文件
- 项目下配置  `tsconfig.json` 可以配置监控的文件夹，排除的文件夹等选项
  - compilerOptions：
    - target 指定编译后ES版本
    - module 指定使用模块化规范
    - lib 指定使用的库，一般不用处理，除非在nodejs环境
    - outDir 指定编译后文件目录
    - outFile 将多个文件合并成一个，一般不用，使用打包工具进行合并处理
    - allowJs ，checkJs，removeComments，noEmit（不生成编译后文件），noEmitOnError
    - alwaysStrict 编译后文件严格模式，noImplicitAny 不允许隐式any类型，strictNullCheck 空指针检查，strict 总开关

## 3.webpack

- 先初始化，`npm init -y`,需要一些前置依赖。
  - webpack webpack-cli typescript ts-loader
- `webpack.config.js` webpack的配置文件名
  - 模块引入，直接 `require`即可
  - 配置信息使用 `module.exports`
- 使用 `html-webpack-plugin` 进行对 html 和 js 的映射管理
- 使用 `webpack-dev-server` 进行自动加载代码
- 使用 `clean-webpack-plugin` 进行文件清理，避免出现新旧文件合并情况
- 使用 `@babel/core @babel/preset-env @babel-loader core-js` 解决版本问题

- 使用 ` less less-loader css-loader style-loader`处理css代码
- 使用 `postcss postcss-loader postcss-preset-env`处理css版本问题

------

