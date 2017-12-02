# jpa-generater

### 为啥要写这个项目

最新新开始的项目要求用springboot+springDataJpa

同时在项目初期，字段变更严重

每次字段变更维护实体类的是个很闹心的事情(其实可以通过ddl-auto来逆向生成数据库，但是习惯了数据库先行)

目前没发现什么好用的生成jpa风格的注解实体类的工具

就把以前用velocity写的springMVC+spring+mybatis的生成器修改了下

### 遇到的需求

* 主键字段名不固定 采用`表名_id`的的方式 暂时使用uuid
* 需要添加`创建时间`、`更新时间`、`删除标志`字段
* 字段变动严重


### 解决的问题

1. jpa注解实体类的生成
2. Entity的抽象
2. Controller的生成
3. Service的抽象
   

### Rest服务快速体验

1. 项目仓库地址 ： https://github.com/xdmdpz/jpa-generater.git
2. 建一个名字为 `jpagenerater`的数据库 `utf8mb4`的
3. 把 `resources/sql` 里面的两个文件（`schema.sql``data.sql`）复制到 `resource/`目录下
4. 修改`application.properties`文件里面的数据库连接
5. 运行一下项目 springboot会把数据结构加载到数据库里 
6. 删除`resources`下的sql文件
7. 启动项目
    
### 代码生成器体验

1. 项目仓库地址 ： https://github.com/xdmdpz/jpa-generater.git
2. 建一个名字为 `jpagenerater`的数据库 字符集选`utf8mb4`
1. 把 `resources/sql` 里面的两个文件（`schema.sql``data.sql`）复制到 `resource/`目录下
2. `schema.sql`里面注释的sql取消注释 改成你需要的数据结构
    
    > tableName_id,create_time,update_time,del_tag 为必要字段 可以按照需求修改模板
    
3. 修改`application.properties`文件里面的数据库连接
4. 运行一下项目 springboot会把数据结构加载到数据库里
5. 修改`generater/utils/Contants.java`的数据库连接配置
6. 取消`generater/DoGenerater.java`代码注释 启动主函数
7. 会在`src/java/carbon`下看到生成的代码
8. 如果用idea的同学可以直接shift+F6修改路径把/carbon删除代码就合并到core目录下了
5. 删除`resources`下的sql文件
7. 启动项目
    
    




