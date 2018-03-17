package com.comp373.model.human;

import java.util.List;

import com.comp373.model.bankaccount.BankAccount;
import com.comp373.model.facility.Gym;
import com.comp373.model.pokemon.Pokemon;

public class GymLeader extends Human {
	
	private List<Pokemon> pokemon;
	private Gym gym;
	
	public GymLeader() {
		
	}
	
	public GymLeader(String fName, String lName, BankAccount account, int badges, List<Pokemon> pocketMonsters, long id, Gym gym) {
		super(fName, lName, account, id);
		this.setPokemon(pocketMonsters);
		this.setGym(gym);
	}

	public List<Pokemon> getPokemon() {
		return pokemon;
	}

	public void setPokemon(List<Pokemon> pokemon) {
		this.pokemon = pokemon;
	}

	public Gym getGym() {
		return gym;
	}

	public void setGym(Gym gym) {
		this.gym = gym;
	}
	
	public void lostBattle(Trainer trainer) {
		//transfer 2x battle fee to trainer
		this.getAccount().transferFunds((this.getGym().getPriceToBattle() * 2), trainer);
	}
}
