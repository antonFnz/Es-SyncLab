
public class Filmato extends ElementoMultimediale implements Playable {
	
	private int durata;
	private int volume = 5;
	private int luminosita = 5;
	
	public Filmato(String titolo, int durata) {
		this.setTitolo(titolo);
		this.durata = durata;
	}

	public int getDurata() {
		return durata;
	}
	
	public int getVolume() {
		return volume;
	}

	public int getLuminosita() {
		return luminosita;
	}
	
	public void weaker() {
		this.volume--;
	}
	
	public void louder() {
		this.volume++;
	}
	
	public void darker() {
		this.luminosita--;
	}
	
	public void brighter() {
		this.luminosita++;
	}
	
	public void play() {
		for (int i = 0; i < this.durata; i++) {
			System.out.println(this.getTitolo());
			for (int j = 0; j < this.volume; j++) {
				System.out.print("! ");
			}
			System.out.println();
			for (int w = 0; w < this.luminosita; w++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	
}
