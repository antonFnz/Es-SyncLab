import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Distributore {
	
	public static void main(String[] args) {
		
		HashMap<String, Bevanda> distributore = new HashMap<>();
		HashMap<Integer, CartaCredito> carteCredito = new HashMap<>();
		
		Bevanda b1 = new Bevanda("Acqua", 0.20);
		Bevanda b2 = new Bevanda("Coca", 0.30);
		Bevanda b3 = new Bevanda("Birra", 1.00);
		
		distributore.put("A", b1);
		distributore.put("B", b2);
		distributore.put("C", b3);
		
		CartaCredito c1 = new CartaCredito(5.5);
		CartaCredito c2 = new CartaCredito(12);
		CartaCredito c3 = new CartaCredito(0.75);
		
		carteCredito.put(12, c1);
		carteCredito.put(21, c2);
		carteCredito.put(99, c3);
		
		ArrayList<Colonna> colonne = new ArrayList<>();
		colonne.add(new Colonna());
		colonne.get(0).aggiornaColonna(b1, 40);
		colonne.add(new Colonna());
		colonne.get(1).aggiornaColonna(b2, 1);
		colonne.add(new Colonna());
		colonne.get(2).aggiornaColonna(b3, 50);
		
		Scanner obj = new Scanner(System.in);
		
		System.out.println("Digita il codice della bevanda:");
		String key = obj.next();
		
		if(!distributore.containsKey(key)) {
			throw new InserimentoNonValido("Bevanda non valida");
		} else {
			System.out.println("Hai scelto la bevanda: " + distributore.get(key).getName());
			System.out.println("Il prezzo della bevanda è: " + distributore.get(key).getPrice() + "€");
		}
		
		int lattineTot = 0;
		int colonna = 0;
		for (Colonna c : colonne) {
			if (c.getBevanda().equals(distributore.get(key))) {
				lattineTot += c.lattineDisponibili();
				colonna = colonne.indexOf(c);
			}
		}
		if (lattineTot == 0) {
			throw new BevandaEsaurita("Bevanda Esaurita!");
		}
		
		System.out.println("Digita il codice della tua carta:");
		while(!obj.hasNextInt()) {
			System.out.println("Codice non valido, inserire un intero!");
			obj.next();
		}
		int codice = obj.nextInt();
		
		if(!carteCredito.containsKey(codice)) {
			throw new InserimentoNonValido("Codice Carta non valido");
		}
		
		if (carteCredito.get(codice).leggiCredito() < distributore.get(key).getPrice()) {
			throw new CreditoInsufficiente("Credito sulla carta insufficiente");
		} else {
			System.out.println("Acquisto effettuato! erogazione dalla colonna " + (colonna + 1));
			colonne.get(colonna).aggiornaColonna(distributore.get(key), colonne.get(colonna).lattineDisponibili() - 1);
			System.out.println("Lattine rimaste nella colonna: " + colonne.get(colonna).lattineDisponibili());
			carteCredito.get(codice).caricaTessera(- distributore.get(key).getPrice());
			System.out.println("Nuovo credito: " + carteCredito.get(codice).leggiCredito());
		}
		
	}
	
}
