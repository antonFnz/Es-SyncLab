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
@Table(name="medico")
public class Medic {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idmedico")
	private int idmedico;
	
	@Column(name="specializzazione")
	private String special;
	
	@Column(name="ospedale")
	private String hospital;
	
	@OneToOne(targetEntity=User.class, cascade=CascadeType.ALL)
	@JoinColumn(name="user_iduser")
	private User user;
	
	public Medic() {
		
	}

	public Medic(int idmedico, String special, String hospital, User user) {
		super();
		this.idmedico = idmedico;
		this.special = special;
		this.hospital = hospital;
		this.user = user;
	}

	public int getIdmedico() {
		return idmedico;
	}

	public void setIdmedico(int idmedico) {
		this.idmedico = idmedico;
	}

	public String getSpecial() {
		return special;
	}

	public void setSpecial(String special) {
		this.special = special;
	}

	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Medic [idmedico=" + idmedico + ", special=" + special + ", hospital=" + hospital + ", user=" + user
				+ "]";
	}

}
