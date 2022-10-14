import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Main {

	Vector<Dress> dressVector = new Vector<>();
	Scanner scan = new Scanner(System.in);
	
	public Main() {
		menu();
	}
	
	public void menu() {
		int input;
		
		do {
			System.out.println("The Executip");
			System.out.println("===================");
			System.out.println("1. Insert new dress");
			System.out.println("2. View all dress");
			System.out.println("3. Delete a dress");
			System.out.println("4. Exit");
			System.out.print(">> ");
			
			input = scan.nextInt();
			scan.nextLine();
			
			if (input < 1 || input > 4) {
				System.out.println("Input has to be between 1 - 4!");
				menu();
			} else {
				switch (input) {
				case 1:
					insertDress();
					break;
				case 2:
					viewDress();
					break;
				case 3:
					deleteDress();
					break;
				}
			}
		} while (input != 4);
	}
	
	public void insertDress() {
		int input;
		
		System.out.println("Pick which type of dress to insert:");
		System.out.println("1. Regular Dress");
		System.out.println("2. Limited Edition Dress");
		System.out.println("3. Back");
		System.out.print(">> ");
			
		input = scan.nextInt();
		scan.nextLine();
		
		if (input < 1 || input > 3) {
			System.out.println("Input has to be between 1 - 3!");
			insertDress();
		}
		
		switch (input) {
		case 1:
			insertDressDetail(input);
			break;
		case 2:
			insertDressDetail(input);
			break;
		case 3:
			menu();
			break;
		}
	}
	
	public void insertDressDetail(int input) {
		
		String name;
		Integer fabricPrice;
		String fabricType;
		Integer discount;
		Integer stock;
	
		do {
			System.out.print("Input dress name [5 - 20 characters]: ");
			name = scan.nextLine();
		} while (name.length() < 5 || name.length() > 20);
		
		if (input == 1) {
			do {
				System.out.print("Input fabric price [Rp. 10000 - 100000]: Rp. ");
				fabricPrice = scan.nextInt();
				scan.nextLine();
			} while (fabricPrice < 10000 || fabricPrice > 100000);
			
			do {
				System.out.print("Input fabric type [Cotton | Wool] (case sensitive): ");
				fabricType = scan.nextLine();
			} while (!fabricType.equals("Cotton") && !fabricType.equals("Wool"));
			
			do {
				System.out.print("Input discount for this dress [1..100]: ");
				discount = scan.nextInt();
				scan.nextLine();
			} while (discount < 1 || discount > 100);
			
			String id = "RE";
			int number;
			Random random = new Random();
			
			for (int i = 0; i < 3; i++) {
				number = random.nextInt(9);
				id = id + String.valueOf(number);
			}
			
			dressVector.add(new Regular(id, name, fabricPrice, fabricType, discount));
			
			System.out.println("Successfully added a new Regular Dress!");
		} else if (input == 2) {
			do {
				System.out.print("Input fabric price [Rp. 100000 - 300000]: Rp. ");
				fabricPrice = scan.nextInt();
				scan.nextLine();
			} while (fabricPrice < 100000 || fabricPrice > 300000);
			
			do {
				System.out.print("Input fabric type [Satin | Chiffon | Crepe] (case sensitive): ");
				fabricType = scan.nextLine();
			} while (!fabricType.equals("Satin") && !fabricType.equals("Chiffon") && 
					!fabricType.equals("Crepe"));
			
			do {
				System.out.print("Input stock for this dress [1..10]: ");
				stock = scan.nextInt();
				scan.nextLine();
			} while (stock < 1 || stock > 10);
			
			String id = "LI";
			Random random = new Random();
			int number;
			
			for (int i = 0; i < 3; i++) {
				number = random.nextInt(9);
				id = id + String.valueOf(number);
			}
			
			dressVector.add(new Limited(id, name, fabricPrice, fabricType, stock));
			
			System.out.println("Successfully added a new Limited Edition Dress!");
		}
	}
	
	public void viewDress() {
		if (dressVector.isEmpty()) {
			System.out.println("No dresses available");
			menu();
		} else {
			for (int i = 0; i < dressVector.size(); i++) {
				Dress currentDress = dressVector.get(i);
				System.out.println("ID = " + currentDress.getId());
				System.out.println("Name = " + currentDress.getName());
				System.out.println("Fabric Price = " + currentDress.getFabricPrice());
				System.out.println("Fabric Type = " + currentDress.getFabricType());
				
				if (currentDress instanceof Regular) {
					System.out.println("Discount = " + ((Regular)currentDress).getDiscount() + "%");
					System.out.println("Total Price = Rp. " + ((Regular)currentDress).totalPrice());
				} else if (currentDress instanceof Limited) {
					System.out.println("Stock = " + ((Limited)currentDress).getStock());
					System.out.println("Total Price = Rp. " + ((Limited)currentDress).totalPrice());
				}
				
				System.out.println();
			}
		}
	}
	
	public void deleteDress() {
		String input;
		if (dressVector.isEmpty()) {
			System.out.println("No dresses available");
			menu();
		} else {
			int x = 0;
			int y = 0;
			viewDress();
			System.out.print("Input dress ID to delete: ");
			input = scan.nextLine();
			
			for (int i = 0; i < dressVector.size(); i++) {
				Dress currentDress = dressVector.get(i);
				if (input.equals(currentDress.getId())) {
					dressVector.remove(i);
					y++;
				} else if (!input.equals(currentDress.getId())) {
					x++;
				}
			}
			
			if (x == dressVector.size() && y == 0) {
				System.out.println("Dress ID is invalid!");
				menu();
			}
		}
	}

	public static void main(String[] args) {
		new Main();
	}

}
