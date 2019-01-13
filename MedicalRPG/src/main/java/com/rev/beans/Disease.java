package com.rev.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Summary* Disease will take in information from the disease table We have a
 * Many to many join table with Symptoms so that many diseases can have many
 * symptoms
 * 
 * @author Darius
 */

//select all from disease_symptom where disease_id = :disease_id
//@NamedQueries ({@NamedQuery (name="getDiseaseWithSymptoms", query="from DISEASE_SYMPTOMS WHERE DISEASE_ID = :DISEASE_ID")})

@Entity
@Table(name = "DISEASES")
public class Disease {

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "DISEASE_SYMPTOMS", joinColumns = { @JoinColumn(name = "DISEASE_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "SYMPTOM_ID") })
	private List<Symptom> symptom = new ArrayList<>();

	public Disease(int disease_id, String disease_name, String disease_description, List<Symptom> symptom) {
		super();
		this.disease_id = disease_id;
		this.disease_name = disease_name;
		this.disease_description = disease_description;
		this.symptom = symptom;
	}

//	public Disease(int disease_id, String disease_name, String disease_description) {
//		super();
//		this.disease_id = disease_id;
//		this.disease_name = disease_name;
//		this.disease_description = disease_description;
//	}
	
	public Disease() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column(name = "DISEASE_ID")
	private int disease_id;
	@Column(name = "DISEASE_NAME")
	private String disease_name;
	@Column(name = "DISEASE_DESCRIPTION")
	private String disease_description;

	public List<Symptom> getSymptom() {
		return symptom;
	}

	public void setSymptom(List<Symptom> symptom) {
		this.symptom = symptom;
	}

	public int getDisease_id() {
		return disease_id;
	}

	public void setDisease_id(int disease_id) {
		this.disease_id = disease_id;
	}

	public String getDisease_name() {
		return disease_name;
	}

	public void setDisease_name(String disease_name) {
		this.disease_name = disease_name;
	}

	public String getDisease_description() {
		return disease_description;
	}

	public void setDisease_description(String disease_description) {
		this.disease_description = disease_description;
	}

	

	@Override
	public String toString() {
		return "Disease [disease_id=" + disease_id + ", disease_name=" + disease_name
				+ ", disease_description=" + disease_description + ", symptom=" + symptom + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((disease_description == null) ? 0 : disease_description.hashCode());
		result = prime * result + disease_id;
		result = prime * result + ((disease_name == null) ? 0 : disease_name.hashCode());
		result = prime * result + ((symptom == null) ? 0 : symptom.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disease other = (Disease) obj;
		if (disease_description == null) {
			if (other.disease_description != null)
				return false;
		} else if (!disease_description.equals(other.disease_description))
			return false;
		if (disease_id != other.disease_id)
			return false;
		if (disease_name == null) {
			if (other.disease_name != null)
				return false;
		} else if (!disease_name.equals(other.disease_name))
			return false;
		if (symptom == null) {
			if (other.symptom != null)
				return false;
		} else if (!symptom.equals(other.symptom))
			return false;
		return true;
	}

}
