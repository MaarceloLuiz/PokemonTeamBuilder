package com.marceloluiz.PokeAPITeamBuilder.services;

import java.util.List;

import com.marceloluiz.PokeAPITeamBuilder.model.dao.DaoFactory;
import com.marceloluiz.PokeAPITeamBuilder.model.dao.PokemonDao;
import com.marceloluiz.PokeAPITeamBuilder.models.entities.Pokemon;

public class PokemonService {
private PokemonDao dao = DaoFactory.createPokemonDao();
	
	public List<Pokemon> findAll(){
		return dao.findAll();
	}
	
	public void saveOrUpdate(Pokemon obj) {
		if(obj.getPokeID() == null) {
			dao.insert(obj);
		}
		else {
			dao.update(obj);
		}
	}
	
	public void remove(Pokemon obj) {
		dao.deleteById(obj.getPokeID());
	}
}
