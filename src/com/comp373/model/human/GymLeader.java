package com.comp373.model.human;

import java.util.List;

import com.comp373.model.facility.Gym;
import com.comp373.model.pokemon.Pokemon;


public interface GymLeader extends Human {

	public void setPokemon(List<Pokemon> pokemon) ;

	public Gym getGym() ;

	public void setGym(Gym gym);

	public void lostBattle(Trainer trainer) ;

}
