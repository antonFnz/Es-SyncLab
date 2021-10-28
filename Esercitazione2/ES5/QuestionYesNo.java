import java.util.Scanner;

public class QuestionYesNo extends Question {

	public QuestionYesNo(String question, String answer, int points) {
		super(question, answer, points);
		while (!(answer.equals("Sì") || answer.equals("No"))) {
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
		while(!(answer.equals("Sì") || answer.equals("No"))) {
			System.out.println("La domanda richiede una risposta tra Sì/No, riprovare:");
			answer = obj.nextLine();
		}
		if (answer.equals(this.getAnswer())) {
			return this.getPoints();
		} else {
			return 0;
		}
	}
	
}
