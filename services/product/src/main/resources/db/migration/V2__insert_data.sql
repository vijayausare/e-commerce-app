-- More categories
INSERT INTO category (id, description, name)
VALUES
    (nextval('category_seq'), 'Clothing and accessories for men and women', 'Fashion'),
    (nextval('category_seq'), 'Health, wellness, and beauty products', 'Health & Beauty'),
    (nextval('category_seq'), 'Office supplies and business essentials', 'Office Supplies'),
    (nextval('category_seq'), 'Pet care food, toys, and accessories', 'Pet Supplies'),
    (nextval('category_seq'), 'Toys and games for children of all ages', 'Toys');

INSERT INTO product (id, description, name, available_quantity, price, category_id)
VALUES
    (nextval('product_seq'), '15-inch laptop with SSD storage', 'UltraBook Z5', 90, 1199.00,
     (SELECT id FROM category WHERE name = 'Electronics')),
    (nextval('product_seq'), '4K Ultra HD Smart TV 55-inch', 'VisionTV 55', 40, 899.49,
     (SELECT id FROM category WHERE name = 'Electronics')),
    (nextval('product_seq'), 'Wireless Bluetooth speaker', 'SoundBlast Mini', 150, 59.90,
     (SELECT id FROM category WHERE name = 'Electronics'));

INSERT INTO product (id, description, name, available_quantity, price, category_id)
VALUES
    (nextval('product_seq'), 'Air fryer 5L capacity', 'AirCook Master', 70, 149.99,
     (SELECT id FROM category WHERE name = 'Home & Kitchen')),
    (nextval('product_seq'), 'Electric kettle stainless steel', 'HotBoil Kettle', 120, 29.95,
     (SELECT id FROM category WHERE name = 'Home & Kitchen')),
    (nextval('product_seq'), 'Memory foam pillows set of 2', 'DreamSleep Duo', 100, 45.50,
     (SELECT id FROM category WHERE name = 'Home & Kitchen'));


INSERT INTO product (id, description, name, available_quantity, price, category_id)
VALUES
    (nextval('product_seq'), 'Science fiction adventure novel', 'Galactic Odyssey', 260, 19.99,
     (SELECT id FROM category WHERE name = 'Books')),
    (nextval('product_seq'), 'History of ancient civilizations', 'Empires of Old', 100, 29.99,
     (SELECT id FROM category WHERE name = 'Books')),
    (nextval('product_seq'), 'Comprehensive cookbook for beginners', 'Kitchen Basics 101', 150, 18.49,
     (SELECT id FROM category WHERE name = 'Books'));


INSERT INTO product (id, description, name, available_quantity, price, category_id)
VALUES
    (nextval('product_seq'), 'Men''s cotton t-shirt', 'Classic Tee', 300, 12.99,
     (SELECT id FROM category WHERE name = 'Fashion')),
    (nextval('product_seq'), 'Women''s denim jacket', 'Denim Breeze', 80, 49.99,
     (SELECT id FROM category WHERE name = 'Fashion')),
    (nextval('product_seq'), 'Unisex sports hoodie', 'HoodFlex', 120, 34.95,
     (SELECT id FROM category WHERE name = 'Fashion'));
