package com.rev.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Summary *

 * Patient object takes in patient table information from the sql
 * @author Darius
 */
@Entity
@Table(name="PATIENTS")
public class Patients {

	public Patients(int patient_ID, String first_Name, String last_Name, int age, int disease_ID) {
		super();
		this.patient_ID = patient_ID;
		this.first_Name = first_Name;
		this.last_Name = last_Name;
		this.age = age;
		this.disease_ID = disease_ID;
	}
	public Patients() {
	
	}
	@Id
	/*@GeneratedValue(strategy=GenerationType.AUTO, generator="patientSequence")
	@SequenceGenerator(allocationSize= 1,name="patientSequence",sequenceName="SQ_PATIENT_PK")*/
	@Column(name="PATIENT_ID")
	private int patient_ID;
	@Column(name="FIRST_NAME")
	private String first_Name;
	@Column(name="LAST_NAME")
	private String last_Name;
	@Column(name="AGE")
	private int age;
	@Column(name="DISEASE_ID")
	private int disease_ID;

	public int getPatient_ID() {
		return patient_ID;
	}
	public void setPatient_ID(int patient_ID) {
		this.patient_ID = patient_ID;
	}
	public String getFirst_Name() {
		return first_Name;
	}
	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}
	public String getLast_Name() {
		return last_Name;
	}
	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getDisease_ID() {
		return disease_ID;
	}
	public void setDisease_ID(int disease_ID) {
		this.disease_ID = disease_ID;
	}
	@Override
	public String toString() {

		return "Patients [patient_ID=" + patient_ID + ", first_Name=" + first_Name + ", last_Name=" + last_Name
				+ ", age=" + age + ", disease_ID=" + disease_ID + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + disease_ID;
		result = prime * result + ((first_Name == null) ? 0 : first_Name.hashCode());
		result = prime * result + ((last_Name == null) ? 0 : last_Name.hashCode());
		result = prime * result + patient_ID;
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
		Patients other = (Patients) obj;
		if (age != other.age)
			return false;
		if (disease_ID != other.disease_ID)
			return false;
		if (first_Name == null) {
			if (other.first_Name != null)
				return false;
		} else if (!first_Name.equals(other.first_Name))
			return false;
		if (last_Name == null) {
			if (other.last_Name != null)
				return false;
		} else if (!last_Name.equals(other.last_Name))
			return false;
		if (patient_ID != other.patient_ID)
			return false;
		return true;
	}
	
	
}
