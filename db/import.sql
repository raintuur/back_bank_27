INSERT INTO public.role (id, type) VALUES (1, 'admin');
INSERT INTO public.role (id, type) VALUES (2, 'customer');

INSERT INTO public.city (id, name) VALUES (1, 'Tallinn');
INSERT INTO public.city (id, name) VALUES (2, 'Tartu');
INSERT INTO public.city (id, name) VALUES (3, 'Pärnu');

INSERT INTO public.transaction (id, type) VALUES (1, 'sularaha sisse');
INSERT INTO public.transaction (id, type) VALUES (2, 'sularaha välja');
INSERT INTO public.transaction (id, type) VALUES (3, 'maksed');

INSERT INTO public."user" (id, role_id, username, password, status) VALUES (1, 1, 'admin', '123', 'A');
INSERT INTO public."user" (id, role_id, username, password, status) VALUES (2, 2, 'helar', '456', 'A');
INSERT INTO public."user" (id, role_id, username, password, status) VALUES (3, 1, 'roby', '123', 'A');

INSERT INTO public.location (id, city_id, name, number_of_atms, picture, status, longitude, latitude) VALUES (1, 1, 'Sikupilli Prisma', 4, null, 'A', null, null);
INSERT INTO public.location (id, city_id, name, number_of_atms, picture, status, longitude, latitude) VALUES (2, 2, 'Jõe Prisma', 3, null, 'A', null, null);
