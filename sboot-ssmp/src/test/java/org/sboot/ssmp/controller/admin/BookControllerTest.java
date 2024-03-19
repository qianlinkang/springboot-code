package org.sboot.ssmp.controller.admin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.HeaderResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
// 开启虚拟mvc调用
@AutoConfigureMockMvc
class BookControllerTest {

    @Test
    void test() {

    }

    @Test
    void testWeb(@Autowired MockMvc mockMvc) throws Exception {
        // http://localhost:8080/books

        // 创建虚拟请求
        RequestBuilder builder = MockMvcRequestBuilders.get("http://localhost:8080/books");
        mockMvc.perform(builder);
    }

    @Test
    void testStatus(@Autowired MockMvc mockMvc) throws Exception {
        // http://localhost:8080/books

        // 创建虚拟请求
        RequestBuilder builder = MockMvcRequestBuilders.get("http://localhost:8080/books");
        // 请求真实值
        ResultActions action = mockMvc.perform(builder);

        // 调用结果匹配器(预期值)
        StatusResultMatchers status = MockMvcResultMatchers.status();
        // 200
        ResultMatcher ok = status.isOk();

        // 匹配
        action.andExpect(ok);

    }

    @Test
    void testBody(@Autowired MockMvc mockMvc) throws Exception {
        // http://localhost:8080/books

        // 创建虚拟请求
        RequestBuilder builder = MockMvcRequestBuilders.get("http://localhost:8080/books");
        // 请求真实值
        ResultActions action = mockMvc.perform(builder);

        // 调用结果匹配器(预期值)
        ContentResultMatchers content = MockMvcResultMatchers.content();
        ResultMatcher result = content.string("springboot");

        // 匹配
        action.andExpect(result);
    }

    @Test
    void testJsonBody(@Autowired MockMvc mockMvc) throws Exception {
        // http://localhost:8080/books

        // 创建虚拟请求
        RequestBuilder builder = MockMvcRequestBuilders.get("http://localhost:8080/books");
        // 请求真实值
        ResultActions action = mockMvc.perform(builder);

        // 调用结果匹配器(预期值)
        ContentResultMatchers content = MockMvcResultMatchers.content();
        ResultMatcher result = content.json("{}");

        // 匹配
        action.andExpect(result);
    }

    @Test
    void testContentType(@Autowired MockMvc mockMvc) throws Exception {
        // http://localhost:8080/books

        // 创建虚拟请求
        RequestBuilder builder = MockMvcRequestBuilders.get("http://localhost:8080/books");
        // 请求真实值
        ResultActions action = mockMvc.perform(builder);

        // 调用结果匹配器(预期值)
        HeaderResultMatchers header = MockMvcResultMatchers.header();
        ResultMatcher contentType = header.string("Content-Type", "application/json");

        // 匹配
        action.andExpect(contentType);
    }

}