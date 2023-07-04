ALTER TABLE permissions
    ADD created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL default now();
ALTER TABLE permissions
    ADD updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL default now();