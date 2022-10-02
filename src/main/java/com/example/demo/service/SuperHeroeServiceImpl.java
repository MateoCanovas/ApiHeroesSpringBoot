package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.SuperHeroeDTO;
import com.example.demo.entity.SuperHeroe;
import com.example.demo.mapper.SuperHeroeMapper;
import com.example.demo.repository.ISuperHeroeRepository;


@Service
public class SuperHeroeServiceImpl implements ISuperHeroeService {

	@Autowired
	private ISuperHeroeRepository heroeRespository;

	
	public void saveHeroe(SuperHeroeDTO heroe) {
		SuperHeroe heroeEntity = SuperHeroeMapper.dtoToEntity(heroe);
		
		heroeRespository.save(heroeEntity);
	}
	
	public void deleteHeroe(SuperHeroeDTO heroe) {
		SuperHeroe heroeEntity = SuperHeroeMapper.dtoToEntity(heroe);
		
		heroeRespository.delete(heroeEntity);
	}
	
	public List<SuperHeroeDTO> findAll() {
		List<SuperHeroeDTO> heroes = new ArrayList<SuperHeroeDTO>();
		heroeRespository.findAll().forEach(heroe -> heroes.add(SuperHeroeMapper.entityToDto(heroe)));
		return heroes;
	}
	
	public SuperHeroeDTO findById(Long id) {
		Optional <SuperHeroe> heroeAux = heroeRespository.findById(id); 
		if (heroeAux.isPresent()) {
			return SuperHeroeMapper.entityToDto(heroeAux.get());
		}
		return null;
	}
	
	public List<SuperHeroeDTO> findByNameLike(String nombre) {
		List<SuperHeroeDTO> heroes = new ArrayList<SuperHeroeDTO>();
		heroeRespository.findAllByNombreHeroeLike(nombre).forEach(heroe -> heroes.add(SuperHeroeMapper.entityToDto(heroe)));
		return heroes;
	}
}
