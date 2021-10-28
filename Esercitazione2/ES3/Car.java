
public class Car extends Vehicle {
	
	private String type;

	public Car(String plate, String brand, String model, String type) {
		super(plate, brand, model);
		this.type = type;
	}

	public String getType() {
		return type;
	}
	
}
