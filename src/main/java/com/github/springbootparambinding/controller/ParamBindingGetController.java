package com.github.springbootparambinding.controller;

import com.alibaba.fastjson.JSON;
import com.github.springbootparambinding.pojo.RequestData1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * <p>
 * 创建时间为 14:11 2019-08-06
 * 项目名称 spring-boot-param-binding
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@Slf4j
@RestController
public class ParamBindingGetController {

    @GetMapping("test1")
    public RequestData1 test1(RequestData1 requestData1) {
        log.info("接收到数据:{}", JSON.toJSONString(requestData1));
        return requestData1;
    }

    @GetMapping("test2/{sets}")
    public Set<String> test2(@PathVariable Set<String> sets) {
        log.info("接收到数据:{}", JSON.toJSONString(sets));
        return sets;
    }

}
