ALTER TABLE admins
    ADD CONSTRAINT uc_admins_email UNIQUE (email);

ALTER TABLE admins
    ADD CONSTRAINT uc_admins_username UNIQUE (username);
