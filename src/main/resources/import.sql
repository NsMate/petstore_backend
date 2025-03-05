INSERT INTO PET (id, name, status) VALUES (1, 'Cat', 'pending');
INSERT INTO PET (id, name, status) VALUES (2, 'Dog', 'available');
INSERT INTO PET (id, name, status) VALUES (3, 'Fish', 'sold');
INSERT INTO PET (id, name, status) VALUES (4, 'Lion', 'available');
INSERT INTO PET (id, name, status) VALUES (5, 'Turtle', 'available');

INSERT INTO PET_ORDER (id, pet_id, quantity, ship_date, status, complete) VALUES (1, 1, 1, '2025-03-28T13:56:42.954Z', 'placed', false);
INSERT INTO PET_ORDER (id, pet_id, quantity, ship_date, status, complete) VALUES (2, 3, 1, '2025-02-28T13:56:42.954Z', 'approved', true);