DROP USER if exists 'admin'@'localhost';
DROP USER if exists 'admin'@'%';

CREATE USER 'admin'@'localhost' identified BY 'admin';
CREATE USER 'admin'@'%' identified BY 'admin';

GRANT ALL privileges ON * . * TO 'admin'@'localhost';
GRANT ALL privileges ON * . * TO 'admin'@'%';