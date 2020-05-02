package com.github.springbootparambinding.controller;

import com.github.springbootparambinding.pojo.ResultDTO;
import com.github.springbootparambinding.pojo.UserInfoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
public class RequestBodyController {

    @PostMapping("body")
    public ResultDTO<UserInfoDTO> body(@RequestBody UserInfoDTO userInfo) {
        return ResultDTO.success(userInfo);
    }
}
