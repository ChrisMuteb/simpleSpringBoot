package com.example.simpleApp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SimpleAppApplicationTests {
//	@Autowired
//	private MockMvc mockMvc;

//	@Test
//	void testHelloEndpoint() throws Exception {
//		mockMvc.perform(MockMvcRequestBuilders.get("/"))
//				.andExpect(MockMvcResultMatchers.status().isOk())
//				.andExpect(MockMvcResultMatchers.content().string("Hello, Spring Boot!"));
//	}

	@Test
	void contextLoads() {
		assertTrue(true);
	}

}
