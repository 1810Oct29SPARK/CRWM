package com.rev.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rev.beans.Patients;
import com.rev.service.PatientService;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PatientController {

	private PatientService patientInfo;
	
	@Autowired
	public PatientController(PatientService patientService) {
		super();
		this.patientInfo = patientService;
	}
	
	@GetMapping(value="/{id}")
		public ResponseEntity<Patients> getPatientById(@PathVariable int id){
		Patients b = patientInfo.getPatientById(id);
		if (b == null) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(b, HttpStatus.OK);
		}
	}

	@GetMapping(value="/patients")
		public ResponseEntity<List<Patients>> getAllPatients(){
		return new ResponseEntity<>(patientInfo.getAllPatients(), HttpStatus.OK);
	}
}