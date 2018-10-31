-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2018-10-31 11:11:07.793

-- tables
-- Table: CompetenceDescriptions
CREATE TABLE CompetenceDescriptions (
    ID integer  NOT NULL,
    Competences_ID int  NOT NULL,
    Description varchar2(500)  NOT NULL,
    CONSTRAINT CompetenceDescriptions_pk PRIMARY KEY (ID)
) ;

-- Table: CompetenceLevels
CREATE TABLE CompetenceLevels (
    ID int  NOT NULL,
    Competences_ID int  NOT NULL,
    Description varchar2(100)  NOT NULL,
    Active numeric(1,0)  NOT NULL,
    OrderLevel int  NOT NULL,
    CONSTRAINT BehavioralCompetenceLevels_pk PRIMARY KEY (ID)
) ;

-- Table: Competences
CREATE TABLE Competences (
    ID int  NOT NULL,
    Functions_ID int  NULL,
    OperatingUnits_ID int  NULL,
    FunctionRoles_ID int  NULL,
    Name varchar2(255)  NOT NULL,
    CONSTRAINT Competences_pk PRIMARY KEY (ID)
) ;

-- Table: FunctionRoles
CREATE TABLE FunctionRoles (
    ID int  NOT NULL,
    Roles_ID int  NOT NULL,
    Functions_ID int  NOT NULL,
    CONSTRAINT FunctionRoles_pk PRIMARY KEY (ID)
) ;

-- Table: Functions
CREATE TABLE Functions (
    ID int  NOT NULL,
    Title varchar2(255)  NOT NULL,
    OperatingUnits_ID int  NOT NULL,
    CONSTRAINT Functions_pk PRIMARY KEY (ID)
) ;

-- Table: OperatingUnits
CREATE TABLE OperatingUnits (
    ID int  NOT NULL,
    Title varchar2(50)  NOT NULL,
    CONSTRAINT OperatingUnits_pk PRIMARY KEY (ID)
) ;

-- Table: Privileges
CREATE TABLE "PRIVILEGES" (
    ID int  NOT NULL,
    FullName varchar2(100)  NOT NULL,
    ShortName char(1)  NOT NULL,
    CONSTRAINT Privileges_pk PRIMARY KEY (ID)
) ;

-- Table: Ratings
CREATE TABLE Ratings (
    Surveys_ID int  NOT NULL,
    Energy numeric(1,0)  NOT NULL,
    Commentary varchar2(255)  NULL,
    Competences_ID int  NOT NULL,
    CONSTRAINT Ratings_pk PRIMARY KEY (Surveys_ID)
) ;

-- Table: Roles
CREATE TABLE Roles (
    ID int  NOT NULL,
    Name varchar2(50)  NOT NULL,
    CONSTRAINT Roles_pk PRIMARY KEY (ID)
) ;

-- Table: SurveySets
CREATE TABLE SurveySets (
    ID int  NOT NULL,
    MemberSurvey int  NOT NULL,
    ManagerSurvey int  NOT NULL,
    ConsensusSurvey int  NOT NULL,
    Year date  NOT NULL,
    UserPrivileges_ID int  NOT NULL,
    CONSTRAINT SurveySets_pk PRIMARY KEY (ID)
) ;

-- Table: Surveys
CREATE TABLE Surveys (
    ID int  NOT NULL,
    DateCompleted timestamp  NULL,
    CONSTRAINT Surveys_pk PRIMARY KEY (ID)
) ;

-- Table: TeamEnrolments
CREATE TABLE TeamEnrolments (
    ID int  NOT NULL,
    Team_ID int  NOT NULL,
    UserPrivileges_id int  NOT NULL,
    Active numeric(1,0)  NOT NULL,
    Roles_ID int  NULL,
    CONSTRAINT TeamEnrolments_pk PRIMARY KEY (ID)
) ;

-- Table: Teams
CREATE TABLE Teams (
    ID int  NOT NULL,
    Name varchar2(255)  NOT NULL,
    CONSTRAINT Teams_pk PRIMARY KEY (ID)
) ;

-- Table: UserPrivileges
CREATE TABLE UserPrivileges (
    ID int  NOT NULL,
    User_ID int  NOT NULL,
    Functions_id int  NULL,
    Active number(1,0)  NOT NULL,
    Country char(2)  NULL,
    Privileges_ID int  NOT NULL,
    CONSTRAINT UserPrivileges_pk PRIMARY KEY (ID)
) ;

-- Table: Users
CREATE TABLE Users (
    ID int  NOT NULL,
    Firstname varchar2(100)  NOT NULL,
    Lastname varchar2(100)  NOT NULL,
    Email varchar2(255)  NOT NULL,
    Password varchar2(150)  NOT NULL,
    HomeCountry char(2)  NOT NULL,
    CONSTRAINT Users_pk PRIMARY KEY (ID)
) ;

-- foreign keys
-- Reference: Behavioral_Competences (table: CompetenceLevels)
ALTER TABLE CompetenceLevels ADD CONSTRAINT Behavioral_Competences
    FOREIGN KEY (Competences_ID)
    REFERENCES Competences (ID);

-- Reference: Competences_FunctionRoles (table: Competences)
ALTER TABLE Competences ADD CONSTRAINT Competences_FunctionRoles
    FOREIGN KEY (FunctionRoles_ID)
    REFERENCES FunctionRoles (ID);

-- Reference: Competences_Functions (table: Competences)
ALTER TABLE Competences ADD CONSTRAINT Competences_Functions
    FOREIGN KEY (Functions_ID)
    REFERENCES Functions (ID);

-- Reference: Competences_OperatingUnits (table: Competences)
ALTER TABLE Competences ADD CONSTRAINT Competences_OperatingUnits
    FOREIGN KEY (OperatingUnits_ID)
    REFERENCES OperatingUnits (ID);

-- Reference: Descriptions_Competences (table: CompetenceDescriptions)
ALTER TABLE CompetenceDescriptions ADD CONSTRAINT Descriptions_Competences
    FOREIGN KEY (Competences_ID)
    REFERENCES Competences (ID);

-- Reference: Enrolment_Team (table: TeamEnrolments)
ALTER TABLE TeamEnrolments ADD CONSTRAINT Enrolment_Team
    FOREIGN KEY (Team_ID)
    REFERENCES Teams (ID);

-- Reference: Enrolments_UserPrivileges (table: TeamEnrolments)
ALTER TABLE TeamEnrolments ADD CONSTRAINT Enrolments_UserPrivileges
    FOREIGN KEY (UserPrivileges_id)
    REFERENCES UserPrivileges (ID);

-- Reference: FunctionRoles_Functions (table: FunctionRoles)
ALTER TABLE FunctionRoles ADD CONSTRAINT FunctionRoles_Functions
    FOREIGN KEY (Functions_ID)
    REFERENCES Functions (ID);

-- Reference: FunctionRoles_Roles (table: FunctionRoles)
ALTER TABLE FunctionRoles ADD CONSTRAINT FunctionRoles_Roles
    FOREIGN KEY (Roles_ID)
    REFERENCES Roles (ID);

-- Reference: Functions_OperatingUnits (table: Functions)
ALTER TABLE Functions ADD CONSTRAINT Functions_OperatingUnits
    FOREIGN KEY (OperatingUnits_ID)
    REFERENCES OperatingUnits (ID);

-- Reference: Ratings_Competences (table: Ratings)
ALTER TABLE Ratings ADD CONSTRAINT Ratings_Competences
    FOREIGN KEY (Competences_ID)
    REFERENCES Competences (ID);

-- Reference: Ratings_Surveys (table: Ratings)
ALTER TABLE Ratings ADD CONSTRAINT Ratings_Surveys
    FOREIGN KEY (Surveys_ID)
    REFERENCES Surveys (ID);

-- Reference: SurveySets_ConsensusSurvey (table: SurveySets)
ALTER TABLE SurveySets ADD CONSTRAINT SurveySets_ConsensusSurvey
    FOREIGN KEY (ConsensusSurvey)
    REFERENCES Surveys (ID);

-- Reference: SurveySets_ManagerSurvey (table: SurveySets)
ALTER TABLE SurveySets ADD CONSTRAINT SurveySets_ManagerSurvey
    FOREIGN KEY (ManagerSurvey)
    REFERENCES Surveys (ID);

-- Reference: SurveySets_MemberSurvey (table: SurveySets)
ALTER TABLE SurveySets ADD CONSTRAINT SurveySets_MemberSurvey
    FOREIGN KEY (MemberSurvey)
    REFERENCES Surveys (ID);

-- Reference: SurveySets_UserPrivileges (table: SurveySets)
ALTER TABLE SurveySets ADD CONSTRAINT SurveySets_UserPrivileges
    FOREIGN KEY (UserPrivileges_ID)
    REFERENCES UserPrivileges (ID);

-- Reference: TeamEnrolments_Roles (table: TeamEnrolments)
ALTER TABLE TeamEnrolments ADD CONSTRAINT TeamEnrolments_Roles
    FOREIGN KEY (Roles_ID)
    REFERENCES Roles (ID);

-- Reference: UserPrivileges_Functions (table: UserPrivileges)
ALTER TABLE UserPrivileges ADD CONSTRAINT UserPrivileges_Functions
    FOREIGN KEY (Functions_id)
    REFERENCES Functions (ID);

-- Reference: UserPrivileges_Privileges (table: UserPrivileges)
ALTER TABLE UserPrivileges ADD CONSTRAINT UserPrivileges_Privileges
    FOREIGN KEY (Privileges_ID)
    REFERENCES "PRIVILEGES" (ID);

-- Reference: UserPrivileges_User (table: UserPrivileges)
ALTER TABLE UserPrivileges ADD CONSTRAINT UserPrivileges_User
    FOREIGN KEY (User_ID)
    REFERENCES Users (ID);

-- End of file.

