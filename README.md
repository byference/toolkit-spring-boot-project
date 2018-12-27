## tools-spring-boot-starter
![](https://img.shields.io/badge/tools--spring--boot--starter-0.1--SNAPSHOT-green.svg)

tools-spring-boot-starter 封装了一些常用工具类，开箱即用。



## 待完成列表

- 全局异常管理
- AOP日志输出
- 代码优化
- 等等。。。



## 使用说明
- 由于本项目目前还是测试版，并未提交各依赖包到中央仓库。用户可git clone本项目，然后在本地编译之后，于pom文件中引入如下依赖：
~~~
<dependency>
    <groupId>com.github.baifenghe</groupId>
    <artifactId>tools-spring-boot-starter</artifactId>
    <version>0.1-SNAPSHOT</version>
</dependency>
~~~

- 在主类上引用`@@EnableParamCheck`注解，即可开启参数校验注解。

~~~
@SpringBootApplication
@EnableParamCheck
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
~~~

使用参数校验注解`@ParamsCheck`

~~~
@RestController
@RequestMapping
public class TestController {
    @Autowired
    private TestService testService;

    @RequestMapping("hello")
    @ParamsCheck(params = "str")
    public String hello(String str) {
        return testService.toUpperCase(str);
    }
}
~~~


## 目前已支持功能

- 参数校验注解（后续考虑移除@EnableParamCheck，采用自动注入）