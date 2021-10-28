
public class Main {
	
	public static void main(String[] args) {
		
		Person p = new Person("Fancello", "Anton", "FNCNNL95R20G015D", "Olbia");
		System.out.print(p.getName() + " ");
		System.out.print(p.getSurname() + " ");
		System.out.println(p.bornYear(p.getTaxCode()));
		
		Stagista[] s = new Stagista[3];
		
		s[0] = new Stagista("Fancello", "Anton", "FNCNNL95R20G015D", "Olbia", 20, 859595);
		s[1] = new Stagista("Samus", "Aran", "SMSRAN90R20G015D", "Zebes", 50, 873480);
		s[2] = new Stagista("Harvey", "Cecil", "HRVCCL98R20G015D", "Baron", 100, 444444);
		
		Stagista youngestSt = s[0];
		int minAgeYear = Integer.parseInt(s[0].bornYear(s[0].getTaxCode()));
		
		for (int i = 0; i < s.length; i++) {
			if (minAgeYear < Integer.parseInt(s[i].bornYear(s[i].getTaxCode()))) {
				minAgeYear = Integer.parseInt(s[i].bornYear(s[i].getTaxCode()));
				youngestSt = s[i];
			}
		}
		
		System.out.println("lo stagista più giovane è: " + youngestSt.getName() + " " + youngestSt.getSurname());
		
	}
	
}
