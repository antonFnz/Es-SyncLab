import java.util.Random;

public class Dado extends OggettiLanciabili {

	@Override
	public void lancio() {
		Random rd = new Random();
		System.out.println("Dado lanciato. Risultato: " + (rd.nextInt(6) + 1));
	}

}
