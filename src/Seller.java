import java.util.ArrayList;
import java.util.List;

public abstract class Seller {
	
	private String name;
	private String city;
	protected int maxItems;
	private List <Item> itemsList;
	
	public Seller (String name, String city) {
		this.name = name;
		this.city = city;
		maxItems = 0;
		itemsList = new ArrayList <Item>();
	}
	
	
	public String getName() {
		return name;
	}
	public String getCity() {
		return city;
	}
	public int getMaxItems() {
		return maxItems;
	}
	public List<Item> getItemsList() {
		return itemsList;
	}
	
	
	public void setName (String name) {
		this.name = name;
	}
	public void setCity (String city) {
		this.city = city;
	}
	public void setItem(List<Item> itemsList) {
		this.itemsList = itemsList;
	}

	
	
	public double itemTaxes(double price) {
		double totalPrice = price;
		return totalPrice;
	}
	
	@Override
	public String toString() {
		return name + ", " + city + "maximum items: " + maxItems;
	}
	
	

}
