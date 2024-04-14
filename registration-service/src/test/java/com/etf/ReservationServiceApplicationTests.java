package com.etf;

import com.etf.repository.PacijentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ReservationServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	PacijentRepository pacijentRepository;

	@Test
	void shouldReturnAllPacijents() throws Exception {
		this.mockMvc.perform(get("/Pacijent/")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("[{\"id\":1,\"ime\":\"Amar\",\"prezime\":\"Beslagic\",\"samUSobi\":true},{\"id\":2,\"ime\":\"Haris\",\"prezime\":\"Beslagic\",\"samUSobi\":false},{\"id\":3,\"ime\":\"Ferhat\",\"prezime\":\"Dobraca\",\"samUSobi\":false}]")));
	}

}
