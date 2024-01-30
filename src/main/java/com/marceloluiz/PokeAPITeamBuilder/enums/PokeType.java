package com.marceloluiz.PokeAPITeamBuilder.enums;

public enum PokeType {
	
	NORMAL(1),
    FIGHTING(2),
    FLYING(3),
    POISON(4),
    GROUND(5),
    ROCK(6),
    BUG(7),
    GHOST(8),
    STEEL(9),
    FIRE(10),
    WATER(11),
    GRASS(12),
    ELECTRIC(13),
    PSYCHIC(14),
    ICE(15),
    DRAGON(16),
    DARK(17),
    FAIRY(18),
    UNKNOWN(10001),
    SHADOW(10002);
	
	private int id;

    private PokeType(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public static PokeType getById(Integer id) {
		for(PokeType e : PokeType.values()) {
			if(e.id == id) return e;
		}
		throw new IllegalArgumentException();
	}
}