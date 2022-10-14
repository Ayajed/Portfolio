
public class Limited extends Dress {
	
	private Integer stock;

	public Limited(String id, String name, Integer fabricPrice, String fabricType, Integer stock) {
		super(id, name, fabricPrice, fabricType);
		this.stock = stock;
	}

	public Integer getStock() {
		return stock;
	}
	
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	@Override
	public int totalPrice() {
		int x = getFabricPrice();
		int y = getStock();
		int price = x + 50000 + ((10 - y) * 10000);
		return price;
	}
}
