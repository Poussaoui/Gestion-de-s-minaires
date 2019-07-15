
drop table Reservations;
drop table Participants;
drop table Presentation;
drop table Conferenciers;
drop table Activites;
drop table Seminaire;
drop table Salles;
drop table Prestataire;
drop table Animateur;

create table Animateur(
	noAnim INTEGER constraint noanim_pk primary key,
	nomAnim VARCHAR(30) not null,
	prenomAnim VARCHAR(30) not null,
	pass VARCHAR(10) not null,
	adresseAnim VARCHAR(70) ,
	telAnim VARCHAR(13) ,
	mailAnim VARCHAR(30) 
);

create table Prestataire(
	id_prest INTEGER constraint id_prest_pk primary key,
	nomPrest VARCHAR(30) not null,
	adresse VARCHAR(70) not null,
	tel VARCHAR(13) not null,
	tarifSalle INTEGER not null,
	tarifPause INTEGER not null,
	tarifDej INTEGER not null,
	constraint tarif_s_check check(tarifSalle >= 0),
	constraint tarif_p_check check(tarifPause >= 0),
	constraint tarif_r_check check(tarifDej >= 0)
);

create table Salles(
	noSalle INTEGER,
	id_prest INTEGER,
	nbplaces INTEGER constraint nbplaces_check check(nbplaces > 0),
	constraint salle_pk primary key (noSalle,id_prest),
	constraint id_prest_fk Foreign key (id_prest) references prestataire(id_prest)
);

create table Seminaire(
	id_sem INTEGER constraint id_sem_pk primary key,
	id_prest INTEGER,
	noSalle INTEGER,
	noAnim INTEGER,
	theme VARCHAR(30) not null,
	type_sem VARCHAR(2) not null,
	dejeuner VARCHAR(3) constraint dejeuner_check check(dejeuner in ('oui','non')),
	tarifPart INTEGER,
	nbmaxPart INTEGER constraint nbmaxpart_check check(nbmaxPart > 0),
	dateSem date not null,
	etat VARCHAR(8) default null,
	constraint seminaire_fk Foreign key (noAnim) references Animateur(noAnim),
	constraint seminaire_fkZ Foreign key (noSalle,id_prest) references Salles(noSalle,id_prest),
	constraint tarifpart_check check(tarifPart > 0),
	constraint type_sem_check check(type_sem in ('AM','PM','JR')),
	constraint etat_sem_check check(etat in ('','annulé', 'confirmé'))
);


create table Activites(
	noAct INTEGER constraint noact_pk primary key,
	nomAct VARCHAR(30) not null,
        id_sem INTEGER,
	duree INTEGER,
        constraint Activite_fk Foreign key (id_sem) references Seminaire(id_sem)
);

create table Conferenciers(
	noConf INTEGER constraint noconf_pk primary key,
	nomConf VARCHAR(30) not null,
	prenomConf VARCHAR(30) not null,
	adresseConf VARCHAR(70) ,
	telConf VARCHAR(13) ,
	mailConf VARCHAR(30) 
);

create table Presentation(
	noConf INTEGER,
	noAct INTEGER,
	titre VARCHAR(50) not null,
	support VARCHAR(50) not null,
	montant INTEGER constraint montant_check check(montant >= 0),
	constraint presentation_pk primary key (noConf,noAct),
	constraint noconf_fk foreign key (noConf) references Conferenciers(noconf),
	constraint noAct_fk foreign key (noAct) references Activites(noAct)
);

create table Participants(
	noPart INTEGER constraint nopart_pk primary key,
	nomPart VARCHAR(30) not null,
	prenomPart VARCHAR(30) not null,
	adressePart VARCHAR(70) ,
	telPart VARCHAR(13),
	mailPart VARCHAR(30)
);

create table Reservations(
	nopart INTEGER,
	id_sem INTEGER,
	statut VARCHAR(8) constraint statut_check check(statut in ('inscrit','attente','annulé')),
	constraint reservations_pk primary key(nopart,id_sem),
	constraint reservations_fk Foreign key (noPart) references Participants(noPart),
	constraint reservations_fk2 Foreign key (id_sem) references Seminaire(id_sem)
);

commit;

