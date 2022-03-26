package com.example.demo;

import com.example.demo.web.FirstController;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
class DemoApplicationTests {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webapplicationContext;

	@Autowired
	FirstController firstController;

	@Test
	void contextLoads() {
	}

	@BeforeEach
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webapplicationContext).build();
	}

	@Test
	public void testHelloPage() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
				.andExpect(status().isOk())
				.andExpect(content().contentType("text/html;charset=UTF-8"))
				.andExpect(view().name("hello"))
				.andExpect(content().string(Matchers.containsString("Hello")));

	}



}
