package com.marceloluiz.PokeAPITeamBuilder.models;

public class PokeSprite {
	
	private Sprites sprite;
	private String url;
	
	public PokeSprite() {
	}
	
	public PokeSprite(Sprites sprite, String url) {
		this.sprite = sprite;
		this.url = url;
	}

	public Sprites getSprite() {
		return sprite;
	}

	public void setSprite(Sprites sprite) {
		this.sprite = sprite;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	
	public enum Sprites{
		
		FRONT_DEFAULT,
		FRONT_SHINY,
		BACK_DEFAULT,
		BACK_SHINY,

	}

	@Override
	public String toString() {
		return "PokeSprite [sprite=" + sprite + ", url=" + url + "]";
	}
	
}
