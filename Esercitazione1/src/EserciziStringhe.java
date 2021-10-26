
public class EserciziStringhe {
	
	// Esercizio 1
	// data una stringa in input la stampa al contrario
	static void stringEs1(String s) {
		StringBuffer reverse = new StringBuffer(s.length());
		for (int i = (s.length() - 1); i >= 0; i--) {
			reverse.append(s.charAt(i));
		}
		System.out.println(reverse);
	}
	
	// Esercizio 2
	// data una stringa stampa solo le vocali della stringa
	static void stringEs2(String s) {
		for (int i = 0; i < s.length(); i++) {
			if ("AEIOUaeiou".indexOf(s.charAt(i)) > -1) {
				System.out.print(s.charAt(i));
			}
		}
	}
	
	// Esercizio 3
	// data una sequenza di stringhe calcola la lunghezza della concatenazione delle stringe che iniziano con una maiuscola
	static void stringEs3(String[] s) {
		int length = 0;
		int i = 0;
		while(!(s[i].isEmpty())) {
			if(Character.isUpperCase(s[i].charAt(0))) {
				length += s[i].length();;
			}
			i++;
		}
		System.out.println(length);
	}
	
	public static void main(String[] args) {
		// Test esercizi
		String s = new String("Viva Java");
		stringEs1(s);
		System.out.println("\n");
		stringEs2(s);
		System.out.println("\n");
		String[] strings = new String[] {"Albero", "foglia", "Radici", "Ramo", "fiore", ""};
		stringEs3(strings);
	}
}
