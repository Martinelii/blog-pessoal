package com.generation.blogpessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.blogpessoal.model.Postagem;

public interface PostagemRepository extends JpaRepository<Postagem, Long> { //Inheriting CRUD of JpaRepository 
	
	public List <Postagem> findByTituloContainingIgnoreCase(@Param("titulo") String titulo); 
						//Realmente Parametros ou apenas nome do metodo ??
}
