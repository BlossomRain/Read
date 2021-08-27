# CentOS7 安装事项

## 1. 一些设置

- 出现wi-fi无法连接，提示Make sure you have a Wi-Fi adapter plugged and turned on
  - 执行ifconfig，只有virbr0；
  - 执行`dhclient -v`，可以看到一直使用 ens33
  - 关闭防火墙，使用xshell可以连接，上网

- 启动脚本
  - 将脚本存放的绝对路径+脚本全名追加到 /etc/rc.d/rc.local 文件最后。执行 `chmod +x /etc/rc.d/rc.local`
  - 将脚本移动到 /etc/rc.d/init.d 目录下，增加可执行权限

- 关闭防火墙
  - `systemctl stop firewalld.service  `，使用 `systemctl status firewalld.service  `查看关闭情况
  - `systemctl disable firewalld.service` 禁用防火墙

- 修改yum源

  - ```shell
     # backup
     mv /etc/yum.repos.d/CentOS-Base.repo /etc/yum.repos.d/CentOS-Base.repo.backup
     # update yum repo
     cd /etc/yum.repos.d/
     # wget http://mirrors.163.com/.help/CentOS7-Base-163.repo
     wget -O /etc/yum.repos.d/CentOS-Base.repo http://mirrors.aliyun.com/repo/Centos-7.repo
    # update cache
    yum makecache
    yum -y update
    ```

    

