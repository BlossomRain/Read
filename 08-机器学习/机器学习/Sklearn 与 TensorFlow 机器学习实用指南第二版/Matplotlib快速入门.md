# Matplotlib快速入门

- [笔记来源](https://matplotlib.org/3.5.1/tutorials/introductory/images.html)

- 笔记时间：2022.02.28

## 1 基础操作

### 1.1 绘图

- plot 放置数据，数据可以是值/坐标，可以指定线条样式，show 绘图，axis 坐标范围
- linspace 均分，title 图标题，xlabel 坐标轴名称，grid 显示网格
- 可以通过set_xxx设置线条的各种样式
- savefig保存图像
- subplot（2，2，1）表示两行两列，放置在第一幅

- figure创建多个画布
- text绘制文字，可以设置各种样式

- 图例 legend
- yscale 坐标轴缩放，xaxis.set_ticks坐标轴刻度
- 设置subplot函数的参数 projection=‘polar’ 极坐标映射

- scatter 绘制散点图