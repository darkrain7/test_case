package com.test.controller;

import com.test.Application;
import com.test.service.CreateService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = Application.class)
public class ProductControllerTest {

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private CreateService createService;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = webAppContextSetup(context).build();
        createService.createFullData();
    }

    @Test
    public void getProductById() throws Exception {
        mockMvc.perform(get("/find?id=1"))
                .andDo(print())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("T19C350EX")))
                .andExpect(jsonPath("$.category.name", is("TV")));
    }

    @Test
    public void getProductByIdNotFound() throws Exception {
        mockMvc.perform(get("/find?id=-1"))
                .andDo(print())
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    public void getProductAll() throws Exception {
        mockMvc.perform(get("/findAll"))
                .andDo(print())
                .andExpect(jsonPath("$.[*].id", hasItems(1, 2, 3, 4)));
    }

    @Test
    public void ProductUpdateTest() throws Exception {
        mockMvc.perform(get("/update?id=1&count=15&price=10"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }

    @Test
    public void ProductUpdateIncorrectCountTest() throws Exception {
        mockMvc.perform(get("/update?id=1&count=-15&price=10"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("false"));
    }

    @Test
    public void ProductUpdateIncorrectPriceTest() throws Exception {
        mockMvc.perform(get("/update?id=1&count=15&price=-10"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("false"));
    }
}