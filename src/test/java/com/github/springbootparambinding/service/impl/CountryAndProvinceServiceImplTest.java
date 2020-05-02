package com.github.springbootparambinding.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.springbootparambinding.service.ICountryAndProvinceService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.util.collections.Sets;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * <p>
 * 创建时间为 下午2:18 2019/11/1
 * 项目名称 spring-boot-param-binding
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */


@SpringBootTest
@RunWith(SpringRunner.class)
public class CountryAndProvinceServiceImplTest {

    @Resource
    private ICountryAndProvinceService service;

    @Test
    public void getCountry() {
        Assert.assertEquals("省份长度不相等", 2, service.getCountry(Sets.newSet("c")).size());
    }

    @Test
    public void getProvince() {
        Assert.assertEquals("省份长度不相等", 2, service.getProvince(Sets.newSet("a")).size());
    }
}