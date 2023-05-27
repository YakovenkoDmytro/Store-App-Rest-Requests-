
-- База даних
CREATE DATABASE demo_db;

-- Таблиця
CREATE TABLE IF NOT EXISTS products
( id INTEGER NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  category VARCHAR(255) NOT NULL,
  price DECIMAL(6,2),
  PRIMARY KEY (id)
);

-- Первинні дані
INSERT INTO products
(name, category, price)
VALUES
('mango', 'fruits', 3.99),
('apple', 'fruits', 1.99),
('tomato', 'vegetables', 2.25),
('grape', 'fruits', 4.99),
('carrot', 'vegetables', 1.95);


SELECT * FROM products;
