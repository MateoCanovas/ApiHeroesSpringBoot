package com.example.demo.dto;

public class SuperHeroeDTO {

	private Long id;
	private String nombre;
	private String poder;

	public SuperHeroeDTO(Long id, String nombre, String poder) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.poder = poder;
	}

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPoder() {
		return poder;
	}

	public void setPoder(String poder) {
		this.poder = poder;
	}
	
}
