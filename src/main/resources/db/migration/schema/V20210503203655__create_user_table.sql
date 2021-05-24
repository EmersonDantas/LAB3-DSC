CREATE SEQUENCE user_sequence
    INCREMENT BY 1
    START WITH 1
    MAXVALUE 9223372036854775807
    MINVALUE 1
    NO CYCLE;

CREATE TABLE IF NOT EXISTS dsc_user (
    id int8 NOT NULL DEFAULT nextval('user_sequence'),
    email varchar(256) NOT NULL UNIQUE,
    nome varchar(2048) NOT NULL,
    senha varchar(2048) NOT NULL
);