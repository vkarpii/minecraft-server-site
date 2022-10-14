DROP USER 'hbserver'@'localhost';
CREATE USER 'hbserver'@'localhost' IDENTIFIED BY 'NhduD2Yda5X2mt5mVJQV';
GRANT ALL PRIVILEGES ON hb_minecraft_server.* TO 'hbserver'@'localhost';
FLUSH PRIVILEGES;