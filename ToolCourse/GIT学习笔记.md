# GIT学习笔记

## 安装配置

下载地址：[http://git-scm.com/](http://git-scm.com/)

### Linux平台

Git的工作需要调用curl、zlib、openssl、expat、libiconv等库的代码，所以需要先安装这些依赖工具。在有yum的系统上（比如Fedora）apt-get的系统上（比如Debian体系），可以使用以下命令

* Debian/Ubuntn

  ```shell
  $ apt-get install libcurl4-gnutls-dev libexpat1-dev gettext \
    libz-dev libssl-dev
  $ apt-get install git-core
  $ git --version
  git version 1.8.1.2
  ```


* Centos/RedHat
```shell
$ yum install curl-devel expat-devel gettext-devel \
  openssl-devel zlib-devel
$ yum -y install git-core
$ git --version
git version 1.7.1
```

### Windows平台

安装包下载地址：[http://msysgit.github.io/](http://msysgit.github.io/)

安装完成之后，就可以使用命令行的git工具（自带ssh客户端），还有一个图形界面的git项目管理工具。在开始菜单里找到“Git”->"Git Bash",会弹出Git命令窗口，可以在该窗口进行Git操作

### Mac平台

下载地址：[http://sourceforge.net/projects/git-osx-installer/](http://sourceforge.net/projects/git-osx-installer/)

## Git配置

Git提供了一个叫做git config的工具，专门用来配置或读取相应的工作环境变量。这些环境变量，决定了Git在各个环节的具体工作方式和方法。这些变量可以存放在以下三个不同的地方：

* /etc/gitconfig文件：系统中对所有用户都普遍使用的配置。若使用git config时用--system选项，读写的就是这个文件
* ~/.gitconfig文件：用户目录下的配置文件只适用于该用户。若使用git config时用--global选项，读写的就是这个文件
* 当前项目的Git目录中的配置文件（也就是工作目录中的.git/config文件）：这里的配置仅仅针对当前项目有效。每个级别的配置都会覆盖上层的相同配置。

在Windows系统上，Git会寻找用户目录下的.gitconfig文件。主目录$HOME变量指定的目录，此外，Git还会尝试寻找/etc/gitconfig文件，只不过看当初装在什么目录，就以此作为根目录来定位

### 用户信息

```shell
配置个人的用户名称和电子邮件地址：

$ git config --global user.name "runoob"
$ git config --global user.email test@runoob.com

--global 参考工作环境变量设置
```

### 文本编辑器

```shell
设置Git默认使用的文本编辑器, 一般可能会是 Vi 或者 Vim。如果你有其他偏好，比如 Emacs 的话，可以重新设置：
$ git config --global core.editor emacs
```

###  差异分析工具

```shell
还有一个比较常用的是，在解决合并冲突时使用哪种差异分析工具。比如要改用 vimdiff 的话：
$ git config --global merge.tool vimdiff
Git 可以理解kdiff3、tkdiff、xxdiff、emerge、vimdiff、ecmerge、opendiff等合并工具的输出信息
```

### 查看配置信息

```shell
要检查已有的配置信息，可以使用 git config --list 命令：
$ git config --list
http.postbuffer=2Muser.name=runoob
user.email=test@runoob.com
有时候会看到重复的变量名，那就说明它们来自不同的配置文件（比如 /etc/gitconfig 和 ~/.gitconfig），不过最终 Git 实际采用的是最后一个。
这些配置我们也可以在 ~/.gitconfig 或 /etc/gitconfig 看到，如下所示：
vim ~/.gitconfig
显示内容如下所示：
[http]
    postBuffer = 2M[user]
    name = runoob
    email = test@runoob.com
也可以直接查阅某个环境变量的设定，只要把特定的名字跟在后面即可，像这样：
$ git config user.name
runoob
```

## Git工作流程

一般的工作流程如下：

* 克隆Git资源作为工作目录
* 在克隆的资源上添加或修改文件
* 如果其他人修改了，你可以更新资源
* 在提交前查看修改
* 提交修改
* 修改完成后，如果发现错误，可以撤回并再次修改并提交

![](https://edu.aliyun.com/files/course/2017/09-25/174429daa761260095.png)

## 基本概念

* 工作区：在电脑里能看到的目录
* 暂存区：英文叫stage或index。一般存放在“.git目录“下的index文件（.git/index）中，所以把暂存区也叫做索引（index）
* 版本库：工作区有个隐藏目录.git，这个不算工作区，而是Git的版本库

 ![](https://edu.aliyun.com/files/course/2017/09-25/1745459ca252743119.jpg)

图中左侧为工作区，右侧为版本库。在版本库中标记为 "index" 的区域是暂存区（stage, index），标记为 "master" 的是 master 分支所代表的目录树。

图中我们可以看出此时 "HEAD" 实际是指向 master 分支的一个"游标"。所以图示的命令中出现 HEAD 的地方可以用 master 来替换。

图中的 objects 标识的区域为 Git 的对象库，实际位于 ".git/objects" 目录下，里面包含了创建的各种对象及内容。

当对工作区修改（或新增）的文件执行 "git add" 命令时，暂存区的目录树被更新，同时工作区修改（或新增）的文件内容被写入到对象库中的一个新的对象中，而该对象的ID被记录在暂存区的文件索引中。

当执行提交操作（git commit）时，暂存区的目录树写到版本库（对象库）中，master 分支会做相应的更新。即 master 指向的目录树就是提交时暂存区的目录树。

当执行 "git reset HEAD" 命令时，暂存区的目录树会被重写，被 master 分支指向的目录树所替换，但是工作区不受影响。

当执行 "git rm --cached <file>" 命令时，会直接从暂存区删除文件，工作区则不做出改变。

当执行 "git checkout ." 或者 "git checkout -- <file>" 命令时，会用暂存区全部或指定的文件替换工作区的文件。这个操作很危险，会清除工作区中未添加到暂存区的改动。

当执行 "git checkout HEAD ." 或者 "git checkout HEAD <file>" 命令时，会用 HEAD 指向的 master 分支中的全部或者部分文件替换暂存区和以及工作区中的文件。这个命令也是极具危险性的，因为不但会清除工作区中未提交的改动，也会清除暂存区中未提交的改动。

## Git 仓库操作

###  创建仓库

```shell
git init [newrepo(指定目录)]
初始化Git仓库并在当前目录生成一个.git目录，该目录包含了所有的元数据
```

### 提交文件

```shell
$ git add *.c
$ git add README
$ git commit -m '初始化项目版本'
将当前目录下的几个文件版本控制，git add告诉Git开始对这些文件进行跟踪
```

### 拷贝项目（类似svn checkout）

```shell
克隆仓库的命令格式：$ git clone <repo>
克隆到指定目录：$ git clone <repo> <directory>

参数说明：
	repo：Git仓库
	directory：本地目录
```

## Git基本操作

* git init

```shell
$ mkdir runoob
$ cd runoob/
$ git initInitialized empty Git repository in\ /Users/tianqixin/www/runoob/.git/
# 在 /www/runoob/.git/ 目录初始化空 Git 仓库完毕。
```

* git clone


参考项目拷贝

```shell
$ git clone git@github.com:schacon/simplegit.gitCloning into 'simplegit'
克隆完成后，在当前目录下会生成一个simplegit目录：
$ cd simplegit/ 
$ ls README Rakefile lib
```

* git add


```shell
$ git add README hello.php
```

* git status

```shell
$ git status -s
查看项目的当前状态
-s：获取简短输出，不加会输出详细内容
```

* vim


```shell
$ vim README
$ git status -s
AM README
A hello.php
AM:文件在添加到缓存之后又有改动
```

* git diff


```shell
git diff 尚未缓存的改动
git diff --cached 查看已缓存的改动
git diff HEAD 查看已缓存与未缓存的所有改动
git diff --stat 显示摘要而非整个diff
```

* git commit


```shell
将缓存区内容添加到仓库
$ git commit -m '第一次版本提交'
如果觉得git add 提交缓存的流程泰国繁琐，Git允许使用-a跳过这一步
$ git commit -a
$ git commit -am '修改文件'
```

* git reset HEAD

```shell
git reset HEAD --hello.php
取消hello.php缓存的内容，如果不加--hello.php,会取消所有的缓存内容，即该命令是取消之前git add添加的，但不希望包含在下一提交快照中的缓存。
```

* git rm

```shell
$ git rm hello.php
默认情况下，会将文件从缓存区和硬盘（工作目录）删除，如果要在工作目录中保留该文件，可以使用 $ git rm --cached
与git reset HEAD的区别
git reset HEAD: 表示取消缓存，即将缓存恢复为做出修改之前的样子
git rm: 表示将条目从缓存中移除，即缓存区中不再包含该文件
```

* git mv

```shell
git mv 命令做的所有事情就是git rm --cached命令的操作，重命名磁盘上的文件，然后再执行git add把新文件添加到缓存区
$ git mv README  README.md
```

## Git分支管理

* 创建分支

```shell
$ git branch 列出本地所有分支
$ git branch* master 该命令意思是，我们有个master分支，并且该分支是当前分支，并列出当前分支的所有分支
注：当执行git init，缺省情况下，Git会创建master分支


$ git branch testing 创建新分支

示例：
$ git branch testing
$ git branch* master
  testing
```

* 切换分支
  切换分支时，Git将还原你的工作目录到你创建分支时候的样子


```shell

$ git checkout testing
切换到testing分支
$ git checkout -b newtest
创建新分支并立即切换到该分支下
```

* 删除分支

```shell
git branch -d testing
```

* 合并分支

```shell
$ git merge newtest
```

* 合并冲突
```shell
手动修改冲突后，可以git add告诉Git文件冲突已经解决
```

## Git查看提交历史

```shell
$ git log 列出历史提交记录
参数
--online: 查看历史记录的简介版本
--graph: 查看历史中什么时候出现了分支、合并
--reverse: 逆向显示所有日志
--author: 查看指定用户的提交日志
--since
--before
--until
--after: 显示指定日期的提交日志
--no-merges: 隐藏合并提交
```

## Git标签

```shell
$ git tag 查看所有标签
参数
-a: 添加标签注解
-s: PGP签名标签
-m: 标签信息
```

## Git远程仓库

### 添加远程仓库

```shell
git remote add [shortname] [url]

配置步骤
<1> 由于你的本地Git仓库和GitHub仓库之间的传输是通过SSH加密的，所以我们需要配置验证信息：
使用以下命令生成SSH Key：$ ssh-keygen -t rsa -C "youremail@example.com"。之后会要求确认路径和输入密码，我们这使用默认的一路回车就行。
<2> 第<1>步成功后，会在~/下生成.ssh文件夹，进去，打开id_rsa.pub，复制里面的key。回到github上，进入 Account Settings（账户配置），左边选择SSH Keys，Add SSH Key,title随便填，粘贴在你电脑上生成的key。
<3> 验证是否成功，在git bash输入ssh -T git@github.com
如果是第一次的会提示是否continue，输入yes就会看到：You've successfully authenticated, but GitHub does not provide shell access 。
这就表示已成功连上github。
<4> 设置username和email，如果已设置可跳过
$ git config --global user.name "your name"
$ git config --global user.email "your_email@youremail.com"
<5> 添加远程地址
git remote add origin git@github.com:yourName/yourRepo.git
后面的yourName和yourRepo表示你再github的用户名和刚才新建的仓库，加完之后进入.git，打开config，这里会多出一个remote "origin"内容，这就是刚才添加的远程地址，也可以直接修改config来配置远程地址。
```

### 查看远程仓库

```shell
$ git remote 查看当前配置有哪些远程仓库
参数
-v: 可以看到每个别名的实际链接地址
```

### 提取远程仓库

```shell
$ git fetch 从远程仓库下载新分支与数据，该命令执行完，需要执行git merge远程分支到你所在的分支

$ git pull 该命令就是在执行git fetch之后紧接着执行git merge远程分支到你所在的任意分支
```

### 推送到远程仓库

```shell
$ git push [alias] [branch] 将你的[branch]推送成为[alias]远程仓库上的[branch]分支
```

### 删除远程仓库

```shell
$ git remote rm [alias]
```

## 服务器搭建

```shell
以 Centos 为例搭建 Git 服务器。

1、安装Git
$ yum install curl-devel expat-devel gettext-devel openssl-devel zlib-devel perl-devel
$ yum install git
接下来我们 创建一个git用户组和用户，用来运行git服务：
$ groupadd git
$ adduser git -g git

2、创建证书登录
收集所有需要登录的用户的公钥，公钥位于id_rsa.pub文件中，把我们的公钥导入到/home/git/.ssh/authorized_keys文件里，一行一个。
如果没有该文件创建它：
$ cd /home/git/$ mkdir .ssh
$ chmod 700 .ssh
$ touch .ssh/authorized_keys
$ chmod 600 .ssh/authorized_keys

3、初始化Git仓库
首先我们选定一个目录作为Git仓库，假定是/home/gitrepo/runoob.git，在/home/gitrepo目录下输入命令：
$ cd /home
$ mkdir gitrepo
$ chown git:git gitrepo/$ cd gitrepo
$ git init --bare runoob.gitInitialized empty Git repository in /home/gitrepo/runoob.git/
以上命令Git创建一个空仓库，服务器上的Git仓库通常都以.git结尾。然后，把仓库所属用户改为git：
$ chown -R git:git runoob.git

4、克隆仓库
$ git clone git@192.168.45.4:/home/gitrepo/runoob.gitCloning into 'runoob'...warning: You appear to have cloned an empty repository.Checking connectivity... done.
192.168.45.4 为 Git 所在服务器 ip ，你需要将其修改为你自己的 Git 服务 ip。

这样我们的 Git 服务器安装就完成了，接下来我们可以禁用 git 用户通过shell登录，可以通过编辑/etc/passwd文件完成。找到类似下面的一行：
git:x:503:503::/home/git:/bin/bash 改为 git:x:503:503::/home/git:/sbin/nologin
```

