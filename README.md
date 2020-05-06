# SpringBoot 参数绑定的 7 种方式

1. 从 URL 路径中获取单个请求参数

请求的参数写在URL中,使用"{}"占位符。  
在方法入口参数中使用 @PathVariable 获取参数。如果占位符 和方法参数名称一样,@PathVariable注解可以免写("data")参数。

请求
+ 方式:GET
+ 路径:http://127.0.0.1:8080/path/one/TestData

```java
@Slf4j
@RestController
@RequiredArgsConstructor
public class PathVariableController {

    @GetMapping("path/one/{data}")
    public ResultDTO<Long> one(@PathVariable("data") Long data) {
        log.error("路径获取单个参数:{}", data);
        return ResultDTO.success(data);
    }
}
```

2. 从 URL 路径中获取多个请求参数

如果请求的参数是个集合，只要方法参数使用集合来接口即可直接换成集合。

请求
+ 方式:GET
+ 路径:http://127.0.0.1:8080/path/many/1,2,3

```java
@Slf4j
@RestController
@RequiredArgsConstructor
public class PathVariableController {

    private final ObjectMapper objectMapper;

    @GetMapping("path/many/{ids}")
    public ResultDTO<Set<Long>> many(@PathVariable("ids") Set<Long> ids) throws JsonProcessingException {
        log.error("路径获取多个参数:{}", objectMapper.writeValueAsString(ids));
        return ResultDTO.success(ids);
    }

}
```

3. 从 URL 中获取单个查询参数

请求
+ 方式:GET
+ 路径:http://127.0.0.1:8080/param1?name=TestName

```java
@Slf4j
@RestController
public class RequestParamController {

    @GetMapping("param1")
    public ResultDTO<String> param1(@RequestParam(name = "name") String name) {
        return ResultDTO.success(name);
    }

}
```

4. 从 URL 中获取查询参数实体

请求
+ 方式:GET
+ 路径:http://127.0.0.1:8080/param2?name=TestName

```java
@Slf4j
@RestController
public class RequestParamController {

    @GetMapping("param2")
    public ResultDTO<UserInfoDTO> param2(UserInfoDTO user) {
        return ResultDTO.success(user);
    }
}
```

5. 从 Body 中获取请求参数实体

请求
+ 方式:GET
+ 路径:http://127.0.0.1:8080/body
+ body:{"name":"TestName"}

```java
@Slf4j
@RestController
public class RequestBodyController {

    @PostMapping("body")
    public ResultDTO<UserInfoDTO> body(@RequestBody UserInfoDTO userInfo) {
        return ResultDTO.success(userInfo);
    }
}
```

6. 从 Header 中获取参数

请求
+ 方式:GET
+ 路径:http://127.0.0.1:8080/header
+ header:testHeader=123abc

```java
@Slf4j
@RestController
public class RequestHeaderController {

    @GetMapping("header")
    public ResultDTO<String> header(@RequestHeader(name = "testHeader") String testHeader) {
        return ResultDTO.success(testHeader);
    }

}
```

7. 从 Cookie 中获取参数

请求
+ 方式:GET
+ 路径:http://127.0.0.1:8080/cookie
+ Cookie:testCookie=123abc

```java
@Slf4j
@RestController
public class RequestCookieController {

    @GetMapping("cookie")
    public ResultDTO<String> cookie(@CookieValue(name = "testCookie") String testCookie) {
        log.debug("testCookie - {}", testCookie);
        return ResultDTO.success(testCookie);
    }

}
```





