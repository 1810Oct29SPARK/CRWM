package com.rev.dao;

import java.util.List;

import com.rev.beans.Patients;

/**
 * @author Max Couch 
 * 
 * This creates basic CRUD methods. Please refer to Impl for specifics.
 */

public interface PatientsDao {
	public Patients getPatientsByID(int id);
	public List<Patients> getAllPatients();
	public void updatePatients(Patients patients);
	public void addPatients(Patients patients);
	public void deletePatients(Patients patients);
}
