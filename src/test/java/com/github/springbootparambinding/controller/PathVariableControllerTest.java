package com.github.springbootparambinding.controller;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.util.collections.Sets;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * <p>
 * 创建时间为 下午10:52 2020/5/2
 * 项目名称 spring-boot-param-binding
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@DirtiesContext
@AutoConfigureMockMvc
@ActiveProfiles("junit")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PathVariableControllerTest {

    /**
     * 模拟mvc测试对象
     */
    @Resource
    private MockMvc mockMvc;

    @Test
    public void one() throws Exception {
        long id = 123L;
        mockMvc.perform(get("/path/one/" + id))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.data").value(id))
                .andReturn()
                .getResponse()
                .getContentAsString();
    }

    @Test
    public void many() throws Exception {
        mockMvc.perform(get("/path/many/1,2,3"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.data").value(Lists.newArrayList(1, 2, 3)))
                .andReturn()
                .getResponse()
                .getContentAsString();
    }
}