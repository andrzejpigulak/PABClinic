CREATE TABLE Patient(user_ID int UNIQUE NOT NULL, 
firstName varchar(20) not null, 
lastName varchar(20) NOT NULL,
userPassword varchar(20) NOT NULL,
pesel bigint UNIQUE NOT NULL,
login varchar(20) UNIQUE NOT NULL,
email varchar(50) UNIQUE NOT NULL,
telephoneNumber int NOT NULL,
address varchar(50),
postCode varchar(10),
city varchar(20),
PRIMARY KEY (user_ID));

CREATE TABLE Specialisation(Specialisation_ID int UNIQUE NOT NULL,
SpecialisationName varchar(20) UNIQUE NOT NULL),
PRIMARY KEY (Specialisation_ID));

CREATE TABLE Doctor(doctor_ID int UNIQUE NOT NULL,
firstName varchar(20) not null, 
lastName varchar(20) NOT NULL,
login varchar(20) UNIQUE NOT NULL,
doctorPassword varchar(20) NOT NULL,
ID_specialisation int NOT NULL,
PRIMARY KEY (doctor_ID),
FOREIGN KEY (ID_specialisation) REFERENCES Specialisation(Specialisation_ID));

INSERT INTO Patient(user_ID, firstName, lastName, userPassword, pesel, login, email, telephoneNumber, address, postCode, city )
VALUES (1,'Adam', 'Kowalski', 'haslo', 87110725732, 'akowalski', 'akowalski@mail.com', 627315621, 'ul. Marszalkowska 12', '61-001', 'Poznań'),
	   (2,'Katarzyna', 'Sikora','haslo',67032265927, 'ksikora', 'akowalski@mail.com', 504213521, 'ul. Grunwaldzka 25/3', '60-783', 'Poznań'),
	   (3,'Mariusz', 'Misiorny','haslo',48072685251, 'mariuszmisiorny', 'mariusz.misiorny@gmail.com', 852451267, 'ul. Mickiewicza 55/23', '01-625', 'Warszawa'),
	   (4,'Agnieszka', 'Sochaczewska','haslo',98122575235, 'agsoch', 'aga.socha@onet.pl', 695264216, 'ul. Alojzego Felińskiego 14', '01-513', 'Warszawa'),
	   (5,'Katarzyna', 'Politowicz','haslo',67071975251, 'kpolitowicz', 'polkata@onet.pl', 515525623, 'ul Małeckiego 16/12', '60-707', 'Poznań'),
	   (6,'Katarzyna', 'Cichopek','haslo',58090276921, 'kcichopek', 'k.cichopek@gmail.com', 725612562, 'ul. Małe Garbary 32', '61-756', 'Poznań'),
	   (7,'Tomasz', 'Karolak','haslo',65111252612, 'tomciokarol', 'tomciokarol@przykladowymail.com', 725516562, 'ul. Aleje Solidarności 21/2', '61-512', 'Poznań'),
	   (8,'Robert', 'Makłowicz','haslo',54102151362, 'kucharzmistrz', 'kucharzmistrz@maklowicz.com', 826125231, 'ul. Kucharska 21', '60-523', 'Poznań'),
	   (9,'Snoop', 'Dog','haslo',86110425124, 'snoopie', 'snoopiedogg@gmail.com', 666666420, 'ul. Weedowa 4/20', '60-420', 'Poznań'),
	   (10,'Edyta', 'Górniak','haslo',79041252123, 'edziaantyszczepionka', 'antyszczepionkowa@gmail.com', 752621272, 'ul. Antyszczepionkwa 21', '61-215', 'Poznań'),
	   (11,'Iwan', 'Delfin','haslo',65050276213, 'iwanplywak', 'plywamzdelfinami@onet.eu', 627631234, 'ul. Delfiny i orki 21', '61-521', 'Poznań');
	   
INSERT INTO Specialisation(Specialisation_ID, SpecialisationName)
VALUES  (1, 'LEKARZRODZINNY'),
		(2, 'DERMATOLOG'),
		(3, 'GINEKOLOG'),
		(4, 'OKULISTA'),
		(5, 'ORTOPEDA'),
		(6, 'PSYCHOLOG'),
		(7, 'PSYCHIATRA'),
		(8, 'LARYNGOLOG'),
		(9, 'NEUROLOG'),
		(10, 'UROLOG'),
		(11, 'POLOZNA'),
		(12, 'PIELEGNIARKA');
		
INSERT INTO doctor (doctor_ID, firstName, lastName, login, doctorPassword, ID_specialisation)
VALUES  (1,'Mateusz', 'Borek', 'matRod', 'meteuszborek', 1),
		(2,'Tomasz', 'Smokowski', 'tomRod', 'tomaszsmokowski', 1),
		(3,'Krzysztof', 'Stanowski', 'krzRod', 'krzysztofstanowski', 1),
		(4,'Michał', 'Pol', 'michRod', 'michalpol', 1),
		(5,'Anna', 'Dermatologowa', 'annaDer', 'annadermatologowa',2),
		(6,'Radosław', 'Majdan', 'radGin', 'radoslawmajdan', 3),
		(7,'Edgar', 'Davids', 'edgarOku', 'edgardavids', 4),
		(8,'Marcin', 'Wasilewski', 'marOrt', 'marcinwasilewski', 5),
		(9,'Katarzyna', 'Selwant', 'katPsy', 'katarzynaselwant', 6),
		(10,'Tomasz', 'Hajto', 'tomPsy', 'tomaszhajto', 7),
		(11,'Franz', 'Smuda', 'fraLar', 'franzsmuda', 8),
		(12,'Petr', 'Cech', 'petrNeu', 'petrcech', 9),
		(13,'Ewelina', 'Sterczewska', 'eweUro', 'ewasterczewska', 10),
		(14,'Zofia', 'Puk', 'zofiaPol', 'zofiapuk', 11),
		(15,'Joanna', 'Arcykoronna', 'joaPie', 'joannaarcykoronna', 12),
		(16,'Władysława', 'Kowalska', 'wlaPie', 'wladyslawakowalska', 12);