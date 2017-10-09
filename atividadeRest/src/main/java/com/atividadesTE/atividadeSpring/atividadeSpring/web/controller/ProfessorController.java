package com.atividadesTE.atividadeSpring.atividadeSpring.web.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.atividadesTE.atividadeSpring.atividadeSpring.modelo.Professor;
import com.atividadesTE.atividadeSpring.atividadeSpring.servico.ExemploDeServico;
import com.atividadesTE.atividadeSpring.atividadeSpring.view.View;
import com.fasterxml.jackson.annotation.JsonView;


@RestController
@RequestMapping(value = "/professor")
public class ProfessorController {
	
	@Autowired
	private ExemploDeServico exemploDeServico;

	public void setExemploDeServico(ExemploDeServico exemploDeServico) {
		this.exemploDeServico = exemploDeServico;
	}
	
	@RequestMapping(value = "/get/{nome}")
	@JsonView(View.All.class)
	public ResponseEntity<Collection<Professor>> pesquisar(@PathVariable("nome") String nome) {
		return new ResponseEntity<Collection<Professor>>(exemploDeServico.buscaProfessor(nome), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getById")
	@JsonView(View.All.class)
	public ResponseEntity<Professor> get(@RequestParam(value="id", defaultValue="1") Long id) {
		Professor professor = exemploDeServico.buscarPorId(id);
		if(professor == null) {
			return new ResponseEntity<Professor>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Professor>(professor, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAll")
	@JsonView(View.Alternative.class)
	public ResponseEntity<Collection<Professor>> getAll() {
		return new ResponseEntity<Collection<Professor>>(exemploDeServico.buscaTodosProfessores(), HttpStatus.OK);
	}
	

	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@JsonView(View.All.class)
	@ResponseStatus(HttpStatus.CREATED)
	public Professor save(@RequestBody Professor professor, HttpServletRequest request, HttpServletResponse response) {
		professor = exemploDeServico.salvarProfessor(professor);
		response.addHeader("Location", request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/professor/getById?id=" + professor.getMatricula());
		return professor;
	}
}
