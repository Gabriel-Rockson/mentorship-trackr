ALTER TABLE admins
    ADD UNIQUE (username, email);