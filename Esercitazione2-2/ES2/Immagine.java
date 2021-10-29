
public class Immagine extends ElementoMultimediale {
	
	private int luminosita = 5;

	public Immagine(String titolo) {
		this.setTitolo(titolo);
	}
	
	public void darker() {
		this.luminosita--;
	}
	
	public void brighter() {
		this.luminosita++;
	}
	
	public void show() {
		System.out.println(this.getTitolo());
		for (int i = 0; i < this.luminosita; i++) {
			System.out.print("* ");
		}
		System.out.println();
	}
	
}
