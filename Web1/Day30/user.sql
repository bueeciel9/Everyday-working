SELECT * FROM "USER";

--������ �ʱ�ȭ
--(1)
--DROP, CREATE
DROP SEQUENCE USER_SEQ;

CREATE SEQUENCE USER_SEQ
INCREMENT BY 1
START WITH 2
MINVALUE 1
MAXVALUE 1000;

--(2)
--ALTER SEQUENCE �������� INCREMENT BY -������ ��;
--SELECT ��������.NEXTVAL FROM DUAL;
--ALTER SEQUENCE �������� INCREMENT BY 1;
INSERT INTO "USER"
(USER_NUMBER, ID, PW, NAME, AGE, PHONE_NUMBER)
VALUES(1, 'hds1234', '1234', '�ѵ���', 20, '01012341234');

TRUNCATE TABLE "USER";

SELECT * FROM "USER";