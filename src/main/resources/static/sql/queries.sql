drop table if exists users;
drop table if exists badania;
drop table if exists visit;
drop table if exists visitDao;
drop table if exists visitHistory;


CREATE TABLE Users(
user_ID SERIAL PRIMARY KEY,
    firstName varchar(20) not null,
    lastName varchar(20) NOT NULL,
    username varchar(20) UNIQUE NOT NULL,
    password varchar(128) NOT NULL,
    pesel bigint UNIQUE,
    email varchar(50) UNIQUE,
    telephoneNumber int,
    address varchar(50),
    postCode varchar(10),
    city varchar(20),
    enabled BOOLEAN NOT NULL DEFAULT TRUE,
    specialisation varchar(20),
    role varchar (6) NOT NULL
    );

CREATE TABLE Badania(
	badanie_ID serial PRIMARY KEY,
	nazwaBadania varchar(50) NOT NULL,
	cenaBadania int NOT NULL
);

CREATE TABLE Visit(
	visit_ID serial PRIMARY KEY,
    visitDate varchar(20),
    visitTime varchar(20),
    doctorName varchar(20),
    doctorLastName varchar(20),
	doctorUsername varchar(10),
    patientName varchar(20),
    patientLastName varchar(20),
	patientUsername varchar (20)
);

CREATE TABLE VisitDao(
visitTime varchar(20)
);

CREATE TABLE VisitHistory (
    visit_ID serial PRIMARY KEY,
    visitDate varchar(20),
    doctorName varchar(20),
    doctorLastName varchar(20),
	doctorUserName varchar(7),
    patientName varchar(20),
    patientLastName varchar(20),
	patientUserName varchar(20),
    visitDescription varchar(1000)
);


INSERT INTO Users(firstName, lastName, password, pesel, username, email, telephoneNumber, address, postCode, city, enabled, role)
VALUES ('Adam', 'Kowalski', '$2a$10$9UU02QHTjSf4qBtyowylpO7053v126C9W2KYQnxrdQkQ7/WHN/C3W', 87110725732, 'akowalski', 'akowalski@mail.com', 627315621, 'ul. Marszalkowska 12', '61-001', 'Poznań', true, 'USER'),
	   ('Katarzyna', 'Sikora','$2a$10$jVRlVK7bdZs4meWCxxen4ewO/rutuZZ7GxWIhDhpBJPSQLC76Iosi',67032265927, 'ksikora', 'akowalska@mail.com', 504213521, 'ul. Grunwaldzka 25/3', '60-783', 'Poznań', true, 'USER'),
	   ('Mariusz', 'Misiorny','haslo',48072685251, 'mariuszmisiorny', 'mariusz.misiorny@gmail.com', 852451267, 'ul. Mickiewicza 55/23', '01-625', 'Warszawa', true, 'USER'),
	   ('Agnieszka', 'Sochaczewska','$2a$10$PKJia/Bsgac1zWKcpNFUou8zDJCy7bqJHdlx1DlP/GHze9Q8zApGu',98122575235, 'agsoch', 'aga.socha@onet.pl', 695264216, 'ul. Alojzego Felińskiego 14', '01-513', 'Warszawa', true, 'USER'),
	   ('Katarzyna', 'Politowicz','haslo',67071975251, 'kpolitowicz', 'polkata@onet.pl', 515525623, 'ul Małeckiego 16/12', '60-707', 'Poznań', true, 'USER'),
	   ('Katarzyna', 'Cichopek','haslo',58090276921, 'kcichopek', 'k.cichopek@gmail.com', 725612562, 'ul. Małe Garbary 32', '61-756', 'Poznań', true, 'USER'),
	   ('Tomasz', 'Karolak','haslo',65111252612, 'tomciokarol', 'tomciokarol@przykladowymail.com', 725516562, 'ul. Aleje Solidarności 21/2', '61-512', 'Poznań', true, 'USER'),
	   ('Robert', 'Makłowicz','haslo',54102151362, 'kucharzmistrz', 'kucharzmistrz@maklowicz.com', 826125231, 'ul. Kucharska 21', '60-523', 'Poznań', true, 'USER'),
	   ('Snoop', 'Dog','haslo',86110425124, 'snoopie', 'snoopiedogg@gmail.com', 666666420, 'ul. Weedowa 4/20', '60-420', 'Poznań', true, 'USER'),
	   ('Edyta', 'Górniak','haslo',79041252123, 'edziaantyszczepionka', 'antyszczepionkowa@gmail.com', 752621272, 'ul. Antyszczepionkwa 21', '61-215', 'Poznań', true, 'USER'),
	   ('Iwan', 'Delfin','haslo',65050276213, 'iwanplywak', 'plywamzdelfinami@onet.eu', 627631234, 'ul. Delfiny i orki 21', '61-521', 'Poznań', true, 'USER');


INSERT INTO Users (firstName, lastName, username, password, specialisation, enabled, role)
VALUES  ('Mateusz', 'Borek', 'matRod', 'meteuszborek', 'LEKARZRODZINNY',true, 'DOCTOR'),
		('Tomasz', 'Smokowski', 'tomRod', 'tomaszsmokowski', 'LEKARZRODZINNY', true, 'DOCTOR'),
		('Krzysztof', 'Stanowski', 'krzRod', '$2a$10$AUc4o/jne0guukYoQZHuYO0NzY9NIqnU1FWAooTn4dIqPA6xFMXXq', 'LEKARZRODZINNY', true, 'DOCTOR'),
		('Michał', 'Pol', 'michRod', 'michalpol', 'LEKARZRODZINNY', true, 'DOCTOR'),
		('Anna', 'Dermatologowa', 'annaDer', 'annadermatologowa','DERMATOLOG', true, 'DOCTOR'),
		('Radosław', 'Majdan', 'radGin', 'radoslawmajdan', 'GINEKOLOG', true, 'DOCTOR'),
		('Edgar', 'Davids', 'edgarOku', 'edgardavids', 'OKULISTA', true, 'DOCTOR'),
		('Marcin', 'Wasilewski', 'marOrt', 'marcinwasilewski', 'ORTOPEDA', true, 'DOCTOR'),
		('Katarzyna', 'Selwant', 'katPsy', 'katarzynaselwant', 'PSYCHOLOG', true, 'DOCTOR'),
		('Tomasz', 'Hajto', 'tomPsy', 'tomaszhajto', 'PSYCHIATRA', true, 'DOCTOR'),
		('Franz', 'Smuda', 'fraLar', 'franzsmuda', 'LARYNGOLOG', true, 'DOCTOR'),
		('Petr', 'Cech', 'petrNeu', 'petrcech', 'NEUROLOG', true, 'DOCTOR'),
		('Ewelina', 'Sterczewska', 'eweUro', 'ewasterczewska', 'UROLOG', true, 'DOCTOR'),
		('Zofia', 'Puk', 'zofiaPol', 'zofiapuk', 'POLOZNA', true, 'DOCTOR'),
		('Joanna', 'Arcykoronna', 'joaPie', 'joannaarcykoronna', 'PIELEGNIARKA', true, 'DOCTOR'),
		('Władysława', 'Kowalska', 'wlaPie', 'wladyslawakowalska', 'PIELEGNIARKA', true, 'DOCTOR');


INSERT INTO Users (firstName, lastName, username, password, enabled, role) values
	('adminName', 'admin lastName', 'admin', '$2a$10$x339SuMBk8CKsxFhTCilJOTkDMjHWyCbXRdtBH7B00onLCMRwHgAi', true, 'ADMIN' );

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

INSERT INTO Visit(visit_ID, visitDate, visitTime, doctorName, doctorLastName, doctorUsername, patientName, patientLastName, patientUsername)
VALUES

	(1, '2021-02-19', '8:00', 'Krzysztof', 'Stanowski', 'krzRod', 'Adam', 'Kowalski', 'akowalski'),
	(2, '2021-02-19','8:30', 'Krzysztof', 'Stanowski', 'krzRod', 'Katarzyna', 'Sikora', 'ksikora'),
	(3, '2021-02-19','9:00', 'Krzysztof', 'Stanowski', 'krzRod', 'Mariusz', 'Misiorny', 'mariuszmisiorny'),
	(4, '2021-02-19','9:30', 'Katarzyna', 'Selwant', 'KatPsy', 'Adam', 'Kowalski', 'akowalski'),
	(5, '2021-02-19','10:00', 'Anna', 'Dermatologowa', 'annaDer', 'Iwan', 'Delfin', 'iwanplywak'),
 	(6, '2021-02-19','10:30', 'Katarzyna', 'Selwant', 'katPsy', 'Edyta', 'Gorniak', 'edziaantyszczepionka'),
	(7, '2021-02-19','11:00', 'Radoslaw', 'Majdan', 'radGin', 'Edyta', 'Gorniak', 'edziaantyszczepionka'),
	(8, '2021-02-19','11:30', 'Krzysztof', 'Stanowski', 'krzRod', 'Snoop', 'Dogg', 'snoopie'),
	(9, '2021-02-19','12:00', 'Mateusz', 'Borek', 'matRod', 'Katarzyna', 'Politowicz','kpolitowicz'),
	(10,'2021-02-19','12:30', 'Mateusz', 'Borek', 'matRod', 'Robert', 'Makłowicz', 'kucharzmistrz');


INSERT INTO VisitDao(visitTime) VALUES

    ('8:00'),
    ('8:30'),
    ('9:00'),
    ('9:30'),
    ('10:00'),
    ('10:30'),
    ('11:00'),
    ('11:30'),
    ('12:00'),
    ('12:30'),
    ('13:00'),
    ('13:30'),
    ('14:30'),
    ('15:00'),
    ('15:30'),
    ('16:00');

