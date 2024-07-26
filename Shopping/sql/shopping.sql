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

-- 회원가입 쿼리
insert into book_member
values('admin23', 'admin','admin','admin','admin','admin','admin',1,sysdate,1000000,1000000);

commit;

select * from book_member;

update book_member set adminck = 1 where memberid='lbi5320';

commit;


-- 국가 테이블 생성
create table vam_nation(
   nationId varchar2(2) primary key,
    nationName varchar2(50)
);
 
-- 국가 테이블 데이터 삽입
insert into vam_nation values ('01', '국내');
insert into vam_nation values ('02', '국외');
 
-- 작가 테이블 생성
create table vam_author(
    authorId number generated as identity (start with 1) primary key,
    authorName varchar2(50),
    nationId varchar2(2),
    authorIntro long,
    foreign key (nationId) references vam_nation(nationId)
);

commit;

insert into vam_author(authorName, nationId, authorIntro) values('유홍준', '01', '작가 소개입니다' );
insert into vam_author(authorName, nationId, authorIntro) values('김난도', '01', '작가 소개입니다' );
insert into vam_author(authorName, nationId, authorIntro) values('폴크루그먼', '02', '작가 소개입니다' );

-- oracle 경우
commit;

select * from vam_author;

