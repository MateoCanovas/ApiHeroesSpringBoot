package com.example.demo.mapper;

import com.example.demo.dto.SuperHeroeDTO;
import com.example.demo.entity.SuperHeroe;

public class SuperHeroeMapper {

	
	public static SuperHeroeDTO entityToDto(SuperHeroe heroe) {
		return new SuperHeroeDTO(heroe.getId(), heroe.getNombre(), heroe.getPoder());
	}
	
	public static SuperHeroe dtoToEntity(SuperHeroeDTO heroe) {
		return new SuperHeroe(heroe.getId(), heroe.getNombre(), heroe.getPoder());
	}
}
