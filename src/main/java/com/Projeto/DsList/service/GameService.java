package com.Projeto.DsList.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Projeto.DsList.dto.GameDTO;
import com.Projeto.DsList.dto.GameMinDTO;
import com.Projeto.DsList.entities.Game;
import com.Projeto.DsList.projections.GameMinProjection;
import com.Projeto.DsList.repositories.GameRepository;

//registrar um componente, injetar um componente no outro
@Service	
public class GameService {
	
	//injetando uma instancia do gameRepository no gameService
	@Autowired
	private GameRepository gameRepository;
	//garante o ACID
	
	@Transactional(readOnly = true) //nao bloquear o banco de dados para escrita
	public GameDTO findById(Long id){
		Game result  = gameRepository.findById(id).get();
		GameDTO dto = new GameDTO(result);
		return dto;
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll(){
		//buscar nos dados todos os games
		List<Game> result = gameRepository.findAll();
		//operaçao para transformar uma lista games numa lista de gamesmin
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findByList(Long listId){
		//buscar nos dados todos os games
		List<GameMinProjection> result = gameRepository.searchByList(listId);
		//operaçao para transformar uma lista games numa lista de gamesmin
		 return result.stream().map(x -> new GameMinDTO(x)).toList();
	}
	
}
