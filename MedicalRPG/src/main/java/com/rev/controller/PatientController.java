package com.rev.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rev.beans.Disease;
import com.rev.beans.Patients;
import com.rev.service.DiseaseService;
import com.rev.service.PatientService;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PatientController {

	private PatientService patientInfo;
	DiseaseService diseaseService = new DiseaseService();

	@Autowired
	public PatientController(PatientService patientService) {
		super();
		this.patientInfo = patientService;
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Patients> getPatientById(@PathVariable int id) {
		Patients b = patientInfo.getPatientById(id);
		Random r = new Random();
		int count = 0;
		List<Disease> dl = diseaseService.getAllDiseases();
		for (Disease d : dl) {
			count++;
		}
		int n = r.nextInt(count) + 1;
		Disease d = diseaseService.getDiseasebyID(n);
		b.setDisease(d);
		return new ResponseEntity<>(b, HttpStatus.OK);
	}

	@GetMapping(value = "/patients")
	public ResponseEntity<List<Patients>> getAllPatients() {
		return new ResponseEntity<>(patientInfo.getAllPatients(), HttpStatus.OK);
	}
}