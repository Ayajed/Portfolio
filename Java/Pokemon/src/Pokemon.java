
public class Pokemon {
	private String name;
	private int hp;
	private int mana;
	private int atkPower;
	
	public Pokemon(String name, int hp, int mana, int atkPower) {
		super();
		this.name = name;
		this.hp = hp;
		this.mana = mana;
		this.atkPower = atkPower;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getMana() {
		return mana;
	}
	public void setMana(int mana) {
		this.mana = mana;
	}
	public int getAtkPower() {
		return atkPower;
	}
	public void setAtkPower(int atkPower) {
		this.atkPower = atkPower;
	}
}
