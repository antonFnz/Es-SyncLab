
public class Cilindro extends Oggetti {
	
	public Cilindro(double area, double height) {
		super(area, height);
	}

	@Override
	public double calcVolume() {
		this.volume = this.area * this.height;
		return volume;
	}

}
