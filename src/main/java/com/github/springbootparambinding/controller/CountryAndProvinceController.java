package com.github.springbootparambinding.controller;

import com.github.springbootparambinding.pojo.CountryAndProvinceDO;
import com.github.springbootparambinding.service.ICountryAndProvinceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Set;

/**
 * <p>
 * 创建时间为 上午10:50 2019/11/1
 * 项目名称 spring-boot-param-binding
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@RestController
public class CountryAndProvinceController {

    @Resource
    private ICountryAndProvinceService service;

    @GetMapping("/country/{set}")
    public Set<CountryAndProvinceDO> getCountry(@PathVariable Set<String> set) {
        return service.getCountry(set);
    }

    @GetMapping("/province/{set}")
    public Set<CountryAndProvinceDO> getProvince(@PathVariable Set<String> set) {
        return service.getProvince(set);
    }


}
