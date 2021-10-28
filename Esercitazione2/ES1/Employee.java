
public class Employee extends Person {
	
	int startYear;
	int salary;
	
	public Employee(String surname, String name, String taxCode, String city, int startYear, int salary) {
		super(surname, name, taxCode, city);
		this.startYear = startYear;
		this.salary = salary;
	}

	public int getStartYear() {
		return startYear;
	}

	public void setStartYear(int startYear) {
		this.startYear = startYear;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public void visualize() {
		System.out.println(this.getName() + " " + this.getSurname() + " " + this.startYear);
	}
	
	public boolean gainsMore(Employee e) {
		if (this.salary >= e.getSalary()) { return true; }
		else { return false; }
	}
	
}
