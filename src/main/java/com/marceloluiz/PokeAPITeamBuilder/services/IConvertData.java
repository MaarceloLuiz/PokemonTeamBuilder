package com.marceloluiz.PokeAPITeamBuilder.services;

public interface IConvertData {
	<T> T getData(String json, Class<T> javaClass);
}
