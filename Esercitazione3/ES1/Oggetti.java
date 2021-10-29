
public abstract class Oggetti {
	
	double area;
	double height;
	double volume;
	
	public Oggetti(double area, double height) {
		this.area = area;
		this.height = height;
	}
	
	public abstract double calcVolume();
	
	public void printVolume() {
		System.out.println(this.calcVolume());
	};
	
}
