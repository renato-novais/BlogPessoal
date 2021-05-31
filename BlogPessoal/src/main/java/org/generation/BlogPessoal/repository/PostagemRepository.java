package org.generation.BlogPessoal.repository;

import java.util.List;

import org.generation.BlogPessoal.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> { // Herança da JPA, usando a classe e o tipo do ID
	public List<Postagem> findAllByTituloContainingIgnoreCase (String titulo);
	
}
