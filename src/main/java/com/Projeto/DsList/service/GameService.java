package com.Projeto.DsList.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Projeto.DsList.dto.GameMinDTO;
import com.Projeto.DsList.entities.Game;
import com.Projeto.DsList.repositories.GameRepository;

//registrar um componente, injetar um componente no outro
@Service	
public class GameService {
	
	//injetando uma instancia do gameRepository no gameService
	@Autowired
	private GameRepository gameRepository;
	
	public List<GameMinDTO> findAll(){
		//buscar nos dados todos os games
		List<Game> result = gameRepository.findAll();
		//operaçao para transformar uma lista games numa lista de gamesmin
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
	}
}
