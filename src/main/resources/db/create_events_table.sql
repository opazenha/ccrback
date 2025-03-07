CREATE TABLE events (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    date DATE NOT NULL,
    time TIME NOT NULL,
    duration INT, -- Time duration represented in minutes
    departament VARCHAR(255),
    status VARCHAR(50),
    reminder VARCHAR(255),
    notes TEXT
);