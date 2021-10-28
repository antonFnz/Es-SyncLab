
public class Garage {
	 
	public int repair(Vehicle v) {
		if (!v.isBroken()) {
			System.out.println("Il veicolo di targa " + v.getPlate() + " non ha bisogno di riparazioni");
			// suppongo un prezzo minimo per il controllo della macchina
			return 100;
		}
		if (v instanceof Car) {
			if (((Car) v).getType() == "SUV") {
				v.setBroken(false);
				System.out.println("La macchina è riparata");
				return 1500;
			}
			if (((Car) v).getType() == "utilitaria") {
				v.setBroken(false);
				System.out.println("La macchina è riparata");
				return 800;
			}
		}
		if (v instanceof Motorcycle) {
			if (((Motorcycle) v).getEngine() == 50) {
				v.setBroken(false);
				System.out.println("La moto è riparata");
				return 400;
			}
			if (((Motorcycle) v).getEngine() == 125) {
				v.setBroken(false);
				System.out.println("La moto è riparata");
				return 700;
			}
		}
		System.out.println("Il veicolo non ha una tipologia definita, impossibile generare preventivo");
		return 0;
	}
	
}
