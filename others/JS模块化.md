# JS模块化学习

- [ ] 笔记时间：2021.06.22

## 1. 基础

将一个js文件分解为多个js文件，使用引入方式

### 1.1 全局函数模式

- 将所有函数都声明为全局函数，在一个文件里面
  - 导致文件过大
  - 可能会被覆盖掉

### 1.2 命名空间模式

- 将函数，属性封装到一个对象里面，本质上和上者没有差别

### 1.3 IIFE模式

- 在2的基础上匿名函数闭包

  ```js
  (function(window){
      //do something
      window.func = {myfunc} //将方法/属性暴露为 全局的一个属性
  })(window);
  ```

- 增强模式

  ```js
  // 将全局的对象通过参数传入
  (function(window,$){
      //do something
      window.func = {myfunc} //将方法/属性暴露为 全局的一个属性
      // jq do something
  })(window,jQuery);
  ```

  

### 1.4 CommonJS

- nodejs 使用的默认模块化

- 每个文件都是一个模块，服务器端运行时同步加载，浏览器端需要提前编译打包，使用 browserify 进行打包

- ```js
  // 暴露模块--本质是对 exports 对象进行赋值,但是浏览器是没有该对象，所以需要编译工具预处理
  module.exports={}
  exports.xxx=value
  // 引入模块
  require(xxx)
  ```

### 1.5 AMD模式

- 异步加载，专门用于浏览器，需要用到 require.js

- ```js
  // 暴露模块
  define(['module1','module2'],function(){
      // .... module1.... module2....
      return moduleWantToExport;
  })
  // 引入模块
  require(['module1','module2'],function(){
      // .... module1.... module2....
  })
  ```

### 1.6 ES6

- 需要编译打包处理，还是有一些兼容问题，所以需要代码转换

- babel 处理 JS 兼容问题，browserify 处理require等语法问题

  实际安装包 

  - 配置 .babelrc 文件，

## 2.ES6-11

### 2.1ES6

- 箭头函数的 this 表示声明位置的对象
- ...表示扩展运算符，可以把数组转为参数序列
- Symbol 表示唯一的值，有点像Java的包装类具有缓存
- 可以自定义迭代器，利用 Symbol.iterator
- 生成器是一个特殊函数，异步编程纯回调
  - 可以使用 yield 逐步返回结果，可以使用迭代器语法
  - 迭代器实参传入会作为前一个 yield 的返回结果
- Promise
- Set 可以使用 迭代器，Map 
- 模块化，模块化使用的时候在 html 引入需要设置 type="module"

### 2.2ES8

- 增加 async 和 await ，用法等同 C# 用法

### 2.3 ES9

- 正则扩展
- 正则断言
- 正则dotAll模式

## 3.JS高级

### 3.1基本类型

- typeof 不可以判断 null与object 类型，object 与 array类型，而 === 可以
- 一些情况下可以使用 对象['属性名'] 进行设置
- 函数调用可以用 函数名.call(对象)，函数调用默认的对象this 是 window

### 3.2函数

- 函数都有一个 prototype 属性，指向 Object 空对象，该对象有一个属性 constructor，指向函数对象。函数定义时自动添加
- \_\_proto\_\_ 是隐式原型，值是构造函数显示原型的值。对象创建时自动添加。
- 原型链：自身属性>隐式原型对象>undefined。实例对象隐式原型等于构造函数的显示对象原型
- 所有函数都是 Function 的实例
- 查找属性才使用原型链，设置属性直接在原型里设置。instanceof 是利用原型链进行判断
- 执行上下文
  - 变量/函数声明会在声明之前就可以使用
  - 全局上下文 window ，会预处理。函数执行之前也会创建上下文
  - 默认只有函数作用域，ES6才有块作用域。会导致循环索引问题
  - 闭包在嵌套内部函数定义执行完就产生，内部函数成为垃圾对象时死亡(闭包,内部嵌套函数且引用了外部对象)需要及时释放或者不用

### 3.3 线程

- 定时器由浏览器管理，回调函数会放到队列里，只有主线程执行完栈内方法，才会执行队列方法
- 代码先后顺序  初始化代码 => ajax => 定时器
- Web worker 可以使用多线程

 