# Win10打造Shell环境

- 时间：2021.8.4

## 1.软件准备

- [Git-for-windows](https://git-scm.com/download/win)
- Windows Terminal （Microsoft Store可下载）

## 2.环境配置

- 将Git的家目录下的bin加入环境变量，步骤如下：
  1. 搜索环境变量![](D:\reading\read\其他记录\images\image-20210805182908311.png)
  2. 添加`GIT_HOME`环境变量，值为安装目录![屏幕截图 2021-08-05 183151](images/屏幕截图 2021-08-05 183151.png)
  3. 新建环境变量![image-20210805183516999](images/image-20210805183516999.png)
  4. 修改Path，增加bin和usr/bin，两行![image-20210805183634344](images/image-20210805183634344.png)
  5. 此时，通过 Win+R，输入bash，可以打开git的bash界面![](images/屏幕截图 2021-08-05 183853.png)![屏幕截图 2021-08-05 183859](images/屏幕截图 2021-08-05 183859.png)

- 配置Windows Terminal
  - 添加启动命令![image-20210805184219149](images/image-20210805184219149.png)![image-20210805184345204](images/image-20210805184345204.png)
  - 顺便设置启动命令![image-20210805184526044](images/image-20210805184526044.png)
  - 到这里已经可以使用shell的命令了

## 3.细节优化

- 更改背景，在 Windows Terminal》配置文件》bash》高级可以设置
- 添加快捷键，在 Windows Terminal 的快捷方式右键，添加快捷键。直接将图标拖动到桌面就可以创建快捷方式。
- 打造Vim，在 GIT_HOME/dev/vimrc 可以进行配置，等价于 linux 里面的 .vimrc
  - 用到了[plug.vim](https://github.com/junegunn/vim-plug)，可以直接搜索github查看教程。
- 远程登陆Linux
  - [使用ssh连接](https://gitee.com/help/articles/4181#article-header0)
  - 连接github和Linux原理一致，自行查找资料即可

