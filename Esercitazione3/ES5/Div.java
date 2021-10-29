
public class Div implements Operazione{
	
	private Operazioni o;
	
	public Div(Operazioni o) {
		this.o = o;
	}
	
	public Operazioni getO() {
		return o;
	}
	
	public double operazione(Operazioni o) {
		return (o.getA() / o.getB());
	}
	
}
