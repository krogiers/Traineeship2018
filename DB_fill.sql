SET DEFINE OFF;

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


--Creating Privileges
-----------------------------------------------------------------------
INSERT INTO Privis (ID, FULLNAME, SHORTNAME) 
VALUES (1, 'TeamMember', 'M');

INSERT INTO Privis (ID, FULLNAME, SHORTNAME) 
VALUES ((SELECT MAX(ID) FROM Privis)+1, 'TeamManager', 'T');

INSERT INTO Privis (ID, FULLNAME, SHORTNAME) 
VALUES ((SELECT MAX(ID) FROM Privis)+1, 'FunctionHolder', 'F');

INSERT INTO Privis (ID, FULLNAME, SHORTNAME) 
VALUES ((SELECT MAX(ID) FROM Privis)+1, 'Director', 'D');

INSERT INTO Privis (ID, FULLNAME, SHORTNAME) 
VALUES ((SELECT MAX(ID) FROM Privis)+1, 'Administrator', 'A');


--Creating user privileges
-----------------------------------------------------------------------

INSERT INTO USERPRIVILEGES (ID, USER_ID, FUNCTIONS_ID, ACTIVE, PRIVIS_ID) 
VALUES (1, 1, 1, 1, 1);

INSERT INTO USERPRIVILEGES (ID, USER_ID, FUNCTIONS_ID, ACTIVE, PRIVIS_ID) 
VALUES ((SELECT MAX(ID) FROM USERPRIVILEGES)+1, 7, 1, 1, 1);

INSERT INTO USERPRIVILEGES (ID, USER_ID, FUNCTIONS_ID, ACTIVE, PRIVIS_ID) 
VALUES ((SELECT MAX(ID) FROM USERPRIVILEGES)+1, 2, NULL, 1, 2);

INSERT INTO USERPRIVILEGES (ID, USER_ID, FUNCTIONS_ID, ACTIVE, COUNTRY, PRIVIS_ID) 
VALUES ((SELECT MAX(ID) FROM USERPRIVILEGES)+1, 3, 1, 1, 'BE', 3);

INSERT INTO USERPRIVILEGES (ID, USER_ID, FUNCTIONS_ID, ACTIVE, PRIVIS_ID) 
VALUES ((SELECT MAX(ID) FROM USERPRIVILEGES)+1, 4, NULL, 1, 4);

INSERT INTO USERPRIVILEGES (ID, USER_ID, FUNCTIONS_ID, ACTIVE, PRIVIS_ID) 
VALUES ((SELECT MAX(ID) FROM USERPRIVILEGES)+1, 5, NULL, 1, 5);

INSERT INTO USERPRIVILEGES (ID, USER_ID, FUNCTIONS_ID, ACTIVE, PRIVIS_ID) 
VALUES ((SELECT MAX(ID) FROM USERPRIVILEGES)+1, 6, 1, 1, 1);

INSERT INTO USERPRIVILEGES (ID, USER_ID, FUNCTIONS_ID, ACTIVE, PRIVIS_ID) 
VALUES ((SELECT MAX(ID) FROM USERPRIVILEGES)+1, 6, NULL, 1, 2);

INSERT INTO USERPRIVILEGES (ID, USER_ID, FUNCTIONS_ID, COUNTRY, ACTIVE, PRIVIS_ID) 
VALUES ((SELECT MAX(ID) FROM USERPRIVILEGES)+1, 6, 1, 'FR', 1, 3);

INSERT INTO USERPRIVILEGES (ID, USER_ID, FUNCTIONS_ID, ACTIVE, PRIVIS_ID) 
VALUES ((SELECT MAX(ID) FROM USERPRIVILEGES)+1, 6, NULL, 1, 4);

INSERT INTO USERPRIVILEGES (ID, USER_ID, FUNCTIONS_ID, ACTIVE, PRIVIS_ID) 
VALUES ((SELECT MAX(ID) FROM USERPRIVILEGES)+1, 6, NULL, 1, 5);


--CReating teams
-----------------------------------------------------------------------

INSERT INTO TEAMS (ID, NAME) 
VALUES (1, 'Java Trainees');

INSERT INTO TEAMS  (ID, NAME) 
VALUES ((SELECT MAX(ID) FROM TEAMS)+1, 'BCOM');


--creating roles
-----------------------------------------------------------------------
INSERT INTO ROLES (ID, NAME) 
VALUES (1, 'Developer');

INSERT INTO ROLES (ID, NAME) 
VALUES ((SELECT MAX(ID) FROM ROLES)+1, 'Lead Developer');

INSERT INTO ROLES (ID, NAME) 
VALUES ((SELECT MAX(ID) FROM ROLES)+1, 'Ombuds/Oncall');

INSERT INTO ROLES (ID, NAME) 
VALUES ((SELECT MAX(ID) FROM ROLES)+1, 'Testing');


--creating teamenrolments
-----------------------------------------------------------------------

INSERT INTO TEAMENROLMENTS (ID, TEAM_ID, USERPRIVILEGES_ID, ACTIVE, ROLES_ID) 
VALUES (1, 1, 1, 1, 1);

INSERT INTO TEAMENROLMENTS  (ID, TEAM_ID, USERPRIVILEGES_ID, ACTIVE, ROLES_ID) 
VALUES ((SELECT MAX(ID) FROM TEAMENROLMENTS)+1, 1, 2, 1, 2);

INSERT INTO TEAMENROLMENTS  (ID, TEAM_ID, USERPRIVILEGES_ID, ACTIVE, ROLES_ID) 
VALUES ((SELECT MAX(ID) FROM TEAMENROLMENTS)+1, 1, 3, 1, NULL);


--creating functionroles
-----------------------------------------------------------------------

INSERT INTO FUNCTIONROLES (ID, ROLES_ID, FUNCTIONS_ID) 
VALUES (1, 1, 1);

INSERT INTO FUNCTIONROLES  (ID, ROLES_ID, FUNCTIONS_ID) 
VALUES ((SELECT MAX(ID) FROM FUNCTIONROLES)+1, 1, 2);

INSERT INTO FUNCTIONROLES  (ID, ROLES_ID, FUNCTIONS_ID) 
VALUES ((SELECT MAX(ID) FROM FUNCTIONROLES)+1, 2, 1);

INSERT INTO FUNCTIONROLES  (ID, ROLES_ID, FUNCTIONS_ID) 
VALUES ((SELECT MAX(ID) FROM FUNCTIONROLES)+1, 3, 1);

INSERT INTO FUNCTIONROLES  (ID, ROLES_ID, FUNCTIONS_ID) 
VALUES ((SELECT MAX(ID) FROM FUNCTIONROLES)+1, 4, 1);




--creating competences
-----------------------------------------------------------------------

INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) VALUES (1, null, 1, null, 'Deliver Online Application MF CICS/PL1'); 
INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) VALUES (2, null, 1, null, 'Deliver Online Application MF O*'); 
INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) VALUES (3, null, 1, null, 'Deliver IMSL Service MF'); 
INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) VALUES (4, null, 1, null, 'Deliver Webservice SOAP MF'); 
INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) VALUES (5, null, 1, null, 'Deliver Webservice REST MF'); 
INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) VALUES (6, null, 1, null, 'Deliver Batch MF PL1'); 
INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) VALUES (7, null, 1, null, 'Deliver Batch MF O*'); 
INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) VALUES (8, null, 1, null, 'Deliver Webapplication Java Colruyt Stack'); 
INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) VALUES (9, null, 1, null, 'Deliver Webapplication Fullstack JSF-JEE'); 
INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) VALUES (10, null, 1, null, 'Deliver Webapplication Backend JEE'); 
INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) VALUES (11, null, 1, null, 'Deliver Webapplication Backend Spring'); 
INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) VALUES (12, null, 1, null, 'Deliver Webapplication Frontend Angular'); 
INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) VALUES (13, null, 1, null, 'Deliver IMSL Service Java '); 
INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) VALUES (14, null, 1, null, 'Deliver Webservice SOAP JEE (HTTP && MQ)'); 
INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) VALUES (15, null, 1, null, 'Deliver Webservice REST JEE '); 
INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) VALUES (16, null, 1, null, 'Deliver Async service JEE'); 
INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) VALUES (17, null, 1, null, 'Deliver Batch Load Cycle SQL'); 
INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) VALUES (18, null, 1, null, 'Deliver Batch Load Cycle PL/SQL'); 
INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) VALUES (19, null, 1, null, 'Deliver Batch Java Colruyt stack '); 
INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) VALUES (20, null, 1, null, 'Deliver Batch JEE  '); 
INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) VALUES (21, null, 1, null, 'Deliver Island Application Access'); 
INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) VALUES (22, null, 1, null, 'Deliver Island Application Excel'); 
INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) VALUES (23, null, 1, null, 'Deliver Webapplication Wavemaker'); 
INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) VALUES (24, null, 1, null, 'Deliver Mobile PDT app Colruyt Stack'); 
INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) VALUES (25, null, 1, null, 'Deliver Mobile Frontend Android Native'); 
INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) VALUES (26, null, 1, null, 'Deliver Mobile Frontend iOS Native'); 
INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) VALUES (27, null, 1, null, 'Deliver Webmethods Service'); 
INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) VALUES (28, null, 1, null, 'Deliver Trading Networks Service'); 
INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) VALUES (29, null, 1, null, 'Deliver BPM Orchestration (ESB)'); 
INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) VALUES (30, null, 1, null, 'Deliver Webservice SOAP ESB'); 
INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) VALUES (31, null, 1, null, 'Deliver Webservice REST ESB'); 
INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) VALUES (32, null, 1, null, 'Deliver Async API (JSON/XML) ESB'); 
INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) VALUES (33, null, 1, null, 'Deliver SOAP/JMS Webservice ESB'); 
INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) VALUES (34, null, 1, null, 'Deliver Virtual Services (SOAP/REST)'); 
INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) VALUES (36, null, 1, null, 'Deliver Online Application Oracle PSFT '); 
INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) VALUES (37, null, 1, null, 'Deliver Batch Oracle PSFT Application Engines'); 
INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) VALUES (38, null, 1, null, 'Deliver Batch Oracle PSFT SQR'); 
INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) VALUES (39, null, 1, null, 'Deliver Webservice PSFT Integration Broker'); 
INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) VALUES (40, null, 1, null, 'Deliver Mobile Frontend Fluid Webapp (PSFT)'); 
INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) VALUES (41, null, 1, null, 'Deliver Microsoft Sharepoint Component'); 
INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) VALUES (42, null, 1, null, 'Deliver SAP Native Application'); 
INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) VALUES (43, null, 1, null, 'Deliver SAP Backend Interface'); 
INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) VALUES (44, null, 1, null, 'Deliver SAP Webapp Frontend Fiori'); 
INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) VALUES (45, null, 1, null, 'Deliver Batch SAP ABAP'); 
INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) VALUES (46, null, 1, null, 'Deliver SAP Business Warehouse Datachain'); 
INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) VALUES (47, null, 1, null, 'Deliver BO Universe'); 
INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) VALUES (48, null, 1, null, 'Design Report Visualisation Design'); 
INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) VALUES (49, null, 1, null, 'Deliver SAP BO Report'); 
INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) VALUES (50, null, 1, null, 'Deliver Tableau Dashboard'); 
INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) VALUES (51, null, 1, null, 'Impact Analysis'); 
INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) VALUES (52, null, 1, null, 'Deliver tableau data source'); 
INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) VALUES (53, null, 1, null, 'Deliver Hana Models'); 
INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) VALUES (54, null, 1, null, 'Continuous Integration & Deployment (Java/Mobile)'); 
INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) VALUES (55, null, 1, null, 'Performance Tuning'); 
INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) VALUES (56, null, 1, null, 'Deliver Technical Documentation & Troubleshooter'); 
INSERT INTO competences  (ID, Functions_ID, FunctionRoles_Id, OperatingUnits_ID, Name) VALUES (57, null, 1, null, 'Use Containerization (not yet rolled out - still in POC)'); 



--creating competenceDescriptions
-----------------------------------------------------------------------

INSERT INTO COMPETENCEDESCRIPTIONS (ID, DESCRIPTION, COMPETENCES_ID) VALUES (1, 'I can design, develop, test and deploy a CICS-application (CICS handling + PL1 + ACF2 API) on either an IDMS or DB2 database, using the standard development tooling (ADMI, TSO, TLNK, AbendAid, chainings) in line with the company standards.', 1);
INSERT INTO COMPETENCEDESCRIPTIONS (ID, DESCRIPTION, COMPETENCES_ID) VALUES (2, 'I can design, develop, test and deploy an online O* application on either an IDMS or O* database, using the standard software development tool(s), ADMI, Debug and testing tools, Database query tools and in line with the company standards (screen layout, design rules,...)', 2);
INSERT INTO COMPETENCEDESCRIPTIONS (ID, DESCRIPTION, COMPETENCES_ID) VALUES (3, 'I can design, develop, test and deploy a CICS-application as an IMSL service provider/requester (CICS handling + PL1 + IMSL procedures) on either an IDMS or DB2 database, using the standard software development tool(s), ADMI, Debug and testing tools, Database query tools.', 3);
INSERT INTO COMPETENCEDESCRIPTIONS (ID, DESCRIPTION, COMPETENCES_ID) VALUES (4, 'I can design, develop, test and deploy a CICS-application which is a webservice provider/requester (XML, CICS handling, SOAP API + PL1) on either an IDMS or DB2 database, using the standard software development tool(s), ADMI, Debug and testing tools, Database query tools.', 4);
INSERT INTO COMPETENCEDESCRIPTIONS (ID, DESCRIPTION, COMPETENCES_ID) VALUES (5, 'I can design, develop, test deploy a CICS-application which is a webservice provider/requester (XML, CICS handling, REST API + PL1) on either an IDMS or DB2 database, using the standard software development tool(s), ADMI, Debug and testing tools, Database query tools.', 5);
INSERT INTO COMPETENCEDESCRIPTIONS (ID, DESCRIPTION, COMPETENCES_ID) VALUES (6, 'I can design, develop, test and deploy a PL1 batch cycle including applications on either an IDMS or DB2 database, using the standard software development tool(s), ADMI, Debug and testing tools, Database query tools, in line with the company standards (EUP, design rules,...)', 6);
INSERT INTO COMPETENCEDESCRIPTIONS (ID, DESCRIPTION, COMPETENCES_ID) VALUES (7, 'I can design, develop, test and deploy a MF batch cycle including O* applications on an O* database, using the standard software development tool(s), ADMI, Debug and testing tools, Database query tools and in line with the company standards (design rules, EUP,...)', 7);
INSERT INTO COMPETENCEDESCRIPTIONS (ID, DESCRIPTION, COMPETENCES_ID) VALUES (8, 'I can design, develop, test and deploy a fullstack webapplication in Colruyt Java stack (baseframe, webframe, webtags) on either a Oracle or DB2 database, using the standard development tooling (RAD, IntelliJ/Eclipse, Git)', 8);
INSERT INTO COMPETENCEDESCRIPTIONS (ID, DESCRIPTION, COMPETENCES_ID) VALUES (9, 'I can design, develop, test and deploy a fullstack webapplication in the JSF-JEE stack (JSF, EJB, JPA) on either a Oracle or DB2 database, using the standard development tooling (IntelliJ/Eclipse, Git, Gradle)', 9);
INSERT INTO COMPETENCEDESCRIPTIONS (ID, DESCRIPTION, COMPETENCES_ID) VALUES (10, 'I can design, develop, test and deploy a backend application exposing REST services in the JEE stack (EJB, JPA/Hibernate), getting data either on an Oracle or DB2 database, using the development tooling (RAD, IntelliJ/Eclipse, RTC, RAM, Git)', 10);
INSERT INTO COMPETENCEDESCRIPTIONS (ID, DESCRIPTION, COMPETENCES_ID) VALUES (11, 'I can design, develop, test and deploy a backend application (using Java 8) exposing REST services in the Spring stack (SpringBoot, SpringCloud, JPA/Hibernate), getting data either on an Oracle or DB2 database, using the development tooling (IntelliJ/Eclipse, Git)', 11);
INSERT INTO COMPETENCEDESCRIPTIONS (ID, DESCRIPTION, COMPETENCES_ID) VALUES (12, 'I can design, develop, test and deploy a frontend application in a Javascript based framework running on Angular, JavaScript, TypeScript and HTML, interacting with (Spring) REST-services, using the standard development tooling (IntelliJ/Eclipse, Visual Code, Git)', 12);
INSERT INTO COMPETENCEDESCRIPTIONS (ID, DESCRIPTION, COMPETENCES_ID) VALUES (13, 'I can design, develop, test and deploy a java-application as an IMSL service provider/requester (java + IMSL procedures) on either an Oracle or DB2 database, using the standard software development tool(s) (RAD, Eclipse/IntelliJ,�)', 13);
INSERT INTO COMPETENCEDESCRIPTIONS (ID, DESCRIPTION, COMPETENCES_ID) VALUES (14, 'I can design, develop, test and deploy SOAP (JAX-WS) service provider and client application using the standard tooling (IntelliJ/Eclipse, Git, Gradle)', 14);
INSERT INTO COMPETENCEDESCRIPTIONS (ID, DESCRIPTION, COMPETENCES_ID) VALUES (15, 'I can design, develop, test and deploy REST (JAX-RS) service provider and client application using the standard tooling (Swagger/OpenAPI, IntelliJ/Eclipse, Git, Gradle)', 15);
INSERT INTO COMPETENCEDESCRIPTIONS (ID, DESCRIPTION, COMPETENCES_ID) VALUES (16, 'I can design, develop, test and deploy Async (JMS/EJB) service provider and client application using the standard tooling (AsyncAPI/YAML, IntelliJ/Eclipse, Git, Gradle)', 16);
INSERT INTO COMPETENCEDESCRIPTIONS (ID, DESCRIPTION, COMPETENCES_ID) VALUES (17, 'I can design, develop, test and deploy a loadcycle (XPS) based on sql-scripts on an Oracle database, using the standard software development tool(s).', 17);
INSERT INTO COMPETENCEDESCRIPTIONS (ID, DESCRIPTION, COMPETENCES_ID) VALUES (18, 'I can design, develop, test and deploy a loadcycle (XPS) based on PL/SQL on an Oracle database, using the standard software development tool(s).', 18);
INSERT INTO COMPETENCEDESCRIPTIONS (ID, DESCRIPTION, COMPETENCES_ID) VALUES (19, 'I can design, develop, test and deploy a fullstack webapplication using JSP and servlets, exposing the frontend by a Colruyt specific taglibrary and writing code relaying on the 1.5 Java code standard, getting data either on an Oracle or DB2 database, using the development tooling (WAS, RAM and RTC)', 19);
INSERT INTO COMPETENCEDESCRIPTIONS (ID, DESCRIPTION, COMPETENCES_ID) VALUES (20, 'I can design, develop, test and deploy Java batch (XPS) application using the standard tooling (IntelliJ/Eclipse, Git, Gradle)', 20);
INSERT INTO COMPETENCEDESCRIPTIONS (ID, DESCRIPTION, COMPETENCES_ID) VALUES (21, 'I can design, develop, test and deploy an Microsoft Access-based Island application, using the standard development tooling, in line with the company standards.', 21);
INSERT INTO COMPETENCEDESCRIPTIONS (ID, DESCRIPTION, COMPETENCES_ID) VALUES (22, 'I can design, develop, test and deploy an Microsoft Excel-based Island application, using the standard development tooling, in line with the company standards.', 22);
INSERT INTO COMPETENCEDESCRIPTIONS (ID, DESCRIPTION, COMPETENCES_ID) VALUES (23, 'I can design, develop, test and deploy a web or mobile application (using Wavemaker), interacting with (Spring) REST-services with a basic knowledge of JavaScript, Angular, HTML and CSS.', 23);
INSERT INTO COMPETENCEDESCRIPTIONS (ID, DESCRIPTION, COMPETENCES_ID) VALUES (24, 'I can design, develop, test and deploy a fullstack PDT Mobile application in Colruyt Java stack (baseframe, PDT-tags) on either a Oracle or DB2 database, using the standard development tooling (Visual Studio, RAD, IntelliJ/Eclipse, Git)', 24);
INSERT INTO COMPETENCEDESCRIPTIONS (ID, DESCRIPTION, COMPETENCES_ID) VALUES (25, 'I can design, develop, test and deploy a native mobile app in Android (using Java or Kotlin), interacting with REST-services, using the standard development tooling (Eclipse/Android Studio, Git).', 25);
INSERT INTO COMPETENCEDESCRIPTIONS (ID, DESCRIPTION, COMPETENCES_ID) VALUES (26, 'I can design, develop, test and deploy a native mobile app in iOS (using Swift), interacting with REST-services, using the standard development tooling (Xcode, Git).', 26);
INSERT INTO COMPETENCEDESCRIPTIONS (ID, DESCRIPTION, COMPETENCES_ID) VALUES (27, 'I can design, develop, test and deploy an application using the development tooling MS Visio, webMethods Designer, RTC and RAM, SOAPUI and Database query tools.', 27);
INSERT INTO COMPETENCEDESCRIPTIONS (ID, DESCRIPTION, COMPETENCES_ID) VALUES (28, 'I can design, develop, test and deploy an application of Trading Networks service using the development tooling MS Visio, webMethods Designer, My Webmethods Server, RTC and RAM', 28);
INSERT INTO COMPETENCEDESCRIPTIONS (ID, DESCRIPTION, COMPETENCES_ID) VALUES (29, 'I can design, implement, test and promote a Business Process Management Orchestration to manage the cooperation of processing and services in our ESB using webMethods Designer, My Webmethods Server, Universal Messaging, RAM and RTC.', 29);
INSERT INTO COMPETENCEDESCRIPTIONS (ID, DESCRIPTION, COMPETENCES_ID) VALUES (30, 'I can design, develop, test and deploy an application using the development tooling MS Visio, webMethods Designer, RTC and RAM, SOAPUI and Database query tools.', 30);
INSERT INTO COMPETENCEDESCRIPTIONS (ID, DESCRIPTION, COMPETENCES_ID) VALUES (31, 'I can design, develop, test and deploy an application using the development tooling MS Visio, webMethods Designer, RTC and RAM, SOAPUI, Postman and Database query tools.', 31);
INSERT INTO COMPETENCEDESCRIPTIONS (ID, DESCRIPTION, COMPETENCES_ID) VALUES (32, 'I can design, develop, test and deploy an application using the development tooling MS Visio, webMethods Designer, RTC and RAM, My webMethods Server, MQ and Database query tools.', 32);
INSERT INTO COMPETENCEDESCRIPTIONS (ID, DESCRIPTION, COMPETENCES_ID) VALUES (33, 'I can design, develop, test and deploy an application using the development tooling MS Visio, webMethods Designer, RTC and RAM, My webMethods Server, MQ and Database query tools.', 33);
INSERT INTO COMPETENCEDESCRIPTIONS (ID, DESCRIPTION, COMPETENCES_ID) VALUES (34, 'I can create, deploy and test virtual services using Centrasite, Mediator, SoapUI and Postman.', 34);
INSERT INTO COMPETENCEDESCRIPTIONS (ID, DESCRIPTION, COMPETENCES_ID) VALUES (36, 'I can design, develop, test and deploy an application in the PeopleSoft development platform (using PeopleCode ) on an Oracle DB using the standard PSFT development tooling (Application Designer).', 36);
INSERT INTO COMPETENCEDESCRIPTIONS (ID, DESCRIPTION, COMPETENCES_ID) VALUES (37, 'I can design, develop, test and deploy a XPS-cycle based on Application Engines, developed in the PeopleSoft development platform on an Oracle DB using the standard PSFT development tooling (Application Designer). I can also schedule an Application Engine myself in the PSFT-environment itself.', 37);
INSERT INTO COMPETENCEDESCRIPTIONS (ID, DESCRIPTION, COMPETENCES_ID) VALUES (38, 'I can design, develop, test and deploy a XPS-cycle based on SQR-scripts, developed in the PeopleSoft development platform on an Oracle DB using the standard PSFT development tooling.', 38);
INSERT INTO COMPETENCEDESCRIPTIONS (ID, DESCRIPTION, COMPETENCES_ID) VALUES (39, 'I can design, develop, test and deploy an Integration Broker webservice, using PeopleTools in PSFT.', 39);
INSERT INTO COMPETENCEDESCRIPTIONS (ID, DESCRIPTION, COMPETENCES_ID) VALUES (40, 'I can design, develop, test and deploy a responsive mobile webapplication in Fluid, interacting with a PSFT-backend, using the development environment of PSFT.', 40);
INSERT INTO COMPETENCEDESCRIPTIONS (ID, DESCRIPTION, COMPETENCES_ID) VALUES (41, 'I can design, develop, test and deploy a Sharepoint component with PowerShell/Javascript using the standard tools (Visual Studio Code, GIT, NPM)', 41);
INSERT INTO COMPETENCEDESCRIPTIONS (ID, DESCRIPTION, COMPETENCES_ID) VALUES (42, 'I can design, develop, test and deploy a native application in the SAP development platform (using ABAP, SAPGUI) on SAP HANA (with CDSViews) using the standard SAP development tooling (ABAP workbench).', 42);
INSERT INTO COMPETENCEDESCRIPTIONS (ID, DESCRIPTION, COMPETENCES_ID) VALUES (43, 'I can design, develop, test and deploy a backend SAP interface exposing iDoc or a Service, getting data on SAP HANA (CDSViews), using the default development tooling (SAP Workbench)', 43);
INSERT INTO COMPETENCEDESCRIPTIONS (ID, DESCRIPTION, COMPETENCES_ID) VALUES (44, 'I can design, develop, test and deploy a frontend web application in Fiori (Javascript, UI5) interacting with SAP backend interfaces.', 44);
INSERT INTO COMPETENCEDESCRIPTIONS (ID, DESCRIPTION, COMPETENCES_ID) VALUES (45, 'I can design, develop, test and deploy a XPS batch cycle including ABAP applications on a SAP HANA database, using the standard software development tool(s) (SAP Workbench)', 45);
INSERT INTO COMPETENCEDESCRIPTIONS (ID, DESCRIPTION, COMPETENCES_ID) VALUES (46, 'I can design, develop, test and deploy a BW datachain in the SAP development platform.', 46);
INSERT INTO COMPETENCEDESCRIPTIONS (ID, DESCRIPTION, COMPETENCES_ID) VALUES (47, 'I can create a universe based on a datamodel in order to create further reports using BO universe design tool, I can analyse the impacts of an universe modification, I can identify the needed universe modification(s) in order to answer to a report modification request, and I know how to bring it in production', 47);
INSERT INTO COMPETENCEDESCRIPTIONS (ID, DESCRIPTION, COMPETENCES_ID) VALUES (48, ' I can make a proposal of visualisation based on high level business needs, I know what the best practices are in order to find the most appropriate way to visualize data / information.', 48);
INSERT INTO COMPETENCEDESCRIPTIONS (ID, DESCRIPTION, COMPETENCES_ID) VALUES (49, 'I can use SAP BO webi in order to create a new report and to meet / challenge business expectations, I can do a retro-engineering of an existing report in order to modify it, and I know how to put this in production', 49);
INSERT INTO COMPETENCEDESCRIPTIONS (ID, DESCRIPTION, COMPETENCES_ID) VALUES (50, 'I can use tableau in order to create a new dashboard and to meet / challenge business expectations, I can do a retro-engineering of an existing dashboard in order to modify it, and I know how to put this in production', 50);
INSERT INTO COMPETENCEDESCRIPTIONS (ID, DESCRIPTION, COMPETENCES_ID) VALUES (51, 'I can, based on the requirements of the assignment I get, make an overview of the impact on our software. I can list out the required design and technical changes for the software components of the technologies I know using the adequate tooling provided', 51);
INSERT INTO COMPETENCEDESCRIPTIONS (ID, DESCRIPTION, COMPETENCES_ID) VALUES (52, 'I can create a data source based on a datamodel in order to create further dashboards using tableau desktop, I can analyse the impacts of a data source modification, I can identify the needed data source modification(s) in order to answer to a dashboard modification request, and I know how to bring it in production', 52);
INSERT INTO COMPETENCEDESCRIPTIONS (ID, DESCRIPTION, COMPETENCES_ID) VALUES (53, 'I can create Hana models, compile them and do performance tuning of these models using advanced SQL skills.', 53);
INSERT INTO COMPETENCEDESCRIPTIONS (ID, DESCRIPTION, COMPETENCES_ID) VALUES (54, 'I can initiate continuous integration and deployment for my (java/mobile) software components. I can write qualitative unit tests and setup a pipeline within Jenkins (in combination with Git, Gradle, Artifactory & SonarQube)', 54);
INSERT INTO COMPETENCEDESCRIPTIONS (ID, DESCRIPTION, COMPETENCES_ID) VALUES (55, 'I can monitor the performance of my developed software components, analyse the results and take the needed actions to improve it (using tools such as Dyntrace, Visual M, RAD Profiler).', 55);
INSERT INTO COMPETENCEDESCRIPTIONS (ID, DESCRIPTION, COMPETENCES_ID) VALUES (56, 'I can create/maintain the needed technical documentation on the software components I work on, for future reference (support & future projects) and share it with the team. I can create/maintain spot-on troubleshooters on the software I work on, to facilitate future support throughout the complete support line (1st line, 2nd,...) using our standard tooling (Solution) and share it with the support teams involved.', 56);
INSERT INTO COMPETENCEDESCRIPTIONS (ID, DESCRIPTION, COMPETENCES_ID) VALUES (57, 'I can built a Docker Image and run Docker Containers.  I can also work with Docker Compose.', 57);


--creating behavioralCompetencesLevels
-----------------------------------------------------------------------

INSERT INTO COMPETENCELEVELS (ID, COMPETENCES_ID, DESCRIPTION, ORDERLEVEL, ACTIVE) 
VALUES (1, 3, 'Knows the values and mission', 1, 0);

INSERT INTO COMPETENCELEVELS (ID, COMPETENCES_ID, DESCRIPTION, ORDERLEVEL, ACTIVE) 
VALUES ((SELECT MAX(ID) FROM COMPETENCELEVELS)+1, 3, 'Works in conformity with the values and mission', 2, 1);

INSERT INTO COMPETENCELEVELS (ID, COMPETENCES_ID, DESCRIPTION, ORDERLEVEL, ACTIVE) 
VALUES ((SELECT MAX(ID) FROM COMPETENCELEVELS)+1, 3, 'Follows up on behaviour of other people that does not correspond with the values and mission', 3, 0);

INSERT INTO COMPETENCELEVELS (ID, COMPETENCES_ID, DESCRIPTION, ORDERLEVEL, ACTIVE) 
VALUES ((SELECT MAX(ID) FROM COMPETENCELEVELS)+1, 3, 'Guards and illustrates the application of the values and mission', 4, 0);

INSERT INTO COMPETENCELEVELS (ID, COMPETENCES_ID, DESCRIPTION, ORDERLEVEL, ACTIVE) 
VALUES ((SELECT MAX(ID) FROM COMPETENCELEVELS)+1, 3, 'Links the company values and mission to each message and decision', 5, 0);

COMMIT;