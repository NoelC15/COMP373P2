package com.comp373.model.pokemon;

public class PokemonImpl implements Pokemon {

	private String type;
	private int level;
	private String name;

	public PokemonImpl() {
	}

	public PokemonImpl(String type, int level, String name) {
		this.type = type;
		this.level = level;
		this.setName(name);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
