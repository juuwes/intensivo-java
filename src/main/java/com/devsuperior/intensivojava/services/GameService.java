package com.devsuperior.intensivojava.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.intensivojava.dto.GameMinDTO;
import com.devsuperior.intensivojava.entities.Game;
import com.devsuperior.intensivojava.repositories.GameRepository;

@Service // ou @Component - registrar classe como componente de sistema - framework gerencia

//camada de serviços
public class GameService {

// injetar Repository no Service
	@Autowired // Spring resolve a dependencia
	private GameRepository gameRepository; // injetando uma instancia
	
// Customizar a saida na API
// Service devolve DTO - Arquitetura
	public List<GameMinDTO> findAll() { // findAll() buscar todos.
		List<Game> result = gameRepository.findAll();

//lib do java | stream(): permite fazer operações com sequencias de dados, operação map(): transforma objetos
// para voltar um stream() para lista .toList()
		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}

}

