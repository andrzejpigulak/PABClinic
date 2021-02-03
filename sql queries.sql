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
city varchar(20)));

CREATE TABLE Doctor(doctor_ID int UNIQUE NOT NULL,
firstName varchar(20) not null, 
lastName varchar(20) NOT NULL,
login varchar(20) UNIQUE NOT NULL,
doctorPassword varchar(20) NOT NULL,
specialisation varchar(20) NOT NULL,
PRIMARY KEY (doctor_ID))

CREATE TABLE Badania(
	badanie_ID serial PRIMARY KEY,
	nazwaBadania varchar(50) NOT NULL,
	cenaBadania int NOT NULL	
)


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
	   
		
INSERT INTO doctor (doctor_ID, firstName, lastName, login, doctorPassword, specialisation)
VALUES  (1,'Mateusz', 'Borek', 'matRod', 'meteuszborek', 'LEKARZRODZINNY'),
		(2,'Tomasz', 'Smokowski', 'tomRod', 'tomaszsmokowski', 'LEKARZRODZINNY'),
		(3,'Krzysztof', 'Stanowski', 'krzRod', 'krzysztofstanowski', 'LEKARZRODZINNY'),
		(4,'Michał', 'Pol', 'michRod', 'michalpol', 'LEKARZRODZINNY'),
		(5,'Anna', 'Dermatologowa', 'annaDer', 'annadermatologowa','DERMATOLOG'),
		(6,'Radosław', 'Majdan', 'radGin', 'radoslawmajdan', 'GINEKOLOG'),
		(7,'Edgar', 'Davids', 'edgarOku', 'edgardavids', 'OKULISTA'),
		(8,'Marcin', 'Wasilewski', 'marOrt', 'marcinwasilewski', 'ORTOPEDA'),
		(9,'Katarzyna', 'Selwant', 'katPsy', 'katarzynaselwant', 'PSYCHOLOG'),
		(10,'Tomasz', 'Hajto', 'tomPsy', 'tomaszhajto', 'PSYCHIATRA'),
		(11,'Franz', 'Smuda', 'fraLar', 'franzsmuda', 'LARYNGOLOG'),
		(12,'Petr', 'Cech', 'petrNeu', 'petrcech', 'NEUROLOG'),
		(13,'Ewelina', 'Sterczewska', 'eweUro', 'ewasterczewska', 'UROLOG'),
		(14,'Zofia', 'Puk', 'zofiaPol', 'zofiapuk', 'POLOZNA'),
		(15,'Joanna', 'Arcykoronna', 'joaPie', 'joannaarcykoronna', 'PIELEGNIARKA'),
		(16,'Władysława', 'Kowalska', 'wlaPie', 'wladyslawakowalska', 'PIELEGNIARKA');
		
INSERT INTO Badania(badanie_ID, nazwaBadania, cenaBadania)
VALUES
	(1, 'AFP', 30),
	(2, 'ALAT', 9),
	(3, 'Albumina', 10),
	(4, 'AP fosfataza zasadowa', 9),
	(5, 'AMH - hormon antymullerowski', 130),
	(6, 'Amylaza', 12),
	(7, 'ANA Hep - 2/LIVER MONKEY', 40),
	(8, 'ANA-test potwierdzenia metodą EUROLINE', 120),
	(9, 'ANCA IIF', 60),
	(10, 'ANCA - test potwierdzenia metodą EUROLINE', 70),
	(11, 'AMA-M2, M2-3E (BPO), Rybosomalne białko P', 150),
	(12, 'Anty CCP (cyclic cytrulinated peptide) Elisa', 42),
	(13, 'AntyGEN HBS', 17),
	(14, 'APTT (czas K-K)', 15),
	(15, 'ASO', 20),
	(16, 'ASPAT', 19),
	(17, 'Badanie kału na krew utajoną', 15),
	(18, 'Beta - HCG', 28),
	(19, 'Białko', 9),
	(20, 'Białko - mocz DZM', 7),
	(21, 'Białko + elektroforeza białek', 30),
	(22, 'Bilirubina całkowita', 9),
	(23, 'Ca całkowity', 7),
	(24, 'Cholestelor', 10),
	(25, 'Estradiol', 26),
	(26, 'Ferrytyna', 30),
	(27, 'Fosforany', 49),
	(28, 'Ft3', 25),
	(29, 'Glukoza', 9),
	(30, 'Homocysteina', 42),
	(31, 'Kortyzol', 32),
	(32, 'Insulina', 30);