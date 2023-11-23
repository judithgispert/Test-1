
public class Farmer extends Seller{

	
	public Farmer(String name, String city) {
		super(name, city);
		
	}

	@Override
	public double itemTaxes(double price) {
		double totalPrice = (price * 0.02) + price;
		return totalPrice;
	}
	
}
