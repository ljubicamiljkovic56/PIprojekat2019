
SET FOREIGN_KEY_CHECKS = 0;

--CREATE TABLE proizvod(proizvod_id BIGINT NOT NULL AUTO_INCREMENT,naziv VARCHAR(20) NOT NULL,cena DECIMAL NOT NULL, PRIMARY KEY (proizvod_id));

INSERT INTO proizvod(naziv, cena) VALUES ('Laptop Dell Latitude', 22000);

INSERT INTO korisnik(korisnicko_ime, lozinka, uloga) VALUES ('pera', 'pera', 'admin');