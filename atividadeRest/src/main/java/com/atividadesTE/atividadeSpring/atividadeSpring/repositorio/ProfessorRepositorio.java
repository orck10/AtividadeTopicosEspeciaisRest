package com.atividadesTE.atividadeSpring.atividadeSpring.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.atividadesTE.atividadeSpring.atividadeSpring.modelo.Materia;
import com.atividadesTE.atividadeSpring.atividadeSpring.modelo.Professor;

public interface ProfessorRepositorio extends CrudRepository<Professor, Long>{
	
	public Professor findByNome(String nome);
	
	public Professor findByMatricula(Long matricula);
	
	public List<Professor> findByMatriculaGreaterThan(Long matricula);
	
	@Query("select p from Professor p where p.nome like %?1%")
	public List<Professor> buscarProfessor(String nome);

}
