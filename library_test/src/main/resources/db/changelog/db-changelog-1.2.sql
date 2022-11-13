--liquibase formatted sql


--changeset grisha:1
CREATE TABLE IF NOT EXISTS library.books
(
    id uuid NOT NULL,
    create_date timestamp without time zone,
    version integer,
    title character varying(255),
    issue_year integer,
    publisher_id uuid,
    CONSTRAINT books_pkey PRIMARY KEY (id),
    CONSTRAINT fkayy5edfrqnegqj3882nce6qo8 FOREIGN KEY (publisher_id)
        REFERENCES library.publishers (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);



--changeset grisha:2
CREATE TABLE IF NOT EXISTS library.newspapers
(
    id uuid NOT NULL,
    create_date timestamp without time zone,
    version integer,
    news_type integer,
    title character varying(255),
    year integer,
    publisher_id uuid,
    CONSTRAINT newspapers_pkey PRIMARY KEY (id),
    CONSTRAINT fkjfaiotd10kp4lf7a4w0jjkmsd FOREIGN KEY (publisher_id)
        REFERENCES library.publishers (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);


--changeset grisha:3
CREATE TABLE IF NOT EXISTS library.magazines
(
    id uuid NOT NULL,
    create_date timestamp without time zone,
    version integer,
    title character varying(255),
    topic character varying(255),
    year integer,
    publisher_id uuid,
    CONSTRAINT magazines_pkey PRIMARY KEY (id),
    CONSTRAINT fkj1ykgjpod1os7dny4bnhq1u8c FOREIGN KEY (publisher_id)
        REFERENCES library.publishers (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);



