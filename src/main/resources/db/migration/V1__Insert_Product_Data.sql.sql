LOAD DATA LOCAL INFILE 'src/main/resources/db/data/product.csv'
INTO TABLE product
FIELDS TERMINATED BY ',' 
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS
(price, id, name);