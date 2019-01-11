# CRWM
Medical RPG

Authors: Max, Rebecca, Darius, Jake

Welcome to Diagnosis.

<h1>Synopsis:</h1> 

Diagnosis is a text RPG where the player simulates a doctor's interactions with their patients. They are to speak with, observe, and run tests to gather information on the patient's symptoms. The player is given a sheet of disease descriptions, and references that sheet against information gathered about what ails the patient. Once the player in confident, they can choose to diagnose the patient. A correct diagnosis will award points to the player. The faster the diagnosis, the more points awarded. Should the player misdiagnose the patient, they will recieve no points, and must move on to the next patient. High scores are gathered between players, and a Top-5-Leaderboard is displayed on the login page. The player can register a new account, login with their credentials, and change their information if needed.

<h1>Database:</h1> 

In our SQL Developer, we have 6 tables of information to apply to the Client-side: Leaderboard, Player, Patients, Diseases, Symptoms, and Disease_Symptoms. 

The Leaderboard Table is only 2 columns of a Leaderboard Primary Key (PK) ID, and a Many-to-One multiplicity Foreign Key (FK) that links to Player. 

The Player table consists of 8 columns: Player_ID PK, player_password, first_name, last_name, high_scores, id_dev, username, and leaderboard_id. Unsure if the leaderboard_id column is necessary, but was implemented in bean testing. No reason to take it away as it is not throwing any exceptions. Can look into this in the future. 

The Patients table consists of 5 columns: a PK ID, first_name, last_name, age, and a Many-to-One multiplicity Foreign Key (FK) that links to Diseases. 

The Diseases table consists of 3 columns: A PK ID, name, and description. 

The Disease_Symptoms is a junction table that connects Diseases and Symptoms for a Many-to-Many multiplicity relationship. (Many diseases can have many symptoms, and many symptoms can be displayed across many diseases). Currently, for the sake of simplicity, every disease has their own symptoms. Future implementation would make it so a symptom can describe many diseases (as diseases can display similar symptoms). The idea behind this is to give the player an extra challenge in their diagnosis. For now, we keep things simple to assemble mechanics as quickly and smoothly as possible. 

The Symptoms table consists of 6 columns: PK ID, name, description, observable, testable, and test.

<h1>Application-Tier</h1>

