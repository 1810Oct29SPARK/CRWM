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

The beans.xml creates our Spring beans.

The hibernate.cfg.xml configures the mappings for our beans. The beans are also annotated, thus rendering the mappings redundant. We did both, however, to ensure proper functionality. It hasn't caused any errors, and we currently see no reason to alter it. That being said, should there be a proper reason to change this, please do so.

Within the Java packages, we'll start at the top with beans. There are 5 beans: Player, Patient, Disease, Symptom, and UsernameScore. The first 4 are reflections of what we find within our databases with the exception of 'Disease' having a 'Symptom' list as a part of its constructor. That is not explicitly stated within the database due to the junction table. 'UsernameScore' became relavant when updating the player's score. Please reference the 'UsernameScore' bean for specifics.

Moving down, we have the 'controller' package containing LoginController, PlayerController, and PatientController. LoginController give us our Get and Post methods to authenticate a user for login, and returns their nonsensitive information in the url to be grabbed by the Angular to plug into the player/dev page. Is it the best way of going about that? Not necessarily. Did it work? Absolutely.

