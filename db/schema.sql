CREATE TABLE if NOT EXISTS aTypes (
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(2000)
);

CREATE TABLE if NOT EXISTS rules (
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(2000)

);

CREATE TABLE if NOT EXISTS accidents (
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(2000),
    text        VARCHAR(2000),
    address     VARCHAR(2000),
    type_id     INTEGER REFERENCES aTypes(id)
);

CREATE TABLE if NOT EXISTS accident_rule (
    accident_id       INTEGER REFERENCES accidents(id),
    rule_id           INTEGER REFERENCES rules(id),
    PRIMARY KEY (accident_id, rule_id)
);

CREATE TABLE if NOT EXISTS users (
	id SERIAL       PRIMARY KEY,
	username        VARCHAR(255) NOT NULL UNIQUE,
	password        VARCHAR(255) NOT NULL,
	email           VARCHAR(255) NOT NULL,
	enable          boolean DEFAULT TRUE
);

CREATE TABLE if NOT EXISTS roles (
	id SERIAL       PRIMARY KEY,
	name            VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE if NOT EXISTS users_roles (
	username_id     INTEGER REFERENCES users(id),
	role_id         INTEGER REFERENCES roles(id),
	PRIMARY KEY(username_id, role_id)
);







