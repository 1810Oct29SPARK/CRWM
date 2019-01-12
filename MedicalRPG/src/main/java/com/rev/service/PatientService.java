package com.rev.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rev.beans.Patients;
import com.rev.beans.Player;
import com.rev.dao.PatientsDao;
import com.rev.daoimpl.PatientsDaoImpl;

@Service(value="patientService")
public class PatientService {

	PatientsDao pdao = new PatientsDaoImpl();

//	public Patients findPatient(String name) {
//		Patients patient = null;
//		List<Patients> patientList = pdao.getAllPatients();
//		if (name != null) {
//			for (Patients p : patientList) {
//				if (name.equals(p.getFirst_Name())) {
//					patient = p;
//					return patient;
//				}
//			}
//		}
//		return patient;
//	}
	public Patients getPatientById(int id) {
		return pdao.getPatientsByID(id);
	}
}
