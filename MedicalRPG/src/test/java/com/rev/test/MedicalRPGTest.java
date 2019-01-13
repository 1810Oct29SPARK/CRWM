/**
 * @author Jake Mulrenin
 */
package com.rev.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.rev.beans.Credentials;
import com.rev.beans.Disease;
import com.rev.beans.LeaderBoard;
import com.rev.beans.Patients;
import com.rev.beans.Player;
import com.rev.beans.Symptom;
import com.rev.dao.DiseaseDao;
import com.rev.dao.LeaderBoardDao;
import com.rev.dao.PatientsDao;
import com.rev.dao.PlayerDao;
import com.rev.dao.SymptomDao;
import com.rev.daoimpl.DiseaseDaoImpl;
import com.rev.daoimpl.LeaderBoardDaoImpl;
import com.rev.daoimpl.PatientsDaoImpl;
import com.rev.daoimpl.PlayerDaoImpl;
import com.rev.daoimpl.SymptomDaoImpl;
import com.rev.service.AuthenticationService;

public class MedicalRPGTest {
    private static final PlayerDao playerDao = new PlayerDaoImpl();
    private static final SymptomDao symptomDao = new SymptomDaoImpl();
    private static final DiseaseDao diseaseDao = new DiseaseDaoImpl();
    private static final PatientsDao patientsDao = new PatientsDaoImpl();
    private static final LeaderBoardDao leaderboardDao = new LeaderBoardDaoImpl();
    private static final AuthenticationService auth = new AuthenticationService();
    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    /**
     * Creates a list of players that is filled with the players
     * from the database. Once full, an assertEquals checks whether
     * the id of the 4th index of the list = 10240, as it should.
     */
    @Test
    public void testGetAllPlayers() {
        List<Player> pList = new ArrayList<>();
        pList = playerDao.getallPlayers();
        assertEquals(10350, pList.get(4).getId());
    }
    /**
     * This test defines a player that should be the object that 
     * is obtained from the getPlayerByID method.
     */
    @Test
    public void testGetAllPlayerByRealId() {
        Player testPlayer = new Player(10220,"lberridge91","Ks7bPBfIqX",609301551,"Lazare","Berridge","false",null);
        System.out.println(playerDao.getPlayerByID(10220));
        assertTrue(testPlayer.equals(playerDao.getPlayerByID(10220)));
    }
    /**
     * This method defines a player that should not be equal to 
     * the empty player that is obtained with an ID of 10, which
     * does not exist.
     */
    @Test
    public void testGetAllPlayerByUnknownId() {
        assertEquals(null,(playerDao.getPlayerByID(10)));
    }
    /**
     * This test case checks the username and password of the player
     * defined within this function. If the username and password 
     * matches what is in the database for this user, isValidUser
     * should return that player.
     */
    @Test
    public void testIsValidUserReal() {
        AuthenticationService auth = new AuthenticationService();
        Credentials cred = new Credentials("lberridge91","Ks7bPBfIqX");
        Player p = new Player(10220,"lberridge91","Ks7bPBfIqX",609301551,"Lazare","Berridge","false",null);
        assertEquals(p,auth.isValidUser(cred));
    }
    /**
     * Given incorrect email, the method, isValidUser, should 
     * not return the player.
     */
    @Test
    public void testIsValidUserIncorrectEmail() {
        Credentials cred = new Credentials("h@indigo.com","yTXA0LXDON");
        Player p = new Player(10250, "hdurrell0@indigo.com","yTXA0LXDON",796121652,"Durrell","Herby","false",null);
        assertFalse(p.equals(auth.isValidUser(cred)));
    }
    /**
     *Given incorrect password, the method, isValidUser, should 
     * not return the player.
     */
    @Test
    public void testIsValidUserIncorrectPassword() {
        Credentials cred = new Credentials("hdurrell0@indigo.com","y");
        Player p = new Player(10250, "hdurrell0@indigo.com","yTXA0LXDON",796121652,"Durrell","Herby","false",null);
        assertFalse(p.equals(auth.isValidUser(cred)));
    }
    /**
     * Given null credentials, the function, isValidUser, should 
     * not return any player
     */
    @Test
    public void testIsValidUserNullCredentials() {
        Credentials cred = new Credentials(null,null);
        Player p = new Player(10250, "hdurrell0@indigo.com","yTXA0LXDON",796121652,"Durrell","Herby","false",null);
        assertFalse(p.equals(auth.isValidUser(cred)));
    }
    /**
     * This test instantiates a Symptom object that should match
     * the Symptom returned by the getSymptomByID method.
     */
    @Test
    public void testgetSymptomByIdRealId() {
        Symptom thisSymptom = new Symptom(1, "Frequent Urination","Patient is urinating very often","yes","no",null);
        assertTrue(thisSymptom.equals(symptomDao.getSymptomByID(1)));
    }
    /**
     * This test instantiates a list that will contain all of the 
     * symptoms that are found in the database. Then, we check the ID
     * of the 17th index of the list, which should be 18.
     */
    @Test
    public void testGetAllSymptoms() {
        List<Symptom> sList = new ArrayList<>();
        sList = symptomDao.getAllSymptoms();
        assertEquals(18, sList.get(17).getSymptom_ID());
    }
    /**
     * This test defines a Symptom that should not match what is 
     * returned by getSymptombyID with an unknown Id number.
     */
    @Test
    public void testGetSymptomByIdUnknownId() {
        Symptom testSymptom = new Symptom(1, "Frequent Urination","Patient is urinating very often","yes","no",null);
        assertFalse(testSymptom.equals(symptomDao.getSymptomByID(1000)));
    }
    /**
     * This test instantiates a Disease object that should match
     * the Disease returned by the getDiseaseByID method, at id of 
     * 1.
     */
    @Test
    public void testgetDiseaseByIdRealId() {
        Disease thisDisease = new Disease(1, "Diabetes", "A blood disease that restricts the breakdown of glucose");
        assertTrue(thisDisease.equals(diseaseDao.getDiseasebyID(1)));
    }
    /**
     * This test instantiates a list that will contain all of the 
     * diseases that are found in the database. Then, we check the object
     * of the 3rd index of the list, which should be the testDisease.
     */
    @Test
    public void testGetAllDiseases() {
        List<Disease> dList = new ArrayList<>();
        dList = diseaseDao.getAllDiseases();
        Disease testDisease = new Disease(4,"Leukemia", "Cancer of the blood-forming tissue in the body");
        assertTrue(testDisease.equals(dList.get(3)));
    }
    /**
     * This test defines an empty Disease that should match what is 
     * returned by getDiseasebyID with an unknown Id number.
     */
    @Test
    public void testGetDiseaseByIdUnknownId() {
        assertEquals(null,(diseaseDao.getDiseasebyID(1000)));
    }
    /**
     * This test instantiates a Patient object that should match
     * the Patient returned by the getPatientByID method, at id of 
     * 1.
     */
    @Test
    public void testgetPatientByIdRealId() {
        Patients thisPatient = new Patients(1, "Hannah","Smith",46,1);
        assertTrue(thisPatient.equals(patientsDao.getPatientsByID(1)));
    }
    /**
     * This test instantiates a list that will contain all of the 
     * patients that are found in the database. Then, we check the object
     * of the 2nd index of the list, which should be the testPatient.
     */
    @Test
    public void testGetAllPatients() {
        List<Patients> pList = new ArrayList<>();
        pList = patientsDao.getAllPatients();
        Patients testPatient = new Patients(3,"Alex",   "Sanchez",82,3);
        assertTrue(testPatient.equals(pList.get(2)));
    }
    /**
     * This test defines an empty Patient that should match what is 
     * returned by getPatientbyID with an unknown Id number.
     */
    @Test
    public void testGetPatientByIdUnknownId() {
        assertEquals(null,(patientsDao.getPatientsByID(1000)));
    }
    /**
     * This test instantiates a LeaderBoard object that should match
     * the LeaderBoard entry  returned by the getLeaderBoardByID method, at id of 
     * 5.
     */
    @Test
    public void testgetLeaderboardByIdRealId() {
        LeaderBoard thisLeaderboard = new LeaderBoard();
        assertTrue(thisLeaderboard.equals(leaderboardDao.getLeaderBoardbyID(5)));
    }
    /**
     * This test instantiates a list that will contain all of the 
     * LeaderBoard entries that are found in the database. Then, we check the object
     * of the 4td index of the list, which should be the testLeaderboard.
     */
    @Test
    public void testGetAllLeaderBoards() {
        List<LeaderBoard> lList = new ArrayList<>();
        lList = leaderboardDao.getAllLeaderBoards();
        LeaderBoard testLeaderboard = new LeaderBoard();
        assertTrue(testLeaderboard.equals(lList.get(4)));
    }
    /**
     * This test defines an empty LeaderBoard that should match what is 
     * returned by getLeaderBoardbyID with an unknown Id number.
     */
    @Test
    public void testGetLeaderBoardByIdUnknownId() {
        LeaderBoard testLeaderboard = new LeaderBoard();
        assertTrue(testLeaderboard.equals(leaderboardDao.getLeaderBoardbyID(1000)));
    }
}