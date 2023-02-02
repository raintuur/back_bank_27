INSERT INTO public.role (id, type) VALUES (DEFAULT, 'admin');
INSERT INTO public.role (id, type) VALUES (DEFAULT, 'customer');

INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Tallinn');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Tartu');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Pärnu');

INSERT INTO public.transaction (id, type) VALUES (DEFAULT, 'sularaha sisse');
INSERT INTO public.transaction (id, type) VALUES (DEFAULT, 'sularaha välja');
INSERT INTO public.transaction (id, type) VALUES (DEFAULT, 'makse');

INSERT INTO public."user" (id, role_id, username, password, status) VALUES (DEFAULT, 1, 'admin', '123', 'A');
INSERT INTO public."user" (id, role_id, username, password, status) VALUES (DEFAULT, 2, 'rain', '123', 'A');
INSERT INTO public."user" (id, role_id, username, password, status) VALUES (DEFAULT, 1, 'roby', '123', 'A');

INSERT INTO public.location (id, city_id, name, number_of_atms, picture, status, longitude, latitude) VALUES (DEFAULT, 1, 'Sikupilli Prisma', 4, null, 'A', null, null);
INSERT INTO public.location (id, city_id, name, number_of_atms, picture, status, longitude, latitude) VALUES (DEFAULT, 2, 'Jõe Prisma', 3, null, 'A', null, null);

INSERT INTO public.location_transaction (id, location_id, transaction_id, available) VALUES (DEFAULT, 1, 1, true);
INSERT INTO public.location_transaction (id, location_id, transaction_id, available) VALUES (DEFAULT, 1, 2, true);
INSERT INTO public.location_transaction (id, location_id, transaction_id, available) VALUES (DEFAULT, 1, 3, true);
INSERT INTO public.location_transaction (id, location_id, transaction_id, available) VALUES (DEFAULT, 2, 1, true);
INSERT INTO public.location_transaction (id, location_id, transaction_id, available) VALUES (DEFAULT, 2, 2, true);
INSERT INTO public.location_transaction (id, location_id, transaction_id, available) VALUES (DEFAULT, 2, 3, false);
