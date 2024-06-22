# Pandas快速入门

- [笔记来源](https://pandas.pydata.org/pandas-docs/stable/getting_started/intro_tutorials/01_table_oriented.html)

- 笔记时间：2022.02.28

## 1 基础操作

### 1.1 Series对象

- 主要操作对象，是一维数组，具有列名
  - 创建 Series，支持numpy的算术操作
  - 创建时候可以指定索引名，传入index参数
  - 访问时候可以使用loc或者iloc或者直接中括号访问，推荐使用前两者
  - 可以从dict初始化，可以给Series对象指定名称
- 时间操作
  - date_range，参数可以指定范围，采样频率 
  - resample重采样，采样频率增加可以配合插值interpolate
  - tz_localize指定时区，cvt_localize转换时区
  - period_range 指定生成的时间范围，

### 1.2 DataFrame对象

- 当成关系型数据库的一张表，索引可以使用public/private修饰，支持tuple
- 支持索引行删除 droplevel，转置T，合并stack，loc/iloc获取列
- 添加列直接加，删除使用del
- 可以通过assign创建新的列
- query支持查询语句，sort_index排序，fillna填充NaN，dropna删除NaN行/列
- 

### 1.3 文件

- 可以保存为csv/html/json/excel，调用to_xxx
- 加载 read_xxx
- 可以像SQL表操作，内联，外联