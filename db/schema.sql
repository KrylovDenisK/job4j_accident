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



