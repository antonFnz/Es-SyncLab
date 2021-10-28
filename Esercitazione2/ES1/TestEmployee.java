
public class TestEmployee {
	
	public static void main(String[] args) {
		
		Employee e1 = new Employee("Snake", "Solid", "SNKSLD80", "New York", 1960, 35000);
		Employee e2 = new Employee("Snake", "Liquid", "SNKLQD80", "New York", 1961, 20000);
		Employee e3 = new Employee("Snake", "Solidus", "SNKSDU80", "New York", 1965, 40000);
		
		System.out.println("L'ordine degli stipendi dei dipendenti, partendo dal più alto è:");
		// modo implementato evitando di usare le interfacce comparator o comparable non ancora introdotte
		// solo allo scopo di testare gainsMore()
		if (e1.gainsMore(e2)) {
			if (e2.gainsMore(e3)) {
				e1.visualize();
				e2.visualize();
				e3.visualize();
			} else if (e3.gainsMore(e1)) {
				e3.visualize();
				e1.visualize();
				e2.visualize();
			} else {
				e1.visualize();
				e3.visualize();
				e2.visualize();
			}
		} else {
			if (e3.gainsMore(e2)) {
				e3.visualize();
				e2.visualize();
				e1.visualize();
			} else if (e3.gainsMore(e1)) {
				e2.visualize();
				e3.visualize();
				e1.visualize();
			} else {
				e2.visualize();
				e1.visualize();
				e3.visualize();
			}
		}
		
	}
}
