package com.rev.dao;

import java.util.List;

import com.rev.beans.Patients;

public interface PatientsDao {
	public Patients getPatientsByID(int id);
	public List<Patients> getAllPatients();
	public void updatePatients(Patients patients);
	public void addPatients(Patients patients);
	public void deletePatients(Patients patients);
}
