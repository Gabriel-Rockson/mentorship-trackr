ALTER TABLE roles
    ADD created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL default now();

ALTER TABLE roles
    ADD updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL default now();