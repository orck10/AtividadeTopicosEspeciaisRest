package com.atividadesTE.atividadeSpring.atividadeSpring;

import java.util.LinkedList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atividadesTE.atividadeSpring.atividadeSpring.modelo.Materia;
import com.atividadesTE.atividadeSpring.atividadeSpring.modelo.Professor;
import com.atividadesTE.atividadeSpring.atividadeSpring.repositorio.MateriaRepositorio;
import com.atividadesTE.atividadeSpring.atividadeSpring.repositorio.ProfessorRepositorio;
import com.atividadesTE.atividadeSpring.atividadeSpring.servico.ExemploDeServico;
import com.atividadesTE.atividadeSpring.atividadeSpring.servico.ExemploDeServicoImplementacao;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    	
    	//Chama repositorio
        ProfessorRepositorio professorRepositoro = (ProfessorRepositorio) context.getBean("professorRepositorio");
        MateriaRepositorio materiaRepositorio = (MateriaRepositorio) context.getBean("materiaRepositorio");
        
        ExemploDeServico servicoDeImple = (ExemploDeServico) context.getBean("exemploDeServico");
       
        Professor p = professorRepositoro.findByNome("João");
        
        
        for(Materia m: p.getMaterias()){
        	System.out.println(m.getNome());
        } 
    }
}
