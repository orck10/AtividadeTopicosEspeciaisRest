package com.atividadesTE.atividadeSpring.atividadeSpring.servico;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atividadesTE.atividadeSpring.atividadeSpring.modelo.Materia;
import com.atividadesTE.atividadeSpring.atividadeSpring.modelo.Professor;
import com.atividadesTE.atividadeSpring.atividadeSpring.repositorio.MateriaRepositorio;
import com.atividadesTE.atividadeSpring.atividadeSpring.repositorio.ProfessorRepositorio;

@Service("exemploDeServico")
public class ExemploDeServicoImplementacao implements ExemploDeServico{
	
	@Autowired
	private ProfessorRepositorio professorRepositoro;
	
	@Autowired
    private MateriaRepositorio materiaRepositorio;
	
	@Transactional
	public void addProfessor(String nome){
		// Cria Professores
		Professor professor1 = new Professor();
		professor1.setNome(nome);
		
		//Salva os professores no banco
		this.professorRepositoro.save(professor1);
	}
	
	@Transactional
	public void addMateria(String nome){
		//Cria Materias
		Materia materia1 = new Materia();
		materia1.setNome(nome);
		
		//Salva as materias no banco
		this.materiaRepositorio.save(materia1);		
	}
	
	@Transactional
	public void associaMaterias(Long profId, Long matriaId){
		Professor p = this.professorRepositoro.findByMatricula(profId);
		
		Materia m = this.materiaRepositorio.findById(matriaId);
		
		p.addMateria(m);
		
		professorRepositoro.save(p);
	}
	
	@Transactional
	public void removeProfessorPorMatricula(Long m){
		professorRepositoro.delete(professorRepositoro.findByMatricula(m));
	}
	
	@Transactional
	public void removeMateriaPorId(Long i){
		materiaRepositorio.delete(materiaRepositorio.findById(i));
	}
	
	public void exemploTransacao() {
		
	}
	
	@Transactional
	public List<Professor> buscaProfessor(String nome) {
		
		return professorRepositoro.buscarProfessor(nome);
	}

	@Transactional
	public Professor buscarPorId(Long i) {
		
		return professorRepositoro.findByMatricula(i);
	}

	@Transactional
	public List<Professor> buscaTodosProfessores() {
		List<Professor> listaProfessor = new ArrayList<Professor>();
		for(Professor p: professorRepositoro.findAll()){
			listaProfessor.add(p);
		}
		return listaProfessor;
	}
	
	@Transactional
	public Professor salvarProfessor(Professor p) {
		return professorRepositoro.save(p);
		
	}
}
