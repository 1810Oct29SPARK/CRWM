package com.rev.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Summary * Takes in symptom from sql symptoms table Use a join table to
 * connect the many to many operation to Disease
 * 
 * @author Darius
 */

@Entity
@Table(name = "SYMPTOMS")
public class Symptom {

	@ManyToMany(mappedBy = "symptom", fetch = FetchType.LAZY)
	private Set<Disease> diseases = new HashSet<>();

	public Symptom(int symptom_ID, String symptom_Name, String symptom_Description, String is_Observable,
			String is_Testable, String symptom_Test) {
		super();
		this.symptom_ID = symptom_ID;
		this.symptom_Name = symptom_Name;
		this.symptom_Description = symptom_Description;
		this.is_Observable = is_Observable;
		this.is_Testable = is_Testable;
		this.symptom_Test = symptom_Test;
	}

	public Symptom() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column(name = "SYMPTOM_ID")
	private int symptom_ID;
	@Column(name = "SYMPTOM_NAME")
	private String symptom_Name;
	@Column(name = "SYMPTOM_DESCRIPTION")
	private String symptom_Description;
	@Column(name = "IS_OBSERVABLE")
	private String is_Observable;
	@Column(name = "IS_TESTABLE")
	private String is_Testable;
	@Column(name = "SYMPTOM_TEST")
	private String symptom_Test;

	public int getSymptom_ID() {
		return symptom_ID;
	}

	public void setSymptom_ID(int symptom_ID) {
		this.symptom_ID = symptom_ID;
	}

	public String getSymptom_Name() {
		return symptom_Name;
	}

	public void setSymptom_Name(String symptom_Name) {
		this.symptom_Name = symptom_Name;
	}

	public String getSymptom_Description() {
		return symptom_Description;
	}

	public void setSymptom_Description(String symptom_Description) {
		this.symptom_Description = symptom_Description;
	}

	public String getIs_Observable() {
		return is_Observable;
	}

	public void setIs_Observable(String is_Observable) {
		this.is_Observable = is_Observable;
	}

	public String getIs_Testable() {
		return is_Testable;
	}

	public void setIs_Testable(String is_Testable) {
		this.is_Testable = is_Testable;
	}

	public String getSymptom_Test() {
		return symptom_Test;
	}

	public void setSymptom_Test(String symptom_Test) {
		this.symptom_Test = symptom_Test;
	}

	@Override
	public String toString() {
		return "Symptom [diseases=" + diseases + ", symptom_ID=" + symptom_ID + ", symptom_Name=" + symptom_Name
				+ ", symptom_Description=" + symptom_Description + ", is_Observable=" + is_Observable + ", is_Testable="
				+ is_Testable + ", symptom_Test=" + symptom_Test + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((diseases == null) ? 0 : diseases.hashCode());
		result = prime * result + ((is_Observable == null) ? 0 : is_Observable.hashCode());
		result = prime * result + ((is_Testable == null) ? 0 : is_Testable.hashCode());
		result = prime * result + ((symptom_Description == null) ? 0 : symptom_Description.hashCode());
		result = prime * result + symptom_ID;
		result = prime * result + ((symptom_Name == null) ? 0 : symptom_Name.hashCode());
		result = prime * result + ((symptom_Test == null) ? 0 : symptom_Test.hashCode());
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
		Symptom other = (Symptom) obj;
		if (diseases == null) {
			if (other.diseases != null)
				return false;
		} else if (!diseases.equals(other.diseases))
			return false;
		if (is_Observable == null) {
			if (other.is_Observable != null)
				return false;
		} else if (!is_Observable.equals(other.is_Observable))
			return false;
		if (is_Testable == null) {
			if (other.is_Testable != null)
				return false;
		} else if (!is_Testable.equals(other.is_Testable))
			return false;
		if (symptom_Description == null) {
			if (other.symptom_Description != null)
				return false;
		} else if (!symptom_Description.equals(other.symptom_Description))
			return false;
		if (symptom_ID != other.symptom_ID)
			return false;
		if (symptom_Name == null) {
			if (other.symptom_Name != null)
				return false;
		} else if (!symptom_Name.equals(other.symptom_Name))
			return false;
		if (symptom_Test == null) {
			if (other.symptom_Test != null)
				return false;
		} else if (!symptom_Test.equals(other.symptom_Test))
			return false;
		return true;
	}

}
