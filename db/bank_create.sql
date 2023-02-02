-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-01-27 10:12:06.276

-- tables
-- Table: city
CREATE TABLE city (
                      id serial  NOT NULL,
                      name varchar(255)  NOT NULL,
                      CONSTRAINT city_pk PRIMARY KEY (id)
);

-- Table: location
CREATE TABLE location (
                          id serial  NOT NULL,
                          city_id int  NOT NULL,
                          name varchar(255)  NOT NULL,
                          number_of_atms int  NOT NULL,
                          picture bytea  NULL,
                          status char(1)  NOT NULL,
                          longitude decimal(6,2)  NULL,
                          latitude decimal(6,2)  NULL,
                          CONSTRAINT location_ak_1 UNIQUE (name) NOT DEFERRABLE  INITIALLY IMMEDIATE,
                          CONSTRAINT location_pk PRIMARY KEY (id)
);

-- Table: location_transaction
CREATE TABLE location_transaction (
                                      id serial  NOT NULL,
                                      location_id int  NOT NULL,
                                      transaction_id int  NOT NULL,
                                      available boolean  NOT NULL,
                                      CONSTRAINT location_transaction_pk PRIMARY KEY (id)
);

-- Table: role
CREATE TABLE role (
                      id serial  NOT NULL,
                      type varchar(50)  NOT NULL,
                      CONSTRAINT role_pk PRIMARY KEY (id)
);

-- Table: transaction
CREATE TABLE transaction (
                             id serial  NOT NULL,
                             type varchar(50)  NOT NULL,
                             CONSTRAINT transaction_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE "user" (
                        id serial  NOT NULL,
                        role_id int  NOT NULL,
                        username varchar(255)  NOT NULL,
                        password varchar(255)  NOT NULL,
                        status char(1)  NOT NULL,
                        CONSTRAINT user_ak_1 UNIQUE (username) NOT DEFERRABLE  INITIALLY IMMEDIATE,
                        CONSTRAINT user_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: location_city (table: location)
ALTER TABLE location ADD CONSTRAINT location_city
    FOREIGN KEY (city_id)
        REFERENCES city (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: location_transaction_location (table: location_transaction)
ALTER TABLE location_transaction ADD CONSTRAINT location_transaction_location
    FOREIGN KEY (location_id)
        REFERENCES location (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: location_transaction_transaction (table: location_transaction)
ALTER TABLE location_transaction ADD CONSTRAINT location_transaction_transaction
    FOREIGN KEY (transaction_id)
        REFERENCES transaction (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: user_role (table: user)
ALTER TABLE "user" ADD CONSTRAINT user_role
    FOREIGN KEY (role_id)
        REFERENCES role (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- End of file.

