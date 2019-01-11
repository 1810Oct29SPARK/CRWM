package com.rev.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rev.beans.Patients;
import com.rev.beans.Player;
import com.rev.service.LoginService;
import com.rev.service.PatientService;

@Controller
public class PatientController {

	private PatientService patientInfo;
	
	@Autowired
	public PatientController(PatientService patientService) {
		super();
		this.patientInfo = patientService;
	}
	@GetMapping(value = "/patient")
	public String getStaticLogin() {
		return "forward:/static/staticQuery.html";
	}

	@PostMapping(value = "/patient", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String handleForm(@RequestBody MultiValueMap<String, String> formParams, Model m) {
		System.out.println("form params recieved: " + formParams);

		Patients pat = patientInfo.findPatient(formParams.getFirst("name"));
		if (pat == null) {
			return "error";
		} else {		
			m.addAttribute("Patient", pat);
			m.addAttribute("pname", pat.getFirst_Name() + " "+ pat.getLast_Name());
			m.addAttribute("disease",pat.getDisease().getDisease_name());
			m.addAttribute("symptom1",pat.getDisease().getSymptom().get(0).getSymptom_Name());
			m.addAttribute("symptom2",pat.getDisease().getSymptom().get(1).getSymptom_Name());
			m.addAttribute("symptom3",pat.getDisease().getSymptom().get(2).getSymptom_Name());
			return "patient";
		}		
	}
}