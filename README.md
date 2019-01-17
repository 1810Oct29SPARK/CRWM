# CRWM
Medical RPG

<h3>Authors: Rebecca, Jake, Darius, Max</h3>

Welcome to Diagnosis.

<h1>Synopsis:</h1> 

Diagnosis is a text RPG where the player simulates a doctor's interactions with their patients. They are to speak with, observe, and run tests to gather information on the patient's symptoms. The player is given a sheet of disease descriptions, and references that sheet against information gathered about what ails the patient. Once the player in confident, they can choose to diagnose the patient. A correct diagnosis will award points to the player. The faster the diagnosis, the more points awarded. Should the player misdiagnose the patient, they will recieve no points, and must move on to the next patient. High scores are gathered between players, and a Top-5-Leaderboard is displayed on the login page. The player can register a new account, login with their credentials, and change their information if needed.

<h1>Database:</h1> 

In our SQL Developer, we have 5 tables of information to apply to the Client-side: Player, Patients, Diseases, Symptoms, and Disease_Symptoms. 

The Player table consists of 8 columns: Player_ID PK, player_password, first_name, last_name, high_scores, id_dev, and username.

The Patients table consists of 5 columns: a PK ID, first_name, last_name, age, and a Many-to-One multiplicity Foreign Key (FK) that links to Diseases. 

The Diseases table consists of 3 columns: A PK ID, name, and description. The disease_id associates with the disease_symptoms in a One-To-Many relationship to achieve a Many-to-Many with Symptoms.

The Disease_Symptoms is a junction table that connects Diseases and Symptoms for a Many-to-Many multiplicity relationship. (Many diseases can have many symptoms, and many symptoms can be displayed across many diseases). Currently, for the sake of simplicity, every disease has their own symptoms. Future implementation will make it so a symptom can describe many diseases (as diseases can display similar symptoms). The idea behind this is to give the player an extra challenge in their diagnosis. For now, we keep things simple to assemble mechanics as quickly and smoothly as possible. 

The Symptoms table consists of 6 columns: PK symptom_id, symptom_name, symptom_description, is_observable, is_testable, symptom_test, and is_dialogue. The name and description appear on the client-side with the disease they are referenced with. This is interpolated onto the clipboard as the player progresses.

<h1>Application-Tier</h1>

Our Java application has multiple dependencies within the pom.xml: javax-servlet, jackson-databind, jackson-datatype, mockito-core, junit, ojdbc, hibernate-core, spring-context, spring-webmvc, validation-api, and maven-compiler-plugin. These allow us to access the necessary libraries for our classes and methods. 

The web.xml acts as the 'Master Servlet' where all the @Controller annotated controllers will use to expose their endpoints through Spring. 

The applicationContext.xml and dispatcherContext.xml checks through the project for annotated objects and enable Spring MVC.

The beans.xml and hibernate.cfg.xml configures the mappings for our beans. The beans are also annotated, thus rendering the mappings redundant. We did both, however, to ensure proper functionality. It hasn't caused any errors, and we currently see no reason to alter it. That being said, should there be a proper reason to change this, please do so.

Within the Java packages, we'll start at the top with beans. There are 5 beans: Player, Patient, Disease, Symptom, and UsernameScore. The first 4 are reflections of what we find within our databases with the exception of 'Disease' having a 'Symptom' list as a part of its constructor. That is not explicitly stated within the database due to the junction table. 'UsernameScore' became relavant when updating the player's score. Please reference the 'UsernameScore' bean for specifics.

Moving down, we have the 'controller' package containing LoginController, PlayerController, and PatientController. LoginController give us our Get and Post methods to authenticate a user for login, and returns their nonsensitive information in the url to be grabbed by the Angular to plug into the player/dev page. Is it the best way of going about that? Not necessarily. Did it work? Absolutely. The PatientController creates our endpoint to grab a single patient, and plug that patient with their information into the game when necessary. The PlayerController is a bit more complex. It grabs all players in general, grabs all players ranked by score in descending order, grabs a player by their id, adds a player during registration, allows them to update their info, one for updating their score after they play through the game, one for deleting their profile, and a final for finding a player by their username.

Next, the 'dao' package with Disease, Patients, Player, and Symptom. Initially, all were given the standard CRUD functions. As the project progressed, we only needed to give the PlayerDao methods to getPlayersByHighSchore() and findPlayerByUsername().

We created a separate package for the Dimpls ('daoimpls'). These extrapolate on the Daos, and give them functionality. All Dimpls are more or less identical in how they achieve their functionality (all use .get, .createQuery, .update, .persist, and .delete). Please refer to individual beans for specifics.

There is a 'main' package (at the time of writing this) for the Driver class. Simply for testing on the fly when errors are thrown and everything is on fire.

Our 'service' package contains DiseaseService, LoginService, PatientService, and PlayerService. Most Services are simply extensions of the dimpls to give to the controllers with the exception of single methods in PlayerService and LoginService. PlayerService has logic for finding players by their username, and LoginService has our authentication functionality for logging into the game. 

The 'util' package only contains HibernateUtil to establish a connection to the database through Environment Variables.

The 'test' package contains 'MedicalRPGTest' for Mockito testing. Please reference this class for specific details of test coverage.

We are utilizing a Tomcat server for this application. Weblogic didn't want to play nice.

<h1>Presentation-Tier</h1>

We're leveraging Angular to create our client-side functionality. We utilize many global variables to load with fetched data, and several methods to grab this data and provide game logic. Again, maybe not best practices, but it works. 

We created various components to interact with data and intermingle with each other to achieve functionality:

'all-players' will return the 4 players that are currently not devs to display on the dev page. The idea behind this is to eventually use an ngFor to get all players that are not devs, and display their information to the devs on the dev page.

'clipboard' is one of the 3 main components on the game page. It displays information regarding the patient, their symptoms, and provides a button that routes to the diseases 'cheatsheet' for players to reference gathered symptoms in their diagnosis.

'devprofile' is the home page for developers. It displays their information, allows them to update their information, delete a player's profile based on their username, play the game, and view all players that are not devs by their information. 

'diabetesbutton' is how the player can choose to diagnose the patient with Diabetes. It is displayed when the player clicks the 'diagnosebutton.'

'diagnosebutton' (reference above) is how the player can see the list of buttons used to diagnose the patient. It can be clicked at anytime, regardless of how much information is gathered by the player. Successful selection of diseases will award points, incorrect selections will award 0 points.

'dialogue' is another of the 3 main components in game page. It is the far left component of the screen that displays the "conversation" taking place between the player and the current patient. It is also where buttons for diagnosis are displayed when 'diagnosebutton' is clicked.

'fibromyalgiabutton' is how the player can choose to diagnose the patient with Fibromyalgia. It is displayed when the player clicks the 'diagnosebutton.'

'game-page' is the center of the application. It is where the 'dialogue,' 'clipboard,' and 'vitals' components are nested.

'laryngitisbutton' is how the player can choose to diagnose the patient with Laryngitis. It is displayed when the player clicks the 'diagnosebutton.'

'leaderboard' provides the functionality to display to players the top scores in the leaderboard. As of now, it is simple a top 5, but future implementations hope to use an ngFor to display all scores in order descending.

'leukemiabotton' is how the player can choose to diagnose the patient with Leukemia. It is displayed when the player clicks the 'diagnosebutton.'

'login' is the first page a user will see. It has a register and login form depending on if the user has an account or not.

'malariabutton' is how the player can choose to diagnose the patient with Malaria. It is displayed when the player clicks the 'diagnosebutton.'

'models' is used for organizing fetched information by the object model. They are reflections of the beans found in the Java application. There are models that function as lists as well.

'motorneuronbutton' is how the player can choose to diagnose the patient with Motor Neuron Disease. It is displayed when the player clicks the 'diagnosebutton.'

'observepatient' is one of the 3 main conversation buttons the player utilizes to gather information about the patient. It will display anything that is "IS_OBSERVABLE" in the Symptoms table in the database, and associate with the patient. 

'play-button' is simply a button that routes to the game page where ever it is placed.

'player-info' will fetch the player username, firstname, and lastname, and display this information on the 'player page.'

'player-page' is the home page for users that are not devs. They can see their username, firstname, and lastname (mentioned above), update their information, are provided a button should they want to delete their account, view a list of the top 5 scores, and can access the game with a 'play-button.'

'question-button' is another of the 3 main conversation buttons to interact with the patient to gather information. It will display "IS_DIALOGUE" in the Symptoms table in the database, and is associated with the patient.

'testbutton' is the last of the 3 main converstion buttons to interact with the patient to gather information. It will display "IS_TESTABLE" in the Symptoms table in the database, and is associated with the patient.

'thankyoubutton' is used to begin the game on the dialogue page.

'vitals' is the final of the 3 main components of the game-page. It displays the healthbar that decreases every time the players selects a dialogue option, and will also display the 'diagnosebutton' the player uses to bring up their options to diagnose the patient.

<h2>Final Thoughts:</h2>

This is a brief overview of an entire application. Points may have been missed. Please reference one of the authors should there be any questions that are not answered in either this document or within the code comments. 

<h3>Thank you, and, again, welcome to Diagnosis! We're thrilled you're here.</h3>
