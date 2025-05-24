package com.Projeto.DsList.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Projeto.DsList.dto.GameListDTO;
import com.Projeto.DsList.dto.GameMinDTO;
import com.Projeto.DsList.service.GameListService;
import com.Projeto.DsList.service.GameService;

//implementar a api
@RestController

//configurando o caminho que vai ser respondido na api
@RequestMapping(value = "/lists")

public class GameListController {
	@Autowired
	private GameListService gameListService;
	
	@Autowired
	private GameService gameService;
	
	@GetMapping
	public List<GameListDTO> findAll(){
		List<GameListDTO> result = gameListService.findAll();
		return result;
	}
	
	@GetMapping(value = "/{listId}/games")
	public List<GameMinDTO> findByList(@PathVariable Long listId){
		List<GameMinDTO> result = gameService.findByList(listId);
		return result;
	}
}
