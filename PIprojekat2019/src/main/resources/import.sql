SET FOREIGN_KEY_CHECKS = 0;

INSERT INTO pdv_kategorija(naziv_kategorije) VALUES ('PDV kategorija 1');
INSERT INTO pdv_kategorija(naziv_kategorije) VALUES ('PDV kategorija 2');

INSERT INTO pdv_stopa(datum_vazenja, procenat, kategorija_id) VALUES ('2020-04-20', 8, 1);
INSERT INTO pdv_stopa(datum_vazenja, procenat, kategorija_id) VALUES ('2020-08-29', 18, 2);

INSERT INTO pdv_kategorija_pdv_stope(pdvkategorija_kategorija_id, pdv_stope_id_stope) VALUES (1,1);
INSERT INTO pdv_kategorija_pdv_stope(pdvkategorija_kategorija_id, pdv_stope_id_stope) VALUES (2,2);

INSERT INTO proizvod(naziv, cena, opis) VALUES ('Laptop Dell Latitude', 22000, 'mali laptop');
INSERT INTO proizvod(naziv, cena, opis) VALUES ('Pakovanje malih zavrtnja', 100, 'visenamenski zavrtnji');
INSERT INTO proizvod(naziv, cena, opis) VALUES ('ScreenClean', 200, 'sprej za ciscenje monitora');
INSERT INTO proizvod(naziv, cena, opis) VALUES ('Asepsol', 600, 'sredstvo za dezinfekciju');
INSERT INTO proizvod(naziv, cena, opis) VALUES ('Steinberg antifriz', 310, 'antifriz za auto');

INSERT INTO jedinica_mere(naziv_jedinice_mere, skraceni_naziv) VALUES ('komad', 'kom.');
INSERT INTO jedinica_mere(naziv_jedinice_mere, skraceni_naziv) VALUES ('gram', 'gr');
INSERT INTO jedinica_mere(naziv_jedinice_mere, skraceni_naziv) VALUES ('mililitar','ml');
INSERT INTO jedinica_mere(naziv_jedinice_mere, skraceni_naziv) VALUES ('litar','l');
INSERT INTO jedinica_mere(naziv_jedinice_mere, skraceni_naziv) VALUES ('kilogram', 'kg');

INSERT INTO grupa_robe_usluga(naziv_grupe) VALUES ('kompjuteri i laptop uredjaji');
INSERT INTO grupa_robe_usluga(naziv_grupe) VALUES ('hemijska sredstva');
INSERT INTO grupa_robe_usluga(naziv_grupe) VALUES ('ostalo');


INSERT INTO roba_usluga(naziv_robe_usluge, opis, roba, id_jedinice_mere, id_grupe) VALUES ('Laptop Dell Latitude','mali laptop', true, 1, 1);
INSERT INTO roba_usluga(naziv_robe_usluge, opis, roba, id_jedinice_mere, id_grupe) VALUES ('Pakovanje malih zavrtnja', 'visenamenski zavrtnji', true, 2, 3);
INSERT INTO roba_usluga(naziv_robe_usluge, opis, roba, id_jedinice_mere, id_grupe) VALUES ('ScreenClean', 'sprej za ciscenje monitora',true, 3, 2);
INSERT INTO roba_usluga(naziv_robe_usluge, opis, roba, id_jedinice_mere, id_grupe) VALUES ('Asepsol', 'sredstvo za ciscenje', true, 4, 2);
INSERT INTO roba_usluga(naziv_robe_usluge, opis, roba, id_jedinice_mere, id_grupe) VALUES ('Steinberg antifriz', 'antifriz za auto', true, 5, 2);

INSERT INTO grupa_robe_usluga_roba_usluga(grupa_robe_usluga_id_grupe, roba_usluga_id_robe_usluge) VALUES (1, 1);
INSERT INTO grupa_robe_usluga_roba_usluga(grupa_robe_usluga_id_grupe, roba_usluga_id_robe_usluge) VALUES (2, 3);
INSERT INTO grupa_robe_usluga_roba_usluga(grupa_robe_usluga_id_grupe, roba_usluga_id_robe_usluge) VALUES (2, 4);
INSERT INTO grupa_robe_usluga_roba_usluga(grupa_robe_usluga_id_grupe, roba_usluga_id_robe_usluge) VALUES (2, 5);
INSERT INTO grupa_robe_usluga_roba_usluga(grupa_robe_usluga_id_grupe, roba_usluga_id_robe_usluge) VALUES (3, 2);

INSERT INTO cenovnik(datum_pocetka_vazenja) VALUES ('2020-01-01');
INSERT INTO cenovnik(datum_pocetka_vazenja) VALUES ('2020-03-03');

INSERT INTO stavka_cenovnika(cena, id_cenovnika, id_robe_usluge) VALUES (22000, 1, 1);
INSERT INTO stavka_cenovnika(cena, id_cenovnika, id_robe_usluge) VALUES (100, 1, 2);
INSERT INTO stavka_cenovnika(cena, id_cenovnika, id_robe_usluge) VALUES (200, 1, 3);
INSERT INTO stavka_cenovnika(cena, id_cenovnika, id_robe_usluge) VALUES (600, 1, 4);
INSERT INTO stavka_cenovnika(cena, id_cenovnika, id_robe_usluge) VALUES (310, 1, 5);

INSERT INTO naseljeno_mesto(naziv_mesta, ptt_broj) VALUES ('Novi Sad', 21000);
INSERT INTO naseljeno_mesto(naziv_mesta, ptt_broj) VALUES ('Beograd', 11000);

INSERT INTO preduzece(naziv_preduzeca, adresa, broj_telefona, fax, id_mesta, id_cenovnika) VALUES ('Smart Co.', 'Vasina 12', '021123456', '123456789', 1, 1);
INSERT INTO preduzece(naziv_preduzeca, adresa, broj_telefona, fax, id_mesta, id_cenovnika) VALUES ('Epic d.o.o.', 'Zemunska 20', '011654321', '987654321', 2, 2);

INSERT INTO poslovni_partner(naziv_poslovnog_partnera, adresa, telefon, fax, email, vrsta_partnera, id_mesta, id_preduzeca) VALUES ('Epic d.o.o', 'Zemunska 20', '011654321', '987654321', 'epicdoo@gmail.com', 'KU', 2, 1);
INSERT INTO poslovni_partner(naziv_poslovnog_partnera, adresa, telefon, fax, email, vrsta_partnera, id_mesta, id_preduzeca) VALUES ('Smart Co.', 'Vasina 12', '021123456', '123456789', 'smartco@gmail.com', 'DO', 1, 2);

INSERT INTO preduzece_poslovni_partneri(preduzece_id_preduzeca, poslovni_partneri_id_poslovnog_partnera) VALUES (1, 1);
INSERT INTO preduzece_poslovni_partneri(preduzece_id_preduzeca, poslovni_partneri_id_poslovnog_partnera) VALUES (2, 2);

INSERT INTO poslovna_godina(godina, zakljucena, id_preduzeca) VALUES (2020, false, 1);
INSERT INTO poslovna_godina(godina, zakljucena, id_preduzeca) VALUES (2020, false, 2);

INSERT INTO preduzece_poslovne_godine(preduzece_id_preduzeca, poslovne_godine_id_godine) VALUES (1, 1);
INSERT INTO preduzece_poslovne_godine(preduzece_id_preduzeca, poslovne_godine_id_godine) VALUES (2, 2);


INSERT INTO korisnik(korisnicko_ime, lozinka, uloga) VALUES ('pera', 'pera', 'admin');
INSERT INTO korisnik(korisnicko_ime, lozinka, uloga) VALUES ('ana', 'ana', 'korisnik');


