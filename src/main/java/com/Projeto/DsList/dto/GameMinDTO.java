package com.Projeto.DsList.dto;

import com.Projeto.DsList.entities.Game;

public class GameMinDTO {
	private long id;
	private String title;
	private Integer year;
	private String imgUrl;
	private String shortDescription;
	
	
	public GameMinDTO(){
		
	}


	public GameMinDTO(Game entity) {
		super();
		id = entity.getId();
		title = entity.getGenre();
		year = entity.getYear();
		imgUrl = entity.getGenre();
		shortDescription = entity.getGenre();
	}


	public long getId() {
		return id;
	}


	public String getTitle() {
		return title;
	}


	public Integer getYear() {
		return year;
	}


	public String getImgUrl() {
		return imgUrl;
	}


	public String getShortDescription() {
		return shortDescription;
	}
	
	
}
