package com.comp373.model.human;

import java.util.List;

import com.comp373.model.pokemon.Pokemon;

public interface Trainer extends Human{

	public int getNumOfBadges();

	public void setNumOfBadges(int numOfBadges);

	public List<Pokemon> getPokemon();

	public void setPokemon(List<Pokemon> pokemon);

	public void scheduleBattle(GymLeader gymLeader);

}
