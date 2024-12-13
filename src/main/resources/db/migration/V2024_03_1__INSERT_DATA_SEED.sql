INSERT INTO vagon_class
VALUES
    ('1st class with seat', 54, 0, 1.7),
    ('1st class without seat', 54, 25, 1.3),
    ('2st class with seat', 72, 0, 1.5),
    ('2st class without seat', 72, 25, 1.1);

INSERT INTO train
VALUES
    (1,'MD-001'),
    (2,'MD-002'),
    (3,'MD-003'),
    (4,'MD-004');

INSERT INTO trainloadedvagons
VALUES
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 4);

INSERT INTO vagon
VALUES
    (1,'1st class with seat'),
    (2,'2st class with seat'),
    (3,'2st class without seat'),
    (4,'2st class without seat');

INSERT INTO trainvagon
VALUES
    (1,1,1),
    (1,2,2),
    (1,3,3),
    (1,4,4),

    (2,1,1),
    (2,2,2),
    (2,3,3),
    (2,4,4),

    (3,1,1),
    (3,2,2),
    (3,3,3),
    (3,4,4),

    (4,1,1),
    (4,2,2),
    (4,3,3),
    (4,4,4);

-- Ocnita - Balti
INSERT INTO travel VALUES (1, 1, 1, '2024-01-01 08:00:00'),
                           (2, 1, 1, '2024-01-01 10:00:00'),
                           (3, 1, 1, '2024-01-01 12:00:00'),
                           (4, 1, 1, '2024-01-01 14:00:00'),
                           (5, 1, 1, '2024-01-01 16:00:00');

-- Balti - Ocnita
INSERT INTO travel VALUES (6, 2, 1, '2024-01-01 08:30:00'),
                           (7, 2, 1, '2024-01-01 10:30:00'),
                           (8, 2, 1, '2024-01-01 12:30:00'),
                           (9, 2, 1, '2024-01-01 14:30:00'),
                           (10, 2, 1, '2024-01-01 16:30:00');
