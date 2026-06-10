package com.example.demo.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Categoria;
import com.example.demo.repository.CategoriaRepository;
//Informando que é um controller
@Controller
@RequestMapping("/promocao") //Se na url tiver escrito /promocao, o sistema entenderá que pertence a esse controller
public class PromocaoController {

	//Informando o repositorio de categoria
	@Autowired
	private CategoriaRepository categoriaRepository;
	
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
