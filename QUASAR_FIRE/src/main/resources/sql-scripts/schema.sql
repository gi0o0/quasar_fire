CREATE TABLE SATELITE (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name varchar(25) DEFAULT NULL,
  distance double DEFAULT NULL,
  message varchar(255) DEFAULT NULL,
  coordinatex double(20) DEFAULT NULL,
  coordinatey double(20) DEFAULT NULL,
  PRIMARY KEY (id)
);