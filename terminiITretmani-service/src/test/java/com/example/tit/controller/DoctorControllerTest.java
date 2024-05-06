package com.example.tit.controller;

//import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mockito;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.tit.dao.DoctorRepository;
import com.example.tit.model.Doctor;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(DoctorController.class)
public class DoctorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DoctorRepository doctorRepository;

    @Test
    public void testGetAllDoctors() throws Exception {
        Doctor doctor1 = new Doctor("John", "Doe", "Specialization1");
        Doctor doctor2 = new Doctor("Jane", "Smith", "Specialization2");
        when(doctorRepository.findAll()).thenReturn(Stream.of(doctor1, doctor2).collect(Collectors.toList()));
        mockMvc.perform(MockMvcRequestBuilders.get("/doktori").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("John"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("Jane"));
    }

    @Test
    public void testGetDoctorById() throws Exception {
    Doctor doctor = new Doctor("John", "Doe", "Specialization1");
    when(doctorRepository.findById(1)).thenReturn(Optional.of(doctor));
    mockMvc.perform(MockMvcRequestBuilders.get("/doktori/1").contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("John"));
    }
    
    @Test
    public void testDeleteDoctor() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.delete("/doktori/1"))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }

    
}

