INSERT INTO public.role (id, type) VALUES (DEFAULT, 'admin');
INSERT INTO public.role (id, type) VALUES (DEFAULT, 'customer');

INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Tallinn')
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Tartu')
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Parnu')

INSERT INTO public.transaction (id, type) VALUES (1, 'sularaha sisse')
INSERT INTO public.transaction (id, type) VALUES (2, 'sularaha valja')
INSERT INTO public.transaction (id, type) VALUES (3, 'maksed')

INSERT INTO public."user" (id, role_id, username, password, status) VALUES (1, 1, 'admin', '123', 'A')
INSERT INTO public."user" (id, role_id, username, password, status) VALUES (2, 2, 'rain', '123', 'A')
INSERT INTO public."user" (id, role_id, username, password, status) VALUES (3, 1, 'roby', '123', 'A'

INSERT INTO public.location (id, city_id, name, number_of_atms, picture, status, longitude, latitude) VALUES (DEFAULT, 1, 'Sikupill Prisma', 4, null, 'A', null, null)
INSERT INTO public.location (id, city_id, name, number_of_atms, picture, status, longitude, latitude) VALUES (DEFAULT, 2, 'Joe Prisma', 3, null, 'A', null, null)

INSERT INTO public.location_transaction (id, location_id, transaction_id, available) VALUES (1, 1, 1, true);
INSERT INTO public.location_transaction (id, location_id, transaction_id, available) VALUES (2, 1, 2, true);
INSERT INTO public.location_transaction (id, location_id, transaction_id, available) VALUES (3, 1, 3, true);
INSERT INTO public.location_transaction (id, location_id, transaction_id, available) VALUES (4, 2, 1, true);
INSERT INTO public.location_transaction (id, location_id, transaction_id, available) VALUES (5, 2, 2, true);
INSERT INTO public.location_transaction (id, location_id, transaction_id, available) VALUES (6, 2, 3, false);
