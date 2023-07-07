CREATE TABLE advisors
(
    id            UUID                        NOT NULL,
    username      VARCHAR(255)                NOT NULL,
    email         VARCHAR(255)                NOT NULL,
    password      VARCHAR(255)                NOT NULL,
    role_id       UUID,
    date_of_birth date                        NOT NULL,
    created_at    TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_at    TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    country       VARCHAR(255)                NOT NULL,
    city          VARCHAR(255)                NOT NULL,
    CONSTRAINT pk_advisors PRIMARY KEY (id)
);

ALTER TABLE advisors
    ADD CONSTRAINT uc_advisors_email UNIQUE (email);

ALTER TABLE advisors
    ADD CONSTRAINT uc_advisors_username UNIQUE (username);

ALTER TABLE advisors
    ADD CONSTRAINT FK_ADVISORS_ON_ROLE FOREIGN KEY (role_id) REFERENCES roles (id);

CREATE TABLE advisees
(
    id            UUID                        NOT NULL,
    username      VARCHAR(255)                NOT NULL,
    email         VARCHAR(255)                NOT NULL,
    password      VARCHAR(255)                NOT NULL,
    role_id       UUID,
    date_of_birth date                        NOT NULL,
    advisor_id    UUID,
    created_at    TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_at    TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    country       VARCHAR(255)                NOT NULL,
    city          VARCHAR(255)                NOT NULL,
    CONSTRAINT pk_advisees PRIMARY KEY (id)
);

ALTER TABLE advisees
    ADD CONSTRAINT uc_advisees_email UNIQUE (email);

ALTER TABLE advisees
    ADD CONSTRAINT uc_advisees_username UNIQUE (username);

ALTER TABLE advisees
    ADD CONSTRAINT FK_ADVISEES_ON_ADVISOR FOREIGN KEY (advisor_id) REFERENCES advisors (id);

ALTER TABLE advisees
    ADD CONSTRAINT FK_ADVISEES_ON_ROLE FOREIGN KEY (role_id) REFERENCES roles (id);