CREATE TABLE IF NOT EXISTS roles
(
    id          UUID NOT NULL,
    name        VARCHAR(200),
    description VARCHAR(200),
    CONSTRAINT pk_roles PRIMARY KEY (id)
);