package com.xy.pois.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class POIsControllerTest {

	private MockMvc mockMvc;
	
	@Autowired
	private POIsController poisController;
	
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(poisController).build();
	}	

	@Test
	public void e_findAllControllerTest()throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/xypois/all"))
		.andExpect(status().is2xxSuccessful())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
	}
	
	@Test
	public void f_findNearbyPOIsControllerTest() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/xypois/?x=20&y=10&d-max=10"))
		.andExpect(status().is2xxSuccessful())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));		
	}

}
