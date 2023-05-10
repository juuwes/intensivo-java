package com.devsuperior.intensivojava.dto;

import com.devsuperior.intensivojava.entities.GameList;

public class GameListDTO {
	
	private Long id;
	private String name;
	
	public GameListDTO() {
	}

// não utilizou BeansUtils, portanto pode ser utilizado somente os metodos Getters
	public GameListDTO(GameList entity) {
		id = entity.getId();
		name = entity.getName();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}	

}
