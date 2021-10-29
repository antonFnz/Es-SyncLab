import java.util.ArrayList;
import java.util.Scanner;

public class ListaSpesa {
	
	public static void main(String[] args) {
		
		ArrayList<Prodotti> ps = new ArrayList<Prodotti>(5);
		ps.add(new Alimentari("1234", "Pane", 7.50, 20, 10, 2022));
		ps.add(new Alimentari("2345", "Latte", 2.20, 31, 10, 2021));
		ps.add(new NonAlimentari("3456", "Bicchiere", 5.00, "vetro"));
		ps.add(new NonAlimentari("4567", "Maglietta", 28.60, "cotone"));
		ps.add(new Prodotti("5678", "Poster", 10.00));
		
		float totale = 0;
		boolean fidelity = false;
		
		int flag = 1;
		Scanner obj = new Scanner(System.in);
		
		System.out.println("Hai la carta fidelity? [Y/N]");
		char verifica = obj.nextLine().charAt(0);
		if (verifica == 'Y') { fidelity = true; }
		
		while (flag != 0) {
			System.out.println("Inserimento Prodotto. Digita il codice del prodotto: (Digita 0 per terminare)");
			String barCode = obj.nextLine();
			if (barCode.equals("0")) { flag = 0; }
			for (Prodotti p : ps) {
				if (p.getBarCode().equals(barCode)) {
					if (fidelity) {
						p.applicaSconto();
						totale += p.getPrice();
					} else {
						totale += p.getPrice();
					}
				}
			}
		}
		
		System.out.println(totale);
	}
	
}
