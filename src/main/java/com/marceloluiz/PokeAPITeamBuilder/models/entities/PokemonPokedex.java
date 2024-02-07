package com.marceloluiz.PokeAPITeamBuilder.models.entities;

import java.util.List;

import com.marceloluiz.PokeAPITeamBuilder.models.PokeStats;
import com.marceloluiz.PokeAPITeamBuilder.models.enums.PokeType;

public class PokemonPokedex {
	
    private int id; //number label
    private String name;
    private String image;
    private List<PokeType> pokeType;
    private List<PokeStats> stats;
    private List<String> weaknesses;
    private int generation;
    private String shiny;
    private String height;
    private String weight;
    
    public PokemonPokedex() {
    }

	public PokemonPokedex(int id, String name, String image, List<PokeType> pokeType, List<PokeStats> stats,
			List<String> weaknesses, int generation, String shiny, String height, String weight) {
		this.id = id;
		this.name = name;
		this.image = image;
		this.pokeType = pokeType;
		this.stats = stats;
		this.weaknesses = weaknesses;
		this.generation = generation;
		this.shiny = shiny;
		this.height = height;
		this.weight = weight;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<PokeType> getPokeType() {
		return pokeType;
	}

	public List<PokeStats> getStats() {
		return stats;
	}

	public List<String> getWeaknesses() {
		return weaknesses;
	}

	public int getGeneration() {
		return generation;
	}

	public void setGeneration(int generation) {
		this.generation = generation;
	}

	public String getShiny() {
		return shiny;
	}

	public void setShiny(String shiny) {
		this.shiny = shiny;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "PokemonPokedex [id=" + id
				+ ", name=" + name
				+ ", image=" + image
				+ ", pokeType=" + pokeType
				+ ", stats=" + stats
				+ ", weaknesses=" + weaknesses
				+ ", generation=" + generation
				+ ", shiny=" + shiny
				+ ", height=" + height
				+ ", weight=" + weight + "]";
	}  
}
