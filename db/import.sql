INSERT INTO public.role (id, type) VALUES (DEFAULT, 'admin');
INSERT INTO public.role (id, type) VALUES (DEFAULT, 'customer');

INSERT INTO public.city (id, name) VALUES (1, 'Tallinn');
INSERT INTO public.city (id, name) VALUES (2, 'Tartu');
INSERT INTO public.city (id, name) VALUES (3, 'Pärnu');

INSERT INTO public.transaction (id, type) VALUES (1, 'sularaha sisse');
INSERT INTO public.transaction (id, type) VALUES (2, 'sularaha välja');
INSERT INTO public.transaction (id, type) VALUES (3, 'maksed');

INSERT INTO public.location (id, city_id, name, number_of_atms, picture, status, longitude, latitude) VALUES (1, 1, 'Sikupilli Prisma', 4, null, 'A', null, null);
INSERT INTO public.location (id, city_id, name, number_of_atms, picture, status, longitude, latitude) VALUES (2, 2, 'Jõe Prisma', 3, null, 'A', null, null);

INSERT INTO public.location_transaction (id, transaction_id, location_id, available) VALUES (1, 1, 1, true);
INSERT INTO public.location_transaction (id, transaction_id, location_id, available) VALUES (2, 2, 1, true);
INSERT INTO public.location_transaction (id, transaction_id, location_id, available) VALUES (3, 3, 1, true);
INSERT INTO public.location_transaction (id, transaction_id, location_id, available) VALUES (4, 1, 2, true);
INSERT INTO public.location_transaction (id, transaction_id, location_id, available) VALUES (5, 2, 2, true);
INSERT INTO public.location_transaction (id, transaction_id, location_id, available) VALUES (6, 3, 2, false);
