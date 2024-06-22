# WPF开发经验小结

- 笔记时间：2021.10.20

## 1. 前端界面设计

### 1.1 一些小技巧

- 使用表格、列表等展示时，可以全部展示，然后利用绑定某个字段进行显示控制进行隐藏。

  通过控制Visibility进行控制，需要注意Hidden的取值会导致对象被卸载。

- 数据模板选择器，在绑定对象的时候会有问题，需要通过父级对象获取上下文强制转为父类ItemsSource列表绑定的对象

  ````C#
  ContentPresenter presenter = container as ContentPresenter;
  DataGridCell cell = presenter.Parent as DataGridCell;
  // CustomClass 为自定义的对象
  CustomClass multiItem = (cell.DataContext as CustomClass);
  ````


- 一个控件在不同的条件下需要展示不同形式（比如下拉列表或者输入框），可以利用数据模板选择器进行处理或者利用TabItem控制其隐藏/展示。

### 1.2 DataGrid展示大列表问题及解决

- 利用数据绑定和DataView，DataGrid可以分组展示。其中数据分组的组名（Expender）的上下文（DataContext）会被设置为DataView，可以通过Loaded重新绑定上下文。
- 每次刷新视图都会刷新分组（Expender），会重复触发Loaded回调，造成画面抖动。可以使用1.1的小技巧控制显示/隐藏，而不是更新数据源然后刷新视图。
- DataGrid在分组情况下，约几百条就开始卡顿，可以使用虚拟化加速。使用的时候可能有一些Bug，比如分组列表会展示不全（[解决](https://www.it1352.com/6851.html)）

### 1.3 透明问题以及DLL引入

- C# 引用外部SDK或者别的DLL时候，建议使用类库的方式导入；
- 使用反射获取当前程序集会获取该可执行文件的用到的所有DLL，假如有缺，会报错；
      但是使用别的库引入则不会发生该情况
- 窗体使用AllowTransparency 会出现许多问题
   - 视频监控使用PictureBox会导致画面无法显示
  - 应用内存会爆增 
