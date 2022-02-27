CREATE DATABASE  aws_db;
USE aws_db;


CREATE TABLE s3info (
  id int NOT NULL AUTO_INCREMENT,
  key_id varchar(50),
  last_modified date,
  e_tag varchar(50),
  size long,
  owner_id varchar(100),
  display_name varchar(50),
  storage_class varchar(50),
  PRIMARY KEY (id)
);

