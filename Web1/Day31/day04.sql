TRUNCATE TABLE "USER";

DROP SEQUENCE USER_SEQ;

CREATE SEQUENCE USER_SEQ
INCREMENT BY 1
START WITH 2
MINVALUE 1
MAXVALUE 1000;

SELECT * FROM "USER";