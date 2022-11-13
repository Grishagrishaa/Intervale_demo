--liquibase formatted sql

--changeset grisha:1
CREATE TABLE IF NOT EXISTS library.newspapers_authors
(
    newspapers_id uuid NOT NULL,
    author_id uuid NOT NULL,
    CONSTRAINT newspapers_authors_pkey PRIMARY KEY (newspapers_id, author_id),
    CONSTRAINT fk7xx2137gs6s0qbj1253mf1r2g FOREIGN KEY (newspapers_id)
        REFERENCES library.newspapers (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fka9vhcbynme8bymyvjti2bjo8w FOREIGN KEY (author_id)
        REFERENCES library.authors (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);



--changeset grisha:2
CREATE TABLE IF NOT EXISTS library.books_authors
(
    books_id uuid NOT NULL,
    author_id uuid NOT NULL,
    CONSTRAINT books_authors_pkey PRIMARY KEY (books_id, author_id),
    CONSTRAINT fk3qua08pjd1ca1fe2x5cgohuu5 FOREIGN KEY (author_id)
        REFERENCES library.authors (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkq3f75b7gkvjqe5k1pa5emwpgw FOREIGN KEY (books_id)
        REFERENCES library.books (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)



--changeset grisha:3
CREATE TABLE IF NOT EXISTS library.magazines_authors
(
    magazines_id uuid NOT NULL,
    author_id uuid NOT NULL,
    CONSTRAINT magazines_authors_pkey PRIMARY KEY (magazines_id, author_id),
    CONSTRAINT fkg8dsfupkks62b6lo55d9uhlli FOREIGN KEY (author_id)
        REFERENCES library.authors (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkpe4r2ij1mb4kd4mbiltvuffya FOREIGN KEY (magazines_id)
        REFERENCES library.magazines (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)






