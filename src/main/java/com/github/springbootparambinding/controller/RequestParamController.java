package com.github.springbootparambinding.controller;

import com.github.springbootparambinding.pojo.ResultDTO;
import com.github.springbootparambinding.pojo.UserInfoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
public class RequestParamController {

    @GetMapping("param1")
    public ResultDTO<String> param1(@RequestParam(name = "name") String name) {
        return ResultDTO.success(name);
    }

    @GetMapping("param2")
    public ResultDTO<UserInfoDTO> param2(UserInfoDTO user) {
        return ResultDTO.success(user);
    }
}
