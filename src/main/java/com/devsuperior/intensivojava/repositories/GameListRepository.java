package com.devsuperior.intensivojava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.intensivojava.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {

	// Quando existe uma consulta SQL, sem a função SELECT, mas com outros comandos (ex. UPDATE), colocar @Modifying
	@Modifying
	@Query(nativeQuery = true, 
	value = "UPDATE tb_belonging SET position = :newPosition WHERE list_id = :listId AND game_id = :gameId")
	void updateBelongingPosition(Long listId, Long gameId, Integer newPosition);

}
