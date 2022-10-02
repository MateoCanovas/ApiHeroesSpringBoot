package com.example.demo.helper;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.SuperHeroeDTO;
import com.example.demo.entity.SuperHeroe;

public class SuperHeroeHelper {
	
	public static SuperHeroe getHeroe() {
		return new SuperHeroe(1L, "Batman", "Rico");
	}
	
	public static SuperHeroeDTO getHeroeDTO() {
		return new SuperHeroeDTO(1L, "Batman", "Rico");
	}
	
	public static List<SuperHeroe> getHeroes() {
		List<SuperHeroe> heroes = new ArrayList();
		heroes.add(getHeroe());
		return heroes;
	}
}
