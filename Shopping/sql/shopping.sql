CREATE TABLE BOOK_MEMBER(
  memberId VARCHAR2(50),
  memberPw VARCHAR2(100) NOT NULL,
  memberName VARCHAR2(30) NOT NULL,
  memberMail VARCHAR2(100) NOT NULL,
  memberAddr1 VARCHAR2(100) NOT NULL,
  memberAddr2 VARCHAR2(100) NOT NULL,
  memberAddr3 VARCHAR2(100) NOT NULL,
  adminCk NUMBER NOT NULL,
  regDate DATE NOT NULL,
  money number NOT NULL,
  point number NOT NULL,
  PRIMARY KEY(memberId)
);
commit;

-- ȸ������ ����
insert into book_member
values('admin23', 'admin','admin','admin','admin','admin','admin',1,sysdate,1000000,1000000);

commit;

select * from book_member;

update book_member set adminck = 1 where memberid='lbi5320';

commit;


-- ���� ���̺� ����
create table vam_nation(
   nationId varchar2(2) primary key,
    nationName varchar2(50)
);
 
-- ���� ���̺� ������ ����
insert into vam_nation values ('01', '����');
insert into vam_nation values ('02', '����');
 
-- �۰� ���̺� ����
create table vam_author(
    authorId number generated as identity (start with 1) primary key,
    authorName varchar2(50),
    nationId varchar2(2),
    authorIntro long,
    foreign key (nationId) references vam_nation(nationId)
);

commit;

insert into vam_author(authorName, nationId, authorIntro) values('��ȫ��', '01', '�۰� �Ұ��Դϴ�' );
insert into vam_author(authorName, nationId, authorIntro) values('�賭��', '01', '�۰� �Ұ��Դϴ�' );
insert into vam_author(authorName, nationId, authorIntro) values('��ũ��׸�', '02', '�۰� �Ұ��Դϴ�' );

-- oracle ���
commit;

select * from vam_author;

