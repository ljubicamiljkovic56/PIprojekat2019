SET FOREIGN_KEY_CHECKS = 0;

INSERT INTO pdv_kategorija(naziv_kategorije) VALUES ('PDV kategorija 1');
INSERT INTO pdv_kategorija(naziv_kategorije) VALUES ('PDV kategorija 2');

INSERT INTO pdv_stopa(datum_vazenja, procenat) VALUES ('2020-04-20', 8);
INSERT INTO pdv_stopa(datum_vazenja, procenat) VALUES ('2020-08-29', 18);

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

--INSERT INTO grupa_robe_usluga_roba_usluga(grupa_robe_usluga_id_grupe, roba_usluga_id_robe_usluge) VALUES (1, 1);
--INSERT INTO grupa_robe_usluga_roba_usluga(grupa_robe_usluga_id_grupe, roba_usluga_id_robe_usluge) VALUES (2, 3);
--INSERT INTO grupa_robe_usluga_roba_usluga(grupa_robe_usluga_id_grupe, roba_usluga_id_robe_usluge) VALUES (2, 4);
--INSERT INTO grupa_robe_usluga_roba_usluga(grupa_robe_usluga_id_grupe, roba_usluga_id_robe_usluge) VALUES (2, 5);
--INSERT INTO grupa_robe_usluga_roba_usluga(grupa_robe_usluga_id_grupe, roba_usluga_id_robe_usluge) VALUES (3, 2);

INSERT INTO cenovnik(datum_pocetka_vazenja) VALUES ('2020-01-01');
INSERT INTO cenovnik(datum_pocetka_vazenja) VALUES ('2020-03-03');

INSERT INTO stavka_cenovnika(cena, id_cenovnika, id_robe_usluge) VALUES (22000, 1, 1);
INSERT INTO stavka_cenovnika(cena, id_cenovnika, id_robe_usluge) VALUES (100, 1, 2);
INSERT INTO stavka_cenovnika(cena, id_cenovnika, id_robe_usluge) VALUES (200, 1, 3);
INSERT INTO stavka_cenovnika(cena, id_cenovnika, id_robe_usluge) VALUES (600, 1, 4);
INSERT INTO stavka_cenovnika(cena, id_cenovnika, id_robe_usluge) VALUES (310, 1, 5);

INSERT INTO naseljeno_mesto(naziv_mesta, ptt_broj) VALUES ('Novi Sad', 21000);
INSERT INTO naseljeno_mesto(naziv_mesta, ptt_broj) VALUES ('Beograd', 11000);

INSERT INTO poslovna_godina(godina, zakljucena) VALUES (2020, false);
INSERT INTO poslovna_godina(godina, zakljucena) VALUES (2020, false);


INSERT INTO poslovni_partner(naziv_poslovnog_partnera, adresa, telefon, fax, email, vrsta_partnera, id_mesta) VALUES ('Epic d.o.o', 'Zemunska 20', '011654321', '987654321', 'epicdoo@gmail.com', 'KU', 2);
INSERT INTO poslovni_partner(naziv_poslovnog_partnera, adresa, telefon, fax, email, vrsta_partnera, id_mesta) VALUES ('Smart Co.', 'Vasina 12', '021123456', '123456789', 'smartco@gmail.com', 'DO', 1);

INSERT INTO preduzece(naziv_preduzeca, adresa, broj_telefona, fax, id_mesta, id_cenovnika, id_godine, id_partnera) VALUES ('Smart Co.', 'Vasina 12', '021123456', '123456789', 1, 1, 1, 1);
INSERT INTO preduzece(naziv_preduzeca, adresa, broj_telefona, fax, id_mesta, id_cenovnika, id_godine, id_partnera) VALUES ('Epic d.o.o.', 'Zemunska 20', '011654321', '987654321', 2, 2, 2, 2);


--INSERT INTO preduzece_poslovni_partneri(preduzece_id_preduzeca, poslovni_partneri_id_poslovnog_partnera) VALUES (1, 1);
--INSERT INTO preduzece_poslovni_partneri(preduzece_id_preduzeca, poslovni_partneri_id_poslovnog_partnera) VALUES (2, 2);


--INSERT INTO preduzece_poslovne_godine(preduzece_id_preduzeca, poslovne_godine_id_godine) VALUES (1, 1);
--INSERT INTO preduzece_poslovne_godine(preduzece_id_preduzeca, poslovne_godine_id_godine) VALUES (2, 2);

INSERT INTO faktura(broj_fakture, datum_fakture, datum_valute, ukupna_osnovica, ukupan_pdv, ukupan_iznos, status_fakture, id_godine, id_poslovnog_partnera, id_preduzeca) VALUES (1, '2020-08-08', '2020-08-08', 310, 10, 320, 'P', 1, 1, 1);
INSERT INTO faktura(broj_fakture, datum_fakture, datum_valute, ukupna_osnovica, ukupan_pdv, ukupan_iznos, status_fakture, id_godine, id_poslovnog_partnera, id_preduzeca) VALUES (2, '2020-09-09', '2020-09-09', 200, 15, 215, 'F', 1, 1, 1);

INSERT INTO stavka_fakture(kolicina, rabat, jedinicna_cena, pdv_stopa, osnovica_za_pdv, iznos_pdv, ukupan_iznos, id_fakture, id_preduzeca, id_robe_usluge) VALUES (1, 5, 310, 5, 310, 20, 320, 1, 1, 5);
INSERT INTO stavka_fakture(kolicina, rabat, jedinicna_cena, pdv_stopa, osnovica_za_pdv, iznos_pdv, ukupan_iznos, id_fakture, id_preduzeca, id_robe_usluge) VALUES (1, 5, 200, 5, 200, 15, 215, 2, 1, 3);

--INSERT INTO faktura_stavke_fakture(faktura_id_fakture, stavke_fakture_id_stavke) VALUES (1, 1);
--INSERT INTO faktura_stavke_fakture(faktura_id_fakture, stavke_fakture_id_stavke) VALUES (2, 2);

INSERT INTO poslovna_godina_fakture(poslovna_godina_id_godine, fakture_id_fakture) VALUES (1, 1);
INSERT INTO poslovna_godina_fakture(poslovna_godina_id_godine, fakture_id_fakture) VALUES (1, 2);

--INSERT INTO poslovni_partner_fakture(poslovni_partner_id_poslovnog_partnera, fakture_id_fakture) VALUES (1 ,1);
--INSERT INTO poslovni_partner_fakture(poslovni_partner_id_poslovnog_partnera, fakture_id_fakture) VALUES (1, 2);

INSERT INTO preduzece_fakture(preduzece_id_preduzeca, fakture_id_fakture) VALUES (1, 1);
INSERT INTO preduzece_fakture(preduzece_id_preduzeca, fakture_id_fakture) VALUES (1, 2);

INSERT INTO preduzece_stavke_fakture(preduzece_id_preduzeca, stavke_fakture_id_stavke) VALUES (1, 1);
INSERT INTO preduzece_stavke_fakture(preduzece_id_preduzeca, stavke_fakture_id_stavke) VALUES (1, 2);

--INSERT INTO roba_usluga_stavke_fakture(roba_usluga_id_robe_usluge, stavke_fakture_id_stavke) VALUES (5, 1);
--INSERT INTO roba_usluga_stavke_fakture(roba_usluga_id_robe_usluge, stavke_fakture_id_stavke) VALUES (3, 2);

INSERT INTO korisnik(korisnicko_ime, lozinka, uloga) VALUES ('pera', 'pera', 'admin');
INSERT INTO korisnik(korisnicko_ime, lozinka, uloga) VALUES ('ana', 'ana', 'korisnik');

INSERT INTO otpremnica(broj_otpremnice, kupac, adresa_isporuke, datum_isporuke, prevoznik, potpis_vozaca, primio_robu, id_fakture) VALUES (1, 'pera', 'Vase Stajica 2, Novi Sad', '2020-10-10', 'MultiExpress', true, true, 1);
INSERT INTO otpremnica(broj_otpremnice, kupac, adresa_isporuke, datum_isporuke, prevoznik, potpis_vozaca, primio_robu, id_fakture) VALUES (2, 'ana', 'Lazina 12, Novi Sad', '2020-11-11', 'OkExpress', true, true, 2);

INSERT INTO stavka_otpremnice(redni_broj_proizvoda,  jedinica_mere, cena, kolicina, napomena, id_otpremnice) VALUES (1, 3, 200, 1, '', 1);
INSERT INTO stavka_otpremnice(redni_broj_proizvoda,  jedinica_mere, cena, kolicina, napomena, id_otpremnice) VALUES (2, 5, 310,  1, 'brza isporuka', 2);


INSERT INTO faktura_otpremnice(faktura_id_fakture, otpremnice_id_otpremnice) VALUES (1,1);
INSERT INTO faktura_otpremnice(faktura_id_fakture, otpremnice_id_otpremnice) VALUES (2,2);

INSERT INTO otpremnica_stavke_otpremnice(otpremnica_id_otpremnice, stavke_otpremnice_id_stavke_otpremnice) VALUES (1, 1);
INSERT INTO otpremnica_stavke_otpremnice(otpremnica_id_otpremnice, stavke_otpremnice_id_stavke_otpremnice) VALUES (2, 2);





