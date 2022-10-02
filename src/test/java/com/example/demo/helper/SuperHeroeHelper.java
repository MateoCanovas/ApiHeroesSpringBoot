package com.example.demo.helper;

import com.example.demo.dto.SuperHeroeDTO;
import com.example.demo.entity.SuperHeroe;

public class SuperHeroeHelper {
	
	public static SuperHeroe getHeroe() {
		return new SuperHeroe(1L, "Batman", "Rico");
	}
	
	public static SuperHeroeDTO getHeroeDTO() {
		return new SuperHeroeDTO(1L, "Batman", "Rico");
	}
}
