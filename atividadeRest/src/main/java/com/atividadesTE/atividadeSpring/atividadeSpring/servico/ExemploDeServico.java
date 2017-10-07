package com.atividadesTE.atividadeSpring.atividadeSpring.servico;

import java.util.List;

import com.atividadesTE.atividadeSpring.atividadeSpring.modelo.Professor;

public interface ExemploDeServico {
	
	public void exemploTransacao();

	void addProfessor(String nome);

	void removeMateriaPorId(Long i);

	void removeProfessorPorMatricula(Long m);

	void associaMaterias(Long profId, Long matriaId);

	void addMateria(String nome);
	
	List<Professor> buscaProfessor(String nome);
	
	Professor buscarPorId(Long i);
	
	List<Professor> buscaTodosProfessores();
	
	Professor salvarProfessor (Professor p);
}
