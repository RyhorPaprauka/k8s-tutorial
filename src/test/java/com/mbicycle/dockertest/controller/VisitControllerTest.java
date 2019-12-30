package com.mbicycle.dockertest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
class VisitControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void check_visits() throws Exception {
        MvcResult firstResult = mockMvc.perform(get("/visit"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        Long firstVisit = objectMapper.readValue(firstResult.getResponse().getContentAsString(), Long.class);

        MvcResult secondResult = mockMvc.perform(get("/visit"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        Long secondVisit = objectMapper.readValue(secondResult.getResponse().getContentAsString(), Long.class);

        assertThat(firstVisit).isEqualTo(1L);
        assertThat(secondVisit).isEqualTo(2L);
    }
}