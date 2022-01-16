package test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestJDBC {

	public static void main(String[] args) {
		
		String dbUrl = "jdbc:mysql://localhost:3306/ospedaledb?useSSL=false";
		String user = "root";
		String password = "root";
		
		try {
			System.out.println("Connecting to DB: " + dbUrl);
			Connection conn = DriverManager.getConnection(dbUrl, user, password);
			System.out.println("Connection successful");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(User.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			long millis=System.currentTimeMillis();
			Date date = new Date(millis);
			User U1 = new User("carlo76", "prova123", "paziente", "Carlo", "Attrezzi", date);
			
			session.beginTransaction();
			
			session.save(U1);
			
			session.getTransaction().commit();
			System.out.println("fatto!");
		}
		finally {
			factory.close();
		}
		
	}

}
