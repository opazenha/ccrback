-- Create prayers table
CREATE TABLE prayers (
    id BIGSERIAL PRIMARY KEY,
    requester_id BIGINT,
    prayer_request TEXT,
    status VARCHAR(50),
    FOREIGN KEY (requester_id) REFERENCES users(id)
);