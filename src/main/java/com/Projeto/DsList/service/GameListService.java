package com.Projeto.DsList.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Projeto.DsList.dto.GameListDTO;
import com.Projeto.DsList.entities.GameList;
import com.Projeto.DsList.projections.GameMinProjection;
import com.Projeto.DsList.repositories.GameListRepository;
import com.Projeto.DsList.repositories.GameRepository;

//registrar um componente, injetar um componente no outro
@Service	
public class GameListService {
	
	//injetando uma instancia do gameRepository no gameService
	@Autowired
	private GameListRepository gameListRepository;
	@Autowired
	private GameRepository gameRepository;
	//garante o ACID
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		//buscar nos dados todos os games
		List<GameList> result = gameListRepository.findAll();
		//operaçao para transformar uma lista games numa lista de gamesmin
		List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
		return dto;
	}
	
	@Transactional
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		List<GameMinProjection> list = gameRepository.searchByList(listId); 
		GameMinProjection obj = list.remove(sourceIndex);
		list.add(destinationIndex, obj);
		
		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex; 
		
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex; 
		
		for(int i = min; i<max; i++) {
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
	}
}
