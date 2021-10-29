import java.util.Comparator;

public class Distributore implements Comparable<Distributore> {

	private String city;
	private String owner;
	private double capacity;
	private double inStore;
	
	public Distributore(String city, String owner, double capacity, double inStore) {
		this.city = city;
		this.owner = owner;
		this.capacity = capacity;
		this.inStore = inStore;
	}
	
	public String getCity() {
		return city;
	}

	public String getOwner() {
		return owner;
	}

	public double getCapacity() {
		return capacity;
	}

	public double getInStore() {
		return inStore;
	}

	public double erogazione(double richiesta) {
		if (richiesta > this.inStore) {
			System.out.println("Benzina insufficiente!");
			// non si può eseguire l'erogazione, il costo è nullo
			return 0;
		} else {
			System.out.println("Erogazione Completata");
			this.inStore -= richiesta;
			// costo inventato, la richiesta ha un costo di 1.20 a unità
			return richiesta * 1.20;
		}
	}
	
	@Override
	public int compareTo(Distributore d){
	    return Comparator.comparing(Distributore::getCapacity).compare(this, d);
	}
	
}
