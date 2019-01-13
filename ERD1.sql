-- @Author: Rebecca

-- This section creates the Player and Leaderboard tables.
CREATE TABLE PLAYER (
PLAYER_ID INT PRIMARY KEY,
EMAIL VARCHAR(50) UNIQUE,
PLAYER_PASSWORD VARCHAR(20),
FIRST_NAME VARCHAR(20),
LAST_NAME VARCHAR(20),
HIGH_SCORES NUMBER,
IS_DEV VARCHAR(20)
);
/
CREATE TABLE LEADERBOARD (
LEADERBOARD_ID INT PRIMARY KEY,
USER_ID VARCHAR(20),
SCORE NUMBER
);
/

-- This section adds constraints to the Foreign Keys, creates sequences, and triggers.
ALTER TABLE LEADERBOARD
ADD CONSTRAINT FK_USER_ID
FOREIGN KEY (USER_ID) REFERENCES PLAYER(PLAYER_ID);
/
CREATE SEQUENCE SQ_PLAYER_ID_PK
START WITH 10000
INCREMENT BY 10;
/
CREATE OR REPLACE TRIGGER TR_INSERT_PLAYER_ID
BEFORE INSERT ON PLAYER 
FOR EACH ROW
BEGIN 
    SELECT SQ_PLAYER_ID_PK.NEXTVAL INTO :NEW.PLAYER_ID FROM DUAL;
END;
/

-- This section inserts information to the Player table according to the values that are listed in the columns.
insert into PLAYER (EMAIL, PLAYER_PASSWORD, FIRST_NAME, LAST_NAME, HIGH_SCORES, IS_DEV) values ('kboden0@google.com', 'qn36JJ6E9ov', 'Karoly', 'Boden', '114383566', 'false');
/
insert into PLAYER (EMAIL, PLAYER_PASSWORD, FIRST_NAME, LAST_NAME, HIGH_SCORES, IS_DEV) values ('jcromett1@statco.com', 'aIValPqO', 'Jone', 'Cromett', '746368599', 'false');
/
insert into PLAYER (EMAIL, PLAYER_PASSWORD, FIRST_NAME, LAST_NAME, HIGH_SCORES, IS_DEV) values ('lberridge2@netlg.com', 'Ks7bPBfIqX', 'Lazare', 'Berridge', '609301551', 'false');
/
insert into PLAYER (EMAIL, PLAYER_PASSWORD, FIRST_NAME, LAST_NAME, HIGH_SCORES, IS_DEV) values ('rhaibel3@irs.gov', 'Mjeiveyj5jM', 'Roderic', 'Haibel', '626797711', 'false');
/
insert into PLAYER (EMAIL, PLAYER_PASSWORD, FIRST_NAME, LAST_NAME, HIGH_SCORES, IS_DEV) values ('rwhetson4@dagon.com', 'Y6KkbYWP1cO', 'Reuben', 'Whetson', '860140548', 'false');
/
insert into PLAYER (EMAIL, PLAYER_PASSWORD, FIRST_NAME, LAST_NAME, HIGH_SCORES, IS_DEV) values ('hdurrell0@indigo.com', 'yTXA0LXDON', 'Herby', 'Durrell', 796121652, 'false');
/
insert into PLAYER (EMAIL, PLAYER_PASSWORD, FIRST_NAME, LAST_NAME, HIGH_SCORES, IS_DEV) values ('mnation1@ailmail.com', 'lBPb3c9', 'Mayer', 'Nation', 648021327, 'false');
/
insert into PLAYER (EMAIL, PLAYER_PASSWORD, FIRST_NAME, LAST_NAME, HIGH_SCORES, IS_DEV) values ('hfylan2@telgraph.com', '2wE7BR', 'Hammad', 'Fylan', 588576524, 'false');
/
insert into PLAYER (EMAIL, PLAYER_PASSWORD, FIRST_NAME, LAST_NAME, HIGH_SCORES, IS_DEV) values ('nnancarrow3@uiuc.edu', 'GpTfq7IRG', 'Nikolos', 'Nancarrow', 388770525, 'false');
/
insert into PLAYER (EMAIL, PLAYER_PASSWORD, FIRST_NAME, LAST_NAME, HIGH_SCORES, IS_DEV) values ('aharwell4@cross.org', 'KAw0H4ZY', 'Alwyn', 'Harwell', 526495310, 'false');
/
insert into PLAYER (EMAIL, PLAYER_PASSWORD, FIRST_NAME, LAST_NAME, HIGH_SCORES, IS_DEV) values ('myakubovic5@buzz.com', 'lcHMVnKpWm', 'Michelle', 'Yakubovich', 025072409, 'false');
/
insert into PLAYER (EMAIL, PLAYER_PASSWORD, FIRST_NAME, LAST_NAME, HIGH_SCORES, IS_DEV) values ('rbourgeois6@msn.com', 'h1trHVs', 'Rica', 'Bourgeois', 280320318, 'false');
/
insert into PLAYER (EMAIL, PLAYER_PASSWORD, FIRST_NAME, LAST_NAME, HIGH_SCORES, IS_DEV) values ('kstoneb7@oracle.com', 'PBvHNhD', 'Kenon', 'Stonebridge', 341146115, 'false');
/
insert into PLAYER (EMAIL, PLAYER_PASSWORD, FIRST_NAME, LAST_NAME, HIGH_SCORES, IS_DEV) values ('tpascoe8@ebay.com', '02GI8qU', 'Tori', 'Pascoe', 835394044, 'false');
/
insert into PLAYER (EMAIL, PLAYER_PASSWORD, FIRST_NAME, LAST_NAME, HIGH_SCORES, IS_DEV) values ('gpetro9@journal.com', 'Nq6dr2m', 'Gavra', 'Petrolli', 586412287, 'false');
/
insert into PLAYER (EMAIL, PLAYER_PASSWORD, FIRST_NAME, LAST_NAME, HIGH_SCORES, IS_DEV) values ('mcouch@crwm.com', 'qwerty', 'Max', 'Couch', 548302749, 'true');
/
insert into PLAYER (EMAIL, PLAYER_PASSWORD, FIRST_NAME, LAST_NAME, HIGH_SCORES, IS_DEV) values ('dwatts@crwm.com', 'qwerty', 'Darius', 'Watts', 803795037, 'true');
/
insert into PLAYER (EMAIL, PLAYER_PASSWORD, FIRST_NAME, LAST_NAME, HIGH_SCORES, IS_DEV) values ('jmulrenin@crwm.com', 'qwerty', 'Jake', 'Mulrenin', 793050384, 'true');
/ 
insert into PLAYER (EMAIL, PLAYER_PASSWORD, FIRST_NAME, LAST_NAME, HIGH_SCORES, IS_DEV) values ('rruiz@crwm.com', 'qwerty', 'Rebecca', 'Ruiz', 947930753, 'true');
/

-- Created a sequence for the Leaderboard ID Primary Key
CREATE SEQUENCE SQ_LEADERBOARD_ID_PK
START WITH 1
INCREMENT BY 1;
/

-- Created a trigger to insert an ID automatically into the Leaderboard ID column
CREATE OR REPLACE TRIGGER TR_INSERT_LEADERBOARD_ID
BEFORE INSERT ON LEADERBOARD 
FOR EACH ROW
BEGIN 
    SELECT SQ_LEADERBOARD_ID_PK.NEXTVAL INTO :NEW.LEADERBOARD_ID FROM DUAL;
END;
/

-- This section inserts information to the Leaderboard column according to the values that are listed in the columns
INSERT INTO LEADERBOARD (USER_ID, SCORE) VALUES ('rruiz@crwm.com', 947930753);
/
INSERT INTO LEADERBOARD (USER_ID, SCORE) VALUES ('rwhetson4@dagon.com', 860140548);
/
INSERT INTO LEADERBOARD (USER_ID, SCORE) VALUES ('tpascoe@ebay.com', 835394044);
/
INSERT INTO LEADERBOARD (USER_ID, SCORE) VALUES ('dwatts@crwm.com', 803795037);
/
INSERT INTO LEADERBOARD (USER_ID, SCORE) VALUES ('hdurrell0@indigo.com', 796121652);
/

-- This section inserts information into the Symptoms table according to the values listed in the columns
INSERT INTO SYMPTOMS (SYMPTOM_ID, SYMPTOM_NAME, SYMPTOM_DESCRIPTION, IS_OBSERVABLE, IS_TESTABLE, SYMPTOM_TEST) 
VALUES (10, 'Frequent Infections', 'Patient is frequently getting infected', 'no', 'yes', 'blood');
/
INSERT INTO SYMPTOMS (SYMPTOM_ID, SYMPTOM_NAME, SYMPTOM_DESCRIPTION, IS_OBSERVABLE, IS_TESTABLE, SYMPTOM_TEST) 
VALUES (11, 'Unusual bleeding', 'Patient is experiencing unusual bleeding', 'yes', 'yes', 'blood');
/
INSERT INTO SYMPTOMS (SYMPTOM_ID, SYMPTOM_NAME, SYMPTOM_DESCRIPTION, IS_OBSERVABLE, IS_TESTABLE, SYMPTOM_TEST) 
VALUES (12, 'Pale skin', 'Skin is unusually pale', 'yes', 'no', 'null');
/

-- This section inserts information into the Disease_Symptoms table according to the values listed in the colums
INSERT INTO DISEASE_SYMPTOMS (DISEASE_ID, SYMPTOM_ID) VALUES (2, 4);
/
INSERT INTO DISEASE_SYMPTOMS (DISEASE_ID, SYMPTOM_ID) VALUES (2, 5);
/
INSERT INTO DISEASE_SYMPTOMS (DISEASE_ID, SYMPTOM_ID) VALUES (2, 6);
/
INSERT INTO DISEASE_SYMPTOMS (DISEASE_ID, SYMPTOM_ID) VALUES (1, 1);
/
INSERT INTO DISEASE_SYMPTOMS (DISEASE_ID, SYMPTOM_ID) VALUES (1, 2);
/
INSERT INTO DISEASE_SYMPTOMS (DISEASE_ID, SYMPTOM_ID) VALUES (1, 3);
/
DELETE FROM DISEASE_SYMPTOMS WHERE SYMPTOM_ID = 4;
/

-- Adding more information to the Symptoms table
INSERT INTO SYMPTOMS (SYMPTOM_ID, SYMPTOM_NAME, SYMPTOM_DESCRIPTION, IS_OBSERVABLE, IS_TESTABLE, SYMPTOM_TEST) 
VALUES (4, 'Hoarseness', 'Voice sounds breathy, raspy, strained, or change in volume', 'yes', 'no', 'null');
/
INSERT INTO SYMPTOMS (SYMPTOM_ID, SYMPTOM_NAME, SYMPTOM_DESCRIPTION, IS_OBSERVABLE, IS_TESTABLE, SYMPTOM_TEST) 
VALUES (5, 'Mild fever', 'Patient has a minor fever', 'yes', 'no', 'null');
/
INSERT INTO SYMPTOMS (SYMPTOM_ID, SYMPTOM_NAME, SYMPTOM_DESCRIPTION, IS_OBSERVABLE, IS_TESTABLE, SYMPTOM_TEST) 
VALUES (6, 'Irritating cough', 'Patient is constantly coughing', 'yes', 'no', 'null');
/
INSERT INTO SYMPTOMS (SYMPTOM_ID, SYMPTOM_NAME, SYMPTOM_DESCRIPTION, IS_OBSERVABLE, IS_TESTABLE, SYMPTOM_TEST) 
VALUES (7, 'Headaches', 'Head hurts constantly', 'yes', 'no', 'null');
/
INSERT INTO SYMPTOMS (SYMPTOM_ID, SYMPTOM_NAME, SYMPTOM_DESCRIPTION, IS_OBSERVABLE, IS_TESTABLE, SYMPTOM_TEST) 
VALUES (8, 'Irritable Bowel Syndrome', 'Patient has an irritable colon', 'yes', 'yes', 'Colonoscopy');
/
INSERT INTO SYMPTOMS (SYMPTOM_ID, SYMPTOM_NAME, SYMPTOM_DESCRIPTION, IS_OBSERVABLE, IS_TESTABLE, SYMPTOM_TEST) 
VALUES (9, 'Muscle stiffness', 'Patient has stiff muscles', 'yes', 'no', 'null');
/

-- This section inserts information into the Diseases table according to the values listed in the columns
INSERT INTO DISEASES (DISEASE_ID, DISEASE_NAME, DISEASE_DESCRIPTION) 
VALUES (4, 'Leukemia', 'Cancer of the blood-forming tissue in the body');
/
INSERT INTO DISEASES (DISEASE_ID, DISEASE_NAME, DISEASE_DESCRIPTION) 
VALUES (5, 'Malaria', 'Mosquito-borne disease caused by a parasite');
/

-- Adding more information into the Disease_Symptoms table
INSERT INTO DISEASE_SYMPTOMS (DISEASE_ID, SYMPTOM_ID) VALUES (2, 4);
/
INSERT INTO DISEASE_SYMPTOMS (DISEASE_ID, SYMPTOM_ID) VALUES (2, 5);
/
INSERT INTO DISEASE_SYMPTOMS (DISEASE_ID, SYMPTOM_ID) VALUES (2, 6);
/
INSERT INTO DISEASE_SYMPTOMS (DISEASE_ID, SYMPTOM_ID) VALUES (3, 7);
/
INSERT INTO DISEASE_SYMPTOMS (DISEASE_ID, SYMPTOM_ID) VALUES (3, 8);
/
INSERT INTO DISEASE_SYMPTOMS (DISEASE_ID, SYMPTOM_ID) VALUES (4, 10);
/
INSERT INTO DISEASE_SYMPTOMS (DISEASE_ID, SYMPTOM_ID) VALUES (4, 11);
/
INSERT INTO DISEASE_SYMPTOMS (DISEASE_ID, SYMPTOM_ID) VALUES (4, 12);
/

-- Adding more information into the Symptoms table
INSERT INTO SYMPTOMS (SYMPTOM_ID, SYMPTOM_NAME, SYMPTOM_DESCRIPTION, IS_OBSERVABLE, IS_TESTABLE, SYMPTOM_TEST) 
VALUES (13, 'Vomiting', 'Patient has vomiting episodes', 'yes', 'no', 'null');
/
INSERT INTO SYMPTOMS (SYMPTOM_ID, SYMPTOM_NAME, SYMPTOM_DESCRIPTION, IS_OBSERVABLE, IS_TESTABLE, SYMPTOM_TEST) 
VALUES (14, 'Diarrhoea', 'Patient has loose or watery bowel movements', 'yes', 'no', 'null');
/
INSERT INTO SYMPTOMS (SYMPTOM_ID, SYMPTOM_NAME, SYMPTOM_DESCRIPTION, IS_OBSERVABLE, IS_TESTABLE, SYMPTOM_TEST) 
VALUES (15, 'Muscle pains', 'Patient suffers of pain in the muscles', 'yes', 'no', 'null');
/

-- Adding more information into the Disease_Symptoms table
INSERT INTO DISEASE_SYMPTOMS (DISEASE_ID, SYMPTOM_ID) VALUES (5, 13);
/
INSERT INTO DISEASE_SYMPTOMS (DISEASE_ID, SYMPTOM_ID) VALUES (5, 14);
/
INSERT INTO DISEASE_SYMPTOMS (DISEASE_ID, SYMPTOM_ID) VALUES (5, 15);
/

-- Had to drop the table Patient because it was created by mistake when connecting the database to hibernate code
DROP TABLE PATIENT;
