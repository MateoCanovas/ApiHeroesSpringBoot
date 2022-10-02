package com.example.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.SuperHeroe;




@Transactional
@Repository("heroeRepository")
public interface ISuperHeroeRepository extends CrudRepository<SuperHeroe, Long>{

	public SuperHeroe getById(Long id);
	
	@Query("SELECT s FROM SuperHeroe s WHERE s.nombreHeroe LIKE CONCAT('%',:nombre,'%')")
	List<SuperHeroe> findAllByNombreHeroeLike(@Param("nombre") String nombre);
}
