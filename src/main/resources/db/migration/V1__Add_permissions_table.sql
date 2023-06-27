CREATE TABLE IF NOT EXISTS permissions
(
    id          UUID NOT NULL,
    name        VARCHAR(200),
    description VARCHAR(200),
    CONSTRAINT pk_permissions PRIMARY KEY (id)
);