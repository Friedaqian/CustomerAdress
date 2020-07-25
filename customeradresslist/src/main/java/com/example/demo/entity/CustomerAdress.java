package com.example.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity

public class CustomerAdress {

	@Id
	@GeneratedValue
	private int ID;

	@NotEmpty
	
	private String Vorname;
	@NotEmpty
	
	private String Nachname;
	@NotEmpty
	
	private String Straße;
	@NotEmpty
	
	private String Hausnummer;
	@NotEmpty
	
	private String PLZ;
	@NotEmpty

	private String Ort;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getVorname() {
		return Vorname;
	}

	public void setVorname(String vorname) {
		Vorname = vorname;
	}

	public String getNachname() {
		return Nachname;
	}

	public void setNachname(String nachname) {
		Nachname = nachname;
	}

	public String getStraße() {
		return Straße;
	}

	public void setStraße(String straße) {
		Straße = straße;
	}

	public String getHausnummer() {
		return Hausnummer;
	}

	public void setHausnummer(String hausnummer) {
		Hausnummer = hausnummer;
	}

	public String getPLZ() {
		return PLZ;
	}

	public void setPLZ(String pLZ) {
		PLZ = pLZ;
	}

	public String getOrt() {
		return Ort;
	}

	public void setOrt(String ort) {
		Ort = ort;
	}

}
