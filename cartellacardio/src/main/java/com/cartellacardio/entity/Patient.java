package com.cartellacardio.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="paziente")
public class Patient {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idpaziente")
	private int id;
	
	@Column(name="sesso")
	private String gender;
	
	@Column(name="fumatore")
	private boolean smoker;
	
	@Column(name="diabetico")
	private boolean diabetic;
	
	@OneToOne(targetEntity=User.class, cascade=CascadeType.ALL)
	@JoinColumn(name="user_iduser")
	private User user;
	
	public Patient() {
		
	}

	public Patient(String gender, boolean smoker, boolean diabetic, User user) {
		super();
		this.gender = gender;
		this.smoker = smoker;
		this.diabetic = diabetic;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isSmoker() {
		return smoker;
	}

	public void setSmoker(boolean smoker) {
		this.smoker = smoker;
	}

	public boolean isDiabetic() {
		return diabetic;
	}

	public void setDiabetic(boolean diabetic) {
		this.diabetic = diabetic;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", gender=" + gender + ", smoker=" + smoker + ", diabetic=" + diabetic + ", user="
				+ user + "]";
	}
	
}
