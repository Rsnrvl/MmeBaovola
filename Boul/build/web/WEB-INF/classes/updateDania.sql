alter table facture add column etat integer;

-- ---------------------------------------------------------------
create view v_vente_avec_categorie_parfum as
select 
    p.idpatisserie,
    p.nompatisserie,
    p.idcategorie,
    p.idparfum,
    ff.quantite
from facture_fille ff
join patisserie p on p.idpatisserie = ff.idpatisserie;

-- -------------------------------------------------------
select
    nompatisseerie,
    sum(quantite)
from v_vente_avec_categorie_parfum
where idcategorie = 'CAT_1' and idparfum = 'PARF_1'
group by nompatisserie