
public class Test5 {
	
	public static void main(String[] args) {
		
		double a = 10;
		double b = 2;
		
		Operazioni o = new Operazioni(a, b);
		Add add = new Add(o);
		o.stampa(add);
		Mul mul = new Mul(o);
		o.stampa(mul);
		Div div = new Div(o);
		o.stampa(div);
	}
	
}
