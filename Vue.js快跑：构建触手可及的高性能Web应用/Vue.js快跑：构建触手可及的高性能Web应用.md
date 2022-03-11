# Vue.js快跑：构建触手可及的高性能Web应用
- [ ] 书籍作者：卡勒姆·麦克雷
- [ ] 笔记时间：2021.8.9

## 第1章 Vue.js基础

### 1.1 为什么选择Vue.js

- 可阅读性更强，无需什么都自己处理

### 1.2 安装和设置

- 最简单的方式使用cdn

### 1.3 vue-loader和webpack

- vue-loader是一个webpack的加载器，允许你将一个组件的所有HTML、JavaScript和CSS代码编写到同一个文件中。

  `vue init webpack`可以构建模板

### 1.4 模板（Template）、数据（Data）和指令（Directive）

- 指令支持简单的逻辑运算

### 1.5 v-if vs v-show

- if不会向DOM插入标签，show只是隐藏标签，所以当某些值不存在的时候后者会报异常，假如频繁切换内容，show会更好

### 1.6 模板中的循环

- v-for 表达式比较简单，支持对象属性的遍历，索引的话用最后一个参数可以获取
- 复制命令所在标签

### 1.7 属性绑定

- v-bind  可以把一个值绑定到一个HTML属性上，简写语法冒号

### 1.8 响应式

- Vue还监控data对象的变化，并在数据变化时更新DOM
- 实现原理：Vue修改了每个添加到data上的对象，当该对象发生变化时Vue会收到通知，从而实现响应式。对象的每个属性会被替换为getter和setter方法，因此可以像使用正常对象一样使用它
  - 存储副本再进行比较，称为脏检查
  - 使用Object.defineProperty()方法覆写属性
- 注意事项
  - 因为是在Vue初始化时候添加的，只有已经存在的属性才是响应式的，后来添加的可以通过Vue.set()进行设置
  - 数组不能直接使用索引设置元素，调用set或者splice
  - 只能缩短数组，调用splic处理，不可以通过改变length修改。

### 1.9 双向数据绑定

- bind默认是单项绑定，data里面属性变化才会引起DOM变化。

- 使用model进行双向绑定，并且会忽略value，checked，selected属性

### 1.10 动态设置HTML

- 双花括号会自动转义HTML，可以使用v-html指令，有xss风险。

### 1.11 方法

- 只要将一个函数存储为methods对象的一个属性，就可以在模板中使用它
- 可以用在属性绑定，插值，任何可以使用JavaScript表达式的地方都可以使用方法
- this 指向this指向该方法所属的组件

### 1.12 计算属性

- 函数定义，属性访问。好处：会被缓存，反复调用速度快。当需要设置属性时，使用getter和setter进行处理。
- 小结：
  - data适合单纯数据，可以是经常变化的数据
  - 函数适合需要传入参数的数据
  - 计算属性适合复杂表达式，经常被调用的

### 1.13 侦听器 

- 可以监听data对象属性或者计算属性的变化，计算属性比监听器更好
- 使用的时候方法只需要和属性同名即可，适合异步处理
- 支持点操作符，此时需要引号包裹方法名，默认传入旧值和新值作为参数。
- deep参数为 true 的话，只有监听对象整体替换才会触发

### 1.14 过滤器

- 用法跟shell语法一样，支持链式语法，插值 ，属性绑定都可以用
- 一般把全局过滤函数注册到Vue，不可以使用 this 对象。

### 1.15 使用ref直接访问元素

- 直接访问DOM元素，可以使用 ref，该元素会被存储到 this.$ref 对象里面

### 1.16 输入和事件

- v-on 绑定事件，简写@。可以时候内联方法或者调用方法，后者会传入事件对象。

  该对象是原生DOM对象，通过 addEventListener 可以添加事件监听器，并且得到同一个事件对象

- 具有很多修饰符
  - .prevent 阻止默认行为
  - .stop 避免继续传播
  - .once 只调用一次
  - .self 只监听自身
  - 按键修饰符，鼠标修饰符
  - 可以将多个修饰符链式调用

### 1.17 生命周期钩子

- created -- 初始化实例之后，也就是new Vue，此时还没有添加到DOM
- mounted -- 元素创建好，不一定已经添加到了DOM，可以用nextTick来保证这一点
- updated -- 在DOM的更改已经完成后触发
- destroyed -- 组件被销毁后触发
- 上述四个都有对应的before方法。

### 1.18 自定义指令

- 添加一个指令类似于添加一个过滤器：可以在将它传入Vue实例或者组件的directives属性，或者使用Vue.directive()注册一个全局指令

- 类型
  - bind -- 会在指令绑定到元素时被调用
  - inserted -- 会在绑定的元素被添加到父节点时被调用
  - update -- 会在绑定该指令的组件节点被更新时调用
  - componentUpdated -- 组件更新后调用 
  - unbind -- 接触绑定
  
- 指令参数

  - el 元素 -- 指令所在标签

  - binding -- 包含一些属性，比如name，value，oldValue，expression等 

### 1.19 过渡和动画

- CSS过渡
  - 使用 transition 组件，需要在样式里面设置 {name}-enter-active 等
- JavaScript动画
  - enter，leave（有before和after）-- 以事件的形式绑定

## 第2章 Vue.js组件

- 组件是一段独立的、代表了页面的一个部分的代码片段

### 2.1 组件基础

- vue组件由模板、js代码、css样式组成
- 通过components可以注入，使用时候标签就可以

### 2.2 数据、方法和计算属性

- 组件都有自己的属性方法，互不干扰
- 组件的data是一个函数，处于互不干扰的考虑设计

### 2.3 传递数据

- Props是通过HTML属性传入组件的

- Prop的大小写，HTML使用-划分单词，JS代码里面可以使用驼峰命名
- 如果想要更改父级组件的值，需要触发update:number事件，语法糖:number.sync
- 为了避免无限触发，可以将值先保存在data里面，再在计算属性/生命周期方法中触发更新父类事件

- v-model也是语法糖，通过单向绑定再触发input事件 

### 2.4 使用插槽（slot）将内容传递给组件

- 传入HTML，slot 标签会替换为组件标签内容，可以设置默认值

- 具名插槽，

- 作用域插槽可以将数据传回slot组件，使父组件中的元素可以访问子组件中的数据
- 任何传递给\<slot\>的属性都可以用slot-scope属性中定义的变量来获取
- 作为一种简写方式，可以解构slot-scope的属性

### 2.5 自定义事件

- v-on可以监听到自定义事件，同事＄emit 可以触发任意事件
- 组件内部可以使用 ＄on，$once和$off

### 2.6 混入

- 只要将混入对象添加到组件中，那么该组件就可以获取到存储在混入对象中的任何东西

- mixins数组中可以放置多个，使用时候跟自身属性一样
- 如果混入对象和组件间有重复的选项，Vue根据类型分别处理
  - 生命周期方法，添加到一个数组统一执行
  - 重复方法、计算属性、非生命周期方法属性直接覆盖
  - 建议明明时候添加前缀/后缀，比如$_xxx_log()等

### 2.7 vue-loader和.vue文件

- 代码分离成各个组件，在App.vue中通过import引入，添加进components属性
-  必须使用预处理器才能在浏览器工作，一般在webpack和vue-loader处理之后。

### 2.8  非Prop属性

- 如果为某个组件设置的属性并不是用作prop，该属性会被添加到组件的HTML根元素上
- 设置在组件上的属性优先级较高，会覆盖掉一样的配置。除了style和class，它们会合并

### 2.9 组件和v-for指令

- 数组对象改变不会重复生成元素，而是更新元素，最好设置key让vue便于区分元素和DOM的关联
- key的选择要有唯一性，尽量不要使用下标

## 第3章 使用Vue添加样式

### 3.1 Class绑定

- v-bind:class设置属性的时候，采用数组，类名会拼接到一起。可以传递对象，键名就是类名，值决定是否拼接

### 3.2 内联样式绑定

- 可以使用数组语法，绑定到style

### 3.3 用vue-loader实现Scoped CSS

### 3.4 用vue-loader实现CSS Modules

- 作为scoped CSS的替代方案，可以用vue-loader实现CSS Modules

### 3.5 预处理器

- 假如使用scss，可以先安装sass-loader和node-sass，在 style 标签添加属性 lang="scss"

## 第4章 render函数和JSX

- 将一个函数传递给Vue实例的render属性时，该函数会传入一个createElement函数，可以使用它来指定需要在页面上显示的HTML

### 4.1 标签名称

- 最简单也是唯一一个必需的参数。可以实字符串或者返回字符串的函数。

### 4.2 数据对象

- 设置属性的地方，attrs、props、domProps、on、slot、ref、class、style等

### 4.3 子节点

- 字符串作为元素的文本内容被输出
- 数组，可以在数组中再次调用createElement函数，来构建一个复杂的DOM树

### 4.4 JSX

- 在babel-plugin-transform-vue-jsx插件的帮助下，可以使用JSX来编写render函数
- 语法和React相近

## 第5章 使用vue-router实现客户端路由

### 5.1 安装

- 可以使用cdn或者 npm 安装，使用webpack需要引入模块并应用 

### 5.2 基本用法

- 引入组件，配置路由，在需要显示的地方插入\<router-view\>

### 5.3 HTML5 History模式

- 将mode改为history就可以不用跳转就能更新页面URL

### 5.4 动态路由

- 路径使用冒号，比如 /user/:userId，会匹配任何符合的路径
- 在组件实例中，可以通过使用属性this.$route来获取当前的路由对象
- 当 触发动态路由变化，不会调用生命周期方法，可以使用beforeRouteUpdate导航守卫（guard）在URL动态部分变化时运行一些代码。
- 除了在组件中使用this.$route.params，还可以让vue-router将params作为路由组件的props传入

### 5.5 嵌套路由

- 创建父路由（比如 /settings）并引入，在children里面设置子路由

### 5.6 重定向和别名

- 指定 redirect 属性即可，或者给组件取别名 alias

### 5.7 链接导航

- 使用 router-link 标签替代 a  标签
  - tag属性 -- 渲染a标签或者别的标签样式
  - to属性 -- 指定跳转位置
  - active-class属性 -- 路径匹配自己激活
  - 原生事件 -- 才可以用v-on监听自定义事件，原生事件需要用.native修饰
  - 编程式导航 -- 可以使用 router.push 进行跳转，go，replace等方法

### 5.8 导航守卫

- vue-router提供了能让你在导航发生之前运行某些代码的功能，router.beforeEach()守卫，带有三个参数
  - to、from以及next，其中from和to分别表示导航从哪里来和到哪里去，而next则是一个回调，在里面你可以让vue-router去处理导航、取消导航、重定向到其他地方或者注册一个错误。
  - 可以进行权限校验，登录等前置检查。可以在routes.meta设置元信息，守卫就可以获取
- 还有afterEach，可以对单独路由定义导航守卫
- 组件内部能使用的守卫有3个：beforeRouteEnter（等效于beforeEach）、beforeRouteUpdate

### 5.9 路由顺序

- 从上往下，匹配的第一个
- 可以利用通配符做错误映射页面，假如有子路由，子路由也需要配置

### 5.10 路由命名

- name属性设置

## 第6章 使用vuex实现状态管理

- 提供了一种集中式存储（centralizedstore），可以在整个应用中使用它来存储和维护全局状态

### 6.1 安装

- CDN或者npm
- 创建 srote/index.js文件，并引入Vue

### 6.2 概念

- 当每个组件都发起一个请求连接，可以利用 this.$store 存储共享数据，比如websocket连接

- State表示数据在vuex中的存储状态，可以放入computed便于访问 ；

  State辅助函数 mapState 返回一个用作计算属性的函数对象，通常情况下，只需要提供一个字符串数组

  - 应用级的state放入vuex中以便组件之间共享，而只用于单个组件内部的简单state则作为组件本地state。

### 6.3 Getter

- 将通常会被重复使用的代码移动到vuexstore内部，从而避免产生冗余。也有辅助函数

### 6.4 Mutation

-  mutation是一个函数，它对state进行同步变更，通过调用store.commit()并传入mutation名称的方式来达成。也有辅助函数
- 只能同步更改state

### 6.5 Action

- 可以异步变更state，可以使用参数解构

### 6.6 Promise与Action

- 可以在action中返回一个promise对象来代替上述做法。另外，调用dispatch也会返回一个promise对象

### 6.7 Module

- 封装玩向外暴露一个Vuex.Store对象，里面modules属性设置模块
- 访问state.messages.messages（而非state.messages），其中第一个messages为模块名称，而第二个messages才是所需状态的值。
- 文件结构 -- 分为 state  mutetions 和 actions 分别暴露，支持命名空间

## 第7章 对Vue组件进行测试

### 7.1 测试单个组件

- vm.$el是一个标准的DOM节点，所以可以通过.querySelector()方法在它的子元素中查找选择器为.count的span元素：
- 也可以使用断言库

### 7.2 介绍vue-test-utils

### 7.3 查询DOM

- wrapper对象，这个对象是由vue-test-utils提供的，它将需要进行模拟的组件封装起来以便对它执行不同的操作
- .find()是wrapper实例提供的方法之一

### 7.4 挂载选项

- 为mount()提供一个对象作为它的第二个参数，并告诉Vue需要让组件拥有什么props

### 7.5 模拟和存根数据

- 有4个.set*()方法，用于设置props、data、computed属性和组件方法

### 7.6 测试事件

- 通过一个方法模拟this.$http的调用过程，之后返回一个promise

