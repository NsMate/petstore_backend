INSERT INTO PET (id, name, status) VALUES (1, 'Zorro', 'not_available');
INSERT INTO PET (id, name, status) VALUES (2, 'Rocky', 'available');
INSERT INTO PET (id, name, status) VALUES (3, 'Dog', 'not_available');

INSERT INTO PET_ORDER (id, pet_id, quantity, ship_date, status, complete) VALUES (1, 1, 1, '20250325', 'pending', false);
INSERT INTO PET_ORDER (id, pet_id, quantity, ship_date, status, complete) VALUES (2, 3, 1, '20250228', 'done', true);