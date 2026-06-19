package com.example.demo.web.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Categoria;
import com.example.demo.domain.Promocao;
import com.example.demo.repository.CategoriaRepository;
import com.example.demo.repository.PromocaoRepository;


//Informando que é um controller
@Controller
@RequestMapping("/promocao") //Se na url tiver escrito /promocao, o sistema entenderá que pertence a esse controller
public class PromocaoController {
	//para logar
	private static Logger log = LoggerFactory.getLogger(PromocaoController.class);
	
	//Informando o repositorio de promocao
	@Autowired
	private PromocaoRepository promocaoRepository;
	
	//Informando o repositorio de categoria
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@PostMapping("/save")
	//função de salvar o objeto que criamos no formulario
	public ResponseEntity<Promocao> salvarPromocao(Promocao promocao){
		//informando o objeto
		log.info("Promocao{}", promocao.toString());
		//adicionando o dia de cadastro ao objeto
		promocao.setDtCadastro(LocalDateTime.now());
		//Os repositorios são responsavel por metodos como o save
		promocaoRepository.save(promocao);
		//confirmação
		return ResponseEntity.ok().build();
	}
	
	//Ele faz referencia a "categorias" que esta no layout 
	@ModelAttribute("categorias")
	public List<Categoria> getCategorias(){
		//Função para mostrar todos as categorias presentes no banco de dados
		return categoriaRepository.findAll();
	}
	// informando que a url precisa ter /promocao/add
	@GetMapping("/add")
	public String abrirCadastro() {
		return "promo-add";
	}
}
