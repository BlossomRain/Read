# Numpy快速入门

- 来源[官方文档](https://numpy.org/)

- 笔记时间：2022.02.25

## 1 基础

### 1.1 基本概念

- Numerical Python，主要对象是其次多维数组，Numpy里面维度称为axis

- Numpy的数组类称为 ndarray，常用属性有

  - ndim 维度个数，中括号层次个数，称为rank
  - size 元素个数
  - shape 形状
  - dtype 元素类型，比如整型，浮点型
  - itemsize  元素占用的 byte 个数

- 操作

  - 创建 zeros,ones,full,empty,array,arange(浮点数时候会发生不确定性，比如1/3),linspace，gromfunction 支持生成器
- 随机数：rand（0-1之间均匀分布），randn（高斯分布）
  - reshape 调整数组的结构并返回新对象，原地修改shape属性可以直接调整结构，ravel展开成一维
- 算术运算  // 表示求商，\*\* 表示指数运算
  
  - 传播规则：如果操作数维度不一样，会尝试嵌套至维度一样，
    - 维度里个数不一样，假如只有一个数，那么复制该数
- 数学和统计方法
  
    - 均值 mean，min，max，summ，prod，std，var（方差）
  - sin, cos,exp,sqrt,...
  - 索引

    - 切片属于浅复制，深复制使用copy
    - 可以使用 tuple 指定操作行
  - ... 替代多个冒号
    - 可以使用布尔数组过滤，多维数组使用 ix_ 方法
- stack操作，可以水平拼接，垂直拼接
    - split操作，可以水平切分，垂直切分
  - 转置数组
    - transpose 转换数组的维度
    - T 线性代数转置  ，dot 点乘，inv 逆矩阵，det行列式，eig特征值
  - SVD分解，diag对角线，trace迹
  - 向量化
    - 使用 meshgrid 产生坐标矩阵，之后再进行操作。相比循环会极大加速

- 文件
  - 保存 save，加载 read/load
  - savetext可以使用scv格式，是savez产生npz格式文件