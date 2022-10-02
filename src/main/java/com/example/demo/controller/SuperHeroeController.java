package com.example.demo.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.SuperHeroeDTO;
import com.example.demo.service.ISuperHeroeService;



@RestController
@RequestMapping("heroes")
public class SuperHeroeController {
	
	@Autowired
	private ISuperHeroeService heroeService;
	
	@GetMapping(value="/heroe", headers="Accept=Application/json")
	public ResponseEntity<SuperHeroeDTO> getHeroe(
			@RequestParam(name="id", required=true) Long id
			) {
		SuperHeroeDTO dto = heroeService.findById(id);
		if (Objects.nonNull(dto)) {
			return new ResponseEntity<>(dto, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping(value="/guardar-heroe", headers="Accept=Application/json")
	public ResponseEntity<SuperHeroeDTO> saveHeroe(
			@RequestBody SuperHeroeDTO heroe
			) {
		heroeService.saveHeroe(heroe);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping(value="/borrar-heroe", headers="Accept=Application/json")
	public ResponseEntity<SuperHeroeDTO> deleteHeroe(
			@RequestBody SuperHeroeDTO heroe
			) {
		heroeService.deleteHeroe(heroe);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value="/listar-todos")
	public ResponseEntity<List<SuperHeroeDTO>> getAllHeroes() {
		List<SuperHeroeDTO> dto  = heroeService.findAll();
		if (Objects.nonNull(dto) && !dto.isEmpty()) {
			return new ResponseEntity<>(dto, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(value="/listar-por-nombre")
	public ResponseEntity<List<SuperHeroeDTO>> getHeroesNameLike(
			@RequestParam(name="nombre", required=true) String nombre
			) {
		List<SuperHeroeDTO> dto  = heroeService.findByNameLike(nombre);
		if (Objects.nonNull(dto) && !dto.isEmpty()) {
			return new ResponseEntity<>(dto, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
