package com.devsuperior.intensivojava.dto;

import com.devsuperior.intensivojava.entities.Game;

public class GameMinDTO {

// DTO é uma classe independente, não está mapeado com o bd

	private Long id;
	private String title;
	private Integer year;
	private String imgUrl;
	private String shortDescription;

	public GameMinDTO() {
	}

	public GameMinDTO(Game entity) { // instanciar a partir do objeto - Game.
		
// retirar o this., não existe ambiguidade.
		id = entity.getId();
		title = entity.getTitle();
		year = entity.getYear();
		imgUrl = entity.getImgUrl();
		shortDescription = entity.getShortDescription();
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Integer getYear() {
		return year;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public String getShortDescription() {
		return shortDescription;
	}

}
