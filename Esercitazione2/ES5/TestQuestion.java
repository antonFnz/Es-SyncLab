import java.util.ArrayList;
import java.util.Random;

public class TestQuestion {
	
	public static void main(String[] args) {
		
		ArrayList<Question> qs = new ArrayList<Question>(4);
		
		int result = 0;
		int maxPoints = 0;
		
		qs.add(new Question("Domanda", "Risposta", 15));
		qs.add(new QuestionYesNo("DomandaSiNo", "Sì", 20));
		qs.add(new NumericQuestion("DomandaNum", "42", 25));
		qs.add(new MultipleQuestion("DomandaMul: 1, 2, 3, 4", "2", 30));
		
		Random rd = new Random();
		
		for (int i = 0; i < 3; i++) {
			int index = rd.nextInt(qs.size() - 1);
			result += qs.get(index).ask();
			maxPoints += qs.get(index).getPoints();
			qs.remove(index);
		}
		
		System.out.println("Hai ottenuto un punteggio di: " + result + "/" + maxPoints);
		
	}
	
}
