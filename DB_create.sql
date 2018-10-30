-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2018-10-30 14:10:36.597

-- tables
-- Table: BehavioralCompetenceLevels
CREATE TABLE BehavioralCompetenceLevels (
    ID int NOT NULL,
    Competences_ID int NOT NULL,
    DescriptionLevel varchar(100) NOT NULL,
    Active numeric(1,0) NOT NULL,
    CONSTRAINT BehavioralCompetenceLevels_pk PRIMARY KEY (ID)
);

-- Table: Competences
CREATE TABLE Competences (
    ID int NOT NULL,
    Functions_ID int NULL,
    Roles_ID int NULL,
    OperatingUnits_ID int NULL,
    Name varchar(255) NOT NULL,
    Description varchar(255) NOT NULL,
    CONSTRAINT Competences_pk PRIMARY KEY (ID)
);

-- Table: FunctionRoles
CREATE TABLE FunctionRoles (
    ID int NOT NULL,
    Roles_ID int NOT NULL,
    Functions_ID int NOT NULL,
    CONSTRAINT FunctionRoles_pk PRIMARY KEY (ID)
);

-- Table: Functions
CREATE TABLE Functions (
    ID int NOT NULL,
    Title varchar(255) NOT NULL,
    OperatingUnits_ID int NOT NULL,
    CONSTRAINT Functions_pk PRIMARY KEY (ID)
);

-- Table: OperatingUnits
CREATE TABLE OperatingUnits (
    ID int NOT NULL,
    Title varchar(50) NOT NULL,
    CONSTRAINT OperatingUnits_pk PRIMARY KEY (ID)
);

-- Table: Ratings
CREATE TABLE Ratings (
    Surveys_ID int NOT NULL,
    Energy numeric(1,0) NOT NULL,
    Commentary varchar(255) NULL,
    Competences_ID int NOT NULL,
    CONSTRAINT Ratings_pk PRIMARY KEY (Surveys_ID)
);

-- Table: Roles
CREATE TABLE Roles (
    ID int NOT NULL,
    Name varchar(50) NOT NULL,
    CONSTRAINT Roles_pk PRIMARY KEY (ID)
);

-- Table: SurveySets
CREATE TABLE SurveySets (
    ID int NOT NULL,
    MemberSurvey int NOT NULL,
    ManagerSurvey int NOT NULL,
    ConsensusSurvey int NOT NULL,
    Year date NOT NULL,
    Enrolments_ID int NOT NULL,
    CONSTRAINT SurveySets_pk PRIMARY KEY (ID)
);

-- Table: Surveys
CREATE TABLE Surveys (
    ID int NOT NULL,
    DateCompleted timestamp NULL,
    CONSTRAINT Surveys_pk PRIMARY KEY (ID)
);

-- Table: TeamEnrolments
CREATE TABLE TeamEnrolments (
    ID int NOT NULL,
    Team_ID int NOT NULL,
    UserPrivileges_id int NOT NULL,
    Active numeric(1,0) NOT NULL,
    Roles_ID int,
    CONSTRAINT TeamEnrolments_pk PRIMARY KEY (ID)
);

-- Table: Teams
CREATE TABLE Teams (
    ID int NOT NULL,
    Name varchar(255) NOT NULL,
    CONSTRAINT Teams_pk PRIMARY KEY (ID)
);

-- Table: UserPrivileges
CREATE TABLE UserPrivileges (
    ID int NOT NULL,
    Privilege char(1) NOT NULL,
    User_ID int NOT NULL,
    Functions_id int NULL,
    CONSTRAINT UserPrivileges_pk PRIMARY KEY (ID)
);

-- Table: Users
CREATE TABLE Users (
    ID int NOT NULL,
    Firstname varchar(100) NOT NULL,
    Lastname varchar(100) NOT NULL,
    Email varchar(255) NOT NULL,
    Password varchar(150) NOT NULL,
    CONSTRAINT Users_pk PRIMARY KEY (ID)
);

-- foreign keys
-- Reference: Behavioral_Competences (table: BehavioralCompetenceLevels)
ALTER TABLE BehavioralCompetenceLevels ADD CONSTRAINT Behavioral_Competences FOREIGN KEY (Competences_ID)
    REFERENCES Competences (ID);

-- Reference: Competences_Functions (table: Competences)
ALTER TABLE Competences ADD CONSTRAINT Competences_Functions FOREIGN KEY (Functions_ID)
    REFERENCES Functions (ID);

-- Reference: Competences_OperatingUnits (table: Competences)
ALTER TABLE Competences ADD CONSTRAINT Competences_OperatingUnits FOREIGN KEY (OperatingUnits_ID)
    REFERENCES OperatingUnits (ID);

-- Reference: Competences_Roles (table: Competences)
ALTER TABLE Competences ADD CONSTRAINT Competences_Roles FOREIGN KEY (Roles_ID)
    REFERENCES Roles (ID);

-- Reference: Enrolment_Team (table: TeamEnrolments)
ALTER TABLE TeamEnrolments ADD CONSTRAINT Enrolment_Team FOREIGN KEY (Team_ID)
    REFERENCES Teams (ID);

-- Reference: Enrolments_UserPrivileges (table: TeamEnrolments)
ALTER TABLE TeamEnrolments ADD CONSTRAINT Enrolments_UserPrivileges FOREIGN KEY (UserPrivileges_id)
    REFERENCES UserPrivileges (ID);

-- Reference: FunctionRoles_Functions (table: FunctionRoles)
ALTER TABLE FunctionRoles ADD CONSTRAINT FunctionRoles_Functions FOREIGN KEY (Functions_ID)
    REFERENCES Functions (ID);

-- Reference: FunctionRoles_Roles (table: FunctionRoles)
ALTER TABLE FunctionRoles ADD CONSTRAINT FunctionRoles_Roles FOREIGN KEY (Roles_ID)
    REFERENCES Roles (ID);

-- Reference: Functions_OperatingUnits (table: Functions)
ALTER TABLE Functions ADD CONSTRAINT Functions_OperatingUnits FOREIGN KEY (OperatingUnits_ID)
    REFERENCES OperatingUnits (ID);

-- Reference: Ratings_Competences (table: Ratings)
ALTER TABLE Ratings ADD CONSTRAINT Ratings_Competences FOREIGN KEY (Competences_ID)
    REFERENCES Competences (ID);

-- Reference: Ratings_Surveys (table: Ratings)
ALTER TABLE Ratings ADD CONSTRAINT Ratings_Surveys FOREIGN KEY (Surveys_ID)
    REFERENCES Surveys (ID);

-- Reference: SurveySets_ConsensusSurvey (table: SurveySets)
ALTER TABLE SurveySets ADD CONSTRAINT SurveySets_ConsensusSurvey FOREIGN KEY (ConsensusSurvey)
    REFERENCES Surveys (ID);

-- Reference: SurveySets_Enrolments (table: SurveySets)
ALTER TABLE SurveySets ADD CONSTRAINT SurveySets_Enrolments FOREIGN KEY (Enrolments_ID)
    REFERENCES TeamEnrolments (ID);

-- Reference: SurveySets_ManagerSurvey (table: SurveySets)
ALTER TABLE SurveySets ADD CONSTRAINT SurveySets_ManagerSurvey FOREIGN KEY (ManagerSurvey)
    REFERENCES Surveys (ID);

-- Reference: SurveySets_MemberSurvey (table: SurveySets)
ALTER TABLE SurveySets ADD CONSTRAINT SurveySets_MemberSurvey FOREIGN KEY (MemberSurvey)
    REFERENCES Surveys (ID);

-- Reference: TeamEnrolments_Roles (table: TeamEnrolments)
ALTER TABLE TeamEnrolments ADD CONSTRAINT TeamEnrolments_Roles FOREIGN KEY (Roles_ID)
    REFERENCES Roles (ID);

-- Reference: UserPrivileges_Functions (table: UserPrivileges)
ALTER TABLE UserPrivileges ADD CONSTRAINT UserPrivileges_Functions FOREIGN KEY (Functions_id)
    REFERENCES Functions (ID);

-- Reference: UserPrivileges_User (table: UserPrivileges)
ALTER TABLE UserPrivileges ADD CONSTRAINT UserPrivileges_User FOREIGN KEY (User_ID)
    REFERENCES Users (ID);

-- End of file.

