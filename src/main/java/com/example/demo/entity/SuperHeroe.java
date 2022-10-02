package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_SUPER_HEROE")
public class SuperHeroe {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nombre_heroe")
	private String nombreHeroe;
	
	@Column(name="super_poder")
	private String poderHeroe;
	
	public SuperHeroe() {
	}

	public SuperHeroe(Long id, String nombre, String poder) {
		this.id = id;
		this.nombreHeroe = nombre;
		this.poderHeroe = poder;
	}

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombreHeroe;
	}

	public void setNombre(String nombre) {
		this.nombreHeroe = nombre;
	}

	public String getPoder() {
		return poderHeroe;
	}

	public void setPoder(String poder) {
		this.poderHeroe = poder;
	}
	
}
