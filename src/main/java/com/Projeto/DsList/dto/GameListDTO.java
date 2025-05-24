package com.Projeto.DsList.dto;

import org.springframework.beans.BeanUtils;

import com.Projeto.DsList.entities.GameList;

public class GameListDTO {
	private Long id;
	private String name;
	
	public GameListDTO() {
	}
	
	public GameListDTO(GameList entity) {
		id = entity.getId();
		name = entity.getName();
		//ou
		//BeanUtils.copyProperties(entity, this);
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	
}
