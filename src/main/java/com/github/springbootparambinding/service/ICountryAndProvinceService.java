package com.github.springbootparambinding.service;

import com.github.springbootparambinding.pojo.CountryAndProvinceDO;

import java.util.Set;

/**
 * <p>
 * 创建时间为 上午10:48 2019/11/1
 * 项目名称 spring-boot-param-binding
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface ICountryAndProvinceService {


    Set<CountryAndProvinceDO> getCountry(Set<String> sets);

    Set<CountryAndProvinceDO> getProvince(Set<String> sets);
}
