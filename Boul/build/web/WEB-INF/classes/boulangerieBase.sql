--------------------------------------------------------------------
create sequence cat_seq increment by 1 start with 1;
CREATE TABLE categorie(
idCategorie varchar(100) primary key not null,
nomCategorie varchar(100)
);
---------------------------------------------------

CREATE TABLE unite (
idUnite varchar(50) primary key not null,
nom varchar(50)
);

insert into unite (idUnite, nom) VALUES ('u1', 'kg');
insert into unite (idUnite, nom) VALUES ('u2', 'l');
insert into unite (idUnite, nom) VALUES ('u3', 'piece') returning idUnite;
------------------------------------------
create sequence parfum_seq increment by 1 start with 1;

CREATE TABLE parfum (
idParfum varchar(100) primary key not null,
nomParfum varchar(100)
);
-- -------------------------------------------------------------------------------
create sequence prod_seq increment by 1 start with 1;

CREATE TABLE produit (
idProduit varchar(100) primary key not null,
nomProduit varchar(100),
idUnite varchar(100),
foreign key (idUnite) references unite(idUnite)
);

insert into produit VALUES ('p0', 'farine', 'u1');
---------------------------------------------------------------------------------
create sequence patisserie_seq increment by 1 start with 1;
CREATE TABLE patisserie(
idPatisserie varchar(100) primary key not null,
nomPatisserie varchar(255),
idCategorie varchar(100),
idParfum varchar(100),
prixUnitaire numeric,
foreign key (idCategorie) references categorie(idCategorie),
foreign key (idParfum) references parfum(idParfum)
);
-------------------------------------------------
create sequence emp_seq increment by 1 start with 1;
CREATE TABLE employe (
idEmploye varchar(100) primary key not null,
nomEmploye varchar(100),
dtn date
);
--mbola tsy natao
----------------------------------------------------------------

-------------------------------------------------------------------
create sequence cli_seq increment by 1 start with 1;
CREATE TABLE client(
idClient varchar(100) primary key not null,
nomClient varchar(255),
genre numeric,
dateNaissance date
);
----------------------------------------------------------------------
create sequence fm_seq increment by 1 start with 1;
CREATE TABLE facture (
idFacture varchar(100) primary key not null,
dateFacture date, 
idClient varchar(100),
foreign key (idClient) references client(idClient)
);
-------------------------------------------------------------------
create sequence ff_seq increment by 1 start with 1;
CREATE TABLE facture_fille (
idFactureFille varchar (100) primary key not null,
idFacture varchar(100),
idPatisserie varchar(100),
quantite numeric,
puPatisserie numeric,
montantTotal numeric,
foreign key (idFacture) references facture(idFacture),
foreign key (idPatisserie) references patisserie(idPatisserie)
);
--------------------------------------------------------------------


