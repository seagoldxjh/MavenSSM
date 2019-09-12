# MavenSSM
本项目使用IDEA搭建一个基于Maven整合Spring，SpringMVC,MyBatis的CRUD管理系统

## Idea不会编译java文件中的xml配置文件，需要手动添加编译
项目打包运行配置文件未加载可在pom文件加入代码
```xml
<resources>
       <resource>
              <directory>src/main/java</directory>
              <includes>
              <include>**/*.properties</include>
              <include>**/*.xml</include>
              </includes>
              <filtering>false</filtering>
       </resource>
</resources>
```
