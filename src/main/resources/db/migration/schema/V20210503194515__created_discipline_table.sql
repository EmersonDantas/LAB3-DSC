CREATE SEQUENCE discipline_sequence
    INCREMENT BY 1
    START WITH 1
    MAXVALUE 9223372036854775807
    MINVALUE 1
    NO CYCLE;

CREATE TABLE IF NOT EXISTS discipline (
    id int8 NOT NULL DEFAULT nextval('discipline_sequence'),
    nome varchar(1024) NOT NULL,
    nota decimal(20) NULL,
    amount_likes int8 NULL DEFAULT 0
);