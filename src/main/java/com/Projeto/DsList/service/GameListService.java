package com.Projeto.DsList.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Projeto.DsList.dto.GameListDTO;
import com.Projeto.DsList.entities.GameList;
import com.Projeto.DsList.repositories.GameListRepository;

//registrar um componente, injetar um componente no outro
@Service	
public class GameListService {
	
	//injetando uma instancia do gameRepository no gameService
	@Autowired
	private GameListRepository gameListRepository;
	//garante o ACID
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		//buscar nos dados todos os games
		List<GameList> result = gameListRepository.findAll();
		//operaçao para transformar uma lista games numa lista de gamesmin
		List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
		return dto;
	}
}
