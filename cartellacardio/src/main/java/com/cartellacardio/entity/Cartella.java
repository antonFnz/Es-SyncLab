package com.cartellacardio.entity;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
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
	
	@Column(name="notaMedico")
	private String medicNote;
	
	@Column(name="notaPaziente")
	private String patientNote;
	
	@OneToOne(targetEntity=Patient.class, cascade=CascadeType.ALL)
	@JoinColumn(name="paziente_idpaziente")
	private Patient patient;
	
	public Cartella() {
		
	}

	public Cartella(String anamnesis, String motive, float pressure, float heartRate, int weight, int height, int waist,
			String medicNote, String patientNote, Medic medic, Patient patient) {
		this.anamnesis = anamnesis;
		this.motive = motive;
		this.pressure = pressure;
		this.heartRate = heartRate;
		this.weight = weight;
		this.height = height;
		this.waist = waist;
		this.medicNote = medicNote;
		this.patientNote = patientNote;
		this.patient = patient;
	}
	
	public int calcAge(Date dob) {
		Instant instant = Instant.ofEpochMilli(dob.getTime());
		LocalDate dateOfBirth = LocalDate.ofInstant(instant, ZoneId.systemDefault());;
		LocalDate currDate = LocalDate.now();
		return Period.between(dateOfBirth, currDate).getYears();
	}
	
	public double calcRisk() {
		double risk_factors =
				(Math.log((double) this.calcAge(this.getPatient().getUser().getBirthDate())) * 3.06117) +
				(Math.log((double) this.getPressure()) * 1.93303) +
				(Math.log(200) * 1.12370) -
				(Math.log(50) * 0.93263) +
				- 23.9802;
		if(this.patient.isSmoker()) { risk_factors+= 0.65451; }
		if(this.patient.isDiabetic()) { risk_factors+= 0.57367; }
		double risk = 100 * (1 - (Math.pow(0.88936, 1/Math.pow(2.71828, -risk_factors))));
		return risk;
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
	
	public String getMedicNote() {
		return medicNote;
	}

	public void setMedicNote(String medicNote) {
		this.medicNote = medicNote;
	}

	public String getPatientNote() {
		return patientNote;
	}

	public void setPatientNote(String patientNote) {
		this.patientNote = patientNote;
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
				+ waist + ", medicNote=" + medicNote + ", patientNote=" + patientNote + ", patient=" + patient + "]";
	}
	
}
