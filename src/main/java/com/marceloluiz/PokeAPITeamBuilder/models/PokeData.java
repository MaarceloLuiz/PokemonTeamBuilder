package com.marceloluiz.PokeAPITeamBuilder.models;

import java.util.List;
import java.util.Map;

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
	private String type;
	private List<Object> statsList;
	private String imageURL;
	
	public PokeData() {
	}
	
	public PokeData(int id, String name, String type, List<Object> statsList, String imageURL) {
		this.id = id;
		this.name = name;
		this.type = type;
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
	
	//@JsonAlias("types")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
	
	
	@JsonAlias("types")
	private void unpackTypeFromNestedObject(Map<String, Object> type) {
		this.type = (String) type.get("type");
	}

	@Override
	public String toString() {
		return "PokeData [id=" + id + ", name=" + name + ", type=" + type + ", statsList=" + statsList
				+ ", imageURL=" + imageURL + "]";
	}
}
