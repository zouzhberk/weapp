# weapp
a weixin mp demo project.

mvn spring-boot:run



##Git代码部署说明

    在你应用的git代码目录里，添加一个新的git远程仓库 sae
    $ git remote add sae https://git.sinacloud.com/weberk

    编辑代码并将代码部署到 `sae` 的版本1。
    $ git add .
    $ git commit -am "make it better"
    $ git push sae master:1

