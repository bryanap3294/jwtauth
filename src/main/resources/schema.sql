CREATE TABLE IF NOT EXISTS USER (
  USERNAME VARCHAR(20) NOT NULL PRIMARY KEY,
  PASSWORD VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS BOOK (
  ID INT NOT NULL PRIMARY KEY,
  NAME VARCHAR(20) NOT NULL,
  DESCRIPTION VARCHAR(30),
  AUTHOR VARCHAR(20)
);