package com.marceloluiz.PokeAPITeamBuilder.enums;

public class PokeStats {
	
    private Stats type;
    private int baseStat;

    public PokeStats() {
    }
    
    public PokeStats(Stats type, int baseStat) {
		this.type = type;
		this.baseStat = baseStat;
	}
    

	public Stats getType() {
		return type;
	}

	public void setType(Stats type) {
		this.type = type;
	}


	public int getBaseStat() {
		return baseStat;
	}

	public void setBaseStat(int baseStat) {
		this.baseStat = baseStat;
	}

	public enum Stats {

        HP(1),
        ATTACK(2),
        DEFENSE(3),
        SPECIAL_ATTACK(4),
        SPECIAL_DEFENSE(5),
        SPEED(6),
        ACCURACY(7),
        EVASION(8);

        private int id;

		private Stats(int id) {
			this.id = id;
		}

		public int getId() {
			return id;
		}
		
		public static Stats getById(Integer id) {
			for(Stats e : Stats.values()) {
				if(e.id == id) return e;
			}
			throw new IllegalArgumentException();
		}
        
    }

	@Override
	public String toString() {
		return "PokeStats [type=" + type + ", baseStat=" + baseStat + "]";
	}
	
}
