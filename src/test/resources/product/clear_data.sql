-- Delete data from the 'Product' table
DELETE FROM Product;

-- For the 'Product' table
ALTER TABLE Product ALTER COLUMN id RESTART WITH 1;