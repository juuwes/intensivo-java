package com.devsuperior.intensivojava.projections;

public interface GameMinProjection {
	
// metodos GET corresponde as consultas (GameRepository)
	Long getId();
	String getTitle();
	Integer getYear();
	String getImgUrl();
	String getShortDescription();
	Integer getPosition();

}
