CREATE TABLE customer(
    id          BIGSERIAL       PRIMARY KEY,
    fio         TEXT            NOT NULL,
    phone       TEXT,
    address     TEXT,
    created_at   TIMESTAMP       DEFAULT now()
)

ALTER TABLE customer RENAME COLUMN createdAt TO created_at