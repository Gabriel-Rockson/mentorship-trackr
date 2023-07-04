ALTER TABLE admins
    ADD created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL default now();

ALTER TABLE admins
    ADD updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL default now();

ALTER TABLE users
    ADD created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL default now();

ALTER TABLE users
    ADD updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL default now();