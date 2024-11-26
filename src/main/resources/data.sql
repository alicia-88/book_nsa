INSERT INTO author (aut_birtdate, aut_firstname, aut_lastname, aut_nationality) VALUES
                                                                                    ('1970-05-15', 'Jean', 'Dupont', 'Française'),
                                                                                    ('1982-08-22', 'Marie', 'Durand', 'Française'),
                                                                                    ('1965-11-30', 'Pierre', 'Martin', 'Française');

INSERT INTO category (cat_name) VALUES
                                    ('Science-fiction'),
                                    ('Roman'),
                                    ('Histoire'),
                                    ('Technologie');

INSERT INTO book (boo_title, boo_price, boo_release_year, boo_cover_image, boo_synopsis, aut_id, cat_id) VALUES
                                                                                                             ('Le Voyage Interstellaire', 19.99, '2015-06-01', 'cover1.jpg', 'Une aventure à travers les étoiles.', 1, 1),
                                                                                                             ('Les Mystères du Temps', 14.99, '2018-09-15', 'cover2.jpg', 'Une exploration du temps et de l''espace.', 2, 1),
                                                                                                             ('Histoire de France', 29.99, '2010-01-10', 'cover3.jpg', 'Un regard approfondi sur l''histoire de France.', 3, 3),
                                                                                                             ('Programmation Moderne', 39.99, '2020-02-20', 'cover4.jpg', 'Guide complet sur les techniques de programmation.', 1, 4);

INSERT INTO `order` (ord_date, ord_quantity, ord_total) VALUES
                                                            ('2023-11-25', 3, 59.97),
                                                            ('2023-11-26', 2, 29.98),
                                                            ('2023-11-27', 1, 19.99);

INSERT INTO line (lin_quantity, lin_price, boo_id, ord_id) VALUES
                                                               (1, 19.99, 1, 1),
                                                               (1, 14.99, 2, 1),
                                                               (1, 24.99, 3, 1),
                                                               (2, 29.99, 3, 2),
                                                               (1, 39.99, 4, 2),
                                                               (1, 19.99, 1, 3);
