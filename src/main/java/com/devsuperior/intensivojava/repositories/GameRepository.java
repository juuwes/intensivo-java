package com.devsuperior.intensivojava.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.intensivojava.entities.Game;
import com.devsuperior.intensivojava.projections.GameMinProjection;

//camada de acesso a dados - Devolve Entities/ORM 

//extendendo da interface JPA 
// <Tipo da Entidade, Tipo do Id da Entidade>

public interface GameRepository extends JpaRepository<Game, Long> {

// consulta customizada SQL no Spring Data JPA
// nativeQuery: funcionar a consulta SQL e não JPQL : lingugagem de consulta da JPA*
// O resultado da consulta SQL deve ser uma interface - Projection.
	@Query(nativeQuery = true, value = """
			SELECT tb_game.id, tb_game.title, tb_game.game_year AS gameYear, tb_game.img_url AS imgUrl,
			tb_game.short_description AS shortDescription, tb_belonging.position
			FROM tb_game
			INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
			WHERE tb_belonging.list_id = :listId
			ORDER BY tb_belonging.position
				""")
	List<GameMinProjection> searchByList(Long listId);

}
