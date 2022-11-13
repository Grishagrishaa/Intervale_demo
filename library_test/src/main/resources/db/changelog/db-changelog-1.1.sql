--liquibase formatted sql

--changeset grisha:1
CREATE TABLE IF NOT EXISTS library.publishers
(
    id uuid NOT NULL,
    create_date timestamp without time zone,
    version integer,
    country character varying(255),
    name character varying(255),
    CONSTRAINT publishers_pkey PRIMARY KEY (id)
);



--changeset grisha:2
CREATE TABLE IF NOT EXISTS library.authors
(
    id uuid NOT NULL,
    create_date timestamp without time zone,
    version integer,
    birth_year integer,
    lastname character varying(255),
    name character varying(255),
    CONSTRAINT authors_pkey PRIMARY KEY (id),
    CONSTRAINT authornameconstraint UNIQUE (name)
)





