# Linux-101-hacks

- 书籍作者:Ramesh Natarajan
- 笔记时间: 2022.08.10

## 第一章 强大的cd命令

- 使用CDPATH定义默认搜索路径

  ```shell
  export CDPATH=/etc
  cd mail
  export CDPATH=.:~:/etc:/var
  ```

- 使用alias跳转目录

  ```shell
  alias ..="cd .."
  alias ..2="cd ../.."
  ```

- 创建目录并跳转

  ```shell
  ### .bash_profile  ###
  function mkdircd(){
  	mkdir -p "$@" && cd "\"$$#\"";
  }
  ```

- 操作目录栈

  ```shell
  cd -
  dirs 	## 展示目录栈
  pushd	## 压入目录栈
  popd	## 出栈并进入
  
  shopt -s cdspell		## 自动矫正
  
  ```

## 第二章 日期操作

- 修改日期/时间

  ```shell
  date {mmddhhmiyyyy.ss}
  date set="31 JAN 2009 22:19:53"
  date +%T -s "22:19:53"
  
  ## 硬件时间  
  hwclock –systohc
  cat /etc/sysconfig/clock
  
  # 展示日期时间
  date +"%A,%B %d %Y"
  date --date="1 year ago"
  date --date='4 hours'
  date --date="this Wednesday"
  # %D mm/dd/yy
  ```

  

## 第三章 SSH客户端

- 基本操作

  ```shell
  ssh -V
  ssh -l root 192.168.1.1		#登录
  ssh -v -l root 192.168.1.1
  
  ~Ctrl-Z 					#暂停远程ssh
  
  ```

  

## 第四章 必要的命令

- grep

  ```shell
  grep -v aaa /etc/passwd			#不符合则显示
  grep -c	....					# 显示个数
  	 -i							# 忽略大小写
  	 -r							# 递归查询
  	 -l							# 只显示文件名
  ```

- find

  ```shell
  find /etc -name "*mail*"		# 文件名查询
  find / -type f -size +100M		# 大于100M的文件
  find . -mtime -2				# 2天没修改的文件
  find / -type f -name *.tar.gz -size +100M -exec ls -l {} \;	#查看指定限制文件
  find . -type f -mtime +60 | xargs tar -cvf /tmp/a.tar
  ```

- 抑制标准输出与错误

  ```shell
  cat aa > /dev/null				#抑制标准输出
  cat aa 2> /dev/null				#抑制错误输出
  
  ```

- 文件操作

  ```shell
  join a b						#拼接文件
  tr a-z A-Z < a					#大小写转换
  sort -t: -u -k 2 names.txt		#排序操作,u=uniq
  ls -al | sort +4nr				#文件大小排序
cut -d: -f 1,3 names.txt		#显示1/3字段 
  ```
  
  

- xargs

  ```shell
  find ~ -name ‘*.log’ -print0 | xargs -0 rm -f
  find /etc -name "*.conf" | xargs ls –l
  cat url-list.txt | xargs wget –c
  find / -name *.jpg -type f -print | xargs tar -cvzf 
  images.tar.gz
  ```

- 文件/系统信息

  ```shell
  stat /etc/my.cnf		#查看文件详细信息
  stat -f /				#查看文件系统信息
  diff -w file1 file2		#文件对比
  ac -d					#用户每次登录时长
  ac -p					#所有用户登录时长
  
  
  ```

## 第五章 提示符

- PSx

  ```shell
  export PS1="\u@\h \w> "	#默认提示符
  export PS2="continue-> "#持续性输入提示符
  export PS3="#? "		#脚本select循环提示符
  export PS4="$0.$LINENO+"#debug执行脚本提示,set -x使用
  export PROMPT_COMMAND="date +%k:%m:%S"
  						#PS1之前调用
  ```

## 第六章 PS1的使用

- 展示不同信息

  ```shell
  \u	\h \W				#用户/主机/路径名
  \$(date +%k:%m:%S)		#时间,或者\t或者\a
  \!	\$?					#历史命令编号/命令状态
  export PS1="\e[0;34m\u@\h \w> \e[m "
  # \e[  	颜色提示开始
  # x;ym	指明颜色,Black 0;30  ~ 0;36
  # \e[m	颜色提示结束
  # \e[{code}m	指明背景色, \e[40m ~ \e[47m
  
  #可以使用 tpub 选择颜色
  tput setab		#使用ANSI escape 的背景色
  tput setaf		#使用ANSI escape 的前景色
  export PS1="\[$(tput bold)$(tput setb 4)$(tput setaf 
  7)\]\u@\h:\w $ \[$(tput sgr0)\]“
  ```

  

## 第七章 归档压缩

- zip / tar

  ```shell
  zip -r a.zip /tmp	#压缩
  zip -0 a.zip /tmp	#0-9级别压缩,9最大
  zip -P passwd a.zip /tmp	#添加密码
  
  unzip -l a.zip		#查看但不解压
  unzip -t a.zip		#测试解压
  
  tar cvzf a.tar /tmp	#归档并使用gzip压缩
  tar cvjf a.tar /tmp	#归档并使用bzip2压缩
  
  
  ```

  

## 第八章 历史命令

- 查看历史命令

  ```shell
  export HISTTIMEFORMAT='%F %T '
  history | more
  Ctrl-R					#搜索
  ↑ / !!	/ !-1 / Ctrl-P	#执行上次命令
  !N						#执行第N条历史命令
  !ps						#执行ps开头历史命令
  HISTSIZE=450 
  HISTFILESIZE=450		#设置历史命令条数
  HISTFILE=/root/.commandline_warrior
  						#修改历史命令保存文件
  export HISTCONTROL=ignoredups	#消除连续重复命令
  export HISTCONTROL=erasedups	#消除全文重复命令
  export HISTCONTROL=ignorespace	#不记录
  history -c				#清空
  
  vi !!:$					#获取上次命令最后一个参数 alt+.
  vi !^					#上次命令第一个参数
  ls -l !cp:2				#上次cp开头命令的第二个参数,$则表示最后一个参数
  export HISTSIZE=0		#禁用历史记录
  export HISTIGNORE=”pwd:ls:ls –ltr:”
  						#忽略某些命令
  ```

  

## 第九章 系统管理员任务

- 分区 / 文件系统

  ```shell
  fdisk 	/dev/sda		#准备分区
  
  mke2fsk	-m0 -b4096 /dev/sda1
  						#格式化分区,m表示root保留空间,b是块大小,产生ext2文件系统
  mkfs.ext3 /dev/sda1		
  mke2fs –j /dev/sda1		#ext3文件系统
  
  tune2fs -l /dev/sda1	#查看文件系统信息
  ```

- 挂载

  ```shell
  mount /dev/sda1 /home/database
  ## /etc/fstab  自动挂载
  /dev/sdaa /home/database ext3 defaults 0 2
  ```

- 创建交换文件系统

  ```shell
  dd if=/dev/zero of=/home/swap-fs bs=1M count=512		#创建交换文件
  mkswap /home/swap-fs	#创建交换区
  swapon /home/swap-fs	#使用交换区
  ```

  

- 用户管理

  ```shell
  adduser -c "John Smith - Oracle Developer" -e 12/31/09 jsmith
  	# -c 详细信息  -e 过期日期
  passwd jsmith		#修改密码
  useradd –D			#使用默认值
  
  groupadd developers	#创建组
  useradd -G developers jsmith
  id jsmith			#验证信息
  cat /etc/passwd
  cat /etc/group
  ```

- SSH免密登录

  ```shell
  ssh-keygen			#生成公钥私钥
  ssh-copy-id -i ~/.ssh/id_rsa.pub remote-host				#复制公钥到远程
  ssh remote-host		#登录
  
  ### 当 ssh-copy-id 失效时候
  ssh-agent $SHELL
  ssh-add -L
  ssh-add
  ```

- 定时

  ```shell
  crontab -e			#定时任务,l展示,r移除
  #min hour day month day-of-week full-path
  0 5 * * * /root/bin/backup.sh
  ```

  

- 安全重启

  ```shell
  Alt+SysRq+commandkey #SysRq是printscreen
  echo "1" > /proc/sys/kernel/sysrq	#开启sysrq按键命令
  # k 杀死当前虚拟终端所有在跑进程
  # s 同步挂载文件系统
  # b 立刻重启不同步
  # e 终止所有进程(除了init)
  # r 进入XLATE模式
  # u 重新用只读模式挂载
  
  echo "b" > /proc/sysrq-trigger 	#也可以如此处理
  r ==> e ==> k  ==>  s ==> u  ==> b 
  ```

## 第十章 服务器控制

- 假设已经安装了Apache服务器

  ```shell
  #检测配置文件
  httpd -t -f conf/httpd.conf.debug
  #指定配置文件
  apachectl -f conf/httpd.conf.debug
  httpd -k start -f conf/httpd.conf.debug
  # 测试完成
  cp httpd.conf.debug httpd.conf
  apachectl start
  
  # 指定网站路径
  httpd -k start -c “DocumentRoot /var/www/html_debug/
  #默认路径
  httpd -k stop && apachectl start
  
  #临时修改日志级别
  httpd -k start -e debug
  
  #展示所有模块
  httpd -l  
  httpd –M
  
  #参数配置,加载指定模块
  httpd –V		#显示参数
  httpd -k start -e debug -Dload-ldap -f
  ```

  

## 第十一章 Bash脚本

- 执行顺序

  ```shell
  # 用户登录
  /etc/profile
  ~/.bash_profile		#存在则执行,否则
  ~/.bash_login		#存在则执行,否则
  ~/.profile
  
  # 用户登出
  ~/.bash_logout
  
  # 非交互shell
  ~/.bashrc			#代码执行 /etc/profile
  	
  ```

  

- 随机数 / 调试脚本

  ```shell
  echo $RANDOM
  ## 调试脚本 xxx.sh
  set -xv
  bash -xv filesize.sh#或者调用时候传参
  
  # 引号
  # 单引号不解析 双引号会解析
  
  # 脚本读取文本
  #!/bin/bash 
  IFS=: 
  echo "Employee Names:" 
  echo "---------------" 
  while read name empid dept
  do 
   echo "$name is part of $dept department" 
  done < ~/employees.txt
  ```

## 第十二章 系统监控与性能分析

- 系统信息

  ```shell
  free -mto		#内存 m-MB t-汇总 o-隐藏缓冲
  df -Tha			#硬盘剩余空间
  du -sh ~		#占用空间大小,s-汇总
  
  ```

  

- 进程信息

  ```shell
  ps -auxf 		#进程树
  ps U tom		#属于指定用户
  
  #top
  F  				#选择不同排序,比如按内存占用排序
  f				#增加新输出
  c				#显示完整路径
  1				#每个CPU
  
  
  # kill
  kill -9 id	
  
  
  #lsof 表示 ls open files
  lsof -u tom
  lsof /bin/vi
  ```

  

- sar

  ```shell
  # 用于监控系统信息,在 sysstat 包中
  #Sadc - System activity data collector
  /usr/lib/sax	#x=1..n,不同功能脚本
  #sa1 调用 /usr/lib/sadcs 每5分钟执行一次
  #sa2 每天报告
  sar -u 			#查看cpu数据
  sar -u -P ALL	#查看每个核
  sar -d			#IO数据
  sar -n DEV /SOCK#网络数据
  ```

- vmstat

  ```shell
  # 传统监控
  vstat 1 100		#每秒执行100次
  
  # netstat 网络分析
  netstat -antp	#tcp 查看端口/进程名/id
  netstat --route	#路由表
  netstat --statistics --raw	#原始数据
  ```

- systemctl

  ```shell
  sysctl -a		#查看所有控制
  
  vi /etc/sysctl.conf 	#编辑并应用
  sysctl –p
  
  sysctl –w {variable-name=value}	#临时修改
  ```

- nice

  ```shell
  #优先级
  ps -axl		# -20 ~ +20 ,-20最大,默认0
  nice --10 ./nice-test.sh &	#调整优先级
  renice 16 -p 13245
  ```

  