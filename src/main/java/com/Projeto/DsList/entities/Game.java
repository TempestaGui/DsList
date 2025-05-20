package com.Projeto.DsList.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//configura a classe java para que seja equivalente a uma tabela do banco relacional
@Entity
//dando o nome para a tabela
@Table(name = "Tb_Game")

public class Game {
	//tornando o id como id na tabela 
	@Id
	//tornando ele autoinclementado pelo banco de dados
	@GeneratedValue(strategy = GenerationType.IDENTITY) //uma forma de indicar para o banco gerar o id
	
	private long id;
	private String title;
	@Column(name = "Game_year")//customizando o nome da coluna no banco
	private Integer year;
	private	String genre;
	private String platforms;
	private Double score;
	private String imgUrl;
	
	@Column(columnDefinition = "TEXT")
	private String shortDescription;
	
	//metodo para que quando for gerado no banco de dados, seja gerado como texto e nao como varchar(255)
	@Column(columnDefinition = "TEXT")
	private String longDescription;
	
	public Game(){	
	}

	public Game(long id, String title, Integer year, String genre, String platforms,Double score ,String imgUrl,
			String shortDescription, String longDescription) {
		super();
		this.id = id;
		this.title = title;
		this.year = year;
		this.genre = genre;
		this.platforms = platforms;
		this.score = score;
		this.imgUrl = imgUrl;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getYear() {
		return year;
	}

	public void setPrice(Integer year) {
		this.year = year;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPlatforms() {
		return platforms;
	}

	public void setPlatforms(String platforms) {
		this.platforms = platforms;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}
	
		public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		return id == other.id;
	}


	
}
