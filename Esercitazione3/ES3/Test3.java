import java.util.Scanner;

public class Test3 {
	
	public static void main(String[] args) {
		
		Scanner obj = new Scanner(System.in);
		System.out.println("Inserisci un numero intero:");
		int n = obj.nextInt();
		
		Quadrato q = new Quadrato();
		q.rappresentazione(n);
		
		Cubo c = new Cubo();
		c.rappresentazione(n);
		
		obj.close();
		
	}
	
}
