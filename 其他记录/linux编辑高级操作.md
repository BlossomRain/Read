# sed、awk、grep

## 1. Awk操作

- 是一种语言，对文本逐行进行操作

- ```sh
   awk -F ":" '{print NF " " NR}' /etc/passwd # 根据：分割，打印列数和当前行数
   echo | awk 'BEGIN{a="100testabc"} a~/test/{print "ok"}'#~/正则匹配
   awk 'BEGIN{a=100;if(a>99){print "ok"}}'	#支持编程
   #内置变量 NF列数 NR行号 FS输入分隔符 RS记录分隔符；FS="\n"每个字段占据一行，RS=""记录由空白行分割
   ifconfig eth0 | awk -F [" ":]+ 'NR==2{print $5}'	#截取IP
    ll *.txt | awk ' {name=$9;gsub(/-/,"_",name);print name;system("mv "$9" "name )}'	#将文件名重命名
  ```

  

## 2. sed操作

- 执行和vi相同的编辑任务

- ```shell
  nl data | sed  '3,$d' |  sed '/north/d'		#删除行
  nl data | sed 's#north#south#g'				#变换分隔符
  nl data | sed -n  '/west/,/east/p'			#指定范围
  nl data | sed  '/west/,/east/s/$/**CAFE**/'	#指定范围修改
  nl data | sed -e '1,3d' -e 's/txt/jpeg/' 	#多重修改
  # a行追加  i行插入 c行修改  s替换 n下一行 y转换命令 q退出
  nl data | sed  '/eastern/{n;s/AM/-----/;}'
  ```

## 3. grep操作

- ```shell
  cat data | grep '\<north\>'					#精确定位单词north
  # -n显示行号 -i忽略大小写 -v不包含的行 -l只显示文件 -c
  ```
  
  

# vim

- ```shell
  V31j						#选中当前行往下31行，批量操作
  
  # 替换，\zs 表示匹配开始，\ze表示匹配结束，\=表明是一个表达式，line(".")表示当前行，line("'<")表示选择的开始行
  :'<,'>s/BIT_MASK_\zs\d*\ze/\=line(".") - line("'<") + 1 
  
  # let 变量赋值，|分隔命令，g匹配后面执行命令，\d\+多个数字，
  :let n=0 | g/opIndex(\zs\d\+/s//\=n/|let n+=1 
  
  :%s/\w//gn									#只匹配显示单词数量
  :%s/\d\+/\=printf("%X", submatch(0))/g		#转换为16进制
  :s/^/\=range(5, 100, 2) 					#生成序列
  ```

  

- 宏

  ```shell
  :let i = 1	#记录变量
  qa			#开始记录操作
  I<C-r>=1<CR>.<ESC>	#行首插入1.
  :let i+=1	#变量加一
  q			#结束录制
  100@a		#重复一百次
  ggVjG:normal @a	#表示从头到尾执行宏
  ```

  