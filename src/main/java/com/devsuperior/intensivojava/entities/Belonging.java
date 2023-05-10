package com.devsuperior.intensivojava.entities;

import java.util.Objects;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_belonging")
public class Belonging {
	
// dupla referencia - classe de associação
// orientação a objetos - apenas um atributo no id.
// classe auxiliar - com duas referencias
	@EmbeddedId
	private BelongingPK id = new BelongingPK(); //objeto instanciado
	
	private Integer position;

	public Belonging() {
	}

	public Belonging(Game game, GameList list, Integer position) {
// referencia para game e gamelist
		id.setGame(game);
		id.setList(list);
		this.position = position;
	}

	public BelongingPK getId() {
		return id;
	}

	public void setId(BelongingPK id) {
		this.id = id;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Belonging other = (Belonging) obj;
		return Objects.equals(id, other.id);
	}	

}
	