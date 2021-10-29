
public class Piramide extends Oggetti {
	
	public Piramide(double area, double height) {
		super(area, height);
	}

	@Override
	public double calcVolume() {
		this.volume = (this.area * this.height) / 3;
		return volume;
	}

}
