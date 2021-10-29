
public class Operazioni extends Stampa {

	private double a;
	private double b;
	
	public Operazioni(double a, double b) {
		this.a = a;
		this.b = b;
	}

	public double getA() {
		return a;
	}

	public double getB() {
		return b;
	}
	
	public void stampa(Operazione o) {
		System.out.println(o.operazione(this));
	}
	
}
