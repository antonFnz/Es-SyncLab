import java.util.Scanner;

public class Question {
	
	private String question;
	private String answer;
	private int points;
		
	public Question(String question, String answer, int points) {
		super();
		this.question = question;
		this.answer = answer;
		this.points = points;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int ask() {
		System.out.println(this.question);
		Scanner obj = new Scanner(System.in);
		String answer = obj.nextLine();
		if (answer.equals(this.answer)) {
			return points;
		} else {
			return 0;
		}
	}
	
}
