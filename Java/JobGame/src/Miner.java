import java.util.Random;

public class Miner extends Worker implements WorkerInterface {
	
	public Miner(String id, String name, String job) {
		super(id, name, job);
	}

	@Override
	public void doJob(int playerMoney, int minerCost, int playerOre, int numberOfMiner) {
		if (playerMoney >= minerCost) {
			int x;
			Random random = new Random();
			x = random.nextInt(3);
			System.out.println("Every miner got " + x + " ore(s)");
			playerOre = x * numberOfMiner;
			playerMoney -= minerCost;
		}
	}

	@Override
	public void sellItem(int playerMoney, int playerOre) {
		playerMoney += 50 + playerOre;
	}


	

}
