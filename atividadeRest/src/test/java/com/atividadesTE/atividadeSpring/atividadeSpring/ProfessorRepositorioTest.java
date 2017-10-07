package com.atividadesTE.atividadeSpring.atividadeSpring;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.atividadesTE.atividadeSpring.atividadeSpring.modelo.Professor;
import com.atividadesTE.atividadeSpring.atividadeSpring.repositorio.MateriaRepositorio;
import com.atividadesTE.atividadeSpring.atividadeSpring.repositorio.ProfessorRepositorio;
import com.atividadesTE.atividadeSpring.atividadeSpring.servico.ExemploDeServico;
import com.atividadesTE.atividadeSpring.atividadeSpring.servico.ExemploDeServicoImplementacao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/ProfessorRepositorioTest.xml" })
@Rollback
@Transactional
public class ProfessorRepositorioTest extends AbstractTransactionalJUnit4SpringContextTests {
	private static final String nome = "Atila";
	private static final String materia = "BD";
	
	@Autowired
	ProfessorRepositorio professorRepositorio;
	
	@Autowired
	MateriaRepositorio materiaRepositorio;
	
	@Autowired
	ExemploDeServico exemploDeServico;
	
	public void setProfessorRepositorio(ProfessorRepositorio professorRepositorio){
		this.professorRepositorio = professorRepositorio;
	}
	
	public void ExempoloDeServico(ExemploDeServico exemploDeServico){
		this.exemploDeServico = exemploDeServico;
	}
	
	@Test
	public void testeDeInsercaoRepositorio(){
		Professor p1 = new Professor();
		p1.setNome(this.nome);
		professorRepositorio.save(p1);
		assertTrue(professorRepositorio.findByNome(this.nome).getNome().equals(this.nome));
	}
	@Test
	public void testeDeRemocaoServico(){
		exemploDeServico.addProfessor(this.nome);
		exemploDeServico.removeProfessorPorMatricula(professorRepositorio.findByNome(this.nome).getMatricula());
		assertTrue(professorRepositorio.findByNome(this.nome) == null);
	}
	@Test
	public void testeDeBusca(){
		exemploDeServico.addProfessor(this.nome);
		exemploDeServico.addMateria(this.materia);
		exemploDeServico.associaMaterias(professorRepositorio.findByNome(this.nome).getMatricula(), materiaRepositorio.findByNome(this.materia).getId());
		Professor p1 = professorRepositorio.findByNome(this.nome);
		assertTrue(!p1.getMaterias().isEmpty());
	}
}
