
public abstract class Dress {

	private String id;
	private String name;
	private Integer fabricPrice;
	private String fabricType;
	
	public abstract int totalPrice();
	
	public Dress(String id, String name, Integer fabricPrice, String fabricType) {
		super();
		this.id = id;
		this.name = name;
		this.fabricPrice = fabricPrice;
		this.fabricType = fabricType;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getFabricPrice() {
		return fabricPrice;
	}
	public void setFabricPrice(Integer fabricPrice) {
		this.fabricPrice = fabricPrice;
	}
	public String getFabricType() {
		return fabricType;
	}
	public void setFabricType(String fabricType) {
		this.fabricType = fabricType;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
