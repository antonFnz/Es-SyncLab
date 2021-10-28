
public class Vehicle {
	
	private String plate;
	private String brand;
	private String model;
	private boolean isBroken;
	
	public Vehicle(String plate, String brand, String model) {
		// supponendo che un veicolo non possa essere registrato già guasto
		// verrà usato il valore di default del tipo boolean (false) alla creazione
		this.plate = plate;
		this.brand = brand;
		this.model = model;
	}
	
	// escludo i setters di brand e model che non possono cambiare nel ciclo di vita dell'oggetto

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public boolean isBroken() {
		return isBroken;
	}

	public void setBroken(boolean isBroken) {
		this.isBroken = isBroken;
	}
	
}
