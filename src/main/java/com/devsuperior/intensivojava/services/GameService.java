package com.devsuperior.intensivojava.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.intensivojava.dto.GameDTO;
import com.devsuperior.intensivojava.dto.GameMinDTO;
import com.devsuperior.intensivojava.entities.Game;
import com.devsuperior.intensivojava.projections.GameMinProjection;
import com.devsuperior.intensivojava.repositories.GameRepository;

@Service // ou @Component - registrar classe como componente de sistema - framework gerencia

//camada de serviços
public class GameService {

// injetar Repository no Service
	@Autowired // Spring resolve a dependencia
	private GameRepository gameRepository; // injetando uma instancia
	
/* boa pratica | todo metodo do service para ser transacional, principios das transações
 *  ACID (atomica, consistente, isolada e duravel - notação : @Transactional (import SPRING)
 *  (readOnly = true) : não irá ter escrita no bd (+ rapido)*/
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		
/* findById() : recebe um id e retorna um objeto.
* findById() do repository retorna tipo Optional, para buscar/pegar o game dentro do Optional .get()
* tratamento de exceção pode ser feito (id inexistente). */
		Game result = gameRepository.findById(id).get();
		
// buscar do banco de dados, converter DTO
		return new GameDTO(result);
	}
	
/* Customizar a saida na API
* Service devolve DTO - Arquitetura */
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll() { // findAll() buscar todos.
		List<Game> result = gameRepository.findAll();

/* lib do java | stream(): permite fazer operações com sequencias de dados, operação map(): transforma objetos
* para voltar um stream() para lista .toList()*/
		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findByList(Long listId) { 
		List<GameMinProjection> result = gameRepository.searchByList(listId); // procurar pela lista(id)
		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}

}
