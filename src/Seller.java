
import java.util.ArrayList;
import java.util.List;

public abstract class Seller {
	
	private String name;
	private String city;
	protected int maxItems;
	private List <Item> inventory;
	
	public Seller (String name, String city) {
		this.name = name;
		this.city = city;
		inventory = new ArrayList <Item>();
		maxItems = 0;
	}
	
	
	public String getName() {
		return name;
	}
	public String getCity() {
		return city;
	}
	public List<Item> getInventory() {
		return inventory;
	}
	public int getMaxItems() {
		return maxItems;
	}
	
	
	public void setName (String name) {
		this.name = name;
	}
	public void setCity (String city) {
		this.city = city;
	}
	public void setItem(List<Item> inventory) {
		this.inventory = inventory;
	}
	
	
	public abstract double totalPrice(double price);

	public abstract int wearItem (Item item);
	
	
	@Override
	public String toString() {
		return name + ", " + city;
	}
	
	

}
