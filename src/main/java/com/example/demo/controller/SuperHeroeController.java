package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.SuperHeroeDTO;



@RestController
@RequestMapping("heroes")
public class SuperHeroeController {
	
	@GetMapping(value="/heroe", headers="Accept=Application/json")
	public ResponseEntity<SuperHeroeDTO> getHeroe(
			@RequestParam(name="id", required=true) Long id
			) {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping(value="/guardar-heroe", headers="Accept=Application/json")
	public ResponseEntity<SuperHeroeDTO> saveHeroe(
			@RequestBody SuperHeroeDTO heroe
			) {
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping(value="/borrar-heroe", headers="Accept=Application/json")
	public ResponseEntity<SuperHeroeDTO> deleteHeroe(
			@RequestBody SuperHeroeDTO heroe
			) {
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value="/listar-todos")
	public ResponseEntity<List<SuperHeroeDTO>> getAllHeroes() {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(value="/listar-por-nombre")
	public ResponseEntity<List<SuperHeroeDTO>> getHeroesNameLike(
			@RequestParam(name="nombre", required=true) String nombre
			) {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
