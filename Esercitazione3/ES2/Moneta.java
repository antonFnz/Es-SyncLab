import java.util.Random;

public class Moneta extends OggettiLanciabili {

	@Override
	public void lancio() {
		Random rd = new Random();
		int flag = rd.nextInt(2);
		if (flag == 0) {
			System.out.println("Moneta lanciata, risultato: Testa!");
		} else {
			System.out.println("Moneta lanciata, risultato: Croce!");
		}
	}

}
