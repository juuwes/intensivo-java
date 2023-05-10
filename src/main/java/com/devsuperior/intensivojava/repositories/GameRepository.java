package com.devsuperior.intensivojava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.intensivojava.entities.Game;

//camada de acesso a dados - Devolve Entities/ORM 

//extendendo da interface JPA 
// <Tipo da Entidade, Tipo do Id da Entidade>

public interface GameRepository extends JpaRepository<Game, Long> {

}
