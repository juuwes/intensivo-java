package com.devsuperior.intensivojava.projections;

public interface GameMinProjection {
	
// metodos GET corresponde as consultas (GameRepository)
	Long getId();
	String getTitle();
	Integer getGameYear();
	String getImgUrl();
	String getShortDescription();
	Integer getPosition();

}
