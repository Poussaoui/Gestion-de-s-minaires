--Insertion dans la table Animateur ------------------------------------------
INSERT INTO Animateur VALUES('1','Michael','Scofield','michael','77 avenue Jeanne d Arc','0605637055','mscofield@oldschool.fr');
INSERT INTO Animateur VALUES('2','Sergio','Marquina','sergio','70 avenue Jeanne d Arc','0605637058','smarquina@oldschool.fr');
INSERT INTO Animateur VALUES('3','henri','Morgan','henri','44 avenue Albert 1er','0605637059','hmorgan@oldschool.fr');

--Insertion dans la table Prestataire ----------------------------------------
INSERT INTO Prestataire VALUES ('100','Cafe Belledonne','3 rue des taillees','0796457610','340','3','15');
INSERT INTO Prestataire VALUES ('101','Le clandestin','10 rue Perrier','0785963410','270','4','12');
INSERT INTO Prestataire VALUES ('102','Angleterre','16 rue des oiseaux','0712385647','235','6','17');
INSERT INTO Prestataire VALUES ('103','Les arcs','19 rue verdun','0741526373','500','3','20');
INSERT INTO Prestataire VALUES ('104','monarque','13 rue Belgique','0748548596','410','6','17');
INSERT INTO Prestataire VALUES ('105','Les amis','21 rue michel','0794084071','600','7','25');
INSERT INTO Prestataire VALUES ('106','Liberty','3 rue Congo','0741241241','285','5','12');
INSERT INTO Prestataire VALUES ('107','Souverains','4 rue piscine','0796858596','300','4','16');
INSERT INTO Prestataire VALUES ('108','Le chef','20 rue Chimie','0774185246','250','3','10');
INSERT INTO Prestataire VALUES ('109','Soleil','18 rue des taillees','0781815200','340','3','11');

--Insertion dans la table Salles ------------------------------------------
INSERT INTO Salles VALUES('1','100','500');
INSERT INTO Salles VALUES('2','101','250');
INSERT INTO Salles VALUES('3','102','400');
INSERT INTO Salles VALUES('4','103','250');
INSERT INTO Salles VALUES('5','104','400');
INSERT INTO Salles VALUES('6','105','400');
INSERT INTO Salles VALUES('7','106','300');
INSERT INTO Salles VALUES('8','107','250');
INSERT INTO Salles VALUES('9','108','100');
INSERT INTO Salles VALUES('10','109','500');


--Insertion dans la table Seminaire ------------------------------------------
INSERT INTO Seminaire VALUES('1','100','1','1','Bargain','JR','oui','15','500','30-APR-18','');
INSERT INTO Seminaire VALUES('2','102','3','1','Antiquité vs Modernité','PM','oui','10','300','30-MAY-2018','');
INSERT INTO Seminaire VALUES('3','101','2','2','Sécurité monétaire','AM','non','8','250','15-JUN-2018','');
INSERT INTO Seminaire VALUES('4','103','4','1','Scylla','PM','non','8','200','20-JUN-2018','');
INSERT INTO Seminaire VALUES('5','104','5','3','Cybersécurité','JR','oui','15','400','30-JUN-2018','');
INSERT INTO Seminaire VALUES('6','100','1','1','Surveillance system','AM','non','8','300','05-JUL-2018','');


--Insertion dans la table Activités ------------------------------------------
INSERT INTO Activites values (110,'bowling','1',30);
INSERT INTO Activites values (111,'karting','2',45);
INSERT INTO Activites values (112,'orchestrate','3',60);
INSERT INTO Activites values (113,'zombies','4',45);
INSERT INTO Activites values (114,'Team burger','5',35);


--Insertion dans la table Conferenciers---------------------------------------
INSERT INTO Conferenciers values (115,'GIRARD','HUGO','21 b rue Claude Bernard 75005 PARIS',0774939750,'alainsaillard@wanadoo.fr');
INSERT INTO Conferenciers values (116,'GUIMOND','SYLVAIN','67 avenue de Flandre 75940 PARIS 19',0924539689,'geralain08160@hotmail.fr');
INSERT INTO Conferenciers values (117,'PETITCLERC','CHANTAL',' 18 rue Albert Einstein Cité Descartes 77420 CHAMPS-SUR-MARNE',0224439071,'aline.czuba@wanadoo.fr');
INSERT INTO Conferenciers values (118,'LUC DUPONT','LUC','12 avenue Budenheim 95605 EAUBONNE Cedex',0984439608,'cbourguignon@club-internet.fr');
INSERT INTO Conferenciers values (119,'GUGLIEMINETTI','BRUNO',' 1 square Chaptal 92300 LEVALLOIS-PERRET',0421439600,'dominique.villiere@wanadoo.fr');


--Insertion dans la table Presentation ---------------------------------------
INSERT INTO Presentation values (115,110,'L engagement des investisseurs sur le climat','climat.ppt',55);
INSERT INTO Presentation values (116,111,'Responsabilite environnementale','environnement.ppt',36);
INSERT INTO Presentation values (117,112,'Procedes generaux de construction des barrages ','barrages.ppt',54);
INSERT INTO Presentation values (118,113,'procedes generaux de construction des gratteciels','gratteciels.ppt',80);
INSERT INTO Presentation values (119,114,'LES QUAIS','Quais.ppt',54);


--Insertion dans la table Participants----------------------------------------
INSERT INTO Participants values (115,'Eric','Cornell','19 Rue Lesdiguières 38400 Grenoble',0628730950,'Eric@wanadoo.fr');
INSERT INTO Participants values (116,'Juan','Maldacena','617 rue des Taillees 75940 PARIS 19',0884889089,'Juan.Maldacena@hotmail.fr');
INSERT INTO Participants values (117,'Anne','Martel',' 106 rue Albert Cité Descartes 99420 CHAMPS-SUR-MARNE',0233338711,'Anne.Martel@wanadoo.fr');
INSERT INTO Participants values (118,'Stephen','Nagler','16 avenue Budum 95605 EAUBONNE Cedex',0894039118,'Stephen@club-internet.fr');
INSERT INTO Participants values (119,'Eric','Cornell','75 rue Chapital 92300 LEVALLOIS-PERRET',0027479144,'Eric.Cornell@gmail.fr');


--Insertion dans la table Reservations----------------------------------------
INSERT INTO Reservations values (115,1,'attente');
INSERT INTO Reservations values (116,2,'inscrit'); 
INSERT INTO Reservations values (117,3,'annulé'); 
INSERT INTO Reservations values (118,4,'attente'); 
INSERT INTO Reservations values (119,5,'inscrit');

commit;
