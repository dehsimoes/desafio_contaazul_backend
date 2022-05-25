package br.com.contaazul.robotnasa.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@WebMvcTest(RoboController.class)
class RoboControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void deveExecutarMovimentos() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.post("/rest/mars/{movimentos}", "MRMM"))
                .andReturn().getResponse();
        assertEquals(200, response.getStatus());
        assertEquals("(2, 1, E)", response.getContentAsString());
    }
}