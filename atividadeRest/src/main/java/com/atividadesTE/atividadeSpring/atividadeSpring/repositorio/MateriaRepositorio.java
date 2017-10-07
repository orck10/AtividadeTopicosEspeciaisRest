package com.atividadesTE.atividadeSpring.atividadeSpring.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.atividadesTE.atividadeSpring.atividadeSpring.modelo.Materia;

public interface MateriaRepositorio extends CrudRepository<Materia, Long>{
	
	public Materia findById(Long id);
	
	public Materia findByNome(String nome);

}
