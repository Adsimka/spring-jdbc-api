CREATE TABLE customer(
    id          BIGSERIAL       PRIMARY KEY,
    fio         TEXT            NOT NULL,
    phone       TEXT,
    address     TEXT,
    created_at   TIMESTAMP       DEFAULT now()
)