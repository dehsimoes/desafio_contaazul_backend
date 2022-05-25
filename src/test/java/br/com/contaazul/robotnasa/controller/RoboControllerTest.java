package br.com.contaazul.robotnasa.controller;

import br.com.contaazul.robotnasa.RoboNasaApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = RoboNasaApplication.class)
class RoboControllerTest {

    private MockMvc mockMvc;

    @BeforeEach
    public void configure(){this.mockMvc = webAppContextSetup(webApplicationContext).build();}
    @Autowired
    WebApplicationContext webApplicationContext;

    @Test
    void deveExecutarMovimentos() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/rest/mars/{movimentos}", "MRMM");
        MockHttpServletResponse response = mockMvc.perform(request).andReturn().getResponse();
        assertEquals(200, response.getStatus());
        assertEquals("(2, 1, E)", response.getContentAsString());
    }

    @Test
    void naoDeveAceitarComandoInvalido() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/rest/mars/{movimentos}", "AAA");
        MockHttpServletResponse response = mockMvc.perform(request).andReturn().getResponse();
        assertEquals(400, response.getStatus());
    }

    @Test
    void naoDeveAceitarNumeros() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/rest/mars/{movimentos}", "M2");
        MockHttpServletResponse response = mockMvc.perform(request).andReturn().getResponse();
        assertEquals(400, response.getStatus());
    }

    @Test
    void naoDeveAndarMaisQueLimite() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/rest/mars/{movimentos}", "MMMMMMMMMMMMMMMMMMMMMMMM");
        MockHttpServletResponse response = mockMvc.perform(request).andReturn().getResponse();
        assertEquals(400, response.getStatus());
    }

}