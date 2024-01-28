package com.marceloluiz.PokeAPITeamBuilder.models;

import java.io.InputStream;

import com.fasterxml.jackson.annotation.JsonAlias;

public record PokeData(@JsonAlias("id") int id, 
					@JsonAlias("name") String name, 
					@JsonAlias("types") String types,
					@JsonAlias("stats") String stats,
					@JsonAlias("front_default") InputStream sprite) {
//stats = HP / DEF / SPD
//InputStream = image
}
