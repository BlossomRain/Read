# AngularJS 学习

- [ ] 笔记时间：2021.06.24

## 1. 简介

- 大型框架，谷歌开发支持TS
- 需要使用脚手架，直接命令行就可以创建空工程

## 2.使用

### 2.1自定义组件

- 使用命令行 ng g component xxx，之后直接在html就可以使用
- 组件由 html css ts 三者组成，开发模式类似WPF
- 数据绑定静态 直接赋值，动态绑定使用中括号将属性包起来，可以用于绑定HTML。支持管道。
- `*ngFor = "let item of arr;let key = index;"`指令可以用于遍历数组，作用于当前标签

- 图片引入直接用assets即可，动态绑定可以引入网络图片
- `(click)='func()')`

- 双向数据绑定需要引入 FormsModule 模块。`[(ngModule)]='xxx'`

### 2.2 服务

- 使用服务作为公共功能 `ng g service services/storage`，配置服务在 providers，模块里面需要引入，支持构造器注入
- 获取DOM节点，使用原生方法可以放在`ngAgterViewInit():void{}`方法里面
  - 使用 ViewChild需要模块里引入ViewChild 和 ElementRef，html中模块用`#xxx`进行表示，代码里可以获取 `@ViewChild('xxx') x:any;`
- 父子组件通信
  - `[xxx]=xxx`组件上自定义属性
  - 引入子组件，使用 `@Input() xxx`，需要引入 Input 模块
  - output 和 eventemit 配合可以触发父组件方法

### 2.3生命周期

### 2.4 Rxjs

- 微软开发，异步处理。引入 Observable from 'rxjs'，观察者模型。好处可以取消订阅
- 支持流式处理再订阅

### 2.5请求数据

- 引入 HttpClientModule ，需要处理跨域问题
- 引入HttpClientJsonpModule ，可以绕开跨域问题，服务器必须支持jsonp，原理是让方法在服务器调用

### 2.6路由

- 路由配置文件里面引入，之后配置路径映射，html 可以用 routerLink 指定
- 参数传递 `queryParams`，获取需要引入 `ActivedRoute`，可以使用js实现动态路由 需要使用 Router
- 父子路由
  - 引入子模块，路由配置文件添加子路由