package com.example.spring_security.controller;

import com.example.spring_security.model.Permission;
import com.example.spring_security.model.Role;
import com.example.spring_security.model.User;
import com.google.common.collect.Sets;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    Permission writePermission = new Permission("user:write");
    Permission readPermission = new Permission("user:read");
    Role role = new Role("ROLE_ADMIN", Sets.newHashSet(writePermission, readPermission), true);
    User admin = new User("admin", "admin", Sets.newHashSet(role), true);

    @BeforeAll
    static void setup(@Autowired DataSource dataSource) {
        try (Connection connection = dataSource.getConnection()) {
            ScriptUtils.executeSqlScript(connection, new ClassPathResource("userControllerData.sql"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(1)
    void addUser() throws Exception {
        JSONObject userJson = new JSONObject();
        userJson.put("username", "farzadafi");
        userJson.put("password", "aA1!aaaa");
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/v1/user/addUser")
                .contentType(MediaType.APPLICATION_JSON)
                .content(userJson.toJSONString());
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    @Order(2)
    void userWriteTest() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/api/v1/user/userWriteTest")
                .with(SecurityMockMvcRequestPostProcessors.user(admin))
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    @Order(3)
    void userReadTest() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/v1/user/userReadTest")
                .with(SecurityMockMvcRequestPostProcessors.user(admin))
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }
}