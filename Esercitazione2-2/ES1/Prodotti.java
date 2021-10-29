
public class Prodotti {
	
	private String barCode;
	private String desc;
	private double price;
	
	public Prodotti(String barCode, String desc, double price) {
		this.barCode = barCode;
		this.desc = desc;
		this.price = price;
	}

	public String getBarCode() {
		return barCode;
	}

	public String getDesc() {
		return desc;
	}

	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void applicaSconto() {
		this.price -= (this.price * 5)/100;
	}
	
	@Override
	public boolean equals(Object obj) {
		Prodotti p = (Prodotti) obj;
		if (this.getBarCode() == p.getBarCode()) {
			return true;
		} else {
			return false;
		}
	}
	
}
