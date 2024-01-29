package com.marceloluiz.PokeAPITeamBuilder.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertData implements IConvertData{
	private ObjectMapper mapper = new ObjectMapper();

	@Override
	public <T> T getData(String json, Class<T> javaClass) {
		try {
			
			return mapper.readValue(json, javaClass);
			
		} catch (JsonMappingException e) {
			throw new RuntimeException(e);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}
	
	 
}
