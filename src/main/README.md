Maven命令
//maven编译命令   忽略测试文档编译 
mvn clean install -Dmaven.test.skip=true 
 
mvn clean install -DskipTests
 
//清除目标目录中的生成结果
mvn clean 
 
//进行打包
mvn clean package 
 
//在本地 Repository 中安装 jar
mvn install 
Git其它命令
 
/*获取远程仓库路径*/
git remote
 
/*获取本地分支*/
git branch 
 
/*在本地创建分支*/
git checkout -b dev  //新建并切换到分支dev
git pull origin dev //本地分支与远程分支连接
 
/*在本地创建分支并推送到远端*/
git checkout -b sit  //新建并切换到本地分支
git push origin sit  
 
 
/*合并分支*/
git checkout master  //返回主分支
git merge dev  //合并dev分支到master
git branch -d dev  //删除分支
 
/*合并分支到某分支的指定版本*/
git log --oneline -5  //查看该分支近5此提交记录
git cherry-pick[版本号id]
 
/*版本回退*/
git reset --hard [log中的commit的id]
git push -f -u origin [分支名]
 
//git强制覆盖本地代码
git fetch --all
git reset --hard origin/master
git pull
Git上传代码命令
/*查看代码变化*/
git status
 
/*还原对文件的修改*/
git checkout 文件全路径
 
/*添加需要上传的文件，第一个添加所有发生改变的文件，第二个添加指定文件*/
git add.
git add ***
 
/*在add以后，commit之前删除添加的文件*/
git reset HEAD 文件全路径
 
/*把添加的内容提交到本地，并写上注释*/
git commit -m "注释内容"
 
/*提交到本地的代码push到远程仓库*/
git push
 
/*更新代码*/
git pull
 
/*代码提交的一般步骤
先更新git pull,
git status 查看改变内容
git add. 添加到暂存区
git commit
git push
*/
Git stash 保存和恢复
参考博客https://blog.csdn.net/daguanjia11/article/details/73810577

//保存当前工作进度
git stash
 
//显示保存进度的列表
git stash list
 
git stash pop [–index] [stash_id]
git stash pop 恢复最新的进度到工作区。git默认会把工作区和暂存区的改动都恢复到工作区。
git stash pop --index 恢复最新的进度到工作区和暂存区。（尝试将原来暂存区的改动还恢复到暂存区）
git stash pop stash@{1}恢复指定的进度到工作区。stash_id是通过git stash list命令得到的 
通过git stash pop命令恢复进度后，会删除当前进度。
 
//除了不删除恢复的进度之外，其余和git stash pop 命令一样。
git stash apply [–index] [stash_id]
 
 
//删除一个存储的进度。如果不指定stash_id，则默认删除最新的存储进度。
git stash drop [stash_id]
 
 
//删除所有存储的进度。
git stash clear
 
 
Git分支操作
//把本地分支push到远程
git push --set-upstream origin localBranch
 
//修改本地分支名称
git branch -m oldName newName
 
解决git每次都要输入密码问题：

git bash进入你的项目目录，输入：

git config --global credential.helper store

文章仅供个人学习记录，都是网上和资料得来，后期跟进补全，如有错误请指正

 