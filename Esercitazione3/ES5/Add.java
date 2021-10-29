
public class Add implements Operazione {
	
	private Operazioni o;
	
	public Add(Operazioni o) {
		this.o = o;
	}
	
	public Operazioni getO() {
		return o;
	}

	public double operazione(Operazioni o) {
		return (o.getA() + o.getB());
	}
	
}
