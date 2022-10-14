import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Main {

	int numberOfMiner = 0;
	int numberOfFisher = 0;
	int playerMoney = 300;
	int playerOre = 0;
	int playerFish = 0;
	Scanner scan = new Scanner(System.in);
	Vector<Worker> workerVector = new Vector<>();
	
	public Main() {
		menu();
	}
	
	public void menu() {
		int input;
		
		do {
			System.out.println("Welcome to JobGame");
			System.out.println("1. View worker");
			System.out.println("2. Order worker");
			System.out.println("3. Hire worker");
			System.out.println("4. Fire Worker");
			System.out.println("5. Sell item");
			System.out.println("6. Exit");
			System.out.print("Choose [1 - 6] >> ");
			
			input = scan.nextInt();
			scan.nextLine();
			
			if (input < 1 || input > 6) {
				System.out.println("Input has to be between 1-6");
				menu();
			} else {
				switch (input) {
				case 1:
					viewWorker();
					break;
				case 2:
					orderWorker();
					break;
				case 3:
					hireWorker();
					break;
				case 4:
					fireWorker();
					break;
				case 5:
					sellItem();
					break;
				}
			}
		} while (input != 6);
		
	}
	
	public void viewWorker() {
		if (workerVector.isEmpty()) {
			System.out.println("There is no worker!");
		} else {
			System.out.println("List of worker");
			
			for (int i = 0; i < workerVector.size(); i++) {
				Worker currentWorker = workerVector.get(i);
				System.out.println("ID = " + currentWorker.getId());
				System.out.println("Name = " + currentWorker.getName());
				System.out.println("Job = " + currentWorker.getJob());
			}
		}
	}
	
	public void orderWorker() {
		if (workerVector.isEmpty()) {
			System.out.println("There is no worker!");
		} else {
			int input;
			int minerCost = 75 * numberOfMiner;
			int fisherCost = 50 * numberOfFisher;
			
			System.out.println("Status: ");
			System.out.println("==========================");
			System.out.println("Your money: $" + playerMoney);
			System.out.println("Miner  : " + numberOfMiner);
			System.out.println("Fisher : " + numberOfFisher);
			System.out.println("Ore    : " + playerOre);
			System.out.println("Fish   : " + playerFish);
			System.out.println("==========================");
			
			if (numberOfMiner == 0) {
				System.out.println("1. Order Miner ( cost : $0 )");
			} else {
				System.out.println("1. Order Miner ( cost : $" + minerCost +  " )");
			}
			
			if (numberOfFisher == 0) {
				System.out.println("2. Order Fisher ( cost : $0 )");
			} else {
				System.out.println("2. Order Fisher ( cost : $" + fisherCost +  " )");
			}
			
			System.out.println("3. Exit");
			System.out.print("Choose [1 - 3] >> ");
				
			input = scan.nextInt();
			scan.nextLine();
			
			if (input < 1 || input > 3) {
				System.out.println("Input has to be between 1 - 3");
			} else if (input == 1){
				if (numberOfMiner == 0) {
					System.out.println("You don't have any miner");
				} else {
					Miner job = null;
					((Miner)job).doJob(playerMoney, minerCost, playerOre, numberOfMiner);
					orderWorker();
				}
			} else if (input == 2) {
				if (numberOfFisher == 0) {
					System.out.println("You don't have any fisher");
				} else {
					Fisher job = null;
					((Fisher)job).doJob(playerMoney, fisherCost, playerFish, numberOfFisher);
					orderWorker();
				}
			} else if (input == 3) {
				menu();
			}
		}
	}
	
	public void hireWorker() {
		String name;
		String job;
		String id = "EP";
		int x;
		
		do {
			System.out.print("Input worker name [3..15] >> ");
			name = scan.nextLine();
		} while (name.length() < 3 || name.length() > 15);
		
		do {
			System.out.print("Input worker job [ Miner | Fisher ] (case sensitive) >> ");
			job = scan.nextLine();
		} while (!job.equals("Miner") && !job.equals("Fisher"));
		
		Random random = new Random();
		for (int i = 0; i < 3; i++) {
			x = random.nextInt(9);
			id += String.valueOf(x);
		}
	
		if (job.equals("Miner")) {
			numberOfMiner++;
			workerVector.add(new Miner(id, name, job));
		} else if (job.equals("Fisher")) {
			numberOfFisher++;
			workerVector.add(new Fisher(id, name, job));
		}
		
		System.out.println("Successfully hired worker!");
	}

	public void fireWorker() {
		String input;
		int x = 0;
		
		if (workerVector.isEmpty()) {
			viewWorker();
		} else {
			viewWorker();
			System.out.print("Input worker ID [ type '0' to back to Main Menu] >> ");
			input = scan.nextLine();
			
			for (int i = 0; i < workerVector.size(); i++) {
				Worker currentWorker = workerVector.get(i);
				if (input.equals(currentWorker.getId())) {
					workerVector.remove(i);
					System.out.println("Successfully fired worker");
				} else if (!input.equals(currentWorker.getId())) {
					x++;
				} else if (input.equals("0")) {
					menu();
				}
			}
			
			if (x > workerVector.size()) {
				System.out.println("Worker ID not found!");
			}
		}
		
	}
	
	public void sellItem() {
		int input;
		Worker sell = null;
		
		System.out.println("Status: ");
		System.out.println("==========================");
		System.out.println("Your money: $" + playerMoney);
		System.out.println("Ore    : " + playerOre);
		System.out.println("Fish   : " + playerFish);
		System.out.println("==========================");
		System.out.println("1. Sell All Ore ($50 for each ore)");
		System.out.println("2. Sell All Fish ($25 for each fish)");
		System.out.println("3. Back to the Main Menu");
		System.out.print("Choose [1 - 3] >> ");
		
		input = scan.nextInt();
		scan.nextLine();
		
		if (input < 1 || input > 3) {
			System.out.println("Input has to be between 1 - 3");
		} else if (input == 1) {
			((Miner)sell).sellItem(playerMoney, playerOre);
		} else if (input == 2) {
			((Fisher)sell).sellItem(playerMoney, playerFish);
		} else if (input == 3) {
			menu();
		}
	}
	
	public static void main(String[] args) {
		new Main();

	}

}
