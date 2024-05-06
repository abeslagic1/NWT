// package com.example.tit.controller;

// import static org.mockito.Mockito.when;

// import java.util.Date;
// import java.util.Optional;
// import java.util.stream.Collectors;
// import java.util.stream.Stream;

// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.junit.jupiter.MockitoExtension;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.http.MediaType;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
// import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

// import com.example.tit.controller.TerminZauzetostiController;
// import com.example.tit.dao.TerminZauzetostiRepository;
// import com.example.tit.model.TerminZauzetosti;

// @ExtendWith(MockitoExtension.class)
// @WebMvcTest(TerminZauzetostiController.class)
// public class TerminZauzetostiControllerTest {

//     @Autowired
//     private MockMvc mockMvc;

//     @MockBean
//     private TerminZauzetostiRepository terminZauzetostiRepository;

//     @Test
//     public void testGetAllTerminiZauzetosti() throws Exception {
//         // TerminZauzetosti terminZauzetosti1 = new TerminZauzetosti(new Date(), new Date(), new Date());
//         // TerminZauzetosti terminZauzetosti2 = new TerminZauzetosti(new Date(), new Date(), new Date());

//         when(terminZauzetostiRepository.findAll()).thenReturn(Stream.of(terminZauzetosti1, terminZauzetosti2).collect(Collectors.toList()));

//         mockMvc.perform(MockMvcRequestBuilders.get("/terminiZauzetosti")
//             .contentType(MediaType.APPLICATION_JSON))
//             .andExpect(MockMvcResultMatchers.status().isOk())
//             .andExpect(MockMvcResultMatchers.jsonPath("$[0].datumTretmana").value(terminZauzetosti1.getDatumTretmana().getTime()))
//             .andExpect(MockMvcResultMatchers.jsonPath("$[0].vrijemePocetka").value(terminZauzetosti1.getVrijemePocetka().getTime()))
//             .andExpect(MockMvcResultMatchers.jsonPath("$[0].vrijemeKraja").value(terminZauzetosti1.getVrijemeKraja().getTime()))
//             .andExpect(MockMvcResultMatchers.jsonPath("$[1].datumTretmana").value(terminZauzetosti2.getDatumTretmana().getTime()))
//             .andExpect(MockMvcResultMatchers.jsonPath("$[1].vrijemePocetka").value(terminZauzetosti2.getVrijemePocetka().getTime()))
//             .andExpect(MockMvcResultMatchers.jsonPath("$[1].vrijemeKraja").value(terminZauzetosti2.getVrijemeKraja().getTime()));
//     }

//     @Test
//     public void testGetTerminZauzetostiById() throws Exception {
//         TerminZauzetosti terminZauzetosti = new TerminZauzetosti(new Date(), new Date(), new Date());

//         when(terminZauzetostiRepository.findById(1)).thenReturn(Optional.of(terminZauzetosti));

//         mockMvc.perform(MockMvcRequestBuilders.get("/terminiZauzetosti/1")
//             .contentType(MediaType.APPLICATION_JSON))
//             .andExpect(MockMvcResultMatchers.status().isOk())
//             .andExpect(MockMvcResultMatchers.jsonPath("$.datumTretmana").value(terminZauzetosti.getDatumTretmana().getTime()))
//             .andExpect(MockMvcResultMatchers.jsonPath("$.vrijemePocetka").value(terminZauzetosti.getVrijemePocetka().getTime()))
//             .andExpect(MockMvcResultMatchers.jsonPath("$.vrijemeKraja").value(terminZauzetosti.getVrijemeKraja().getTime()));
//     }

//     @Test
//     public void testDeleteTerminZauzetosti() throws Exception {
//         mockMvc.perform(MockMvcRequestBuilders.delete("/terminiZauzetosti/1"))
//             .andExpect(MockMvcResultMatchers.status().isOk());
//     }
// }

