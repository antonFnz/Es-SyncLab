package test;
import java.sql.Date;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@Column(name = "iduser")
	private int id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String pwd;
	
	@Column(name = "ruolo")
	private String role;
	
	@Column(name = "nome")
	private String name;
	
	@Column(name = "cognome")
	private String surname;
	
	@Column(name = "dataNascita")
	private Date date;
	
	public User() {
		
	}

	public User(String username, String pwd, String role, String name, String surname, Date date) {
		this.username = username;
		this.pwd = pwd;
		this.role = role;
		this.name = name;
		this.surname = surname;
		this.date = date;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}
	
}
