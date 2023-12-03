public class Farmer extends Seller{

	private static int itemWear;
	private final static double tax = 0.02;
	
	public Farmer(String name, String city) {
		super(name, city);
		maxItems = 5;
		itemWear = 15;
	}
	
	public int getMaxItems() {
		return maxItems;
	}
	
	public int getItemWear() {
		return itemWear;
	}

	@Override
	public double totalPrice(double price) {
		double totalPrice = (price * tax) + price;
		return totalPrice;
	}

	@Override
	public int wearItem(Item item) {
		itemWear =  item.getConservation() - itemWear;
		return itemWear;
	}
	
}
