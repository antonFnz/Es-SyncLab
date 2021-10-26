import java.util.Scanner;

// vietato usare array in tutti e 3 gli esercizi
public class EserciziCicli {
	// Esercizio 1
	// data una sequenza di numeri verifica se sono tutti positivi e pari
	static void loopEs1() {
		boolean flag = true;
		Scanner obj = new Scanner(System.in);
		System.out.println("Inserisci un numero a scelta di interi, inserisci uno 0 quando hai terminato");
		int n = obj.nextInt();
		while (n != 0) {
			if (n < 0 || n % 2 != 0) {
				flag = false;
			}
			n = obj.nextInt();
		}
		if (flag == true) {
			System.out.println("Tutti interi e positivi");
		} else {
			System.out.println("NO");
		}
	}
	
	// Esercizio 2
	// data una sequenza di numeri stampa la media aritmetica dei numeri divisibili per 3
	static void loopEs2() {
		int i = 0;
		int media = 0;
		Scanner obj = new Scanner(System.in);
		System.out.println("Inserisci un numero a scelta di interi, inserisci uno 0 quando hai terminato");
		int n = obj.nextInt();
		while (n != 0) {
			if (n % 3 == 0) { i++; media += n;}
			n = obj.nextInt();
		}
		System.out.println((float) media/i);
	}
	
	// Esercizio 3
	// esegue 5 volte un ciclo che consiste nel chiedere all'user di digitare un valore a propria scelta di characters
	static void loopEs3() {
		Scanner obj = new Scanner(System.in);
		for (int j = 0; j < 5; j++) {
			System.out.println("Quanti caratteri vuoi inserire?");
			int numberOfChars = obj.nextInt();
			for (int i = 0; i < numberOfChars; i++) {
				System.out.println("Digita il carattere #" + (i + 1));
				char character = obj.next().charAt(0);
				System.out.println(character);
			}
		}
	}
	
	public static void main(String[] args) {
		loopEs1();
		System.out.println("\n");
		loopEs2();
		System.out.println("\n");
		loopEs3();
	}
}
