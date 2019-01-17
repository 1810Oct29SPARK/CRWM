package com.rev.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rev.beans.Disease;
import com.rev.dao.DiseaseDao;
import com.rev.daoimpl.DiseaseDaoImpl;

@Service(value = "diseaseService")
public class DiseaseService {

	DiseaseDao dd = new DiseaseDaoImpl();

	public Disease getDiseasebyID(int id) {
		return dd.getDiseasebyID(id);
	}

	public List<Disease> getAllDiseases() {
		return dd.getAllDiseases();
	}

	public void updateDisease(Disease disease) {
		dd.updateDisease(disease);
	}

	public void addDisease(Disease disease) {
		dd.addDisease(disease);
	}

	public void deleteDisease(Disease disease) {
		dd.deleteDisease(disease);
	}

}
