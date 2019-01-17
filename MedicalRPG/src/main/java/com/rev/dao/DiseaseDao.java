package com.rev.dao;

import java.util.List;

/**
 * @author Max Couch 
 * 
 * This creates basic CRUD methods. Please refer to Impl for specifics.
 */

import com.rev.beans.Disease;

public interface DiseaseDao {
	public Disease getDiseasebyID(int id);
	public List<Disease> getAllDiseases();
	public void updateDisease(Disease disease);
	public void addDisease(Disease disease);
	public void deleteDisease(Disease disease);
}
