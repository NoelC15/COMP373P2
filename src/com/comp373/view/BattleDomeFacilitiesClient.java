package com.comp373.view;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.comp373.model.bankaccount.BankAccount;
import com.comp373.model.building.BattleDome;
import com.comp373.model.facility.Gym;
import com.comp373.model.human.GymLeader;
import com.comp373.model.human.Human;
import com.comp373.model.human.Manager;
import com.comp373.model.human.Trainer;
import com.comp373.model.pokemon.Pokemon;

public class BattleDomeFacilitiesClient {

	private static List<Pokemon> team;
	private static List<Pokemon> gymPokemon;

	public static void setGymPokemon(List<Pokemon> gymPokemon) {
		BattleDomeFacilitiesClient.gymPokemon = gymPokemon;
	}

	public static void setTeam(List<Pokemon> team) {
		BattleDomeFacilitiesClient.team = team;
	}

	public static void main(String args[]) throws Exception {

		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/app-context.xml");
		System.out.println("***************** Application Context instantiated! ******************");

		// TODO should be fixed; method defined in human are not visible in
		// manager
		Human manager = (Manager) context.getBean("manager");
		manager.setFirstName("John");
		manager.setLastName("Smith");
		manager.setHumanId(456789054);

		System.out.println("\tManager: \t\t" + manager.getFirstName() + " " + manager.getLastName() + "\n");
		System.out.println("\tManager ID: \t\t" + manager.getHumanId() + "\n");

		// Make manager bank account
		BankAccount mangBankAccount = manager.getAccount();
		
		mangBankAccount.setTotalFunds(1500.67);
		manager.setAccount(mangBankAccount);
		System.out.println("\tManager's Bank Account funds:\t" + manager.getAccount().getTotalFunds() + "\n");
		System.out.println("\t" + manager.getFirstName() + "'s Bank Account number (random generation):\t"
				+ manager.getAccount().getAccountNumber() + "\n");

		// Create a BattleDome
		BattleDome redVersion = (BattleDome) context.getBean("battleDome");
		redVersion.setBuildingId("BattleDome01");
		
		// Assign it to the manager
		// TODO can this line be written without casting
		((Manager) manager).setBattleDome(redVersion);

		// TODO should be fixed; method defined in human are not visible in
		// trainer
		// Create a trainer
		Human trainer = (Trainer) context.getBean("trainer");
		trainer.setFirstName("Ash");
		trainer.setLastName("Ketchum");
		trainer.setHumanId(12345678);
		// TODO can this line be written without casting
		((Trainer) trainer).setNumOfBadges(2);

		System.out.println("\tTrainer: \t\t" + trainer.getFirstName() + " " + trainer.getLastName() + "\n");
		System.out.println("\tTrainer ID: \t\t" + trainer.getHumanId() + "\n");
		System.out.println("\t" + trainer.getFirstName() + " has " + ((Trainer) trainer).getNumOfBadges() + " badges");

		// Make trainer bank account
		BankAccount trainerAccount = trainer.getAccount();
		trainerAccount.setTotalFunds(600.45);
		trainer.setAccount(trainerAccount);
		System.out.println("\tTrainers's Bank Account funds:\t" + trainer.getAccount().getTotalFunds() + "\n");
		System.out.println("\t" + trainer.getFirstName() + "'s Bank Account number (random generation):\t"
				+ trainer.getAccount().getAccountNumber() + "\n");

		// Make Pokemon for Ash
		// how to use getBean with object created with constructor parameters
		Pokemon pikachu = (Pokemon) context.getBean("pokemon");
		pikachu.setType("electric");
		pikachu.setLevel(6);
		pikachu.setName("Pikachu");
		Pokemon squirtle = (Pokemon) context.getBean("pokemon");
		squirtle.setType("water");
		squirtle.setLevel(7);
		squirtle.setName("Squirtle");
		Pokemon charmander = (Pokemon) context.getBean("pokemon");
		charmander.setType("fire");
		charmander.setLevel(8);
		charmander.setName("Charmander");

		team.add(pikachu);
		team.add(squirtle);
		team.add(charmander);

		((Trainer) trainer).setPokemon(team);

		System.out.println("\t" + trainer.getFirstName() + "'s Pokemon:");
		int numOfPokemon = team.size();
		for (int i = 0; i < numOfPokemon; i++) {
			// TODO can this line be written without casting
			System.out.println("\t\t" + ((Trainer) trainer).getPokemon().get(i).getName());
		}

		// Create a gym leader
		GymLeader leader = (GymLeader) context.getBean("gymLeader");
		leader.setFirstName("Brock");
		leader.setLastName("The Rock");
		leader.setHumanId(3456789);
		System.out.println("\tGym Leader: \t" + leader.getFirstName() + " " + leader.getLastName() + "\n");
		System.out.println("\tLeader ID: \t" + leader.getHumanId() + "\n");

		// Make BankAccount for gym leader
		BankAccount gymAccount = leader.getAccount(); 

		gymAccount.setTotalFunds(897.06);
		leader.setAccount(gymAccount);
		System.out.println(
				"\t" + leader.getFirstName() + "'s Bank Account funds:\t" + leader.getAccount().getTotalFunds() + "\n");
		System.out.println("\t" + leader.getFirstName() + "'s Bank Account number (random generation):\t"
				+ leader.getAccount().getAccountNumber() + "\n");

		// Make Pokemon for Brock
		Pokemon geodude = (Pokemon) context.getBean("pokemon");
		geodude.setType("ground");
		geodude.setLevel(6);
		geodude.setName("Geodude");

		Pokemon onyx = (Pokemon) context.getBean("pokemon");
		onyx.setType("ground");
		onyx.setLevel(7);
		onyx.setName("Onyx");

		Pokemon zubat = (Pokemon) context.getBean("pokemon");
		zubat.setType("poison");
		zubat.setLevel(8);
		zubat.setName("Zubat");

		gymPokemon.add(geodude);
		gymPokemon.add(onyx);
		gymPokemon.add(zubat);

		leader.setPokemon(gymPokemon);

		System.out.println("\t" + leader.getFirstName() + "'s Pokemon:");
		int numOfGymPokemon = gymPokemon.size();
		for (int i = 0; i < numOfGymPokemon; i++) {
			System.out.println("\t\t" + leader.getPokemon().get(i).getName());
		}

		// Make a gym
		Gym pewterCity = (Gym) context.getBean("gym");
		// TODO can this line be written without casting
		((Manager) manager).getBattleDome().addNewFacility(pewterCity); // add gym to battledome
		leader.setGym(pewterCity); // assign gym to leader
		pewterCity.setCapacity(400);
		pewterCity.setOpenDate(1997, 1, 1);
		pewterCity.setPriceToBattle(15.50);
		pewterCity.setGymName("Pewter City Gym");
		pewterCity.addGymDetail("A rock type gym with " + leader.getFirstName() + " as acting gym leader.");

		System.out.println("\t" + pewterCity.getGymName() + "'s capacity is " + pewterCity.requestAvailableCapacity()
				+ " and it costs $" + pewterCity.getPriceToBattle() + " to battle\n");
		System.out.println("\t" + pewterCity.getGymName() + " opened on " + pewterCity.getOpenDate() + "\n");

		// Schedule a battle
		// TODO can this line be written without casting
		((Trainer) trainer).scheduleBattle(leader); // schedule battle with gym leader
		System.out.println("\tIs " + pewterCity.getGymName() + " in use now?: " + pewterCity.getGymState());
		System.out.println("\tGym leader " + leader.getFirstName() + " is paid a fee of $"
				+ leader.getGym().getPriceToBattle() + " by " + trainer.getFirstName() + " to battle." + "\n");
		System.out.println(
				"\t" + leader.getFirstName() + "'s new bank balance is " + leader.getAccount().getTotalFunds());
		System.out.println("\t" + trainer.getFirstName() + "'s new bank balance is "
				+ trainer.getAccount().getTotalFunds() + "\n");

		// Brock lost.
		// TODO can this line be written without casting
		leader.lostBattle((Trainer) trainer);
		System.out.println("\t" + leader.getFirstName() + " lost the battle and therefore paid out $"
				+ (leader.getGym().getPriceToBattle() * 2) + " to " + trainer.getFirstName() + "\n");
		System.out.println(
				"\t" + leader.getFirstName() + "'s new bank balance is " + leader.getAccount().getTotalFunds());
		System.out.println("\t" + trainer.getFirstName() + "'s new bank balance is "
				+ trainer.getAccount().getTotalFunds() + "\n");
		// Empty gym
		pewterCity.getGymUses().vacateFacility(pewterCity);
		System.out.println("\tIs " + pewterCity.getGymName() + " in use now?: " + pewterCity.getGymState());

		// Have damage occur & request maintenance, set to maint status
		String[] damageTypes = { "electrical", "structural" };
		pewterCity.getGymMaint().makeFacilityMaintRequest(damageTypes, "Lights burnt out and columns cracked", 2,
				pewterCity);
		System.out.println(
				"\t" + pewterCity.getGymName() + " has had maintenance scheduled on " + pewterCity.listGymProblems());
		System.out.println("\t" + pewterCity.getGymName() + " is currently " + pewterCity.getGymState());
		// Print out cost of maintenance
		System.out.println("\t" + pewterCity.getGymName() + "'s damage costs totaled $"
				+ pewterCity.getGymMaint().calcMaintenanceCostForFacility(pewterCity.listMaintenance()));
		System.out.println("\t" + pewterCity.getGymName() + "'s total downtime due to the last battle was "
				+ pewterCity.getGymMaint().calcDownTimeForFacilitiy(pewterCity.listMaintenance()) + " days.");
		// Let's pretend we were having a great day and the maintenance was
		// already
		// done even though I requested it for 2 days from now....
		pewterCity.listMaintenance().resolveMaintIssue(pewterCity);
		System.out.println("\tMaintenance has been done, " + pewterCity.getGymName() + " is currently "
				+ pewterCity.getGymState());
	}
}
