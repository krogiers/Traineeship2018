--CREATING USERS 
-----------------------------------------------------------------------

INSERT INTO USERS (ID, FIRSTNAME, LASTNAME, EMAIL, PASSWORD, HOMECOUNTRY) 
VALUES (1, 'Laura', 'Lynn', 'Laura.Lynn@gmail.com', 'LauraLynn', 'BE');

INSERT INTO USERS (ID, FIRSTNAME, LASTNAME, EMAIL, PASSWORD, HOMECOUNTRY) 
VALUES ((SELECT MAX(ID) FROM USERS)+1, 'Wouter', 'Mosselmans', 'Wouter.Mosselmans@gmail.com', 'WouterMosselmans', 'BE');

INSERT INTO USERS (ID, FIRSTNAME, LASTNAME, EMAIL, PASSWORD, HOMECOUNTRY) 
VALUES ((SELECT MAX(ID) FROM USERS)+1, 'Maarten', 'Spooren', 'Maarten.Spooren@gmail.com', 'MaartenSpooren', 'BE');

INSERT INTO USERS (ID, FIRSTNAME, LASTNAME, EMAIL, PASSWORD, HOMECOUNTRY) 
VALUES ((SELECT MAX(ID) FROM USERS)+1, 'Director', 'Joe', 'Director.Joe@gmail.com', 'DirectorJoe', 'BE');

INSERT INTO USERS (ID, FIRSTNAME, LASTNAME, EMAIL, PASSWORD, HOMECOUNTRY) 
VALUES ((SELECT MAX(ID) FROM USERS)+1, 'Admin', 'Is trator', 'Administrator@gmail.com', 'Administrator', 'BE');

INSERT INTO USERS (ID, FIRSTNAME, LASTNAME, EMAIL, PASSWORD, HOMECOUNTRY) 
VALUES ((SELECT MAX(ID) FROM USERS)+1, 'Root', 'Woot', 'Root.Woot@gmail.com', 'RootWoot', 'BE');

INSERT INTO USERS (ID, FIRSTNAME, LASTNAME, EMAIL, PASSWORD, HOMECOUNTRY) 
VALUES ((SELECT MAX(ID) FROM USERS)+1, 'Yendel', 'Lintermans', 'Yendel.Lintermans@gmail.com', 'YendelLintermans', 'BE');


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

INSERT INTO USERPRIVILEGES (ID, PRIVILEGE, USER_ID, FUNCTIONS_ID, ACTIVE) 
VALUES (1, 'M', 1, 1, 1);

INSERT INTO USERPRIVILEGES (ID, PRIVILEGE, USER_ID, FUNCTIONS_ID, ACTIVE) 
VALUES ((SELECT MAX(ID) FROM USERPRIVILEGES)+1, 'M', 7, 1, 1);

INSERT INTO USERPRIVILEGES (ID, PRIVILEGE, USER_ID, FUNCTIONS_ID, ACTIVE) 
VALUES ((SELECT MAX(ID) FROM USERPRIVILEGES)+1, 'T', 2, NULL, 1);

INSERT INTO USERPRIVILEGES (ID, PRIVILEGE, USER_ID, FUNCTIONS_ID, ACTIVE, COUNTRY) 
VALUES ((SELECT MAX(ID) FROM USERPRIVILEGES)+1, 'F', 3, 1, 1, 'BE');

INSERT INTO USERPRIVILEGES (ID, PRIVILEGE, USER_ID, FUNCTIONS_ID, ACTIVE) 
VALUES ((SELECT MAX(ID) FROM USERPRIVILEGES)+1, 'D', 4, NULL, 1);

INSERT INTO USERPRIVILEGES (ID, PRIVILEGE, USER_ID, FUNCTIONS_ID, ACTIVE) 
VALUES ((SELECT MAX(ID) FROM USERPRIVILEGES)+1, 'A', 5, NULL, 1);

INSERT INTO USERPRIVILEGES (ID, PRIVILEGE, USER_ID, FUNCTIONS_ID, ACTIVE) 
VALUES ((SELECT MAX(ID) FROM USERPRIVILEGES)+1, 'M', 6, 1, 1);

INSERT INTO USERPRIVILEGES (ID, PRIVILEGE, USER_ID, FUNCTIONS_ID, ACTIVE) 
VALUES ((SELECT MAX(ID) FROM USERPRIVILEGES)+1, 'T', 6, NULL, 1);

INSERT INTO USERPRIVILEGES (ID, PRIVILEGE, USER_ID, FUNCTIONS_ID, COUNTRY, ACTIVE)  
VALUES ((SELECT MAX(ID) FROM USERPRIVILEGES)+1, 'F', 6, 1, 'FR', 1);

INSERT INTO USERPRIVILEGES (ID, PRIVILEGE, USER_ID, FUNCTIONS_ID, ACTIVE) 
VALUES ((SELECT MAX(ID) FROM USERPRIVILEGES)+1, 'D', 6, NULL, 1);

INSERT INTO USERPRIVILEGES (ID, PRIVILEGE, USER_ID, FUNCTIONS_ID, ACTIVE) 
VALUES ((SELECT MAX(ID) FROM USERPRIVILEGES)+1, 'A', 6, NULL, 1);


--CReating teams
-----------------------------------------------------------------------

INSERT INTO TEAMS (ID, NAME) 
VALUES (1, 'Java Trainees');

INSERT INTO TEAMS  (ID, NAME) 
VALUES ((SELECT MAX(ID) FROM TEAMS)+1, 'BCOM');


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
VALUES ((SELECT MAX(ID) FROM Functionroles)+1, 1, 2);

INSERT INTO Functionroles  (ID, ROLES_ID, Functions_ID) 
VALUES ((SELECT MAX(ID) FROM Functionroles)+1, 2, 1);


--creating competences
-----------------------------------------------------------------------

INSERT INTO competences (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) 
VALUES (1, null, 1 , null, 'Deliver Online Application MF CICS/PL1');

INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) 
VALUES ((SELECT MAX(ID) FROM competences)+1, null, 1, null, 'Deliver IMSL Service MF');

INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) 
VALUES ((SELECT MAX(ID) FROM competences)+1, 1, null, null, 'Company Involvement');

INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) 
VALUES ((SELECT MAX(ID) FROM competences)+1, null, null, 1, 'BPS');


--creating competenceDescriptions
-----------------------------------------------------------------------

INSERT INTO CompetenceDescriptions (ID, Description, Competences_ID) 
VALUES (1, 'I can design, develop, test and deploy a CICS-application (CICS handling + PL1 + ACF2 API) on either an IDMS or DB2 database, using the standard development tooling (ADMI, TSO, TLNK, AbendAid, chainings) in line with the company standards.', 1);

INSERT INTO CompetenceDescriptions (ID, Description, Competences_ID) 
VALUES ((SELECT MAX(ID) FROM CompetenceDescriptions)+1, 'I can design, develop, test and deploy a CICS-application as an IMSL service provider/requester (CICS handling + PL1 + IMSL procedures) on either an IDMS or DB2 database, using the standard software development tool(s), ADMI, Debug and testing tools, Database query tools.', 2);

INSERT INTO CompetenceDescriptions (ID, Description, Competences_ID) 
VALUES ((SELECT MAX(ID) FROM CompetenceDescriptions)+1, 'To show yourself connected with the mission and values of the company, to create a connection with other people and to make sure that all behaviour corresponds with this. ', 3);


--creating behavioralCompetencesLevels
-----------------------------------------------------------------------

INSERT INTO behavioralcompetencelevels (ID, Competences_id, Description, orderlevel, Active) 
VALUES (1, 3, 'Knows the values and mission', 1, 0);

INSERT INTO behavioralcompetencelevels (ID, Competences_id, Description, orderlevel, Active) 
VALUES ((SELECT MAX(ID) FROM behavioralcompetencelevels)+1, 3, 'Works in conformity with the values and mission', 2, 1);

INSERT INTO behavioralcompetencelevels (ID, Competences_id, Description, orderlevel, Active) 
VALUES ((SELECT MAX(ID) FROM behavioralcompetencelevels)+1, 3, 'Follows up on behaviour of other people that does not correspond with the values and mission', 3, 0);

INSERT INTO behavioralcompetencelevels (ID, Competences_id, Description, orderlevel, Active) 
VALUES ((SELECT MAX(ID) FROM behavioralcompetencelevels)+1, 3, 'Guards and illustrates the application of the values and mission', 4, 0);

INSERT INTO behavioralcompetencelevels (ID, Competences_id, Description, orderlevel, Active) 
VALUES ((SELECT MAX(ID) FROM behavioralcompetencelevels)+1, 3, 'Links the company values and mission to each message and decision', 5, 0);

COMMIT;