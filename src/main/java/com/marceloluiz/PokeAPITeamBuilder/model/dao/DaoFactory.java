package com.marceloluiz.PokeAPITeamBuilder.model.dao;

import com.marceloluiz.PokeAPITeamBuilder.db.DB;
import com.marceloluiz.PokeAPITeamBuilder.model.dao.impl.PokemonDaoJDBC;

public class DaoFactory {
	
	public static PokemonDao createPokemonDao() {
		return new PokemonDaoJDBC(DB.getConnection());
	}

}
