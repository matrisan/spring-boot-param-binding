package com.github.springbootparambinding.controller;

import com.github.springbootparambinding.pojo.ResultDTO;
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
public class PathVariableController {

    @GetMapping("path/one/{data}")
    public ResultDTO<String> one(@PathVariable String data) {
        return ResultDTO.success(data);
    }

    @GetMapping("path/many/{ids}")
    public ResultDTO<Set<Long>> many(@PathVariable("ids") Set<Long> ids) {
        return ResultDTO.success(ids);
    }

}
