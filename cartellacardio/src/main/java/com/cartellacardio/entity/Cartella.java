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
@Table(name="cartella")
public class Cartella {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idcartella")
	private int idcartella;
	
	@Column(name="anamnesi")
	private String anamnesis;
	
	@Column(name="motivoVisita")
	private String motive;
	
	@Column(name="pressione")
	private float pressure;
	
	@Column(name="frequenzaCardiaca")
	private float heartRate;
	
	@Column(name="peso")
	private int weight;
	
	@Column(name="altezza")
	private int height;
	
	@Column(name="vita")
	private int waist;
	
	@OneToOne(targetEntity=Medic.class, cascade=CascadeType.ALL)
	@JoinColumn(name="medico_idmedico")
	private Medic medic;
	
	@OneToOne(targetEntity=Patient.class, cascade=CascadeType.ALL)
	@JoinColumn(name="paziente_idpaziente")
	private Patient patient;
	
	public Cartella() {
		
	}

	public Cartella(String anamnesis, String motive, float pressure, float heartRate, int weight, int height, int waist,
			Medic medic, Patient patient) {
		super();
		this.anamnesis = anamnesis;
		this.motive = motive;
		this.pressure = pressure;
		this.heartRate = heartRate;
		this.weight = weight;
		this.height = height;
		this.waist = waist;
		this.medic = medic;
		this.patient = patient;
	}

	public int getIdcartella() {
		return idcartella;
	}

	public void setIdcartella(int idcartella) {
		this.idcartella = idcartella;
	}

	public String getAnamnesis() {
		return anamnesis;
	}

	public void setAnamnesis(String anamnesis) {
		this.anamnesis = anamnesis;
	}

	public String getMotive() {
		return motive;
	}

	public void setMotive(String motive) {
		this.motive = motive;
	}

	public float getPressure() {
		return pressure;
	}

	public void setPressure(float pressure) {
		this.pressure = pressure;
	}

	public float getHeartRate() {
		return heartRate;
	}

	public void setHeartRate(float heartRate) {
		this.heartRate = heartRate;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWaist() {
		return waist;
	}

	public void setWaist(int waist) {
		this.waist = waist;
	}

	public Medic getMedic() {
		return medic;
	}

	public void setMedic(Medic medic) {
		this.medic = medic;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "Cartella [idcartella=" + idcartella + ", anamnesis=" + anamnesis + ", motive=" + motive + ", pressure="
				+ pressure + ", heartRate=" + heartRate + ", weight=" + weight + ", height=" + height + ", waist="
				+ waist + ", medic=" + medic + ", patient=" + patient + "]";
	}
	
}
