import java.time.temporal.ChronoUnit;
import java.time.LocalDate;

public class Data {
	
	private int day;
	private int month;
	private int year;
	
	public Data(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	@Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }
	
	public boolean getDifference() {
		LocalDate dataScadenza = LocalDate.parse(this.toString());
		LocalDate currentDate = LocalDate.now();
		long diffGiorni = ChronoUnit.DAYS.between(currentDate, dataScadenza);
		if (diffGiorni > 10) {
			return true;
		} else {
			return false;
		}
	}
	
}
