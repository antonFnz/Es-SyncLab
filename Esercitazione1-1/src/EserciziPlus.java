import java.util.Arrays;
import java.util.Random;

public class EserciziPlus {
	
	// Esercizio 1
	// genera un array di dim random con valori random e lo riordina in ordine crescente
	static void es1() {
		Random random = new Random();
		int dim = random.nextInt(20);
		int[] array = new int[dim];
		for (int i = 0; i < dim; i++) {
			array[i] = random.nextInt(100);
		}
		Arrays.sort(array); // implementa QuickSort, con costo O(nlog(n))
		for (int i = 0; i < dim; i++) {
			System.out.println(array[i]);
		}
	}
	
	// Esercizio 2
	// data una stringa restituisce true se essa è palindroma, false altrimenti
	// caso case-sensitive, se lo volessi non case-sensitive potrei usare toLowerCase() o to toUpperCase() sulla stringa prima del controllo
	static boolean es2(String s) {
		for (int i = 0; i < s.length()/2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - i - 1)) { return false; }
		}
		return true;
	}
	
	// Esercizio 3
	// metodo che stampa i primi 50 numeri della serie di fibonacci
	// utilizzo il tipo primitivo long perchè int andrebbe in overflow
	static void es3() {
		long first = 0;
		long second = 1;
		for(int i = 0; i < 50 - 2; i++) {
			long number = first + second;
			first = second;
			second = number;
			System.out.print(number + " ");
		}
	}
	
	// Esercizio 4
	// data una matrice effettua la trasposta di essa
	static void es4(int[][] matrix) {
		int [][] tMatrix = new int[matrix[0].length][matrix.length];
		for (int i = 0; i < matrix[0].length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				tMatrix[i][j] = matrix[j][i];
				System.out.print(tMatrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		// Test esercizi
		System.out.println("Array random ordinato:");
		es1();
		System.out.println("\n");
		String s1 = "radar";
		String s2 = "sonar";
		if(es2(s1)) { System.out.println(s1 + " è una stringa palindroma"); }
		if(!es2(s2)) { System.out.println(s2 + " NON è una stringa palindroma"); }
		System.out.println("\n");
		es3();
		System.out.println("\n");
		int[][] m = new int[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				m[i][j] = j + 1;
			}
		}
		es4(m);
	}
}
