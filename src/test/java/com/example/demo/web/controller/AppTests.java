package com.example.demo.web.controller;

import com.example.demo.config.RootApplicationConfig;
import com.example.demo.config.TestApplicationConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;


import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * AppTests
 *
 * @author herohyohwan@gmail.com
 * @date 2017.01.09
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { TestApplicationConfig.class })
public class AppTests {
    /**
     * The Mock mvc.
     */
    private MockMvc mockMvc;

    /**
     * The Wac.
     */
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    protected WebApplicationContext wac;

    /**
     * Sets .
     */
    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    /**
     * Simple.
     *
     * @throws Exception the exception
     */
    @Test
    public void simple() throws Exception {
        mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status", is(200)))
                .andExpect(jsonPath("$.message", is("Hello world!")));
    }
}
