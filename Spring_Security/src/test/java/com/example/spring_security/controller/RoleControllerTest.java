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
class RoleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    Permission permission = new Permission("role:write");
    Role role = new Role("ROLE_ADMIN", Sets.newHashSet(permission), true);
    User admin = new User("admin", "admin", Sets.newHashSet(role), true);

    @BeforeAll
    static void setup(@Autowired DataSource dataSource) {
        try (Connection connection = dataSource.getConnection()) {
            ScriptUtils.executeSqlScript(connection, new ClassPathResource("roleControllerData.sql"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(1)
    void addRole() throws Exception {
        JSONObject RoleJson = new JSONObject();
        RoleJson.put("name", "ROLE_TEST");
        RoleJson.put("permissions", Sets.newHashSet("test"));
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/role/addRole")
                .with(SecurityMockMvcRequestPostProcessors.user(admin))
                .contentType(MediaType.APPLICATION_JSON)
                .content(RoleJson.toJSONString());
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    @Order(2)
    void assignPermissionToRole() throws Exception {
        JSONObject RoleJson = new JSONObject();
        RoleJson.put("name", "ROLE_ADMIN");
        RoleJson.put("permissions", Sets.newHashSet("role:write"));
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/role/assignPermissionToRole")
                .with(SecurityMockMvcRequestPostProcessors.user(admin))
                .contentType(MediaType.APPLICATION_JSON)
                .content(RoleJson.toJSONString());
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }
}