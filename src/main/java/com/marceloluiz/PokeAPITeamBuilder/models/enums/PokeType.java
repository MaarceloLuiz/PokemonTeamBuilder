package com.marceloluiz.PokeAPITeamBuilder.models.enums;

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
    SHADOW(10002),
    NONE(99999);
	
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
	
    public PokeType[] weak,strong, noEffect;
    
    static{
    	//Normal
    	NORMAL.weak = new PokeType[]{FIGHTING};
    	NORMAL.strong = new PokeType[]{};
    	NORMAL.noEffect = new PokeType[]{GHOST};
    	//Grass
    	GRASS.weak = new PokeType[]{FLYING, POISON, BUG, FIRE, ICE};
    	GRASS.strong = new PokeType[]{GROUND, WATER, GRASS, ELECTRIC};
    	GRASS.noEffect = new PokeType[]{};
    	//Electric
    	ELECTRIC.weak = new PokeType[]{GROUND};
    	ELECTRIC.strong = new PokeType[]{FLYING, STEEL, ELECTRIC};
    	ELECTRIC.noEffect = new PokeType[]{};
    	//Water
    	WATER.weak = new PokeType[]{GRASS, ELECTRIC};
    	WATER.strong = new PokeType[]{STEEL, FIRE, WATER, ICE};
    	WATER.noEffect = new PokeType[]{};
    	//Fire
    	FIRE.weak = new PokeType[]{GROUND, ROCK, WATER};
    	FIRE.strong = new PokeType[]{BUG, STEEL, FIRE, GRASS, ICE, FAIRY};
    	FIRE.noEffect = new PokeType[]{};
    	//Bug
    	BUG.weak = new PokeType[]{FLYING, ROCK, FIRE};
    	BUG.strong = new PokeType[]{FIGHTING, GROUND, GRASS};
    	BUG.noEffect = new PokeType[]{};
    	//Ghost
    	GHOST.weak = new PokeType[]{GHOST, DARK};
    	GHOST.strong = new PokeType[]{POISON, BUG};
    	GHOST.noEffect = new PokeType[]{NORMAL, FIGHTING};
    	//Psychic
    	PSYCHIC.weak = new PokeType[]{BUG, GHOST, DARK};
    	PSYCHIC.strong = new PokeType[]{FIGHTING, PSYCHIC};
    	PSYCHIC.noEffect = new PokeType[]{};
    	//Steel
    	STEEL.weak = new PokeType[]{FIGHTING, GROUND, FIRE};
    	STEEL.strong = new PokeType[]{NORMAL, FLYING, ROCK, BUG, STEEL, GRASS, PSYCHIC, ICE, DRAGON, FAIRY};
    	STEEL.noEffect = new PokeType[]{POISON};
    	//Dark
    	DARK.weak = new PokeType[]{FIGHTING, BUG, FAIRY};
    	DARK.strong = new PokeType[]{GHOST, DARK};
    	DARK.noEffect = new PokeType[]{PSYCHIC};
    	//Flying
    	FLYING.weak = new PokeType[]{ROCK, ELECTRIC, ICE};
    	FLYING.strong = new PokeType[]{FIGHTING, BUG, GRASS};
    	FLYING.noEffect = new PokeType[]{GROUND};
    	//Ice
    	ICE.weak = new PokeType[]{FIGHTING, ROCK, STEEL, FIRE};
    	ICE.strong = new PokeType[]{ICE};
    	ICE.noEffect = new PokeType[]{};
    	//Poison
    	POISON.weak = new PokeType[]{GROUND, PSYCHIC};
    	POISON.strong = new PokeType[]{FIGHTING, POISON, GRASS, FAIRY};
    	POISON.noEffect = new PokeType[]{};
    	//Ground
    	GROUND.weak = new PokeType[]{WATER, GRASS, ICE};
    	GROUND.strong = new PokeType[]{POISON, ROCK};
    	GROUND.noEffect = new PokeType[]{ELECTRIC};
    	//Rock
    	ROCK.weak = new PokeType[]{FIGHTING, GROUND, STEEL, WATER, GRASS};
    	ROCK.strong = new PokeType[]{NORMAL, FLYING, POISON, FIRE};
    	ROCK.noEffect = new PokeType[]{};
    	//Dragon
    	DRAGON.weak = new PokeType[]{ICE, DRAGON, FAIRY};
    	DRAGON.strong = new PokeType[]{FIRE, WATER, GRASS, ELECTRIC};
    	DRAGON.noEffect = new PokeType[]{};
    	//Fighting
    	FIGHTING.weak = new PokeType[]{FLYING, PSYCHIC, FAIRY};
    	FIGHTING.strong = new PokeType[]{ROCK, BUG, DARK};
    	FIGHTING.noEffect = new PokeType[]{};
    	//Fairy
    	FAIRY.weak = new PokeType[]{POISON, STEEL};
    	FAIRY.strong = new PokeType[]{FIGHTING, BUG, DARK};
    	FAIRY.noEffect = new PokeType[]{DRAGON};
    	//None to avoid null reference errors
    	NONE.weak = new PokeType[]{};
    	NONE.strong = new PokeType[]{};
    	NONE.noEffect = new PokeType[]{};
    }
    
}