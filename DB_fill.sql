ALTER TABLE BehavioralCompetenceLevels
    DISABLE CONSTRAINT Behavioral_Competences;

ALTER TABLE Competences
    DISABLE CONSTRAINT Competences_Functions;

ALTER TABLE Competences
    DISABLE CONSTRAINT Competences_OperatingUnits;

ALTER TABLE Competences
    DISABLE CONSTRAINT Competences_Roles;

ALTER TABLE TeamEnrolments
    DISABLE CONSTRAINT Enrolment_Team;

ALTER TABLE TeamEnrolments
    DISABLE CONSTRAINT Enrolments_UserPrivileges;

ALTER TABLE FunctionRoles
    DISABLE CONSTRAINT FunctionRoles_Functions;

ALTER TABLE FunctionRoles
    DISABLE CONSTRAINT FunctionRoles_Roles;

ALTER TABLE Functions
    DISABLE CONSTRAINT Functions_OperatingUnits;

ALTER TABLE Ratings
    DISABLE CONSTRAINT Ratings_Competences;

ALTER TABLE Ratings
    DISABLE CONSTRAINT Ratings_Surveys;

ALTER TABLE SurveySets
    DISABLE CONSTRAINT SurveySets_Enrolments;

ALTER TABLE SurveySets
    DISABLE CONSTRAINT SurveySets_ConsensusSurvey;

ALTER TABLE SurveySets
    DISABLE CONSTRAINT SurveySets_ManagerSurvey;

ALTER TABLE SurveySets
    DISABLE CONSTRAINT SurveySets_MemberSurvey;

ALTER TABLE TeamEnrolments
    DISABLE CONSTRAINT TeamEnrolments_Roles;

ALTER TABLE UserPrivileges
    DISABLE CONSTRAINT UserPrivileges_Functions;

ALTER TABLE UserPrivileges
    DISABLE CONSTRAINT UserPrivileges_User;

DELETE FROM FUNCTIONS;
DELETE FROM USERPRIVILEGES;
DELETE FROM OPERATINGUNITS;
DELETE FROM USERS;
DELETE FROM TEAMS;
DELETE FROM TEAMENROLMENTS;
DELETE FROM ROLES;

ALTER TABLE BehavioralCompetenceLevels
    ENABLE CONSTRAINT Behavioral_Competences;

ALTER TABLE Competences
    ENABLE CONSTRAINT Competences_Functions;

ALTER TABLE Competences
    ENABLE CONSTRAINT Competences_OperatingUnits;

ALTER TABLE Competences
    ENABLE CONSTRAINT Competences_Roles;

ALTER TABLE TeamEnrolments
    ENABLE CONSTRAINT Enrolment_Team;

ALTER TABLE TeamEnrolments
    ENABLE CONSTRAINT Enrolments_UserPrivileges;

ALTER TABLE FunctionRoles
    ENABLE CONSTRAINT FunctionRoles_Functions;

ALTER TABLE FunctionRoles
    ENABLE CONSTRAINT FunctionRoles_Roles;

ALTER TABLE Functions
    ENABLE CONSTRAINT Functions_OperatingUnits;

ALTER TABLE Ratings
    ENABLE CONSTRAINT Ratings_Competences;

ALTER TABLE Ratings
    ENABLE CONSTRAINT Ratings_Surveys;

ALTER TABLE SurveySets
    ENABLE CONSTRAINT SurveySets_Enrolments;

ALTER TABLE SurveySets
    ENABLE CONSTRAINT SurveySets_ConsensusSurvey;

ALTER TABLE SurveySets
    ENABLE CONSTRAINT SurveySets_ManagerSurvey;

ALTER TABLE SurveySets
    ENABLE CONSTRAINT SurveySets_MemberSurvey;

ALTER TABLE TeamEnrolments
    ENABLE CONSTRAINT TeamEnrolments_Roles;

ALTER TABLE UserPrivileges
    ENABLE CONSTRAINT UserPrivileges_Functions;

ALTER TABLE UserPrivileges
    ENABLE CONSTRAINT UserPrivileges_User;

--CREATING USERS 
-----------------------------------------------------------------------

INSERT INTO USERS (ID, FIRSTNAME, LASTNAME, EMAIL, PASSWORD) 
VALUES (1, 'Laura', 'Lynn', 'Laura.Lynn@gmail.com', 'LauraLynn');

INSERT INTO USERS (ID, FIRSTNAME, LASTNAME, EMAIL, PASSWORD) 
VALUES ((SELECT MAX(ID) FROM USERS)+1, 'Wouter', 'Mosselmans', 'Wouter.Mosselmans@gmail.com', 'WouterMosselmans');

INSERT INTO USERS (ID, FIRSTNAME, LASTNAME, EMAIL, PASSWORD) 
VALUES ((SELECT MAX(ID) FROM USERS)+1, 'Maarten', 'Spooren', 'Maarten.Spooren@gmail.com', 'MaartenSpooren');

INSERT INTO USERS (ID, FIRSTNAME, LASTNAME, EMAIL, PASSWORD) 
VALUES ((SELECT MAX(ID) FROM USERS)+1, 'Director', 'Joe', 'Director.Joe@gmail.com', 'DirectorJoe');

INSERT INTO USERS (ID, FIRSTNAME, LASTNAME, EMAIL, PASSWORD) 
VALUES ((SELECT MAX(ID) FROM USERS)+1, 'Admin', 'Is trator', 'Administrator@gmail.com', 'Administrator');

INSERT INTO USERS (ID, FIRSTNAME, LASTNAME, EMAIL, PASSWORD) 
VALUES ((SELECT MAX(ID) FROM USERS)+1, 'Root', 'Woot', 'Root.Woot@gmail.com', 'RootWoot');

INSERT INTO USERS (ID, FIRSTNAME, LASTNAME, EMAIL, PASSWORD) 
VALUES ((SELECT MAX(ID) FROM USERS)+1, 'Yendel', 'Lintermans', 'Yendel.Lintermans@gmail.com', 'YendelLintermans');


-- CREATING OperatingUnits
-----------------------------------------------------------------------

INSERT INTO OPERATINGUNITS (ID, TITLE) 
VALUES (1, 'BPS');

INSERT INTO OPERATINGUNITS (ID, TITLE)
VALUES ((SELECT MAX(ID) FROM OPERATINGUNITS)+1, 'CCX');



--Creating functions
-----------------------------------------------------------------------

INSERT INTO FUNCTIONS (ID, TITLE, OPERATINGUNITS_ID) 
VALUES (1, 'Software Engineer', 1);

INSERT INTO FUNCTIONS (ID, TITLE, OPERATINGUNITS_ID) 
VALUES ((SELECT MAX(ID) FROM FUNCTIONS)+1, 'Software Analyst', 1);

INSERT INTO FUNCTIONS (ID, TITLE, OPERATINGUNITS_ID) 
VALUES ((SELECT MAX(ID) FROM FUNCTIONS)+1, 'Project Manager', 1);

INSERT INTO FUNCTIONS (ID, TITLE, OPERATINGUNITS_ID) 
VALUES ((SELECT MAX(ID) FROM FUNCTIONS)+1, 'Software Engineer', 2);

INSERT INTO FUNCTIONS (ID, TITLE, OPERATINGUNITS_ID) 
VALUES ((SELECT MAX(ID) FROM FUNCTIONS)+1, 'Software Analyst', 2);


--Creating User privileges
-----------------------------------------------------------------------

INSERT INTO USERPRIVILEGES (ID, PRIVILEGE, USER_ID, FUNCTIONS_ID) 
VALUES (1, 'M', 1, 1);

INSERT INTO USERPRIVILEGES (ID, PRIVILEGE, USER_ID, FUNCTIONS_ID) 
VALUES ((SELECT MAX(ID) FROM USERPRIVILEGES)+1, 'M', 7, 1);

INSERT INTO USERPRIVILEGES (ID, PRIVILEGE, USER_ID, FUNCTIONS_ID) 
VALUES ((SELECT MAX(ID) FROM USERPRIVILEGES)+1, 'T', 2, NULL);

INSERT INTO USERPRIVILEGES (ID, PRIVILEGE, USER_ID, FUNCTIONS_ID) 
VALUES ((SELECT MAX(ID) FROM USERPRIVILEGES)+1, 'F', 3, 1);

INSERT INTO USERPRIVILEGES (ID, PRIVILEGE, USER_ID, FUNCTIONS_ID) 
VALUES ((SELECT MAX(ID) FROM USERPRIVILEGES)+1, 'D', 4, NULL);

INSERT INTO USERPRIVILEGES (ID, PRIVILEGE, USER_ID, FUNCTIONS_ID) 
VALUES ((SELECT MAX(ID) FROM USERPRIVILEGES)+1, 'A', 5, NULL);

INSERT INTO USERPRIVILEGES (ID, PRIVILEGE, USER_ID, FUNCTIONS_ID) 
VALUES ((SELECT MAX(ID) FROM USERPRIVILEGES)+1, 'M', 6, NULL);

INSERT INTO USERPRIVILEGES (ID, PRIVILEGE, USER_ID, FUNCTIONS_ID) 
VALUES ((SELECT MAX(ID) FROM USERPRIVILEGES)+1, 'T', 6, NULL);

INSERT INTO USERPRIVILEGES (ID, PRIVILEGE, USER_ID, FUNCTIONS_ID) 
VALUES ((SELECT MAX(ID) FROM USERPRIVILEGES)+1, 'F', 6, NULL);

INSERT INTO USERPRIVILEGES (ID, PRIVILEGE, USER_ID, FUNCTIONS_ID) 
VALUES ((SELECT MAX(ID) FROM USERPRIVILEGES)+1, 'D', 6, NULL);

INSERT INTO USERPRIVILEGES (ID, PRIVILEGE, USER_ID, FUNCTIONS_ID) 
VALUES ((SELECT MAX(ID) FROM USERPRIVILEGES)+1, 'A', 6, NULL);


--CReating teams
-----------------------------------------------------------------------

INSERT INTO TEAMS (ID, NAME) 
VALUES (1, 'Java Trainees');

INSERT INTO TEAMS  (ID, NAME) 
VALUES ((SELECT MAX(ID) FROM USERPRIVILEGES)+1, 'BCOM');


--creating roles
-----------------------------------------------------------------------
INSERT INTO ROLES (ID, Name) 
VALUES (1, 'Developer');

INSERT INTO ROLES (ID, Name) 
VALUES ((SELECT MAX(ID) FROM ROLES)+1, 'Lead Developer');


--creating teamenrolments
-----------------------------------------------------------------------

INSERT INTO TEAMENROLMENTS (ID, TEAM_ID, USERPRIVILEGES_ID, ACTIVE, ROLES_ID) 
VALUES (1, 1, 1, 1, 1);

INSERT INTO TEAMENROLMENTS  (ID, TEAM_ID, USERPRIVILEGES_ID, ACTIVE, ROLES_ID) 
VALUES ((SELECT MAX(ID) FROM TEAMENROLMENTS)+1, 1, 2, 1, 2);

INSERT INTO TEAMENROLMENTS  (ID, TEAM_ID, USERPRIVILEGES_ID, ACTIVE, ROLES_ID) 
VALUES ((SELECT MAX(ID) FROM TEAMENROLMENTS)+1, 1, 3, 1, null);


--creating functionroles
-----------------------------------------------------------------------

INSERT INTO Functionroles (ID, ROLES_ID, Functions_ID) 
VALUES (1, 1, 1);

INSERT INTO Functionroles  (ID, ROLES_ID, Functions_ID) 
VALUES ((SELECT MAX(ID) FROM Functionroles)+1, 1, 2, 1, 2);

INSERT INTO Functionroles  (ID, ROLES_ID, Functions_ID) 
VALUES ((SELECT MAX(ID) FROM Functionroles)+1, 1, 3, 1, null);