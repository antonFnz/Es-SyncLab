
public class Alimentari extends Prodotti {
	
	private Data date;
	
	public Alimentari(String barCode, String desc, double price, int day, int month, int year) {
		super(barCode, desc, price);
		this.date = new Data(day, month, year);
	}
	
	@Override
	public void applicaSconto() {
		if (date.getDifference()) {
			this.setPrice((this.getPrice() * 80)/100);
		}
	}
	
}
