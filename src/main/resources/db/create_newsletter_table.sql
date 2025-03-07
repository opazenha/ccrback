CREATE TABLE newsletters (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255),
    content TEXT,
    date DATE
);

INSERT INTO newsletters (title, content, date) VALUES
('Newsletter 1', 'Content 1', '2024-01-01'),
('Newsletter 2', 'Content 2', '2024-01-08'),
('Newsletter 3', 'Content 3', '2024-01-15'),
('Newsletter 4', 'Content 4', '2024-01-22'),
('Newsletter 5', 'Content 5', '2024-01-29'),
('Newsletter 6', 'Content 6', '2024-02-05'),
('Newsletter 7', 'Content 7', '2024-02-12'),
('Newsletter 8', 'Content 8', '2024-02-19'),
('Newsletter 9', 'Content 9', '2024-02-26'),
('Newsletter 10', 'Content 10', '2024-03-04');