package com.Projeto.DsList.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Projeto.DsList.entities.Game;
import com.Projeto.DsList.service.GameService;

//implementar a api

@RestController
//configurando o caminho que vai ser respondido na api
@RequestMapping(value = "/Games")

public class GameController {
	@Autowired
	private GameService gameService;
	@GetMapping
	public List<Game> findAll(){
		List<Game> result = gameService.findAll();
		return result;
	}
}
