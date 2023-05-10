package com.devsuperior.intensivojava.entities;

import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

//classe auxiliar: representa ok multipla

// @Embeddable: encapsulando dois atributos em uma só classe. private BelongingPK id, representa dois campos na tabela.
@Embeddable
public class BelongingPK {

// @ManyToOne: muitos para um. configuração JPA - mapeamento do mapa relacional (relacionamentos).
	@ManyToOne

// mapeado dois campos de chave estrangeiras na tabela.
// @JoinColumn: configurar o nome da chave estrangeira. 
	@JoinColumn(name = "game_id")
	private Game game;
	
	@ManyToOne
	@JoinColumn(name = "list_id")
	private GameList list;
	
	public BelongingPK() {
	}
	
	public BelongingPK(Game game, GameList list) {
		this.game = game;
		this.list = list;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public GameList getList() {
		return list;
	}

	public void setList(GameList list) {
		this.list = list;
	}

// para comparar uma pk multipla:
	@Override
	public int hashCode() {
		return Objects.hash(game, list);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BelongingPK other = (BelongingPK) obj;
		return Objects.equals(game, other.game) && Objects.equals(list, other.list);
	}
	
	
	
	

}
