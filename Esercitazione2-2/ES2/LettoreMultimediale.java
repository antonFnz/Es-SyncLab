import java.util.Scanner;

public class LettoreMultimediale {
	
	public static void main(String[] args) {
		
		ElementoMultimediale[] storage = new ElementoMultimediale[5];
		
		Scanner obj = new Scanner(System.in);
		
		for (int i = 0; i < 5; i++) {
			System.out.println("Inserire file #" + (i+1) + ". E' di tipo Immagine/Filmato/Registrazione Audio?");
			String tipo = obj.nextLine();
			// salva un'immagine
			if (tipo.equals("Immagine")) {
				System.out.println("Digitare il nome dell'immagine:");
				String fileName = obj.nextLine();
				storage[i] = new Immagine(fileName);
			// salva un filmato
			} else if (tipo.equals("Filmato")) {
				System.out.println("Digitare il nome del filmato:");
				String fileName = obj.nextLine();
				System.out.println("Qual è la durata del filmato?");
				int length = obj.nextInt();
				obj.nextLine();
				storage[i] = new Filmato(fileName, length);
			// salva una registrazione
			} else if (tipo.equals("Registrazione Audio")) {
				System.out.println("Digitare il nome della registrazione:");
				String fileName = obj.nextLine();
				System.out.println("Qual è la durata della registrazione?");
				int length = obj.nextInt();
				obj.nextLine();
				storage[i] = new RegistrazioneAudio(fileName, length);
			}
		}
		
		System.out.println("Quale file vuoi riprodurre? inserire un numero tra 1 e 5 oppure 0 per terminare");
		while (!obj.hasNextInt()) {
			System.out.println("Inserimento invalido, riprovare");
		}
		int index = obj.nextInt();
		if (index == 0) { return; }
		while (index != 0) {
			if (storage[index - 1] instanceof Immagine) {
				Immagine file = (Immagine) storage[index - 1];
				file.show();
				System.out.println("Vuoi modificare la luminosità? Digita + / - oppure un altro carattere per continuare");
				char option = obj.next().charAt(0);
				switch (option) {
				case '+':
					file.brighter();
					break;
				case '-':
					file.darker();
				default:
					break;
				}
			} else if (storage[index - 1] instanceof RegistrazioneAudio) {
				RegistrazioneAudio file = (RegistrazioneAudio) storage[index - 1];
				file.play();
				System.out.println("Vuoi modificare il volume? Digita + / - oppure un altro carattere per continuare");
				char option = obj.next().charAt(0);
				switch (option) {
				case '+':
					file.louder();
					break;
				case '-':
					file.weaker();
				default:
					break;
				}
			} else {
				Filmato file = (Filmato) storage[index - 1];
				file.play();
				System.out.println("Vuoi modificare la luminosità? Digita + / - oppure un altro carattere per continuare");
				char option = obj.next().charAt(0);
				switch (option) {
				case '+':
					file.brighter();
					break;
				case '-':
					file.darker();
				default:
					break;
				}
			}
			System.out.println("Quale file vuoi riprodurre? inserire un numero tra 1 e 5 oppure 0 per terminare");
			index = obj.nextInt();
		}
	}
	
}
