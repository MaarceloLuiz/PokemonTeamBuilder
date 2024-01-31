package com.marceloluiz.PokeAPITeamBuilder.model.dao;
import java.util.List;

import com.marceloluiz.PokeAPITeamBuilder.models.entities.Pokemon;

public interface PokemonDao {
	
	void insert(Pokemon obj);
	void update(Pokemon obj);
	void deleteById(Integer id);
	Pokemon findById(Integer id);
	List<Pokemon> findAll();
}
