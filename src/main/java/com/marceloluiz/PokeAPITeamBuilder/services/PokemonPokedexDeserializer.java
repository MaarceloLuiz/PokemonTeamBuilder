package com.marceloluiz.PokeAPITeamBuilder.services;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.marceloluiz.PokeAPITeamBuilder.models.PokeData;
import com.marceloluiz.PokeAPITeamBuilder.models.PokeSprite;
import com.marceloluiz.PokeAPITeamBuilder.models.PokeSprite.Sprites;
import com.marceloluiz.PokeAPITeamBuilder.models.PokeStats;
import com.marceloluiz.PokeAPITeamBuilder.models.enums.PokeType;

public class PokemonPokedexDeserializer {
	private String baseJson;
	private ObjectMapper mapper;
	private JsonNode jsonNode;
	private APIConsumption apiConsumption;
	
	private String[] getPokemonUrl() {
		baseJson = apiConsumption.gettingData("https://pokeapi.co/api/v2/pokemon?limit=3&offset=0");
		mapper = new ObjectMapper();
		
		try {
			
			jsonNode = mapper.readTree(baseJson);
			JsonNode urlArray = jsonNode.get("results");
			
			String[] pokeUrl = new String[urlArray.size()];
			
			for(int i = 0; i < urlArray.size(); i++) {
				JsonNode url = urlArray.get(i);
				pokeUrl[i] = url.get("url").asText();
			}
			
			return pokeUrl;
				
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	private List<PokeData> getBaseData() {
		apiConsumption = new APIConsumption();
		
		var json = "";
		ConvertData convert;
		PokeData data;
		
		List<PokeData> urlList = new ArrayList<>();
		
		for(String url : getPokemonUrl()) {
			json = apiConsumption.gettingData(url);
			
			convert = new ConvertData();
			data = convert.getData(json, PokeData.class);
			
			urlList.add(data);
		}
		
		return urlList;
	}
	
	public List<PokeType> getTypes() {
		List<Integer> type = new ArrayList<>();
		
		for(PokeData baseData : getBaseData()) {
			String typeList = baseData.getTypeList().toString();
			
			boolean found;
			String find = "";
			for(int i = 1; i <= PokeType.values().length; i++) {
				find = "/type/" + i + "/";
				found = typeList.contains(find);
				
				if(found == true) {
					type.add(i);
				}
				
			}
			
		}
		List<PokeType> pokeType = new ArrayList<>();
		
		for(Integer convertedType : type) {
			pokeType.add(PokeType.getById(convertedType));
		}
		 
		return pokeType;
	}
	
	public List<PokeStats> getStats() {
		var json = "";
		apiConsumption = new APIConsumption();
		mapper = new ObjectMapper();
		List<PokeStats> pokeStats = new ArrayList<>();	
		
		try {
			
			for(String url : getPokemonUrl()) {
				json = apiConsumption.gettingData(url);			
				jsonNode = mapper.readTree(json);
				JsonNode statsArray = jsonNode.get("stats");
				
				for(int i = 0; i < statsArray.size(); i++) {
					JsonNode stat = statsArray.get(i);
					pokeStats.add(new PokeStats(PokeStats.Stats.getById(i+1),
							stat.get("base_stat").asInt()));
				}					
			}	
			
			return pokeStats;
			
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<PokeSprite> getSprites() {
		var json = "";
		apiConsumption = new APIConsumption();
		mapper = new ObjectMapper();
		List<PokeSprite> pokeSprites = new ArrayList<>();	
		
		try {
			for(String url : getPokemonUrl()) {
				json = apiConsumption.gettingData(url);		
				
				jsonNode = mapper.readTree(json);
				JsonNode spritesObject = jsonNode.get("sprites");
				
				for(int i = 0; i < PokeSprite.Sprites.values().length; i++) {
					PokeSprite.Sprites typeSprites = Sprites.values()[i];
					JsonNode urlNode = spritesObject.get(typeSprites.name().toLowerCase());
					pokeSprites.add(new PokeSprite(typeSprites, urlNode.isNull() ? null : urlNode.toString()));
					
				}
			}	
			
			return pokeSprites;
			
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
