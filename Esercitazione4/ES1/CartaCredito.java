
public class CartaCredito {
	
	private double credito = 0;

	public CartaCredito(double credito) {
		this.credito = credito;
	}

	public double leggiCredito() {
		return credito;
	}

	public void caricaTessera(double credito) {
		this.credito += credito;
	}

}
