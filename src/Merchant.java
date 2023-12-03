public class Merchant extends Seller{
	
	private final static double tax = 0.04;
	
	public Merchant(String name, String city) {
		super(name, city);
		maxItems = 7;
	}
	
	public int getMaxItems() {
		return maxItems;
	}

	@Override
	public double totalPrice(double price) {
		double totalPrice = (price * tax) + price;
		return totalPrice;
	}

	@Override
	public int wearItem(Item item) {
		int wear =  item.getConservation();
		return wear;
	}
}
