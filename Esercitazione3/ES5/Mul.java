
public class Mul implements Operazione{
	
	private Operazioni o;
	
	public Mul(Operazioni o) {
		this.o = o;
	}
	
	public Operazioni getO() {
		return o;
	}
	
	public double operazione(Operazioni o) {
		return (o.getA() * o.getB());
	}
	
}
