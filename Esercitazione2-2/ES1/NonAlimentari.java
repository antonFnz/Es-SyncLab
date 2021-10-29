
public class NonAlimentari extends Prodotti {
	
	private String materiale;

	public NonAlimentari(String barCode, String desc, double price, String materiale) {
		super(barCode, desc, price);
		this.materiale = materiale;
	}
	
	@Override
	public void applicaSconto() {
		if (this.materiale.equals("carta") || this.materiale.equals("vetro") || this.materiale.equals("plastica")) {
			this.setPrice((this.getPrice() * 90)/100);
		}
	}
	
}
