-- Mengupdate harga di tabel product
UPDATE product SET price = 20000 WHERE code = 'PRD001';

-- Melihat hasil update langsung
SELECT * FROM product;