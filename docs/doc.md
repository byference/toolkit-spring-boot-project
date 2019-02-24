# 文档


## 如何引用


> 由于本项目目前还是测试版，并未提交各依赖包到中央仓库。用户可git clone本项目，然后在本地编译之后，于pom文件中引入如下依赖：

~~~
<dependency>
    <groupId>com.github.baifenghe</groupId>
    <artifactId>toolkit-spring-boot-starter</artifactId>
    <version>0.2-SNAPSHOT</version>
</dependency>
~~~


## 已支持功能


1. [参数非空校验](#参数非空校验)

2. [全局异常处理](#全局异常处理)

3. [全局日志处理](#全局日志处理)






### 参数非空校验

> 支持json

在主类上引用`@EnableParamCheckHandler`注解，即可开启参数校验注解以及全局异常处理

- `@ParamsCheck` 
- `@ParamsCheck4Json` 

使用方法，首先在启动类上添加开启参数校验注解 `@EnableParamCheckHandler` :

~~~java
@SpringBootApplication
@EnableParamCheckHandler
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
~~~

使用参数校验注解`@ParamsCheck`

~~~java
@RestController
@RequestMapping
public class TestController {

    @Autowired
    private TestService testService;

    // 普通表单提交或get请求
    @RequestMapping("hello")
    @ParamsCheck(params = "name")
    public String hello(String name) {
        return R.success("ParamsCheck操作成功!", name);
    }
    
    // json
    @RequestMapping("json")
    @ParamsCheck4Json(params = "name")
    public String test(@RequestBody String name) {
        return R.success("ParamsCheck4Json操作成功!", name);
    }
}
~~~


### 全局异常处理

~~~java
@SpringBootApplication
@EnableGlobalExceptionHandler
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
~~~



### 全局日志处理
~~~java
@SpringBootApplication
@EnableGlobalLog
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
~~~