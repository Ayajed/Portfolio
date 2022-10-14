import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Main {

	Random random = new Random();
	Scanner scan = new Scanner(System.in);
	Vector<Pokemon> pokemonVector = new Vector<>();
	
	int enemyHp;
	int enemyAtkPower;
	
	public Main() {
		menu();
	}
	
	public void menu() {
		int input;
		
		do {
			System.out.println("===================");
			System.out.println("Welcome to Pokemon!");
			System.out.println("===================");
			System.out.println("1. Catch Pokemon");
			System.out.println("2. View Pokemon(s)");
			System.out.println("3. Train Pokemon");
			System.out.println("4. Release Pokemon");
			System.out.println("5. Exit");
			System.out.println("===================");
			System.out.print(">> ");
			
			input = scan.nextInt();
			scan.nextLine();
			
			if (input < 1 || input > 5) {
				System.out.println("Number must be between 1 - 5");
				menu();
			} else {
				switch (input) {
				case 1:
					catchPokemon();
					break;
				case 2:
					viewPokemon();
					break;
				case 3:
					trainPokemon();
					break;
				case 4:
					releasePokemon();
					break;
				}
			}
			
		} while (input != 5);
	}
	
	public void catchPokemon() {
		String name;
		int hp;
		int mana;
		int atkPower = 0;
		
		do {
			System.out.print("Input pokemon name [5 - 10 character] >> ");
			name = scan.nextLine();
		} while (name.length() < 5 || name.length() > 10);
		
		hp = random.nextInt(1000 - 100) + 100;
		mana = random.nextInt(100 - 25) + 25;
		
		if (mana <= 50) {
			atkPower = random.nextInt(15 - 10) + 10;
		} else if (mana > 50) {
			atkPower = random.nextInt(7 - 3) + 7;
		}
		
		pokemonVector.add(new Pokemon(name, hp, mana, atkPower));
		
	}
	
	public void viewPokemon() {
		if (pokemonVector.isEmpty()) {
			System.out.println("You have no pokemon");
			menu();
		} else {
			for (int i = 0; i < pokemonVector.size(); i++) {
				Pokemon currentPokemon = pokemonVector.get(i);
				
				System.out.println("#" + (i + 1));
				System.out.println("Name        : " + currentPokemon.getName());
				System.out.println("HP          : " + currentPokemon.getHp());
				System.out.println("Mana        : " + currentPokemon.getMana());
				System.out.println("Attack Power: " + currentPokemon.getAtkPower());
			}
		}
	}
	
	public void trainPokemon() {		
		if (pokemonVector.isEmpty()) {
			System.out.println("You have no pokemon");
		} else {
			int input;
			
			System.out.println("Select enemy difficulty");
			System.out.println("1. Easy");
			System.out.println("2. Medium");
			System.out.println("3. Hard");
			System.out.print(">> ");
				
			input = scan.nextInt();
			scan.nextLine();
			
			if (input < 1 || input > 3) {
				System.out.println("Invalid input");
				menu();
			}
			
			if (input == 1) {
				enemyAtkPower = random.nextInt(3 - 1) + 1;
			} else if (input == 2) {
				enemyAtkPower = random.nextInt(7 - 4) + 4;
			} else if (input == 3) {
				enemyAtkPower = random.nextInt(10 - 5) + 5;
			}
			
			
			System.out.println("=======================");
			System.out.println("You encounter an enemy!");
			
			switch (input) {
			case 1:
				System.out.println("Enemy Difficulty  : Easy");
				break;
			case 2:
				System.out.println("Enemy Difficulty  : Medium");
				break;
			case 3:
				System.out.println("Enemy Difficulty  : Hard");
				break;
			}
			
			System.out.println("Enemy Attack Power: " + enemyAtkPower);
			System.out.println("What's your action?");
			System.out.println("1. Fight");
			System.out.println("2. Run");
			System.out.println("=======================");
			System.out.print(">> ");
			
			input = scan.nextInt();
			scan.nextLine();
			
			if (input < 1 || input > 2) {
				System.out.println("Invalid input");
				menu();
			} else {
				switch (input) {
				case 1:
					fight(enemyAtkPower);
					break;
				case 2:
					System.out.println("You ran like a coward");
					menu();
				}
			}
			
		}
	}
	
	public void fight(int enemyAtkPower) {
		int input;
		System.out.println("Enemy Attack Power: " + enemyAtkPower);
		System.out.println("Select Pokemon to Train: ");
		
		for (int i = 0; i < pokemonVector.size(); i++) {
			Pokemon currentPokemon = pokemonVector.get(i);
			System.out.println((i + 1) + ". " + currentPokemon.getName());
		}
	
		System.out.print(">> ");
		input = scan.nextInt();
		scan.nextLine();
		
		if (input < 0 || input > pokemonVector.size()) {
			System.out.println("Invalid input");
			fight(enemyAtkPower);
		} else {
			Pokemon chosenPokemon = pokemonVector.get(input-1);
			
			int hp = chosenPokemon.getHp();
			int mana = chosenPokemon.getMana();
			
			chosenPokemon.setHp(hp - enemyAtkPower);
			chosenPokemon.setMana(mana - 2);
			
			System.out.println("Successfully trained " + chosenPokemon.getName());
			System.out.println("Training Result:");
			System.out.println("Name: " + chosenPokemon.getName());
			System.out.println("HP  : " + chosenPokemon.getHp());
			System.out.println("Mana: " + chosenPokemon.getMana());
		}
	}
	
	public void releasePokemon() {
		int input;
		
		if (pokemonVector.isEmpty()) {
			System.out.println("There is no pokemon");
			menu();
		} else {
			viewPokemon();
			System.out.print("Select which pokemon you want to release [pokemon number]: ");
			
			input = scan.nextInt();
			scan.nextLine();
			
			if (input < 0 || input > pokemonVector.size()) {
				System.out.println("Invalid input");
				menu();
			} else {
				pokemonVector.remove(input-1);
			}
		}
	}

	public static void main(String[] args) {
		new Main();
	}

}
