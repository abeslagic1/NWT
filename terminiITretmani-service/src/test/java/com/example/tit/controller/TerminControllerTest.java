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

//import com.example.tit.controller.TerminController;
import com.example.tit.dao.TerminRepository;
import com.example.tit.model.Termin;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(TerminController.class)
public class TerminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TerminRepository terminRepository;

    @Test
    public void testGetAllTermini() throws Exception {
        Termin termin1 = new Termin("Komentar 1", "Zakazan", null, null, null, null);
        Termin termin2 = new Termin("Komentar 2", "Otkazan", null, null, null, null);
        when(terminRepository.findAll()).thenReturn(Stream.of(termin1, termin2).collect(Collectors.toList()));

        mockMvc.perform(MockMvcRequestBuilders.get("/termini")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].komentar").value("Zakazan"))
            .andExpect(MockMvcResultMatchers.jsonPath("$[1].status").value("Komentar 2"));
    }

    @Test
    public void testGetTerminById() throws Exception {
        Termin termin = new Termin("Komentar", "Zakazan", null, null, null, null);
        when(terminRepository.findById(1)).thenReturn(Optional.of(termin));

        mockMvc.perform(MockMvcRequestBuilders.get("/termini/1")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.komentar").value("Zakazan"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("Komentar"));
    }

    @Test
    public void testDeleteTermin() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/termini/1"))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
