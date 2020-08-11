package com.github.springbootparambinding.controller;

import com.github.springbootparambinding.pojo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 创建时间为 下午10:41 2020/5/2
 * 项目名称 spring-boot-param-binding
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Slf4j
@RestController
public class RequestCookieController {

    @GetMapping("cookie")
    public ResultVO<String> cookie(@CookieValue(name = "testCookie") String testCookie) {
        log.debug("testCookie - {}", testCookie);
        return ResultVO.success(testCookie);
    }

}
