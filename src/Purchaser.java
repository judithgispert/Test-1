import java.util.ArrayList;
import java.util.List;

public class Purchaser {
	
	private String name;
	private String city;
	List <Item> purchaserItems;
	
	
	public Purchaser (String name, String city) {
		this.name = name;
		this.city = city;
		purchaserItems = new ArrayList<Item>();
	}
	
	public String getName() {
		return name;
	}
	public String getCity() {
		return city;
	}
	public List<Item> getPurchaserItems() {
		return purchaserItems;
	}

}
