package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.SuperHeroeDTO;

public interface ISuperHeroeService {
	
	public void saveHeroe(SuperHeroeDTO heroe);
	
	public void deleteHeroe(SuperHeroeDTO heroe);
	
	public List<SuperHeroeDTO> findAll();
	
	public SuperHeroeDTO findById(Long id);
	
	public List<SuperHeroeDTO> findByNameLike(String nombre);

}
