package com.etf.controller;


import com.etf.repository.PacijentRepository;
import com.etf.service.PacijentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PacijentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PacijentService pacijentService;

    @Autowired
    private PacijentRepository pacijentRepository;

    @BeforeEach
    public void setUp(){
        pacijentRepository.deleteAll();
    }

    @Test
    public void TestCreatePacijentOK() throws Exception {
        String pacijent1="{\n" +
                "  \"ime\": \"ime1\",\n" +
                "  \"prezime\": \"prezime1\"\n"+
                "}";
        String pacijent2="{\n" +
                "  \"ime\": \"ime2\",\n" +
                "  \"prezime\": \"prezime2\"\n"+
                "}";



        RequestBuilder requestBuilder= MockMvcRequestBuilders.post("/Pacijent/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(pacijent2);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk());

    }

    @Test
    public void TestCreatePacijentFalse() throws Exception {
        String pacijent1="{\n" +
                "  \"prezime\": \"prezime1\"\n"+
                "}";

        RequestBuilder requestBuilder= MockMvcRequestBuilders.post("/Pacijent/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(pacijent1);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isBadRequest());

    }

    @Test
    public void TestGetPacijent() throws Exception {
        pacijentRepository.deleteAll();
        RequestBuilder requestBuilder= MockMvcRequestBuilders.get("/Pacijent/")
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk());
    }


}
