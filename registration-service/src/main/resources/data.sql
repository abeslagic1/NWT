DELETE FROM krevet;
DELETE FROM pacijent;
DELETE FROM rezervacija;
DELETE FROM soba;

INSERT INTO krevet (naziv_kreveta, soba_id, zauzetost) values ('Krevet_2', 1, false);
INSERT INTO krevet (naziv_kreveta, soba_id, zauzetost) values ('Krevet_3', 2, false);
INSERT INTO krevet (naziv_kreveta, soba_id, zauzetost) values ('Krevet_4', 3, false);
INSERT INTO krevet (naziv_kreveta, soba_id, zauzetost) values ('Krevet_1', 1, true);
INSERT INTO krevet (naziv_kreveta, soba_id, zauzetost) values ('Krevet_5', 4, false);


INSERT INTO pacijent (ime, prezime, samUSobi) values ('Amar', 'Beslagic', true);
INSERT INTO pacijent (ime, prezime, samUSobi) values ('Haris', 'Beslagic', false);
INSERT INTO pacijent (ime, prezime, samUSobi) values ('Ferhat', 'Dobraca', false);

INSERT INTO rezervacija (pacijent_id, krevet_id, soba_id, datum_dolaska, datum_odlaska) values (1, 2, 1, '2024-05-15T10:30:00', '2024-05-22T00:00:00');
INSERT INTO rezervacija (pacijent_id, krevet_id, soba_id, datum_dolaska, datum_odlaska) values (2, 3, 2, '2024-05-01', '2024-05-05');
-- INSERT INTO rezervacija (id, pacijent_id, krevet_id, soba_id, datum_dolaska, datum_odlaska) values (1, 3, 2, 1, '12-01-2023', '18-01-2023');
-- INSERT INTO rezervacija (id, pacijent_id, krevet_id, soba_id, datum_dolaska, datum_odlaska) values (1, 4, 2, 1, '12-01-2023', '18-01-2023');


INSERT INTO soba (naziv_sobe, zauzetost, private_shared) values ('Soba_1', false, 'S');
INSERT INTO soba (naziv_sobe, zauzetost, private_shared) values ('Soba_2', false, 'S');
INSERT INTO soba (naziv_sobe, zauzetost, private_shared) values ('Soba_3', false, 'S');
INSERT INTO soba (naziv_sobe, zauzetost, private_shared) values ('Soba_4', true, 'P');