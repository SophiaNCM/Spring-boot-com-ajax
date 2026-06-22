package com.example.demo.web.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Categoria;
import com.example.demo.domain.Promocao;
import com.example.demo.repository.CategoriaRepository;
import com.example.demo.repository.PromocaoRepository;

import jakarta.validation.Valid;


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
	//======================================================= LISTAR AS PROMOCOES ==========================================================

	@GetMapping("/list")
	public String listarOfertas(ModelMap model) {
		Sort sort = Sort.by(Sort.Direction.DESC, "dtCadastro");
		PageRequest pageRequest = PageRequest.of(0,8,sort);
		model.addAttribute("promocao", promocaoRepository.findAll(pageRequest));
		//A pagina de retorno
		return "promo-list";
	}
//========================================================================================================================================

	
//======================================================= METODO DE SALVAR ============================================================
	@SuppressWarnings("deprecation")
	@PostMapping("/save")
	//função de salvar o objeto que criamos no formulario
	//@Valid e BindingResult servem para validar as requisições do model
	public ResponseEntity<?> salvarPromocao(@Valid Promocao promocao, BindingResult result){
		//caso tenha erro
		if(result.hasErrors()) {
			//Vai procurar qual o erro com Map
			Map<String, String> errors = new HashMap<>();
			//Vendo em cada campo
			for (FieldError error: result.getFieldErrors()) {
				//informando o campo e erro
				errors.put(error.getField(), error.getDefaultMessage());
			}
			return ResponseEntity.unprocessableEntity().body(errors);
		}
		//informando o objeto
		log.info("Promocao{}", promocao.toString());
		//adicionando o dia de cadastro ao objeto
		promocao.setDtCadastro(LocalDateTime.now());
		//Os repositorios são responsavel por metodos como o save
		promocaoRepository.save(promocao);
		//confirmação
		return ResponseEntity.ok().build();
	}
	//========================================================================================================================================
	
	//======================================================= LISTAR AS CATEGORIAS ============================================================
	//Ele faz referencia a "categorias" que esta no layout 
	@ModelAttribute("categorias")
	public List<Categoria> getCategorias(){
		//Função para mostrar todos as categorias presentes no banco de dados
		return categoriaRepository.findAll();
	}
	//======================================================================================================================================
	//======================================================= METODO DE ADD ================================================================

	// informando que a url precisa ter /promocao/add
	@GetMapping("/add")
	public String abrirCadastro() {
		return "promo-add";
	}
	//======================================================================================================================================

}
