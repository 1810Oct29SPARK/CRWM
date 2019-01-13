package com.rev.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rev.beans.Patients;
import com.rev.beans.Player;
import com.rev.dao.PatientsDao;
import com.rev.daoimpl.PatientsDaoImpl;

@Service(value = "patientService")
public class PatientService {

	PatientsDao pdao = new PatientsDaoImpl();

	public Patients getPatientById(int id) {
		return pdao.getPatientsByID(id);
	}

	public List<Patients> getAllPatients() {
		return pdao.getAllPatients();
	}

	public void updatePatients(Patients patients) {
		
	}

	public void addPatients(Patients patients) {
		
	}

	public void deletePatients(Patients patients) {
		
	}
}
