

public class Thief extends Seller{
	
	public static int itemWear;

	public Thief(String name, String city) {
		super(name, city);
		maxItems = 3;
		itemWear = 25;
	}
	
	public int getMaxItems() {
		return maxItems;
	}

	@Override
	public double totalPrice(double price) {
		double totalPrice = price;
		return totalPrice;
	}

	@Override
	public int wearItem(Item item) {
		itemWear =  item.getConservation() - itemWear;
		return itemWear;
	}

	

	
	

}
