LOAD DATA LOCAL INFILE 'src/main/resources/db/data/user.csv'
INTO TABLE user
FIELDS TERMINATED BY ',' 
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS
(grade, id, address, name);