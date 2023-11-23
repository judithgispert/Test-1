
public class Merchant extends Seller{

	
	public Merchant(String name, String city) {
		super(name, city);
		maxItems = 4;
	}

	@Override
	public double itemTaxes(double price) {
		double totalPrice = (price * 0.04) + price;
		return totalPrice;
	}

}
