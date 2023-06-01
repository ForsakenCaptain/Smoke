package com.example.smoke.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.xml.transform.Result;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(GameService.class)
class GameServiceTest {

    @Autowired
    private MockMvc mvc;

//    @Test
//    void createGame() {
//
//    }

//    @Test
//    void getGameById() throws Exception {
//        RequestBuilder request = MockMvcRequestBuilders.get("/");
//        MvcResult result = mvc.perform(request).andReturn();
//        assertEquals("", result.getResponse().getContentAsString());
//    }
}