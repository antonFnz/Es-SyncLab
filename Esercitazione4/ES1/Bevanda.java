
public class Bevanda {
	
	private String name;
	private double price;
	
	public Bevanda (String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public int hashCode() {
	    int prime = 31;
	    return prime + (name == null ? 0 : name.hashCode());    
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        Bevanda d = (Bevanda) o;
        if (name != d.name)
            return false;
        return true;
    }
	
}
