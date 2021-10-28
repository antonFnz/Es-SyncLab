
public class TestVehicles {
	
	public static void main(String[] args) {
		
		Vehicle[] vehicles = new Vehicle[3];
		
		vehicles[0] = new Car("PLATE1", "BRAND1", "MODEL1", "SUV");
		vehicles[1] = new Motorcycle("PLATE2", "BRAND2", "MODEL2", 125);
		vehicles[2] = new Vehicle("PLATE3", "BRAND3", "MODEL3");
		
		vehicles[2].setBroken(true);
		
		for (int i = 0; i < vehicles.length; i++) {
			System.out.print(vehicles[i].getPlate() + " " + vehicles[i].getModel());
			if (vehicles[i].isBroken()) {
				System.out.println(" (Stato: il veicolo è guasto)");
			} else {
				System.out.println(" (Stato: il veicolo è OK)");
			}
		}
	
	}
	
}
