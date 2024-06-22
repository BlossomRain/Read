# CPP开发注意事项

- 笔记时间:2022.4.20

## 1.OpenCV开发问题

### d后缀的依赖库问题

- opencv的库带分为带d和不带d的版本,表示是否为Debug环境,在搭建环境的时候一定要注意和vs开发环境对应,

  比如下图的Debug对应的就是带d的版本,Release则代表使用不带d的版本

  ![image-20220420144700962](images/image-20220420144700962.png)



















# Ubuntu下OpenCV环境搭建

- 笔记时间:2022.4.14

## 1 步骤

- [官网查看](https://docs.opencv.org/4.5.5/df/d65/tutorial_table_of_content_introduction.html)
- 环境Ubuntu

### 下载并编译Opencv-Linux

- 编译核心模块

- ```shell
  # Install minimal prerequisites (Ubuntu 18.04 as reference)
  # 安装依赖
  sudo apt update && sudo apt install -y cmake g++ wget unzip
  # Download and unpack sources
  #下载源码
  wget -O opencv.zip https://github.com/opencv/opencv/archive/4.x.zip
  unzip opencv.zip
  # Create build directory
  # 创建编译目录并编译
  mkdir -p build && cd build
  # Configure
  cmake  ../opencv-4.x
  # Build
  cmake --build .
  ```

- 安装

- ```shell
  # 安装会把头文件/库安装到 /usr/local/lib , /usr/local/inclue ...,用户需要使用root权限
  sudo make install
  # 默认依赖库是在 /usr/lib查找,所以添加库查找
  vim /etc/ld.so.conf
  # 添加库,内容如下
  include /etc/ld.so.conf.d/*.conf
  /usr/local/lib/
  ```

- 验证是否成功

- ```cpp
  #新建一个cpp文件
  #include <iostream>
  #include <opencv2/opencv.hpp>
  
  int main() {
  	std::cout << "hello world";
  	cv::Mat a(10, 10, CV_8U, 10);
  	std::cout << a << std::endl;
  	return 0;
  }
  ```

- ```shell
  #假如没有错误应该正确生成
  g++ main.cpp\
  -I/usr/local/include/opencv4 \
  -I/usr/local/include/opencv4/opencv2 \
  -L /usr/local/lib \
  -l opencv_core 
  
  #,测试无报错就成功
  ./a.out
  
  ```

  







### Visual Studio 2019 配置

- 建立远程连接跨平台项目,项目配置好需要的头文件和库

- 项目属性 - 配置属性 - VC++目录

  - ```shell
    # 包含目录,头文件的位置,需要先查看一下在哪里
    /usr/local/include/opencv4/
    /usr/local/include/opencv4/opencv2
    ```

  - ```shell
    # 库目录, so文件所在
    /usr/local/lib
    ```

    

- 项目属性 - 配置属性 - 链接器

  - ```shell
    # 输入 - 库依赖项,指定需要用到的库
    opencv_calib3d
    opencv_core
    opencv_features2d
    opencv_flann
    opencv_highgui
    opencv_imgproc
    opencv_ml
    opencv_objdetect
    opencv_photo
    opencv_stitching
    opencv_video
    rt
    pthread
    m
    dl
    ```

    

# Windows OpenCV 环境搭建

## 1 步骤

- [官网](https://opencv.org/releases/)

  ![image-20220418163056916](images/image-20220418163056916.png)

- 下载安装,选择安装目录可以自定义安装即可,不要有中文路径

- 修改环境变量,位置是刚才安装路径中的  opencv/build/x64/vc15/bin

  ![image-20220418163356328](images/image-20220418163356328.png)

- VS配置

  - 项目调试环境改为x64![image-20220418164010124](images/image-20220418164010124.png)
  - 打开项目属性 - 配置属性 - VC++目录 包含目录,添加对应的include![image-20220418163641200](images/image-20220418163641200.png)
  - 库目录,跟include同级别的lib![image-20220418163735651](images/image-20220418163735651.png)
  - 最后链接器-输入-附加依赖项,添加lib![image-20220418163859242](images/image-20220418163859242.png)

