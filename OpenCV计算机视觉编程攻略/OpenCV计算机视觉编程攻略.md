# OpenCV计算机视觉编程攻略

- 书籍作者:[[加\] Robert Laganière](https://book.douban.com/search/Robert Laganière)
- 笔记时间:2022.04.13

## 第1章 图像编程入门

- 安装,使用vs开发下载后引入头文件和对应的lib库即可

  使用mingw则需要自行编译后引入使用

- ```c++
  // Mat类型是头部有一个data指针指向数据,直接复制是浅复制
  // 前两个参数表示行列
  // CV_8U表示8位无符号,CV_8UC3表示三个通道
  // Scalar表示当前图像填充的值
  cv::Mat img(240,320,CV_8U,100);
  
  // 用于重新分配图像
  img.create();
  img.copyTo();
  img.clone();
  
  // 由于直接使用浅复制,所以不要直接返回类的成员
  ```

- 除了Mat还有其他类型的矩阵,比如Matx,Matx3d等表示小矩阵

- ROI

  - ```C++
    // 定义Mat时候指定范围或者使用两个 cv::Range表明范围
    cv::Mat imageROI(image, 
        cv::Rect(image.cols-logo.cols, // ROI 坐标
        image.rows-logo.rows, 
        logo.cols,logo.rows)); // ROI 大小
    
    // cv::copyTo()可以指定掩码
    ```

    

## 第2章 操作像素

- 



## 附录