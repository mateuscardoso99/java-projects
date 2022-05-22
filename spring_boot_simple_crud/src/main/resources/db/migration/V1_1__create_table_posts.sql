/* flyway: instalar para controlar as migrations */
CREATE TABLE posts (
    id BIGINT AUTO_INCREMENT NOT NULL,
    title VARCHAR(100) NOT NULL,
    text TEXT NOT NULL,
    description TEXT NOT NULL,
    CONSTRAINT PK_POST PRIMARY KEY (id),
    CONSTRAINT U_POST_TITLE UNIQUE (title)
);