import java.util.Scanner;

public class MultipleQuestion extends NumericQuestion {
	
	public MultipleQuestion(String question, String answer, int points) {
		super(question, answer, points);
		while (!answer.matches("[1-4]")) {
			System.out.println("Formulazione invalida della domanda [" + question + "] inserire una risposta valida:");
			Scanner obj = new Scanner(System.in);
			String newAnswer = obj.nextLine();
			answer = newAnswer;
			this.setAnswer(newAnswer);
		}
	}
	
	@Override
	public int ask() {
		System.out.println(this.getQuestion());
		Scanner obj = new Scanner(System.in);
		String answer = obj.nextLine();
		while(!answer.matches("[1-4]")) {
			System.out.println("La domanda richiede una risposta tra le opzioni da 1 a 4, riprovare:");
			answer = obj.nextLine();
		}
		if (answer.equals(this.getAnswer())) {
			return this.getPoints();
		} else {
			return 0;
		}
	}
	
}
