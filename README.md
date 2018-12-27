## tools-spring-boot-starter
![](https://img.shields.io/badge/tools--spring--boot--starter-0.1--SNAPSHOT-green.svg)

tools-spring-boot-starter 封装了一些常用工具类，开箱即用。



## 使用方法
- 由于本项目目前还是测试版，并未提交各依赖包到中央仓库。用户可git clone本项目，然后在本地编译之后，于pom文件中引入如下依赖：
~~~
<dependency>
    <groupId>com.github.baifenghe</groupId>
    <artifactId>tools-spring-boot-starter</artifactId>
    <version>0.1-SNAPSHOT</version>
</dependency>
~~~

- 在主类上引用`@EnableTest`注解，开启测试功能

~~~
@SpringBootApplication
@EnableTest
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
~~~



## 待办事项
- 无