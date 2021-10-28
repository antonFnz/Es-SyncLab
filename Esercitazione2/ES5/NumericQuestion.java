import java.util.Scanner;

public class NumericQuestion extends Question {
	
	public NumericQuestion(String question, String answer, int points) {
		super(question, answer, points);
		while (!answer.matches("0|[1-9]\\d*")) {
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
		while(!answer.matches("0|[1-9]\\d*")) {
			System.out.println("La domanda richiede una risposta che sia un intero, riprovare:");
			answer = obj.nextLine();
		}
		if (answer.equals(this.getAnswer())) {
			return this.getPoints();
		} else {
			return 0;
		}
	}
	
}
