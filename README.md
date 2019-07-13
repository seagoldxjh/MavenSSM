# MavenSSM
项目打包运行配置文件未加载可在pom文件加入代码
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
