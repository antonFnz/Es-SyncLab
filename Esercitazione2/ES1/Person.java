
public class Person {
	
	private String surname;
	private String name;
	private String taxCode;
	private String city;
	
	public Person() {}

	public Person(String surname, String name, String taxCode, String city) {
		this.surname = surname;
		this.name = name;
		this.taxCode = taxCode;
		this.city = city;
	}


	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public String bornYear(String taxCode) {
		if (taxCode == null || taxCode.length() < 16) {
			System.out.println("Inserimento codice fiscale invalido, riprovare l'inserimento");
			return "0";
		}
		// per semplicità ignoro il caso di stagisti nati dopo il 2000, nel qual caso userei un controllo sulla stringa presa dal codice fiscale
		return "19" + taxCode.substring(6, 8);
	}
	
}
