import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;



public class Menu {

	public void menuApp() {
		System.out.println("Application menu: \r\n" 
							+ "1. Create new seller. \r\n" 
							+ "2. Add item to seller. \r\n" 
							+ "3. Shows the cheapest item in a city.\r\n"
							+ "4. Check a seller's items. \r\n"
							+ "5. Create purchaser. \r\n"
							+ "6. Shop item. \r\n"
							+ "7. Show purchaser items. \r\n"
							+ "8. Consult all the sellers in a city. \r\n"
							+ "9. Consult all the purchasers in a city. \r\n"
							+ "0. Exit app.");	
	}
	
	public void app() throws ExceptionItem {
		boolean exit = true;
		List<Seller> sellersList = new ArrayList <Seller>();
		List<Purchaser> purchaserList = new ArrayList <Purchaser>();
		
		do {
			menuApp();
			int num = getInt("Choose the section you want to access:");
			
			switch(num) {
			
				case 1:
					createSeller(sellersList);
					exit = false;
					break;
				
				case 2:
					addItem(sellersList);
					exit = false;
					break;
				
				case 3:
					exit = false;
					break;
				
				case 4:
					sellerItems(sellersList);
					exit = false;
					break;
				
				case 5:
					createPurchaser(purchaserList);
					exit = false;
					break;
				
				case 6:
					exit = false;
					break;
				
				case 7:
					purchaserItems(purchaserList);
					exit = false;
					break;
				
				case 8:
					sellerCity(sellersList);
					exit = false;
					break;
				
				case 9:
					purchaserCity(purchaserList);
					exit = false;
					break;
			
				case 0:
					System.out.println("Closing application.");
					exit = true;
					break;
				default:
					System.out.println("Error.");
			}	
		}while(exit == false);
	}
	
	
	
	
	static int getInt (String missatge) {
		Scanner input = new Scanner (System.in);
		System.out.println(missatge);
		return input.nextInt();
	}
	static double getDouble (String missatge) {
		Scanner input = new Scanner (System.in);
		System.out.println(missatge);
		return input.nextDouble();
	}
	static String getString (String missatge) {
		Scanner input = new Scanner (System.in);
		System.out.println(missatge);
		return input.nextLine();
	}
	
	
	
	public static void createFarmer (String name, String city, List<Seller> sellersList) {
		sellersList.add(new Farmer(name, city));
	}
	public static void createThief (String name, String city, List<Seller> sellersList) {
		sellersList.add(new Thief(name, city));
	}
	public static void createMerchant (String name, String city, List<Seller> sellersList) {
		sellersList.add(new Merchant(name, city));
	}
	
	public static void createSeller(List<Seller> sellersList) {
		
		System.out.println("1. Create new Farmer. \r\n" 
				+ "2. Create new Thief. \r\n" 
				+ "3. Create new Merchant.\r\n");	
		int numSeller = getInt ("Choose the section you want to access:");
		switch(numSeller) {
			case 1:
				createFarmer (getString("Name:"), getString("City:"), sellersList);
				break;
			case 2:
				createThief (getString("Name:"), getString("City:"), sellersList);
				break;
			case 3:
				createMerchant (getString("Name:"), getString("City:"), sellersList);
				break;
		}
	}
	
	public static void createPurchaser(List<Purchaser> purchaserList) {
		purchaserList.add(new Purchaser(getString("Name:"), getString("City:")));
	}
	
	public static int getSeller(List<Seller> sellersList) {
		String nameSeller = getString("Write the name of the seller:");

		int nameFound = -1;
		
		for(int cont = 0; cont < sellersList.size(); cont++) {
			if(nameSeller.equalsIgnoreCase(sellersList.get(cont).getName())){
				nameFound = cont;
			}
		}
		return nameFound;
	}
	
	public static int getPurchaser (List <Purchaser> purchaserList) {
		String namePurchaser = getString("Write the name of the purchaser:");

		int nameFound = -1;
		
		for(int cont = 0; cont < purchaserList.size(); cont++) {
			if(namePurchaser.equalsIgnoreCase(purchaserList.get(cont).getName())){
				nameFound = cont;
			}
		}
		return nameFound;
	}
	
	public static void addItem(List<Seller> sellersList) throws ExceptionItem{
		int found = getSeller(sellersList);
		
		if (found != -1) {
			if (sellersList.get(found).getItemsList().size() >= sellersList.get(found).getMaxItems()) {
				throw new ExceptionItem();
			}
			sellersList.get(found).getItemsList().add(new Item (getString("Item name:"), getString("Item type:"), getDouble("Item price:")));
		} else {
			System.out.println("Seller not found");
		}
	}
	
	/*public static void cheapestItem (List<Seller> sellersList) {
		String nameCity = getString("Write the name of the city:");
		
		sellersList.stream().filter(l -> l.getCity().contains(nameCity)).filter(l -> l.getItemsList()).mapToDouble(l -> l).min()
		
	}*/
	
	public static void sellerItems(List<Seller> sellersList) {
		int numSeller = getSeller(sellersList);
		
		sellersList.get(numSeller).getItemsList().stream().forEach(l -> System.out.println(l.getName()));
	}
	
	public static void purchaserItems(List<Purchaser> purchaserList) {
		int numSeller = getPurchaser(purchaserList);
		
		purchaserList.get(numSeller).getPurchaserItems().stream().forEach(l -> System.out.println(l));
	}
	
	public static void sellerCity(List<Seller> sellersList) {
		String nameCity = getString("Write the name of the city:");
		sellersList.stream().filter(l -> l.getCity().contains(nameCity)).collect(Collectors.toList()).forEach(System.out::println);
	}
	
	public static void purchaserCity(List<Purchaser> purchaserList) {
		String nameCity = getString("Write the name of the city:");
		purchaserList.stream().filter(l -> l.getCity().contains(nameCity)).collect(Collectors.toList()).forEach(System.out::println);
	}
}
