package com.github.springbootparambinding.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.springbootparambinding.pojo.ResultVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * <p>
 * 创建时间为 下午10:42 2020/5/2
 * 项目名称 spring-boot-param-binding
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Slf4j
@RestController
@RequiredArgsConstructor
public class PathVariableController {

    private final ObjectMapper objectMapper;

    @GetMapping("path/one/{data}")
    public ResultVO<Long> one(@PathVariable("data") Long data) {
        log.error("路径获取单个参数:{}", data);
        return ResultVO.success(data);
    }

    @GetMapping("path/many/{ids}")
    public ResultVO<Set<Long>> many(@PathVariable("ids") Set<Long> ids) throws JsonProcessingException {
        log.error("路径获取多个参数:{}", objectMapper.writeValueAsString(ids));
        return ResultVO.success(ids);
    }

}
