package com.gunda.spring.crud.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import  org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = JurisdictionController.class)
public class JurisdictionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getJurisdictionsByYear() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/itra/getAllJurisByYears")
                .param("year","2019")).andExpect(status().isOk());

    }


}
