
public class Test4 {

	public static void main(String[] args) {
		
		double incassi = 0;
		
		Distributore dist1 = new Distributore("Milano", "Tizio", 6000, 2000);
		
		incassi = dist1.erogazione(3000);
		incassi = dist1.erogazione(1500);
		
		System.out.println("Incassi: " + incassi);
		System.out.println("Nuova quantit� in serbatoio: " + dist1.getInStore());
		
		Distributore dist2 = new Distributore("Milano", "Caio", 8000, 5000);
		
		if (dist1.compareTo(dist2) > 0) {
			System.out.println("Il distributore di " + dist1.getOwner() + " � pi� capiente");
		} else {
			System.out.println("Il distributore di " + dist2.getOwner() + " � pi� capiente");
		}
		
	}
	
}
