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