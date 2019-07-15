--1 Impossible d'organiser plus de 3 seminaires le meme jour. ok

--2 -Le nombre de participants d'un seminaire est inferieur ou egale au nombre de places max. ok

--3 -Impossible d'annuler une reservation à partir d'une semaine du seminaire. ok

--3 -Plus d'inscription possible pour un sémaine à une seminaire de la date prévue ok

--4-on ne peut ajouter une activité après u mois/ok
--5 on ne peut ajouter une présentation a moins d'un mois/ok
  
--6 -Le conferencier fournit son titre au moins un mois avant le seminaire/ok

--7 -Le conferencier fournit son support au mois 2 semaines avant le seminaire / ok
    --- empecher update support a 2 semaines du seminaire
--8 -Le conferencier precise son montant au moins un mois avant le seminaire / ok
--9-Confirmation ou annulation du seminaire une semaine avant la date.

--10 PL/SQL -On ne peut pas annuler un séminaire qui a le nombre de réservation supérieur au nbmax /2

--11 -Si le nb de participants est égale au nb max de participants, mettre toutes les inscriptions en attente. ok
--12. --le date de création du séminaire (sysdate) doit etre supérieur à  la dateSEm -30 /ok
--13. si ty-sem = JR ==>  dejeuner = oui / ok
--14.-- nb d'activité d'un séminaire = 6 si type_sem= JR et 3 sinon /en cours/ ok
--15 --animateur ne fait pas 2 seminaire en mm temps /ok
--16   Pour un meme prestataire on ne peut pas avoir deux seminaire dans unne meme salle le meme jour /ok
--17 un conférencier ne peut pas animé  deux seminaire le meme jour/ok

-------------- Contrainte_1 : Impossible d'organiser plus de 3 seminaires le meme jour.
CREATE OR REPLACE  TRIGGER contrainte_1
BEFORE INSERT ON Seminaire
FOR EACH ROW
DECLARE
nbSem number;
BEGIN
   Select count(*) into nbSem
   from seminaire
   where dateSem= :new.dateSem;
   
   IF nbSem=3
    THEN Raise_application_error('-20101', 'deja 3 seminaire prevus pour cette date');
   END IF;
   
END;
/
-------------------- Le nombre de participants d'un seminaire est inferieur ou egale au nombre de places max.

-------------- Contrainte_3 -:Impossible d'annuler une reservation à partir d'une semaine dPour un meme prestataire on ne peut pas avoir deux seminaire dans unne meme salle le meme jouru seminaire.
CREATE OR REPLACE  TRIGGER Contrainte_3
BEFORE UPDATE of statut  ON Reservations
FOR EACH ROW
DECLARE
dateA date;
BEGIN

Select dateSem into dateA
from Seminaire 
where id_sem = :new.id_sem;

    IF (sysdate + 7)> dateA
	 THEN Raise_application_error('-20101', 'impossible d annuler la réservation à une semaine u séminaire');
   END IF;
END;
/
-------------------- --4- on ne peut ajouter une activité après un mois
CREATE OR REPLACE TRIGGER contrainte__4
BEFORE INSERT ON Activites
FOR EACH ROW
DECLARE
datSem date;
BEGIN
SELECT dateSem INTO datSem FROM Seminaire WHERE id_sem = :new.id_sem ;
 
IF ( datSem < SYSDATE + 30) THEN
    Raise_application_error('-20101','on ne peut ajouter une activité apres un mois de la creation du seminaire');
END IF;
END;  
/

-------------------- -- 5 on ne peut ajouter une présentation a moins d'un mois
CREATE OR REPLACE TRIGGER contrainte_5
BEFORE INSERT ON Presentation
FOR EACH ROW
DECLARE
idSem number;
datSem date;
BEGIN

SELECT id_sem INTO idSem FROM Activites WHERE noAct= :new.noAct ;
SELECT dateSem INTO datSem FROM Seminaire WHERE id_sem = idSem ;

IF ( datSem < SYSDATE + 30) THEN
    Raise_application_error('-20101','on ne peut ajouter une presentation a moins d un mois');
END IF;
END;
/


----------6 -Le conferencier fournit son titre au moins un mois avant le seminaire
CREATE OR REPLACE  TRIGGER Contrainte_6
BEFORE UPDATE of titre  ON Presentation
FOR EACH ROW
DECLARE
dateA date;
BEGIN
select dateSem into dateA from Seminaire where id_sem=(select id_sem from Activites where noAct= :new.noAct);



    IF (sysdate + 30)> dateA
	 THEN Raise_application_error('-20101', 'impossible de modifier le titre de lq prestation a moins d 1 mois du seminaire');
   END IF;
END;
/
-----------7 -Le conferencier fournit son support au mois 2 semaines avant le seminaire 
    --- empecher update support a 2 semaines du seminaire
CREATE OR REPLACE  TRIGGER Contrainte_7
BEFORE UPDATE of support  ON Presentation
FOR EACH ROW
DECLARE
dateA date;
BEGIN
select dateSem into dateA from Seminaire where id_sem=(select id_sem from Activites where noAct= :new.noAct);



    IF (sysdate + 14)> dateA
	 THEN Raise_application_error('-20101', 'impossible de de fournir le support a moins de 2 semaines du semianaire');
   END IF;
END;
/
------------Contrainte_8 -Le conferencier precise son montant au moins un mois avant le seminaire
CREATE OR REPLACE  TRIGGER Contrainte_8
BEFORE UPDATE of montant  ON Presentation
FOR EACH ROW
DECLARE
dateA date;
BEGIN
select dateSem into dateA from Seminaire where id_sem=(select id_sem from Activites where noAct= :new.noAct);



    IF (sysdate + 30)> dateA
	 THEN Raise_application_error('-20101', 'impossible de modifier le montant de lq prestation a moins d 1 mois du seminaire');
   END IF;
END;
/
-------9-Confirmation ou annulation du seminaire une semaine avant la date.
CREATE OR REPLACE  TRIGGER Contrainte_9
BEFORE UPDATE of etat  ON Seminaire
FOR EACH ROW
DECLARE
dateA date;
BEGIN
select dateSem into dateA from Seminaire where id_sem=:new.id_sem;



    IF (sysdate + 7)> dateA
	 THEN Raise_application_error('-20101', 'modifier l etat du seminaire a moins d une semaine du seminaire');
   END IF;
END;
/
-------------------- 11  Le nombre de participants d'un seminaire est inferieur ou egale au nombre de places max. + Si le nb de participants est égale au nb max de participants, mettre toutes les inscriptions en attente.
CREATE OR REPLACE TRIGGER contrainte_11
BEFORE INSERT OR UPDATE ON Reservations
FOR EACH ROW
DECLARE
nbParti number;
maxParti number;
BEGIN
SELECT nbmaxPart INTO maxParti FROM Seminaire WHERE id_sem = :new.id_sem ;
SELECT COUNT(*) INTO nbParti FROM Reservations WHERE id_sem = :new.id_sem ;
IF ( nbParti > maxParti)
THEN
	:new.statut := 'attente';
--Raise_application_error('-20101','Le nombre de participants superieur de nombre de places max');
END IF;
END; 
/
-------------------- 12. --le date de création du séminaire (sysdate) doit etre supérieur à  la dateSEm -30
CREATE OR REPLACE TRIGGER contrainte_12
BEFORE INSERT OR UPDATE ON Seminaire
FOR EACH ROW
BEGIN
IF (:new.dateSem < SYSDATE + 30) THEN
	Raise_application_error('-20101','Date de creation du seminaire doit etre superieur de 30 jrs');
END IF;
END; 
/
------------Contrainte_13. si ty-sem = JR ==>  dejeuner = oui
CREATE OR REPLACE TRIGGER Contrainte_13
BEFORE INSERT OR UPDATE ON Seminaire
FOR EACH ROW

BEGIN
  
   
  IF(:new.type_sem='JR')
   THEN :new.dejeuner:= 'oui';
   END IF;

  
END;
/
-------------------- 14.-- nb d'activité d'un séminaire = 6 si type_sem= JR et 3 sinon
CREATE OR REPLACE TRIGGER contrainte_14
BEFORE INSERT OR UPDATE ON Activites
FOR EACH ROW
DECLARE
nbActiv number;
typeSem VARCHAR(50);
BEGIN
SELECT type_sem INTO typeSem FROM Seminaire WHERE id_sem = :new.id_sem;
SELECT COUNT(*) INTO nbActiv FROM Activites WHERE id_sem = :new.id_sem;
IF (typeSem = 'JR') THEN
	IF (nbActiv > 6) THEN
		--DBMS_OUTPUT.put_line();
	  Raise_application_error('-20101','Le nombre d activites d un seminaire superieur de a 6');
	END IF;
ELSE
   IF nbActiv > 3 THEN
	  Raise_application_error('-20101','Le nombre d activites d un seminaire superieur de a 3');
	END IF;
END IF;
END; 
/

-------------- 14.-- nb d'activité d'un séminaire = 6 si type_sem= JR et 3 sinon
CREATE OR REPLACE TRIGGER contrainte_14_b
AFTER INSERT OR UPDATE ON Activites
FOR EACH ROW
DECLARE
nbActiv number;
typeSem VARCHAR(50);
BEGIN

SELECT COUNT(*) INTO nbActiv FROM Activites WHERE id_sem = :new.id_sem ;
SELECT type_sem INTO typeSem FROM Seminaire WHERE id_sem = :new.id_sem ;


IF typeSem = 'JR' THEN
	IF nbActiv < 6 THEN
	  Raise_application_error('-20101','Le nombre d activites d un seminaire inferieur de a 6, il faut ajouter une activites');
	END IF;
ELSE
   IF nbActiv < 3 THEN
	  Raise_application_error('-20101','Le nombre d activites d un seminaire inferieur de a 3, il faut ajouter une activites');
	END IF;
END IF;
END; 
/

------------------Contrainte_15 l'animateur ne fait pas deux seminaire en meme temps
CREATE OR REPLACE TRIGGER Contrainte_15
BEFORE INSERT OR UPDATE ON Seminaire
FOR EACH ROW
DECLARE
nbanim number;
BEGIN
  
  select count(noAnim) into nbanim from Seminaire
  where dateSem= :new.dateSem and noAnim= :new.noAnim;
  
  IF(nbanim=1)
   THEN Raise_application_error('-20101', 'Cet Animateur ne peut pas diriger un deuxieme seminaire ce jour');
   END IF;

  
END;
/

---------------Conntrainte_16 Pour un meme prestataire on ne peut pas avoir deux seminaire dans unne meme salle le meme jour


--******************************************************************************************************************************************************************************************************************

---------------- 16   Pour un meme prestataire on ne peut pas avoir deux seminaire dans unne meme salle le meme jour
CREATE OR REPLACE TRIGGER contrainte_16
BEFORE INSERT OR UPDATE ON Seminaire
FOR EACH ROW
DECLARE
nb number;
BEGIN

SELECT COUNT(*) INTO nb FROM Seminaire WHERE id_prest = :new.id_prest and noSalle = :new.noSalle and dateSem = :new.dateSem;

IF (nb = 1 ) THEN
	--DBMS_OUTPUT.put_line();
	 Raise_application_error('-20101','Pour un meme prestataire on ne peut pas avoir deux seminaire dans unne meme salle le meme jour');
END IF;
END; 
/








------------------Contrainte_17 un conférencier ne peut pas animé  deux seminaire le meme jour

CREATE OR REPLACE TRIGGER Contrainte_17
BEFORE INSERT OR UPDATE ON Presentation
FOR EACH ROW
DECLARE
nbconf number;
BEGIN
----récupérer la date du seminaire auquel le conférencier est 


  select count(*) into nbconf from (select id_sem,dateSem from Seminaire 
  where id_sem =(select id_sem from Activites natural join Presentation  where noConf= :new.noConf))
  where dateSem= (select dateSem from Seminaire where id_sem=(select id_sem from Activites where noAct= :new.noAct));

  
  
  IF(nbconf=1)
   THEN Raise_application_error('-20101', 'Ce Conferencier ne peut pas intervenir dans un deuxieme seminaire ce jour');
   END IF;

  
END;
/
