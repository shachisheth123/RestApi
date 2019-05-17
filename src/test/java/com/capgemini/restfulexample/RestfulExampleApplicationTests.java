package com.capgemini.restfulexample;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.capgemini.restfulexample.controller.PersonController;
import com.capgemini.restfulexample.entity.Person;
import com.capgemini.restfulexample.service.PersonService;

@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class RestfulExampleApplicationTests {

	@MockBean
	private PersonService service;

	@Autowired
	private PersonController controller;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void contextLoads() {

		assertThat(controller).isNotNull();

	}

	@Test
	public void postAddNew() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.post("/addNew")).andExpect(status().isOk());

	}

	@Test
	public void getAllTest() throws Exception {
		List<Person> person = null;

		Mockito.when(service.getAll()).thenReturn(person);

	}

	@Test
	public void getAllTestResult() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/findAll")).andExpect(status().isOk());

	}

	@Test
	public void deletePersonById() throws Exception {

		/*
		 * mockMvc.perform(MockMvcRequestBuilders.delete("/deletePerson"))
		 * .andExpect(status().isOk());
		 */
	}

	@Test
	@DisplayName("POST /addNew")
	public void testCreateProduct() throws Exception {
		Person postPerson = new Person(101, "shachi");
		Person mockPerson = new Person(101, "shachi");

		//       
		//  Mockito.when(service.addProduct(postProduct)).thenReturn(mockProduct);

		doReturn(mockPerson).when(service).addNew(any());

		mockMvc.perform(post("/addNew")).andExpect(MockMvcResultMatchers.jsonPath("$.personId", is(101)))
				.andExpect(MockMvcResultMatchers.jsonPath("$.personName", is("shachi")));
	}

	/*
	 * @Test
	 * 
	 * @DisplayName("GET /findAll") public void testFindAll() throws Exception {
	 * List<Person> person; List<Person> mockPerson = null;
	 * 
	 * //        //
	 *  Mockito.when(service.addProduct(postProduct)).thenReturn(mockProduct);
	 * 
	 * doReturn(mockPerson).when(service).getAll();
	 * 
	 * mockMvc.perform(post("/findAll")).andExpect(MockMvcResultMatchers.jsonPath(
	 * "$.personId", is(101)))
	 * .andExpect(MockMvcResultMatchers.jsonPath("$.personName", is("shachi"))); }
	 */

	@Test
	@DisplayName("GET /findById")
	public void testFindById() throws Exception {
		Person postPerson = new Person(101, "shachi");
		//  Mockito.when(service.addProduct(postProduct)).thenReturn(mockProduct);

		when(service.findById(101)).thenReturn(postPerson);

		mockMvc.perform(get("/findById")).andExpect(MockMvcResultMatchers.jsonPath("$.personId", is(101)));
	}

	@Test

	public void deleteByIdSuccess() throws Exception{

	when(service.delete(101)).thenReturn(true);

	mockMvc.perform(delete("deleteById/{personId}",101)).andExpect(status().isNotFound());

	    }
}
