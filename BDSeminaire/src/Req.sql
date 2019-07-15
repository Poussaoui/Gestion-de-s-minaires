
-- Confirmation séminaire --
UPDATE seminaire SET etat = 'confirmé' WHERE id_sem = :n ; 

-- Annulation séminaire --
UPDATE seminaire SET etat = 'annulé' WHERE id_sem = :n ;

-- Prévenir le prestataire --
SELECT * FROM prestataire WHERE id_prest = :n ; 

-- Vision sur la semaine --
-- semaine en cours
SELECT * FROM seminaire WHERE dateSem BETWEEN SYSDATE AND SYSDATE + 7 ;
-- semaine passée
SELECT * FROM seminaire WHERE dateSem BETWEEN SYSDATE-7 AND SYSDATE ;
-- Total des dépenses prévues ?? --
-- Dépenses max --
SELECT  
CASE type_sem WHEN 'JR' THEN ( (tarifPause*2 + tarifDej) * nbmaxPart) + tarifSalle + montant
ELSE CASE dejeuner WHEN 'oui' THEN ( (tarifPause + tarifDej) * nbmaxPart) + tarifSalle + montant
ELSE (tarifPause * nbmaxPart) + tarifSalle + montant
END
END as DepensesMax
FROM prestataire natural join seminaire natural join activites natural join presentation
WHERE id_sem = :n ;

-- Dépenses min 
SELECT  
CASE type_sem WHEN 'JR' THEN ( (tarifPause*2 + tarifDej) * (nbmaxPart/2) ) + tarifSalle + montant
     ELSE CASE dejeuner WHEN 'oui' THEN ( (tarifPause + tarifDej) * (nbmaxPart/2) ) + tarifSalle + montant
                        ELSE (tarifPause * (nbmaxPart/2) ) + tarifSalle + montant
          END
END as DepensesMin
FROM prestataire natural join seminaire natural join activites natural join presentation  
WHERE id_sem = :n ;

-- Total des recettes prévues ?? --
-- Recettes max --
SELECT tarifPart * nbmaxPart as recettesMaxPrevues FROM seminaire
WHERE id_sem = :n ;

-- Recettes min --
SELECT (tarifPart * nbmaxPart)/2 as recettesMinPrevues FROM seminaire
WHERE id_sem = :n ;

-- Création séminaire --
INSERT INTO seminaire('id_sem','id_prest','noSalle', 'noAnim', 'theme', 'typeSem', 'dejeuner', 'tarifPart', 'nbmaxPart', 'dateSem', 'etat') VALUES(:n,:n,:n,:n,:n,:n,:n,:n,:n,:n,:n);

-- Annulation Réservation --
UPDATE reservations SET statut = 'annulé' WHERE nopart = :n AND id_sem = :n;

-- Insertion Participant --
INSERT INTO participants(noPart, nomPart, prenomPart) VALUES(:n,:n,:n);


-- Sélection des programmes dans la semaine --
-- Liste des activités et conférenciers
SELECT noAct,nomAct,nomConf,prenomConf FROM activites natural join presentation natural join conferenciers
WHERE id_sem = :n ;

-- Nombre de participants inscrits
SELECT COUNT(*) as NbreParticipants FROM Reservations natural join Seminaire
WHERE id_sem = :n AND statut = 'inscrit' ;

-- Lister les presentations
SELECT id_sem ,noAct, noConf, titre, support, montant FROM Presentation natural join Activites 
WHERE id_sem = :n ;

-- Nombre d'inscrits pour un séminaire confirmé
SELECT  COUNT(*) FROM Seminaire natural join Reservations
WHERE id_sem = :n AND etat = 'confirmé' AND statut = 'inscrit';

-- Recettes réalisées
