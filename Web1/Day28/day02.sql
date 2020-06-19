/*
 * FLOWER ���̺� �����ϱ�
 * �÷��� : ID, NAME, AGE, COLOR
 * ID�� PK�� �����Ѵ�.
 * FLOWER���� FLOWER2�� ���̺�� ����
 * FLOWER2���� PRICE�÷� �߰�
 * INSERT�� �� �ֱ�(2���� ���� �ֱ�)
 * FLOWER2���̺� �� ����(TRUNCATE)
 * FLOWER2���̺� ��ü ����(DROP)
 */
CREATE TABLE FLOWER(
	ID VARCHAR2(10),
	NAME VARCHAR2(20),
	AGE NUMBER(2),
	COLOR VARCHAR2(10),
	CONSTRAINT FLOWER_PK PRIMARY KEY (ID)
);

SELECT * FROM FLOWER;

ALTER TABLE FLOWER RENAME TO FLOWER2;

SELECT * FROM FLOWER2;

ALTER TABLE FLOWER2 ADD PRICE NUMBER(8);

SELECT * FROM FLOWER2;

INSERT INTO FLOWER2
(ID, NAME, AGE, COLOR, PRICE)
VALUES('20200001', '���', 1, '������', 3500);

INSERT INTO FLOWER2
(ID, NAME, AGE, COLOR, PRICE)
VALUES('20200002', '�عٶ��', 2, '�����', 5500);

SELECT * FROM FLOWER2;

TRUNCATE TABLE FLOWER2;

DROP TABLE FLOWER2;
------------------------------------------------------------------
--������(Sequence)
--������ ���� �������ִ� ����Ŭ ��ü(�ڵ� �� �÷�)

CREATE SEQUENCE USER_SEQ
INCREMENT BY 1
START WITH 1
MINVALUE 1
MAXVALUE 1000;

--DROP SEQUENCE USER_SEQ
CREATE TABLE "USER"(
	USER_NUMBER NUMBER NOT NULL,
	ID VARCHAR2(20),
	PW VARCHAR2(20),
	NAME VARCHAR2(20),
	AGE NUMBER,
	PHONE_NUMBER VARCHAR2(11),
	CONSTRAINT USER_PK PRIMARY KEY (ID)
);

SELECT * FROM "USER";

INSERT INTO "USER"
(USER_NUMBER, ID, PW, NAME, AGE, PHONE_NUMBER)
VALUES(USER_SEQ.NEXTVAL, 'hds1234', '1234', '�ѵ���', 20, '01043825111');

SELECT * FROM "USER";
----------------------------------------------------------------------------------------
/*
 * PK
 * 		CONSTRAINT ���������̸� PRIMARY KEY(�÷���)
 * 
 * 		ALTER TABLE ���̺�� ADD CONSTRINT ���������̸� PRIMARY KEY(�÷���)
 * 
 * FK
 * 		CONSTARAINT ���������̸� FOREIGN KEY(�÷���)
 * 		REFERENCES �θ����̺��(�θ�PK�÷���)
 * 
 * 		ALTER TABLE ���̺�� ADD
 *		CONSTARAINT ���������̸� FOREIGN KEY(�÷���) 
 * 		REFERENCES �θ����̺��(�θ�PK�÷���)
 * 
 * �� �߰�
 * 		�θ����̺� ���� �� ���� �ڽ����̺�
 * 
 * �� ����
 * 		�ڽ����̺� ���� �� ���� �θ����̺�
 * 
 * ���̺��� ���踦 ������ ERD���� Ȯ���غ� �� �ִ�.
 * 
 * �� : �θ�
 * �� : �ڽ�
 */

/*
 * ���� / �ֿϰ�
 * 
 * OWNER			��			PET
 * ID(PK) VC2(20)			DOG_ID(PK) VC2(20)
 * --------------------------------------------------
 * NAME VC2(20)			NAME VC2(20)
 * AGE NUMBER(3)			OWNER_ID(FK) VC2(20)
 * ADDRESS VC2(30)		AGE NUMBER(2)
 * GENDER CHAR(1)		FEED VC2(20)
 * 									DISEASE VC2(30)
 */ 
DROP TABLE PET;

CREATE TABLE PET(
	DOG_ID VARCHAR2(20),
	NAME VARCHAR2(20),
	OWNER_ID VARCHAR2(20),
	AGE NUMBER(2),
	FEED VARCHAR2(20),
	DISEASE VARCHAR2(30),
	CONSTRAINT PET_PK PRIMARY KEY(DOG_ID),
	CONSTRAINT PET_FK FOREIGN KEY(OWNER_ID) 
	REFERENCES OWNER(ID)
);

SELECT * FROM PET;


CREATE TABLE OWNER(
	ID VARCHAR2(20),
	NAME VARCHAR2(20),
	AGE NUMBER(3),
	ADDRESS VARCHAR2(30),
	GENDER CHAR(1),
	CONSTRAINT OWNER_PK PRIMARY KEY(ID)
);
SELECT * FROM OWNER;

INSERT INTO OWNER
(ID, NAME, AGE, ADDRESS, GENDER)
VALUES('001204001', '�ѵ���', 20, '����� ���Ǳ� ��õ��', 'M');

SELECT * FROM OWNER;

INSERT INTO PET
(DOG_ID, NAME, OWNER_ID, AGE, FEED, DISEASE)
VALUES('190202001', '�ٵ���', '001204001', 2, '���', '��ħ����');

SELECT * FROM PET;

INSERT INTO PET
(DOG_ID, NAME, OWNER_ID, AGE, FEED, DISEASE)
VALUES('190202002', '������', '001204001', 2, '���', '����');

SELECT * FROM PET;

DROP TABLE PET;

DELETE FROM OWNER
WHERE ID='001204001';

SELECT * FROM OWNER;

DROP TABLE OWNER;

SELECT * FROM EMPLOYEES;
----------------------------------------------------------------
--�ɰ� ȭ��
CREATE TABLE FLOWER(
	NAME VARCHAR2(20),
	COLOR VARCHAR2(10),
	PRICE NUMBER(6),
	CONSTRAINT FLOWER_PK PRIMARY KEY (NAME)
);


CREATE TABLE POT(
	ID VARCHAR2(10),
	COLOR VARCHAR2(20),
	SHAPE VARCHAR2(20),
	NAME VARCHAR2(20),
	CONSTRAINT POT_PK PRIMARY KEY(ID),
	CONSTRAINT POT_FK FOREIGN KEY(NAME)
	REFERENCES FLOWER(NAME)
);

SELECT * FROM FLOWER;
SELECT * FROM POT;

INSERT INTO FLOWER
(NAME, COLOR, PRICE)
VALUES ('���', '������', 5000);

INSERT INTO FLOWER
(NAME, COLOR, PRICE)
VALUES ('�عٶ��', '�����', 7000);

INSERT INTO FLOWER
(NAME, COLOR, PRICE)
VALUES ('����ȭ', '��ȫ��', 10000);


SELECT * FROM FLOWER;

INSERT INTO POT
(ID, COLOR, SHAPE, NAME)
VALUES('200402001', '������', '������ü', '����ȭ');

INSERT INTO POT
(ID, COLOR, SHAPE, NAME)
VALUES('200402002', '�Ͼ��', '����', '����ȭ');

SELECT * FROM POT;

UPDATE POT
SET NAME = '�عٶ��'
WHERE NAME = '����ȭ';

DELETE FROM POT
WHERE NAME != '���';

SELECT * FROM POT;

TRUNCATE TABLE POT;

DROP TABLE POT;

DROP TABLE FLOWER;
----------------------------------------------------------
--�������� ��ȭ
CREATE TABLE PERSON(
	ID VARCHAR2(20),
	NAME VARCHAR2(20),
	AGE NUMBER(3),
	GENDER CHAR(1) DEFAULT 'M' NOT NULL CONSTRAINT CHECK_CHAR
	CHECK(GENDER = 'M' OR GENDER = 'W'),
	CONSTRAINT PERSON_PK PRIMARY KEY (ID)
);

INSERT INTO PERSON
(ID, NAME, AGE)
VALUES('001', '�ѵ���', 20);

SELECT * FROM PERSON;

INSERT INTO PERSON
(ID, NAME, AGE, GENDER)
VALUES('002', '�ϴ�', 20, 'W');

SELECT * FROM PERSON;
-----------------------------------------------------------
--�ǽ�
SELECT * FROM PLAYER;

--PLAYER ���̺��� TEAM_ID�� 'K01'�� ���� �˻�
SELECT * FROM PLAYER
WHERE TEAM_ID = 'K01';
--PLAYER ���̺��� TEAM_ID�� 'K01'�� �ƴ� ���� �˻�
SELECT * FROM PLAYER
WHERE TEAM_ID <> 'K01';
--PLAYER ���̺��� WEIGHT�� 70�̻��̰� 80������ ���� �˻�
SELECT * FROM PLAYER
WHERE WEIGHT >= 70 AND WEIGHT <= 80;

SELECT * FROM PLAYER
WHERE WEIGHT BETWEEN 70 AND 80;
--PLAYER���̺��� TEAM_ID�� 'K03'�̰� HEIGHT�� 180�̸��� ���� �˻�
SELECT * FROM PLAYER
WHERE TEAM_ID = 'K03' AND HEIGHT < 180;

--PLAYER���̺��� TEAM_ID�� 'K06'�̰� NICKNAME�� '����'�� ���� �˻�
SELECT * FROM PLAYER
WHERE TEAM_ID = 'K06' AND NICKNAME = '����';
--STADIUM���̺��� SEAT_COUNT�� 30000�ʰ��̰� 41000������ ����� �˻�
SELECT * FROM STADIUM
WHERE SEAT_COUNT > 30000 AND SEAT_COUNT <= 41000;
--PLAYER���̺��� TEAM_ID�� 'K02'�̰ų� 'K07'�̰� �������� 'MF'�� ���� �˻�
--WHERE ���������� OR���� AND�� �켱������ ����.
--OR�� �����ϱ� ���ؼ��� ��ȣ�� �����־�� �Ѵ�.
SELECT * FROM PLAYER
WHERE TEAM_ID = 'K02' OR TEAM_ID = 'K07' AND "POSITION" = 'MF';

SELECT * FROM PLAYER
WHERE (TEAM_ID = 'K02' OR TEAM_ID = 'K07') AND "POSITION" = 'MF';

SELECT * FROM PLAYER
WHERE TEAM_ID IN('K02', 'K07') AND "POSITION" = 'MF'
--ORDER BY TEAM_ID DESC;
--ORDER BY TEAM_ID;
ORDER BY 3;







































