package com.devsuperior.intensivojava.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.intensivojava.dto.GameListDTO;
import com.devsuperior.intensivojava.entities.GameList;
import com.devsuperior.intensivojava.projections.GameMinProjection;
import com.devsuperior.intensivojava.repositories.GameListRepository;
import com.devsuperior.intensivojava.repositories.GameRepository;

@Service
public class GameListService {

	@Autowired 	
	private GameListRepository gameListRepository; 
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll() { 
		List<GameList> result = gameListRepository.findAll();
		return result.stream().map(x -> new GameListDTO(x)).toList();
	}
	
	
	@Transactional
	//mover jogos/atualizar jogos	
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		List<GameMinProjection> list = gameRepository.searchByList(listId);
		
		//remover item de uma posição:
		GameMinProjection obj = list.remove(sourceIndex);
		// adicionar item a lista.
		list.add(destinationIndex, obj);
		
		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
		
		for (int i = min; i <= max; i++) {
			// list.get(i).getId(): busca id do jogo
			// i = nova posição --- "lista 2, id 9, posição i
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}

	}

}

