CREATE TABLE admins
(
    id        UUID NOT NULL,
    username  VARCHAR(255) NOT NULL,
    firstname VARCHAR(255) NOT NULL,
    email     VARCHAR(255) NOT NULL,
    password  VARCHAR(255) NOT NULL,
    role_id   UUID NOT NULL,
    CONSTRAINT pk_admins PRIMARY KEY (id)
);

ALTER TABLE admins
    ADD CONSTRAINT FK_ADMINS_ON_ROLE FOREIGN KEY (role_id) REFERENCES roles (id);