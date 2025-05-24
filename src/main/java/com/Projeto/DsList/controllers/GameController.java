package com.Projeto.DsList.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Projeto.DsList.dto.GameDTO;
import com.Projeto.DsList.dto.GameMinDTO;
import com.Projeto.DsList.service.GameService;

//implementar a api
@RestController

//configurando o caminho que vai ser respondido na api
@RequestMapping(value = "/Games")

public class GameController {
	@Autowired
	private GameService gameService;
	@GetMapping
	public List<GameMinDTO> findAll(){
		List<GameMinDTO> result = gameService.findAll();
		return result;
	}
	
	@GetMapping(value = "/{id}")
	public GameDTO findById(@PathVariable Long id){
		GameDTO result = gameService.findById(id);
		return result;
	}
}
