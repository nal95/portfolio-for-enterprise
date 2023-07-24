CREATE TABLE IF NOT EXISTS enterprises (
    id SERIAL PRIMARY KEY,
    enterprise_name VARCHAR(50) NOT NULL,
    enterprise_token VARCHAR(50)  NOT NULL
);