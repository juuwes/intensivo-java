package com.devsuperior.intensivojava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.intensivojava.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
