package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Promocao;
//As interfaces servem como assinatura para comando tipo, findAll, findById e entre outros
public interface PromocaoRepository extends JpaRepository<Promocao,Long>{

}
