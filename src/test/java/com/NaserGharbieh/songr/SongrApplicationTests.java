package com.NaserGharbieh.songr;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
class SongrApplicationTests {
	@Autowired
	MockMvc mockMvc;
	@Test
	void testHelloPage() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
				.andDo(print()) // Print the response content to the console for debugging
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(containsString("<div> <P> hello world  </P> </div>")));

	}
	@Test
	void testCapitalizedPage() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/capitalize/smalltext"))
				.andDo(print()) // Print the response content to the console for debugging
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(containsString("<h1>SMALLTEXT</h1>")));

	}

	@Test
	void contextLoads() {
	}

}
