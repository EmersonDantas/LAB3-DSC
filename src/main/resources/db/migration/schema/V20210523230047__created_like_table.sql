CREATE SEQUENCE like_sequence
    INCREMENT BY 1
    START WITH 1
    MAXVALUE 9223372036854775807
    MINVALUE 1
    NO CYCLE;

CREATE TABLE IF NOT EXISTS dsc_like (
    id int8 NOT NULL DEFAULT nextval('like_sequence'),
    discipline_id int8 NOT NULL,
    user_id int8 NOT NULL,

    CONSTRAINT discipline_like_fk FOREIGN KEY (discipline_id) REFERENCES discipline(id) ON DELETE CASCADE,
    CONSTRAINT user_like_fk FOREIGN KEY (user_id) REFERENCES dsc_user(id) ON DELETE CASCADE
    );