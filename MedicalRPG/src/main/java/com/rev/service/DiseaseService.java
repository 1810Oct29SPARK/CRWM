package com.rev.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rev.beans.Disease;
import com.rev.dao.DiseaseDao;
import com.rev.daoimpl.DiseaseDaoImpl;

/**
 * 
 * @author Max Couch
 * 
 *         DiseaseService was originally unimplemented throughout most of the
 *         development process, but became necessary when we randomized diseases
 *         to patients. All normal CRUD methods were made in case there was a
 *         necessity in future iterations.
 *
 */

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
