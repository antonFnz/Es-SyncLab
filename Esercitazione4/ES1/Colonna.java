
public class Colonna {
	
	private Bevanda bevanda;
	private int numeroLattine;
	
	public Colonna() {
		this.numeroLattine = 0;
	}
	
	public void aggiornaColonna(Bevanda bevanda, int numeroLattine) {
		this.bevanda = bevanda;
		this.numeroLattine = numeroLattine;
	}
	
	public Bevanda getBevanda() {
		return bevanda;
	}
	
	public int lattineDisponibili() {
		return numeroLattine;
	}
	
}
