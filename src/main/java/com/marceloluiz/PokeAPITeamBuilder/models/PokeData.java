package com.marceloluiz.PokeAPITeamBuilder.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokeData {
	
	private int id;
	private String name;
	private List<Object> typeList;
	
	public PokeData() {
	}
	
	public PokeData(int id, String name, List<Object> typeList, List<Object> statsList, String imageURL) {
		this.id = id;
		this.name = name;
		this.typeList = typeList;
	}

	@JsonAlias("id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@JsonAlias("name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@JsonAlias("types")
	public List<Object> getTypeList() {
		return typeList;
	}
	
	@Override
	public String toString() {
		return "PokeData [id=" + id + ", name=" + name + ", typeList=" + typeList + "]";
	}

}
