package com.atividadesTE.atividadeSpring.atividadeSpring.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.atividadesTE.atividadeSpring.atividadeSpring.view.View;
import com.fasterxml.jackson.annotation.JsonView;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "MATERIA")
public class Materia {
	@Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "MAT_ID")
	@JsonView(View.All.class)
	private Long id;
	
	@Column(name = "MAT_NOME", unique=true, length = 15, nullable = false)
	@JsonView({View.Main.class, View.Alternative.class})
	private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
