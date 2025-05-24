package com.Projeto.DsList.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Projeto.DsList.entities.GameList;

//componente para fazer consultas com o banco 
public interface GameListRepository extends JpaRepository<GameList, Long>{

}
