package com.atividadesTE.atividadeSpring.atividadeSpring.modelo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.atividadesTE.atividadeSpring.atividadeSpring.view.View;
import com.fasterxml.jackson.annotation.JsonView;



@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "PROFESSOR")
public class Professor {
	
	@Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "PROF_ID")
	@JsonView({View.All.class, View.Alternative.class})
	private Long matricula;
	
	@Column(name = "PROF_NOME", length = 15, nullable = false)
	@JsonView({View.Main.class, View.Alternative.class})
	private String nome;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "PROF_MATERIA", 
	    	joinColumns = { @JoinColumn(name = "PROF_ID") }, 
	    	inverseJoinColumns = { @JoinColumn(name = "MAT_ID") })
	@JsonView({View.Main.class, View.Alternative.class})
	@XmlElement(name = "MATERIA")
	private Set<Materia> materias = new HashSet<Materia>();

	public void addMateria(Materia materia){
		this.materias.add(materia);
	}
	
	public void removeMateria(Materia materia){
		this.materias.remove(materia);
	}

	public Set<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(Set<Materia> materias) {
		this.materias = materias;
	}

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	
}
