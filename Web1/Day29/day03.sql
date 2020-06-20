--DML(DELETE, UPDATE) �ǽ�

--PLAYER ���̺��� TEAM_ID�� 'K01'�� ���� �̸��� �� �̸����� �ٲٱ�
UPDATE PLAYER
SET PLAYER_NAME = '�ѵ���'
WHERE TEAM_ID = 'K01';

SELECT * FROM PLAYER
WHERE TEAM_ID = 'K01';
--ROLLBACK

--PLAYER ���̺��� POSITION�� 'MF'�� ���� �����ϱ�
DELETE FROM PLAYER
WHERE "POSITION" = 'MF';

SELECT * FROM PLAYER
WHERE "POSITION" = 'MF';
--ROLLBACK

--PLAYER ���̺��� HEIGHT�� 180�̻��� ���� �����ϱ�
DELETE FROM PLAYER
WHERE HEIGHT >= 180;

SELECT * FROM PLAYER
WHERE HEIGHT >= 180;
--ROLLBACK

--AS(ALIAS) : ��Ī
--SELECT �� : ��Ī�� AS �ڿ� ���ų�, ���鹮�� �ڿ� ����.
--FROM �� : ���鹮�� �ڿ� ����.

SELECT PLAYER_ID AS "���� ��ȣ", PLAYER_NAME �̸� FROM PLAYER;

--PLAYER���̺��� �����̸���, TEAM���̺��� �ּҸ� �˻�
SELECT P.TEAM_ID, P.PLAYER_NAME, T.ADDRESS 
FROM PLAYER P, TEAM T;

--STADIUM���̺��� ADDRESS��, TEAM���̺��� TEL �˻�
SELECT S.ADDRESS AS "����� �ּ�", T.TEL ��ȭ��ȣ
FROM STADIUM S , TEAM T;

--NULL
--���ǵ��� ���� ��
--�� �� ��� �������� �ο��� �� ���(PK�� �Ұ���, FK�� ����)
--NVL	: NULL�� ��� �ٸ� ������ ���� �� �˻�
--NVL2	: NULL�� ���� ��, NULL�� �ƴ� ���� �� 2������ ���� 

SELECT NVL(NICKNAME, '���� ����') AS ���� FROM PLAYER;

--PLAYER���̺��� NATION�� NULL�̸� �̵��
--NULL�� �ƴϸ� ������� ���� �� �����̸�, ���� �˻�
--AS�� ���� ��� ���η� �ֱ�
--NVL2(�÷���, NULL�� �ƴ� ��, NULL�� ��)
SELECT PLAYER_NAME, NVL2(NATION, '���', '�̵��') "���� ��� ����"
FROM PLAYER;

SELECT NICKNAME FROM PLAYER;
-------------------------------------------
--USER���̺��� �ִٸ� DROP�ϱ�
DROP TABLE "USER";
--USER_SEQ �����
--1���� ����, 1�� ����, 1000����
DROP SEQUENCE USER_SEQ;

CREATE SEQUENCE USER_SEQ
INCREMENT BY 1
START WITH 1
MINVALUE 1
MAXVALUE 1000;

--USER���̺� �����
--USER_NUMBER NUMBER NOT NULL
--ID VC2(20)
--PW VC2(20),
--NAME VC2(20),
--AGE NUMBER,
--PHONE_NUMBER VC2(11),
--PK�� ID�÷��� �ο�
CREATE TABLE "USER"(
	USER_NUMBER NUMBER NOT NULL,
	ID VARCHAR2(20),
	PW VARCHAR2(20),
	NAME VARCHAR2(20),
	AGE NUMBER,
	PHONE_NUMBER VARCHAR2(11),
	CONSTRAINT USER_PK PRIMARY KEY(ID)
);

SELECT * FROM "USER";

SELECT COUNT(*) FROM "USER"
WHERE ID = 'hds9638';

INSERT INTO "USER"
(USER_NUMBER, ID, PW, NAME, AGE, PHONE_NUMBER)
VALUES(USER_SEQ.NEXTVAL, 'hds1204', '1234', '�ѵ���', 20, '01012341234');

SELECT * FROM "USER";

TRUNCATE TABLE "USER"; 




















