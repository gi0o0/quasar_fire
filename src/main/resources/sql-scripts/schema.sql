CREATE TABLE quasar.SATELITE (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name varchar(25) DEFAULT NULL,
  distance decimal DEFAULT NULL,
  message varchar(255) DEFAULT NULL,
  coordinatex decimal DEFAULT NULL,
  coordinatey decimal DEFAULT NULL,
  PRIMARY KEY (id)
);