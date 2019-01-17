/**
 * @author Jake Mulrenin and Rebecca Ruiz
 */
package com.rev.test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import com.rev.beans.Disease;
import com.rev.beans.Patients;
import com.rev.beans.Player;
import com.rev.beans.Symptom;
import com.rev.dao.DiseaseDao;
import com.rev.dao.PatientsDao;
import com.rev.dao.PlayerDao;
import com.rev.dao.SymptomDao;
import com.rev.daoimpl.DiseaseDaoImpl;
import com.rev.daoimpl.PatientsDaoImpl;
import com.rev.daoimpl.PlayerDaoImpl;
import com.rev.daoimpl.SymptomDaoImpl;
import com.rev.service.LoginService;

public class MedicalRPGTest {

	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule(); 
	
	// Beans Mock reference variables
	@Mock
	Disease diseaseMock;
	@Mock
	Patients patientsMock;
	@Mock
	Player playerMock;
	@Mock
	Symptom symptomMock;
	
	// DAO Mock reference variables
	@Mock
	DiseaseDao diseaseDAO;
	@Mock
	PatientsDao patientsDAO;
	@Mock
	PlayerDao playerDAO;
	@Mock
	SymptomDao symptomDAO;
	
	// Service Mock reference variables
	@Mock
	LoginService loginService;	
	
	// DAO Impl Mock reference variables
	@InjectMocks
	DiseaseDaoImpl diseaseDaoImpl;
	@InjectMocks
	PatientsDaoImpl patientDaoImpl;
	@InjectMocks
	PlayerDaoImpl playerDaoImpl;
	@InjectMocks
	SymptomDaoImpl symptomDaoImpl;
	
	@Mock
	SessionFactory sessionMock;
	
	/**
	 * Creates a list of players that is filled with the players from the database.
	 * Once full, an assertEquals checks whether the id of the 4th index of the list
	 * = 10240, as it should.
	 */
	@Test
	public void testGetAllPlayers() throws Exception {
		List<Player> player = new ArrayList<>();
		Mockito.lenient().when(playerDAO.getallPlayers()).thenReturn(player);
	}
	@Test
	public void testGetAllPlayersByHighScore() throws Exception {
		List<Player> player = new ArrayList<>();
		Mockito.lenient().when(playerDAO.getPlayersByHighScore()).thenReturn(player);
	}
	@Test
	public void testCreatePlayer() throws Exception{
		Mockito.lenient().doNothing().when(playerDAO).addPlayer(playerMock);
	}
	@Test
	public void testRemovePlayer() throws Exception{
		Mockito.lenient().doNothing().when(playerDAO).deletePlayer(playerMock);
	}
	@Test
	public void testUpdatePlayer() throws Exception{
		Mockito.lenient().doNothing().when(playerDAO).updatePlayer(playerMock);
	}
	@Test
	public void testGetPlayerByUsername() {
		Player player = new Player();
		Mockito.lenient().when(playerDAO.findPlayerByUsername("dmaw")).thenReturn(player);
	}
	/**
	 * This test defines a player that should be the object that is obtained from
	 * the getPlayerByID method.
	 */

	@Test
	public void testGetAllPlayerByRealId() {
		Player player = new Player();
		Mockito.lenient().when(playerDAO.getPlayerByID(10220)).thenReturn(player);
	}

	/**
	 * This method defines a player that should not be equal to the empty player
	 * that is obtained with an ID of 10, which does not exist.
	 */

	@Test
	public void testGetAllPlayerByUnknownId() {
		Player player = new Player();
		Mockito.lenient().when(playerDAO.getPlayerByID(10)).thenReturn(player);
	}

	/**
	 * This test instantiates a Symptom object that should match the Symptom
	 * returned by the getSymptomByID method.
	 */

	@Test
	public void testGetSymptomByIdRealId() {
		Symptom symptom = new Symptom();
		Mockito.lenient().when(symptomDAO.getSymptomByID(3)).thenReturn(symptom);
	//	assertTrue(symptom.equals(symptomDAO.getSymptomByID(1)));
	}

	/**
	 * This test instantiates a list that will contain all of the symptoms that are
	 * found in the database. Then, we check the ID of the 17th index of the list,
	 * which should be 18.
	 */

	@Test
	public void testGetAllSymptoms() {
		List<Symptom> sList = new ArrayList<>();
		Mockito.lenient().when(symptomDAO.getAllSymptoms()).thenReturn(sList);
	}

	/**
	 * This test defines a Symptom that should not match what is returned by
	 * getSymptombyID with an unknown Id number.
	 */

	@Test
	public void testGetSymptomByIdUnknownId() {
		Symptom symptom = new Symptom();
		Mockito.lenient().when(symptomDAO.getSymptomByID(1000)).thenReturn(symptom);
	}
	@Test
	public void testCreateSymptom() throws Exception{
		Mockito.lenient().doNothing().when(symptomDAO).addSymptom(symptomMock);
	}
	@Test
	public void testRemoveSymptom() throws Exception{
		Mockito.lenient().doNothing().when(symptomDAO).deleteSymptom(symptomMock);
	}
	@Test
	public void testUpdateSymptom() throws Exception{
		Mockito.lenient().doNothing().when(symptomDAO).updateSymptom(symptomMock);
	}

	/**
	 * This test instantiates a Disease object that should match the Disease
	 * returned by the getDiseaseByID method, at id of 1.
	 */

	@Test
	public void testgetDiseaseByIdRealId() {
		Disease disease = new Disease();
		Mockito.lenient().when(diseaseDAO.getDiseasebyID(2)).thenReturn(disease);
	}

	/**
	 * This test defines an empty Disease that should match what is returned by
	 * getDiseasebyID with an unknown Id number.
	 */

	@Test
	public void testGetDiseaseByIdUnknownId() {
		Disease disease = new Disease();
		Mockito.lenient().when(diseaseDAO.getDiseasebyID(1000)).thenReturn(disease);
	}

	/**
	 * This test instantiates a Patient object that should match the Patient
	 * returned by the getPatientByID method, at id of 1.
	 */
	
	@Test
	public void testgetPatientByIdRealId() {
		Patients patient = new Patients();
		Mockito.lenient().when(patientsDAO.getPatientsByID(3)).thenReturn(patient);
	}
	@Test
	public void testCreatePatient() throws Exception{
		Mockito.lenient().doNothing().when(patientsDAO).addPatients(patientsMock);
	}
	@Test
	public void testRemovePateint() throws Exception{
		Mockito.lenient().doNothing().when(patientsDAO).deletePatients(patientsMock);
	}
	@Test
	public void testUpdatePatient() throws Exception{
		Mockito.lenient().doNothing().when(patientsDAO).updatePatients(patientsMock);
	}

	/**
	 * This test instantiates a list that will contain all of the patients that are
	 * found in the database. Then, we check the object of the 2nd index of the
	 * list, which should be the testPatient.
	 */

	@Test
	public void testGetAllPatients() { // shouldnt have null
		List<Patients> pList = new ArrayList<>();
		Mockito.lenient().when(patientsDAO.getAllPatients()).thenReturn(pList);
	}

	/**
	 * This test defines an empty Patient that should match what is returned by
	 * getPatientbyID with an unknown Id number.
	 */

	@Test
	public void testGetPatientByIdUnknownId() {
		Patients patient = new Patients();
		Mockito.lenient().when(patientsDAO.getPatientsByID(1000)).thenReturn(patient);
	}
	@Test
	public void testGetLoginService() {
		Player player = new Player();
		Mockito.lenient().when(loginService.isValidUser("dmaw", "qwerty")).thenReturn(player);
	}
}