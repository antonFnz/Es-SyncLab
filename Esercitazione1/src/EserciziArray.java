import java.util.Random;

public class EserciziArray {
	
	// Esercizio 1
	// prende un array di dim 10 a piacere e stampa gli elementi in ordine -> Primo, Ultimo, Secondo, Penultimo...
	static void arrayEs1() {
		int[] array = new int[10];
		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}
		for (int i = 0; i < array.length/2; i++) {
			System.out.println(array[i]);
			System.out.println(array[array.length - i - 1]);
		}
	}
	
	// Esercizio 2
	// verifica se il numero di pari e dispari in un array random sono uguali oppure no
	static void arrayEs2() {
		int contaPari = 0;
		int contaDispari = 0;
		Random random = new Random();
		int[] array = new int[10];
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(100);
			System.out.println(array[i]);
		}
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 == 0) {
				contaPari++;
			} else {
				contaDispari++;
			}
		}
		if (contaPari == contaDispari) {
			System.out.println("Pari e dispari uguali");
		} else {
			System.out.println("Pari e dispari diversi");
		}
	}
	
	// Esercizio 3
	// verifica se in un array di dim 10 con elementi random vi sono 3 elementi consecutivi uguali
	static void arrayEs3() {
		int maxConsecutive = 0;
		Random random = new Random();
		int[] array = new int[10];
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(5);
			System.out.println(array[i]);
		}
		int occurrence = 1;
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] == array[i + 1]) { 
				occurrence++;
				if (occurrence > maxConsecutive) { maxConsecutive = occurrence; }
			} else {
				occurrence = 1;
			}
		}
		if (maxConsecutive >= 3) {
			System.out.println("Tre valori consecutivi uguali");
		} else {
			System.out.println("NO");
		}
	}
	
	// Esercizio 4
	// verifica se, date due sequenze di stringhe di dim 5, un elemento di una sequenza compare anche nell'altra
	static void arrayEs4(String[] s1, String[] s2) {
		for (int i = 0; i < s1.length; i++) {
			for (int j = 0; j < s2.length; j++) {
				if (s1[i].equals(s2[j])) {
					System.out.println("OK");
					return;
				}
			}
		}
		System.out.println("KO");	
	}
	
	public static void main(String[] args) {
		// Test esercizi
	    arrayEs1();
	    System.out.println("\n");
	    arrayEs2();
	    System.out.println("\n");
	    arrayEs3();
	    System.out.println("\n");
	    String[] s1 = new String[] {"aa", "bb", "cc", "dd", "ee"};
	    String[] s2 = new String[] {"cc", "dd", "ee", "ff", "gg"};
	    String[] s3 = new String[] {"hh", "ii", "ll", "mm", "nn"};
	    arrayEs4(s1, s2);
	    System.out.println("\n");
	    arrayEs4(s2, s3);
	}
}