drop table if exists patient;
drop table if exists doctor;
drop table if exists badania;

CREATE TABLE Patient(user_ID serial PRIMARY KEY, 
firstName varchar(20) not null, 
lastName varchar(20) NOT NULL,
userPassword varchar(20) NOT NULL,
pesel bigint UNIQUE NOT NULL,
login varchar(20) UNIQUE NOT NULL,
email varchar(50) UNIQUE NOT NULL,
telephoneNumber int NOT NULL,
address varchar(50),
postCode varchar(10),
city varchar(20));

CREATE TABLE Doctor(doctor_ID serial PRIMARY KEY,
firstName varchar(20) not null, 
lastName varchar(20) NOT NULL,
login varchar(20) UNIQUE NOT NULL,
doctorPassword varchar(20) NOT NULL,
specialisation varchar(20) NOT NULL);

CREATE TABLE Badania(
	badanie_ID serial PRIMARY KEY,
	nazwaBadania varchar(50) NOT NULL,
	cenaBadania int NOT NULL	
)


INSERT INTO Patient(firstName, lastName, userPassword, pesel, login, email, telephoneNumber, address, postCode, city )
VALUES ('Adam', 'Kowalski', 'haslo', 87110725732, 'akowalski', 'akowalski@mail.com', 627315621, 'ul. Marszalkowska 12', '61-001', 'Poznań'),
	   ('Katarzyna', 'Sikora','haslo',67032265927, 'ksikora', 'akowalska@mail.com', 504213521, 'ul. Grunwaldzka 25/3', '60-783', 'Poznań'),
	   ('Mariusz', 'Misiorny','haslo',48072685251, 'mariuszmisiorny', 'mariusz.misiorny@gmail.com', 852451267, 'ul. Mickiewicza 55/23', '01-625', 'Warszawa'),
	   ('Agnieszka', 'Sochaczewska','haslo',98122575235, 'agsoch', 'aga.socha@onet.pl', 695264216, 'ul. Alojzego Felińskiego 14', '01-513', 'Warszawa'),
	   ('Katarzyna', 'Politowicz','haslo',67071975251, 'kpolitowicz', 'polkata@onet.pl', 515525623, 'ul Małeckiego 16/12', '60-707', 'Poznań'),
	   ('Katarzyna', 'Cichopek','haslo',58090276921, 'kcichopek', 'k.cichopek@gmail.com', 725612562, 'ul. Małe Garbary 32', '61-756', 'Poznań'),
	   ('Tomasz', 'Karolak','haslo',65111252612, 'tomciokarol', 'tomciokarol@przykladowymail.com', 725516562, 'ul. Aleje Solidarności 21/2', '61-512', 'Poznań'),
	   ('Robert', 'Makłowicz','haslo',54102151362, 'kucharzmistrz', 'kucharzmistrz@maklowicz.com', 826125231, 'ul. Kucharska 21', '60-523', 'Poznań'),
	   ('Snoop', 'Dog','haslo',86110425124, 'snoopie', 'snoopiedogg@gmail.com', 666666420, 'ul. Weedowa 4/20', '60-420', 'Poznań'),
	   ('Edyta', 'Górniak','haslo',79041252123, 'edziaantyszczepionka', 'antyszczepionkowa@gmail.com', 752621272, 'ul. Antyszczepionkwa 21', '61-215', 'Poznań'),
	   ('Iwan', 'Delfin','haslo',65050276213, 'iwanplywak', 'plywamzdelfinami@onet.eu', 627631234, 'ul. Delfiny i orki 21', '61-521', 'Poznań');
	   
		
INSERT INTO doctor (firstName, lastName, login, doctorPassword, specialisation)
VALUES  ('Mateusz', 'Borek', 'matRod', 'meteuszborek', 'LEKARZRODZINNY'),
		('Tomasz', 'Smokowski', 'tomRod', 'tomaszsmokowski', 'LEKARZRODZINNY'),
		('Krzysztof', 'Stanowski', 'krzRod', 'krzysztofstanowski', 'LEKARZRODZINNY'),
		('Michał', 'Pol', 'michRod', 'michalpol', 'LEKARZRODZINNY'),
		('Anna', 'Dermatologowa', 'annaDer', 'annadermatologowa','DERMATOLOG'),
		('Radosław', 'Majdan', 'radGin', 'radoslawmajdan', 'GINEKOLOG'),
		('Edgar', 'Davids', 'edgarOku', 'edgardavids', 'OKULISTA'),
		('Marcin', 'Wasilewski', 'marOrt', 'marcinwasilewski', 'ORTOPEDA'),
		('Katarzyna', 'Selwant', 'katPsy', 'katarzynaselwant', 'PSYCHOLOG'),
		('Tomasz', 'Hajto', 'tomPsy', 'tomaszhajto', 'PSYCHIATRA'),
		('Franz', 'Smuda', 'fraLar', 'franzsmuda', 'LARYNGOLOG'),
		('Petr', 'Cech', 'petrNeu', 'petrcech', 'NEUROLOG'),
		('Ewelina', 'Sterczewska', 'eweUro', 'ewasterczewska', 'UROLOG'),
		('Zofia', 'Puk', 'zofiaPol', 'zofiapuk', 'POLOZNA'),
		('Joanna', 'Arcykoronna', 'joaPie', 'joannaarcykoronna', 'PIELEGNIARKA'),
		('Władysława', 'Kowalska', 'wlaPie', 'wladyslawakowalska', 'PIELEGNIARKA');
		
INSERT INTO Badania(nazwaBadania, cenaBadania)
VALUES
	('AFP', 30),
	('ALAT', 9),
	('Albumina', 10),
	('AP fosfataza zasadowa', 9),
	('AMH - hormon antymullerowski', 130),
	('Amylaza', 12),
	('ANA Hep - 2/LIVER MONKEY', 40),
	('ANA-test potwierdzenia metodą EUROLINE', 120),
	('ANCA IIF', 60),
	('ANCA - test potwierdzenia metodą EUROLINE', 70),
	('AMA-M2, M2-3E (BPO), Rybosomalne białko P', 150),
	('Anty CCP (cyclic cytrulinated peptide) Elisa', 42),
	('AntyGEN HBS', 17),
	('APTT (czas K-K)', 15),
	('ASO', 20),
	('ASPAT', 19),
	('Badanie kału na krew utajoną', 15),
	('Beta - HCG', 28),
	('Białko', 9),
	('Białko - mocz DZM', 7),
	('Białko + elektroforeza białek', 30),
	('Bilirubina całkowita', 9),
	('Ca całkowity', 7),
	('Cholestelor', 10),
	('Estradiol', 26),
	('Ferrytyna', 30),
	('Fosforany', 49),
	('Ft3', 25),
	('Glukoza', 9),
	('Homocysteina', 42),
	('Kortyzol', 32),
	('Insulina', 30);