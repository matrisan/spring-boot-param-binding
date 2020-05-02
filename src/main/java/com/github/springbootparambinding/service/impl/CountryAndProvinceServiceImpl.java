package com.github.springbootparambinding.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.springbootparambinding.pojo.CountryAndProvinceDO;
import com.github.springbootparambinding.service.ICountryAndProvinceService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * <p>
 * 创建时间为 上午10:49 2019/11/1
 * 项目名称 spring-boot-param-binding
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Service
public class CountryAndProvinceServiceImpl implements ICountryAndProvinceService {

    @Value(value = "classpath:json/country.json")
    private Resource countryResource;

    @Value(value = "classpath:json/province.json")
    private Resource provinceResource;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    @SneakyThrows(IOException.class)
    public Set<CountryAndProvinceDO> getCountry(Set<String> sets)  {
        Map<String, Set<CountryAndProvinceDO>> map = objectMapper.readValue(countryResource.getFile(), new TypeReference<Map<String, Set<CountryAndProvinceDO>>>() {
        });
        return sets.stream().flatMap(one -> map.get(one).stream()).collect(Collectors.toSet());
    }

    @Override
    @SneakyThrows(IOException.class)
    public Set<CountryAndProvinceDO> getProvince(Set<String> sets) {
        Map<String, Set<CountryAndProvinceDO>> map = objectMapper.readValue(provinceResource.getFile(), new TypeReference<Map<String, Set<CountryAndProvinceDO>>>() {
        });
        return sets.stream().flatMap(one -> map.get(one).stream()).collect(Collectors.toSet());
    }


}
