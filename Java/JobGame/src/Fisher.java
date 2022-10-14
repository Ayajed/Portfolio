import java.util.Random;

public class Fisher extends Worker implements WorkerInterface{

	
	public Fisher(String id, String name, String job) {
		super(id, name, job);
	}

	@Override
	public void doJob(int playerMoney, int fisherCost, int playerFish, int numberOfFisher) {
		if (playerMoney >= fisherCost) {
			int x;
			Random random = new Random();
			x = random.nextInt(3);
			System.out.println("Every fisher got " + x + " fish(es)");
			playerFish = x * numberOfFisher;
			playerMoney -= fisherCost;
		}
	}

	@Override
	public void sellItem(int playerMoney, int playerFish) {
		playerMoney += 25 + playerFish;
	}
	
	

}
