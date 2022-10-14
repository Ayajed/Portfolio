
public class Regular extends Dress {

	private Integer discount;

	public Regular(String id, String name, Integer fabricPrice, String fabricType, Integer discount) {
		super(id, name, fabricPrice, fabricType);
		this.discount = discount;
	}

	public Integer getDiscount() {
		return discount;
	}
	
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
	
	@Override
	public int totalPrice() {
		int x = getFabricPrice();
		int y = getDiscount();
		int price = (x + 50000) * ((100 - y) / 100);
		return price;
	}
}
