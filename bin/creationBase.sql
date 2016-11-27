create database gestionAccount;

CREATE TABLE user 
(   id BIGINT PRIMARY KEY,  
 first_name VARCHAR(255),  
 last_name VARCHAR(255),  
 email VARCHAR(255)    );

CREATE TABLE account
(   id BIGINT PRIMARY KEY,
   id_u BIGINT,  
 name VARCHAR(255), 
  FOREIGN KEY fk_user(id_u) REFERENCES user(id) );



INSERT INTO user VALUES 
(1,'yousra','elghzizal','y@hot.fr'),  
(2,'fanny','dibou','f@hot.fr'),  
(3,'jack','david','j@hot.fr');


INSERT INTO account VALUES 
(1,2,'account1'),
 (2,3,'account2'),
 (3,2,'account3'), 
(4,2,'account4'), 
(5,1,'account5');

<!-- les requetes SQL utilisées en JOOQ--> 

SELECT * FROM user;

SELECT * FROM user WHERE id=1;

SELECT * FROM account  WHERE name LIKE 'acc%';

SELECT name FROM account  WHERE id_u IS NOT NULL;

SELECT u.first_name,a.id,a.name FROM user u,account a  WHERE u.id=a.id_u










