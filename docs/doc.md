# 文档


## 如何引用

> 由于本项目目前还是测试版，并未提交各依赖包到中央仓库。用户可git clone本项目，然后在本地编译之后，于pom文件中引入如下依赖：

~~~
<dependency>
    <groupId>com.github.baifenghe</groupId>
    <artifactId>tools-spring-boot-starter</artifactId>
    <version>0.1-SNAPSHOT</version>
</dependency>
~~~


## 已支持功能


-[参数非空校验](#参数非空校验)

-[全局异常处理](#全局异常处理)


### 参数非空校验
- 在主类上引用`@EnableParamCheckHandler`注解，即可开启参数校验注解以及全局异常处理

~~~
@SpringBootApplication
@EnableParamCheckHandler
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


### 全局异常处理

~~~
@SpringBootApplication
@EnableGlobalExceptionHandler
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
~~~