package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Promocao;
//As interfaces servem como assinatura para comando tipo, findAll, findById e entre outros
public interface PromocaoRepository extends JpaRepository<Promocao,Long>{
//============================================ QUERIES DE LIKES COM SQL ============================================================
	//Atualizar a contagem de likes
	@Transactional(readOnly= false)
	@Modifying
	@Query("update Promocao p set p.likes = p.likes + 1 where p.id = :id")
	void updateSomarLikes(@Param("id") Long id);
	
	//Informa a quantidade de likes
	@Query("select p.likes from Promocao p where p.id = :id")
	int findLikesById(@Param("id") Long id);
}
