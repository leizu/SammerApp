alter database last default character set utf8;
drop table if exists user cascade;
CREATE TABLE user (
  user_name VARCHAR(45) NULL,
  password VARCHAR(45) NULL,
  prefecture_id INT(45) NULL,
  token VARCHAR(45) NULL,
  PRIMARY KEY (user_name));

insert into user(user_name,password,prefecture_id,token) value ('したえ','test','10','fsiejhfu');