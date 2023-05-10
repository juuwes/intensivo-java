package com.devsuperior.intensivojava.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.intensivojava.dto.GameMinDTO;
import com.devsuperior.intensivojava.services.GameService;

// Controlador REST: porta de entrada o back-end, disponibiliza a API
@RestController

// @RequestMapping: mapear o recurso. Configurar o caminho respondido na API
@RequestMapping(value = "/games")
public class GameController { 

// injetar Service no Controller
	@Autowired
	private GameService gameService;

// @GetMapping: mapear Service com o verbo HTTP | endopoint buscar/obter os objetos - metodo GET
	@GetMapping
	public List<GameMinDTO> findAll() {
		List<GameMinDTO> result = gameService.findAll();
		return result;		
	}

}
