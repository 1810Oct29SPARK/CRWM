package com.revature.test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.rev.Beans.Credentials;
import com.rev.Beans.Player;
import com.rev.Dao.PlayerDao;
import com.rev.DaoImpl.PlayerDaoImpl;
import com.rev.Service.AuthenticationService;

public class MedicalRPGTest {

	private static final PlayerDao playerDao = new PlayerDaoImpl();
	private static final SymptomDao symptomDao = new SymptomDaoImpl();
	private static final DiseaseDao diseaseDao = new DiseaseDaoImpl();
	private static final PatientsDao patientsDao = new PatientsDaoImpl();
	private static final LeaderBoardDao leaderboardDao = new LeaderBoardDaoImpl();
	private static final AuthenticationService auth = new AuthenticationService();

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void testGetAllPlayers() {
		List<Player> pList = new ArrayList<>();
		pList = playerDao.getallPlayers();
		assertEquals(10240, pList.get(4).getId());
	}
	@Test
	public void testGetAllPlayerByRealId() {
		Player testPlayer = new Player(10250, "hdurrell0@indigo.com","yTXA0LXDON","Herby","Durrell",796121652,"false");
		assertTrue(testPlayer.equals(playerDao.getPlayerbyID(10250)));
	}
	@Test
	public void testGetAllPlayerByUnknownId() {
		Player testPlayer = new Player(10250, "hdurrell0@indigo.com","yTXA0LXDON","Herby","Durrell",796121652,"false");
		assertFalse(testPlayer.equals(playerDao.getPlayerbyID(10)));
	}
	@Test
	public void testIsValidUserReal() {
		AuthenticationService auth = new AuthenticationService();
		Credentials cred = new Credentials("hdurrell0@indigo.com","yTXA0LXDON");
		Player p = new Player(10250, "hdurrell0@indigo.com","yTXA0LXDON","Herby","Durrell",796121652,"false");
		assertEquals(p,auth.isValidUser(cred));
	}
	@Test
	public void testIsValidUserIncorrectEmail() {
		Credentials cred = new Credentials("h@indigo.com","yTXA0LXDON");
		Player p = new Player(10250, "hdurrell0@indigo.com","yTXA0LXDON","Herby","Durrell",796121652,"false");
		assertFalse(p.equals(auth.isValidUser(cred)));
	}
	@Test
	public void testIsValidUserIncorrectPassword() {
		Credentials cred = new Credentials("hdurrell0@indigo.com","y");
		Player p = new Player(10250, "hdurrell0@indigo.com","yTXA0LXDON","Herby","Durrell",796121652,"false");
		assertFalse(p.equals(auth.isValidUser(cred)));
	}
	@Test
	public void testIsValidUserNullCredentials() {
		Credentials cred = new Credentials(null,null);
		Player p = new Player(10250, "hdurrell0@indigo.com","yTXA0LXDON","Herby","Durrell",796121652,"false");
		assertFalse(p.equals(auth.isValidUser(cred)));
	}
	
	/*public Symptom getSymptombyID(int id);
	public List<Symptom> getallSymptom();
	public void updateSymptom(Symptom symptom);
	public void addSymptom(Symptom symptom);
	public void deleteSymptom(Symptom symptom);*/
	@Test
	public void testgetSymptomByIdRealId() {
		Symptom thisSymptom = new Symptom(1, "Frequent Urination","Patient is urinating very often","yes","no",null);
		assertTrue(thisSymptom.equals(symptomDao.getSymptombyID(1)));
	}
	@Test
	public void testGetAllSymptoms() {
		List<Symptom> sList = new ArrayList<>();
		sList = symptomDao.getallPlayers();
		assertEquals(18, sList.get(17).getId());
	}
	@Test
	public void testGetSymptomByIdUnknownId() {
		Symptom testSymptom = new Symptom(1, "Frequent Urination","Patient is urinating very often","yes","no",null);
		assertFalse(testSymptom.equals(symptomDao.getSymptombyID(1000)));
	}
	@Test
	public void testgetDiseaseByIdRealId() {
		Disease thisDisease = new Disease(1, "Frequent Urination","Patient is urinating very often","yes","no",null);
		assertTrue(thisDisease.equals(diseaseDao.getDiseasebyID(1)));
	}
	@Test
	public void testGetAllDiseases() {
		List<Disease> dList = new ArrayList<>();
		dList = diseaseDao.getallDiseases();
		Disease testDisease = new Disease(4,"Leukemia", "Cancer of the blood-forming tissue in the body");
		assertTrue(testDisease.equals(dList.get(3)));
	}
	@Test
	public void testGetDiseaseByIdUnknownId() {
		Disease testDisease = new Disease(null,null,null);
		assertTrue(testDisease.equals(diseaseDao.getDiseasebyID(1000)));
	}
	1	Hannah	Smith	46	1
	@Test
	public void testgetPatientByIdRealId() {
		Patient thisPatient = new Patient(1, "Hannah","Smith",46,1);
		assertTrue(thisPatient.equals(patientsDao.getPatientbyID(1)));
	}
	@Test
	public void testGetAllPatients() {
		List<Patient> pList = new ArrayList<>();
		pList = patientsDao.getallPatients();
		Patient testPatient = new Patient(3,"Alex",	"Sanchez",82,3);
		assertTrue(testPatient.equals(pList.get(2)));
	}
	@Test
	public void testGetPatientByIdUnknownId() {
		Patient testPatient = new Patient(null,null,null,null,null);
		assertTrue(testPatient.equals(patientsDao.getPatientbyID(1000)));
	}
	@Test
	public void testgetLeaderboardByIdRealId() {
		LeaderBoard thisLeaderboard = new LeaderBoard(5,"hdurrell0",796121652);
		assertTrue(thisLeaderboard.equals(leaderboardDao.getLeaderBoardbyID(5)));
	}
	@Test
	public void testGetAllLeaderBoards() {
		List<LeaderBoard> lList = new ArrayList<>();
		lList = leaderboardDao.getallLeaderBoards();
		LeaderBoard testLeaderboard = new LeaderBoard(5,"hdurrell0",796121652);
		assertTrue(testLeaderboard.equals(lList.get(4)));
	}
	@Test
	public void testGetLeaderBoardByIdUnknownId() {
		LeaderBoard testLeaderboard = new LeaderBoard(null,null,null);
		assertTrue(testLeaderboard.equals(leaderboardDao.getPatientbyID(1000)));
	}
}
