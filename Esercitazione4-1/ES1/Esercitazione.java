import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class Esercitazione {
	
	// ESERCIZIO 1
	
	static LinkedList<Integer> creaRandom(int n, int max) {
		Random rd = new Random();
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			list.add(rd.nextInt(max));
		}
		return list;
	}
	
	static void stampa(Iterator<Integer> i) {
		while (i.hasNext()) {
			System.out.print(i.next() + " ");
		}
	}
	
	static void provaEx1() {
		LinkedList<Integer> lista = Esercitazione.creaRandom(20, 20);
		Iterator<Integer> it = lista.iterator();
		Esercitazione.stampa(it);
		lista.sort(null);
		System.out.println();
		it = lista.iterator();
		Esercitazione.stampa(it);
	}
	
	/* per eseguire l'esercizio con ArrayList il procedimento è uguale in quanto iterator() e add()
	 * sono metodi in comune tra ArrayList e LinkedList
	 */
	
	
	// ESERCIZIO 2
	
	static LinkedList<Integer> creaRandomCrescente(int n) {
		Random rd = new Random();
		LinkedList<Integer> list = new LinkedList<>();
		int nextValue = rd.nextInt(100);
		for(int i = 0; i < n; i++) {
			list.add(nextValue);
			nextValue += rd.nextInt();
		}
		return list;
	}
	
	static LinkedList<Integer> parseString(LinkedList<String> a) {
		LinkedList<Integer> list = new LinkedList<>();
		int size = a.size();
		for(int i = 0; i < size; i++) {
			list.add(Integer.parseInt(a.get(i)));
		}
		return list;
	}
	
	/* il metodo può sollevare un eccezione, in particolare NumberFormatExcpetion
	 * quando l'input della stringa da convertire è per esempio la stringa vuota o una
	 * stringa il valore numerico supera il valore massimo consentito per gli int
	 */
	
	static void provaEx2() {
		LinkedList<String> list = new LinkedList<>(Arrays.asList("10", "23", "34", "148", "27", "2", "88", "000", "012", "5670"));
		LinkedList<Integer> list2 = Esercitazione.parseString(list);
		Iterator<Integer> it = list2.iterator();
		Esercitazione.stampa(it);
	}
	
	
	// ESERCIZIO 3
	
	static LinkedList<Integer> mergeOrdinato(Iterator<Integer> a, Iterator<Integer> b) {
		LinkedList<Integer> mergedList = new LinkedList<>();
		int i = a.hasNext() ? a.next() : -1;
		int j = b.hasNext() ? b.next() : -1;
		while (i != -1 || j != -1) {
			if(i == -1) {
				mergedList.add(j);
				j = b.hasNext() ? b.next() : -1;
			} else if(j == -1) {
				mergedList.add(i);
				i = a.hasNext() ? a.next() : -1;
			} else if (i <= j) {
				mergedList.add(i);
				i = a.hasNext() ? a.next() : -1;
			} else {
				mergedList.add(j);
				j = b.hasNext() ? b.next() : -1;
			}
		}
		return mergedList;
	}
	
	static void provaEx3() {
		LinkedList<Integer> list1 = new LinkedList<>(Arrays.asList(1, 2, 6, 7, 9, 11, 12));
		LinkedList<Integer> list2 = new LinkedList<>(Arrays.asList(3, 4, 5, 8, 10));
		Iterator<Integer> it1 = list1.iterator();
		Iterator<Integer> it2 = list2.iterator();
		LinkedList<Integer> mergedList = Esercitazione.mergeOrdinato(it1, it2);
		Iterator<Integer> it = mergedList.iterator();
		Esercitazione.stampa(it);
	}
	
	
	// ESERCIZIO 4
	
	static LinkedList<LinkedList<Integer>> insiemeDiInsiemi(int n) {
		LinkedList<LinkedList<Integer>> listaInsiemi = new LinkedList<>();
		for(int i = 0; i < n; i++) {
			LinkedList<Integer> list = new LinkedList<>();
			for(int j = 0; j < (i + 1); j++) {
				list.add(j);
			}
			listaInsiemi.add(list);
		}
		return listaInsiemi;
	}
	
	static void stampa(LinkedList<LinkedList<Integer>> a) {
		Iterator<LinkedList<Integer>> it = a.iterator();
		while(it.hasNext()) {
			Iterator<Integer> itSub = it.next().iterator();
			Esercitazione.stampa(itSub);
			System.out.println();
		}
	}

}
