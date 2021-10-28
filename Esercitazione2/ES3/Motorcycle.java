
public class Motorcycle extends Vehicle {
	
	private int engine;

	public Motorcycle(String plate, String brand, String model, int engine) {
		super(plate, brand, model);
		this.engine = engine;
	}

	public int getEngine() {
		return engine;
	}
	
	// in questo caso lascio il setter supponendo si possa modificare la cilindrata
	public void setEngine(int engine) {
		this.engine = engine;
	}
	
}
