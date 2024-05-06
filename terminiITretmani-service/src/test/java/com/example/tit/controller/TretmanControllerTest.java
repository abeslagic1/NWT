package com.example.tit.controller;

import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

//import com.example.tit.controller.TretmanController;
import com.example.tit.dao.TretmanRepository;
import com.example.tit.model.Tretman;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(TretmanController.class)
public class TretmanControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TretmanRepository tretmanRepository;

    @Test
    public void testGetAllTretmani() throws Exception {
        Tretman tretman1 = new Tretman("Naziv1", "Opis1", null);
        Tretman tretman2 = new Tretman("Naziv2", "Opis2", null);

        when(tretmanRepository.findAll()).thenReturn(Stream.of(tretman1, tretman2).collect(Collectors.toList()));

        mockMvc.perform(MockMvcRequestBuilders.get("/tretmani")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].naziv").value("Naziv1"))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].opis").value("Opis1"))
            .andExpect(MockMvcResultMatchers.jsonPath("$[1].naziv").value("Naziv2"))
            .andExpect(MockMvcResultMatchers.jsonPath("$[1].opis").value("Opis2"));
    }

    @Test
    public void testGetTretmanById() throws Exception {
        Tretman tretman = new Tretman("Naziv", "Opis", null);
        when(tretmanRepository.findById(1)).thenReturn(Optional.of(tretman));

        mockMvc.perform(MockMvcRequestBuilders.get("/tretmani/1")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.naziv").value("Naziv"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.opis").value("Opis"));
    }

    @Test
    public void testDeleteTretman() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/tretmani/1"))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }
}

