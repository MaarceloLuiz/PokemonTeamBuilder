package com.marceloluiz.PokeAPITeamBuilder.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokeData {
//	@JsonAlias("id") int id, 
//	@JsonAlias("name") String name,  
//	@JsonProperty("types") List<Object> typeList, 
//	@JsonAlias("stats") List<Object> statsList, 
//	@JsonAlias("front_female") String imageURL
	
	private int id;
	private String name;
	private List<Object> typeList;
	private List<Object> statsList;
	private String imageURL;
	
	public PokeData() {
	}
	
	public PokeData(int id, String name, List<Object> typeList, List<Object> statsList, String imageURL) {
		this.id = id;
		this.name = name;
		this.typeList = typeList;
		this.statsList = statsList;
		this.imageURL = imageURL;
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


	@JsonAlias("stats")
	public List<Object> getStatsList() {
		return statsList;
	}

	//@JsonAlias("front_female")
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	

	@Override
	public String toString() {
		return "PokeData [id=" + id + ", name=" + name + ", typeList=" + typeList + ", statsList=" + statsList
				+ ", imageURL=" + imageURL + "]";
	}
}
