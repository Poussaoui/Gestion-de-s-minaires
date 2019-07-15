update Presentation set montant= '10'
where noConf='116' and noAct='115';

select id_sem,id_prest,etat from seminaire where dateSem < sysdate+7;

select id_sem,count(*) as nbpart  from Reservations 
where statut = 'inscrit'
group by id_sem;


select count(*) * 10 as recettes
from( select id_sem,tarifPart,statut from Seminaire natural join Reservations where id_sem=2 and statut ='inscrit');
-------Recettes
select id_sem,tarifPart *nbpart as recettes from Seminaire natural join(select id_sem,count(*) as nbpart  from Reservations 
where statut = 'inscrit'
group by id_sem)
where id_sem=2;

