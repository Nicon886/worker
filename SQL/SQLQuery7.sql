--�Ӱ����ڲ��ظ�������
GO 
CREATE TRIGGER insert_jiaban ON jiaban
INSTEAD OF INSERT
AS 

	IF EXISTS ( SELECT * FROM INSERTED WHERE INSERTED.dday IN(SELECT jiaban.dday FROM jiaban WHERE jiaban.id=INSERTED.id))
		ROLLBACK TRANSACTION
	ELSE
		BEGIN	
		INSERT INTO jiaban SELECT id,stime,endtime,sumtime,dday FROM INSERTED
		PRINT 'GOOD'
		END
