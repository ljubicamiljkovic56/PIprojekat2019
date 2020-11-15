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

INSERT INTO roba_usluga(naziv_robe_usluge, opis, roba, id_jedinice_mere) VALUES ('Laptop Dell Latitude','mali laptop', true, 1);
INSERT INTO roba_usluga(naziv_robe_usluge, opis, roba, id_jedinice_mere) VALUES ('Pakovanje malih zavrtnja', 'visenamenski zavrtnji', true, 2);
INSERT INTO roba_usluga(naziv_robe_usluge, opis, roba, id_jedinice_mere) VALUES ('ScreenClean', 'sprej za ciscenje monitora',true, 3);
INSERT INTO roba_usluga(naziv_robe_usluge, opis, roba, id_jedinice_mere) VALUES ('Asepsol', 'sredstvo za ciscenje', true, 4);
INSERT INTO roba_usluga(naziv_robe_usluge, opis, roba, id_jedinice_mere) VALUES ('Steinberg antifriz', 'antifriz za auto', true, 5);

INSERT INTO korisnik(korisnicko_ime, lozinka, uloga) VALUES ('pera', 'pera', 'admin');
INSERT INTO korisnik(korisnicko_ime, lozinka, uloga) VALUES ('ana', 'ana', 'korisnik');


