# 图书管理系统

## 项目介绍
🔥 SSM + MySQL + Vue2.x + ElementUI 🔥

本项目使用 Idea 开发工具采用当前最火的Java + Web前端框架开发，在保证质量的同时界面美观，交互友好，实在是期末大作业的首选项目。

## 软件架构

使用软件设计三层架构 + 前后端分离开发：

* 控制Controller层：接收以及响应数据。
* 业务Service层：对业务逻辑的封装，对数据层方法进行组装。
* 数据Dao层：和数据库进行交互，进行数据的增删改查。
* 前端资源页面：放在webapp目录下面，用于前端页面展示。

> Dao：data access object

## 使用前提

下载该项目之前需要下载JDK8+、Maven、MySQL。

## 项目页面

本项目实现了用户登录/退出功能、图书信息以及借阅者信息的增删改查功能。

<img src="https://gitee.com/linxuanstar/bookProject/raw/master/src/main/resources/img/2-1.png"/>

<img src="https://gitee.com/linxuanstar/bookProject/raw/master/src/main/resources/img/2-2.png" />

<img src="https://gitee.com/linxuanstar/bookProject/raw/master/src/main/resources/img/2-3.png" />

## 安装教程

如果您并未学习过 Git 或者是并不喜欢 Git 亦或是不想使用 Git 这款工具，那么可以直接从网盘下载。

- 百度网盘Windows链接：https://pan.baidu.com/s/1waV4zjt9NImKwN6VvdAsEA?pwd=ugyz 

- 阿里云Windows链接：https://www.aliyundrive.com/s/tU8bPKChben
- 蓝奏云Windows链接：https://wwdi.lanzoum.com/iJ6Hq0wpbi1i
- 蓝奏云Centos链接：https://wwdi.lanzoum.com/iIBzG0wt8sad 密码:8jg3
- Linux用户也可以下载windows版本文件然后选择所需的文件上传至Linux服务器，最后运行即可！
## 部署说明

### Windows部署

可以参考《基于SSM 图书管理系统的设计与实现.docx》这个文档。

1. 导入SQL文件。

   创建一个数据库然后使用图形化界面或者`source`命令将`src\main\resources\demand\bookmanage.sql`导入MySQL数据库中。

   ```sql
   -- 这里演示一下使用MySQL命令方式将SQL文件导入
   -- 创建linxuan数据库
   mysql> create database if not exists linxuan;
   Query OK, 1 row affected, 1 warning (0.02 sec)
   
   -- 使用linxuan数据库
   mysql> use linxuan;
   Database changed
   
   -- 导入SQL文件，注意SQL文件不要放在中文目录下面。可以直接复制放在D盘下面，使用完之后删除掉。
   mysql> source /usr/local/bookmanage.sql
   Query OK, 0 rows affected (0.00 sec)
   ...
   ```

2. 修改MySQL连接信息。

   修改`src\main\resources\jdbc.properties`里面的数据库连接URL、连接用户名、连接密码。

   ```properties
   # MySQL驱动，如果是MySQL8不用修改，之前的版本修改为com.mysql.jdbc.Driver
   jdbc.driver=com.mysql.cj.jdbc.Driver
   # MySQL连接信息，将linxuan数据库更改你自己的数据库名称
   jdbc.url=jdbc:mysql://localhost:3306/linxuan?useSSL=false
   # MySQL用户名，可以不更改
   jdbc.username=root
   # 更改为你自己的登录密码
   jdbc.password=123456
   ```

3. 下载Lombok插件。

   Lombok能够帮助我们简化开发，使用它不仅需要在`pom.xml`中引入依赖，同样需要在IDEA里面下载该插件。点击File -> Settings -> Plugins，转到插件仓库。

   <img src="https://gitee.com/linxuanstar/bookProject/raw/master/src/main/resources/img/1-2%E4%B8%8B%E8%BD%BDLombok%E6%8F%92%E4%BB%B6.png" />

4. 下载依赖。

   点击Maven刷新图标，下载所需依赖。

   <img src="https://gitee.com/linxuanstar/bookProject/raw/master/src/main/resources/img/1-1Maven%E5%88%B7%E6%96%B0.png" />

5. 启动项目。

   本项目使用了 Tomcat 插件解决了用户部署困难的问题，所以这里仅教授采用插件来部署项目。您可自行选择是否使用本地 Tomcat 来部署项目。

   下载好所有的 Maven 依赖之后点击 Maven 图标，找到Plugins，点击「tomcat7:run」即可成功启动。打开浏览器http://localhost/page/login.html页面即可成功访问，账号为admin，密码为123456。

   <img src="https://gitee.com/linxuanstar/bookProject/raw/master/src/main/resources/img/1-3%E5%90%AF%E5%8A%A8%E9%A1%B9%E7%9B%AE.png" />

### Linux部署

部署前提：安装JDK + Maven + MySQL

#### Git 方式

在本仓库一共有两个分支，master和test，其中test分支并没有《基于SSM 图书管理系统的设计与实现.docx》文档，因此下载速度较快。当然上面网盘的压缩包里面是有这个文档的。

```sh
[root@linxuanVM ~]# cd /opt/app/test/
[root@linxuanVM test]# ll
total 0

# 克隆test分支
[root@linxuanVM test]# git clone -b test git@github.com:linxuanstar/bookProject.git
Cloning into 'bookProject'...
remote: Enumerating objects: 153, done.
remote: Counting objects: 100% (153/153), done.
remote: Compressing objects: 100% (120/120), done.
remote: Total 153 (delta 22), reused 151 (delta 20), pack-reused 0
Receiving objects: 100% (153/153), 36.41 MiB | 5.66 MiB/s, done.
Resolving deltas: 100% (22/22), done.

# 查看克隆下来的文件
[root@linxuanVM test]# cd bookProject/
[root@linxuanVM bookProject]# ll
total 56
-rw-r--r-- 1 root root 35147 May 21 11:10 LICENSE
-rw-r--r-- 1 root root  5521 May 21 11:10 pom.xml
-rw-r--r-- 1 root root  4619 May 21 11:10 README.md
drwxr-xr-x 4 root root  4096 May 21 11:10 src

# 登录MySQL将SQL文件给导入数据库中
[root@linxuanVM bookProject]# mysql -u root -p
Enter password: 
# 创建linxuan数据库
mysql> create database if not exists linxuan;
Query OK, 1 row affected, 1 warning (0.02 sec)
# 使用linxuan数据库
mysql> use linxuan;
Database changed
# 导入SQL文件
mysql> source /opt/app/test/bookProject/src/main/resources/demand/bookmanage.sql
Query OK, 0 rows affected (0.00 sec)
...
# 退出MySQL
mysql> exit

# 看一下是否需要修改自己的MySQL连接信息，用户名、密码是否正确。
# 如果需要修改那么使用 vim 命令修改./src/main/resources/jdbc.properties文件


# 执行tomcat7插件，这样就开始运行了，日志会在控制台打印。如果想要日志在文件中打印需要配置log4j.xml
# 执行该插件之后会下载系列的jar包，用于编译、测试、打包...
[root@linxuanVM bookProject]# mvn tomcat7:run
```

插件中设置的端口号为80，因此打开本地浏览器访问http://YourLinuxIP/page/login.html页面即可成功访问，账号为admin，密码为123456。

#### 压缩包下载

```sh
# 使用lrzsz或者FileZilla等文件上传工具将压缩包上传至Linux服务器
[root@linxuanVM test]# ll
total 856
-rw-r--r-- 1 root root 869207 May 21 14:42 bookProject.tar.gz
drwxr-xr-x 3 root root   4096 May 21 14:38 bookProjectTmp
# 将文件解压至当前目录
[root@linxuanVM test]# tar -zxvf bookProject.tar.gz 
...

# 查看当前目录下文件
[root@linxuanVM test]# ll
total 860
drwxr-xr-x 3 root root   4096 May 21 14:43 bookProject
-rw-r--r-- 1 root root 869207 May 21 14:42 bookProject.tar.gz
drwxr-xr-x 3 root root   4096 May 21 14:38 bookProjectTmp
# 进入bookProject目录
[root@linxuanVM test]# cd bookProject
# 查看当前目录下面文件
[root@linxuanVM bookProject]# ll
total 56
-rw-r--r-- 1 root root 35821 May 21 14:38 LICENSE
-rw-r--r-- 1 root root  5671 May 21 14:38 pom.xml
-rw-r--r-- 1 root root  6467 May 21 14:38 README.md
drwxr-xr-x 4 root root  4096 May 21 14:38 src


# 登录MySQL将SQL文件给导入数据库中
[root@linxuanVM bookProject]# mysql -u root -p
Enter password: 
# 创建linxuan数据库
mysql> create database if not exists linxuan;
Query OK, 1 row affected, 1 warning (0.02 sec)
# 使用linxuan数据库
mysql> use linxuan;
Database changed
# 导入SQL文件
mysql> source /opt/app/test/bookProject/src/main/resources/demand/bookmanage.sql
Query OK, 0 rows affected (0.00 sec)
...

# 看一下是否需要修改自己的MySQL连接信息，用户名、密码是否正确。
# 如果需要修改那么使用 vim 命令修改./src/main/resources/jdbc.properties文件


# 执行mvn clean命令，看一下mvn是否可以成功运行
[root@linxuanVM bookProject]# mv clean
# 执行tomcat7插件，这样就开始运行了，日志会在控制台打印。如果想要日志在文件中打印需要配置log4j.xml
# 执行该插件之后会下载系列的jar包，用于编译、测试、打包...
[root@linxuanVM bookProject]# mvn tomcat7:run
```

插件中设置的端口号为80，因此打开本地浏览器访问http://YourLinuxIP/page/login.html页面即可成功访问，账号为admin，密码为123456。

## 注意事项

* 修改前端页面后浏览器没有更换样式，那么可以使用「Ctrl + F5」快捷键清除浏览器缓存强制更新前端页面。
* 数据库的 SQL 文件在逻辑上是有一点问题的，可以自行修改。

## 联系方式

如果有什么问题可以使用邮箱联系我：linxuan123_n@163.com
