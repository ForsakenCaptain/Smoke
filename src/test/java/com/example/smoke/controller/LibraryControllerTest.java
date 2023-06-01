package com.example.smoke.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
//@WebMvcTest(LibraryController.class)

public class LibraryControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getGames() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/library/GetAllGames")
                .accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(MockMvcResultMatchers.jsonPath("$.[0].name").exists())
            .andExpect(MockMvcResultMatchers.jsonPath("$.[2].name").exists());
    }

    @Test
    public void getGame() throws Exception {
        String expectedName = "Halo";
//        int expectedName = 1;

        mvc.perform( MockMvcRequestBuilders
                .get("/library/GetGames/{id}", 1)
                .accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(expectedName));
    }
}