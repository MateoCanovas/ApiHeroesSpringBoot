package com.example.demo.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.helper.SuperHeroeHelper;
import com.example.demo.repository.ISuperHeroeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SuperHeroeControllerTest {
	
	@MockBean
	private ISuperHeroeRepository heroeRepository;
	@Autowired
	private MockMvc mockMvc;

	private static ObjectMapper om;

	@BeforeAll
	public static void setUp() {
		om = new ObjectMapper();
	}
	
	@Test
	void testFindById() throws Exception {
		when(heroeRepository.findById(1L)).thenReturn(Optional.of(SuperHeroeHelper.getHeroe()));
		mockMvc.perform(get("http://localhost:8080/heroes/heroe?id=1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
	
	@Test
	void testFindByIdNoContent() throws Exception {
		mockMvc.perform(get("http://localhost:8080/heroes/heroe?id=1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNoContent());
	}
	
	@Test
	void testSaveheroe() throws Exception {
		mockMvc.perform(post("http://localhost:8080/heroes/guardar-heroe").contentType(MediaType.APPLICATION_JSON)
				.content(om.writeValueAsString(SuperHeroeHelper.getHeroeDTO()))).andExpect(status().isOk());
	}
	
	@Test
	void testDeleteheroe() throws Exception {
		mockMvc.perform(post("http://localhost:8080/heroes/borrar-heroe").contentType(MediaType.APPLICATION_JSON)
				.content(om.writeValueAsString(SuperHeroeHelper.getHeroeDTO()))).andExpect(status().isOk());
	}
	
	@Test
	void testGetAllHeroes() throws Exception {
		when(heroeRepository.findAll()).thenReturn(SuperHeroeHelper.getHeroes());
		mockMvc.perform(get("http://localhost:8080/heroes/listar-todos").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
	
	@Test
	void testGetAllHeroesNoContent() throws Exception {
		mockMvc.perform(get("http://localhost:8080/heroes/listar-todos").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNoContent());
	}
	
	@Test
	void testGetHeroesnameLike() throws Exception {
		when(heroeRepository.findAllByNombreHeroeLike("man")).thenReturn(SuperHeroeHelper.getHeroes());
		mockMvc.perform(get("http://localhost:8080/heroes/listar-por-nombre?nombre=man").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
	
	@Test
	void testGetHeroesnameLikeNoContent() throws Exception {
		mockMvc.perform(get("http://localhost:8080/heroes/listar-por-nombre?nombre=man").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNoContent());
	}
}
