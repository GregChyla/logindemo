create sequence hibernate_sequence;
create sequence user_sequence;
create sequence role_sequence;

CREATE TABLE user_t
(
    id                 BIGINT PRIMARY KEY,
    username           character varying NOT NULL,
    email              character varying NOT NULL,
    password           character varying NOT NULL,
    account_non_locked BOOLEAN                    default true,
    created            timestamp         not null default current_timestamp,
    UNIQUE (username, email)
);

CREATE TABLE role
(
    role_id   INTEGER NOT NULL PRIMARY KEY,
    role_name varchar(30) DEFAULT NULL
);

CREATE TABLE user_role
(
    user_id BIGINT NOT NULL,
    role_id INTEGER NOT NULL,
    PRIMARY KEY (user_id, role_id),
    CONSTRAINT user_fk FOREIGN KEY (user_id) REFERENCES user_t (id),
    CONSTRAINT role_fk FOREIGN KEY (role_id) REFERENCES role (role_id)
);



