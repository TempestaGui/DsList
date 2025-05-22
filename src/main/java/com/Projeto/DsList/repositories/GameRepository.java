package com.Projeto.DsList.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Projeto.DsList.entities.Game;

//componente para fazer consultas com o banco 
public interface GameRepository extends JpaRepository<Game, Long>{

}
