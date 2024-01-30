package com.marceloluiz.PokeAPITeamBuilder.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PokeDataType(@JsonAlias("name") String typeList) {

}
