-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2018-10-31 11:11:07.793

-- foreign keys
ALTER TABLE CompetenceLevels
    DROP CONSTRAINT Behavioral_Competences;

ALTER TABLE Competences
    DROP CONSTRAINT Competences_FunctionRoles;

ALTER TABLE Competences
    DROP CONSTRAINT Competences_Functions;

ALTER TABLE Competences
    DROP CONSTRAINT Competences_OperatingUnits;

ALTER TABLE CompetenceDescriptions
    DROP CONSTRAINT Descriptions_Competences;

ALTER TABLE TeamEnrolments
    DROP CONSTRAINT Enrolment_Team;

ALTER TABLE TeamEnrolments
    DROP CONSTRAINT Enrolments_UserPrivileges;

ALTER TABLE FunctionRoles
    DROP CONSTRAINT FunctionRoles_Functions;

ALTER TABLE FunctionRoles
    DROP CONSTRAINT FunctionRoles_Roles;

ALTER TABLE Functions
    DROP CONSTRAINT Functions_OperatingUnits;

ALTER TABLE Ratings
    DROP CONSTRAINT Ratings_Competences;

ALTER TABLE Ratings
    DROP CONSTRAINT Ratings_Surveys;

ALTER TABLE SurveySets
    DROP CONSTRAINT SurveySets_ConsensusSurvey;

ALTER TABLE SurveySets
    DROP CONSTRAINT SurveySets_ManagerSurvey;

ALTER TABLE SurveySets
    DROP CONSTRAINT SurveySets_MemberSurvey;

ALTER TABLE SurveySets
    DROP CONSTRAINT SurveySets_UserPrivileges;

ALTER TABLE TeamEnrolments
    DROP CONSTRAINT TeamEnrolments_Roles;

ALTER TABLE UserPrivileges
    DROP CONSTRAINT UserPrivileges_Functions;

ALTER TABLE UserPrivileges
    DROP CONSTRAINT UserPrivileges_Privis;

ALTER TABLE UserPrivileges
    DROP CONSTRAINT UserPrivileges_User;

-- tables
DROP TABLE CompetenceDescriptions;

DROP TABLE CompetenceLevels;

DROP TABLE Competences;

DROP TABLE FunctionRoles;

DROP TABLE Functions;

DROP TABLE OperatingUnits;

DROP TABLE Privis;

DROP TABLE Ratings;

DROP TABLE Roles;

DROP TABLE SurveySets;

DROP TABLE Surveys;

DROP TABLE TeamEnrolments;

DROP TABLE Teams;

DROP TABLE UserPrivileges;

DROP TABLE Users;

-- End of file.

