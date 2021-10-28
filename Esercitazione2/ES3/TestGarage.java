
public class TestGarage {
	
	public static void main(String[] args) {
		
		Vehicle[] vehicles = new Vehicle[3];
		
		vehicles[0] = new Car("PLATE1", "BRAND1", "MODEL1", "SUV");
		vehicles[1] = new Motorcycle("PLATE2", "BRAND2", "MODEL2", 125);
		vehicles[2] = new Vehicle("PLATE3", "BRAND3", "MODEL3");
		
		vehicles[1].setBroken(true);
		vehicles[2].setBroken(true);
		
		Garage g = new Garage();
		int price;
		
		for (int i = 0; i < vehicles.length; i++) {
			price = g.repair(vehicles[i]);
			System.out.println("Prezzo: " + price + "\n");
		}
		
	}
	
}
