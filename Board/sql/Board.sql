create table lbi_board(
bno number generated always as IDENTITY,
title varchar2(150) not null,
content varchar2(2000) not null,
writer varchar2(50) not null,
regdate date default sysdate,
updatedate date default sysdate,
CONSTRAINT pk_board PRIMARY KEY(bno)
);

insert into lbi_board(title, content, writer) values ('테스트 제목', '테스트 내용', '작가');

commit;

drop table lbi_board;
select * from lbi_board;

--재귀복사
insert into lbi_board(title,content,writer)(select title, content, writer from lbi_board);

--행 확인
select count(*) from lbi_board;

commit;

--Rownum방식1
select rn, bno, title, content, writer, regdate, updatedate from(
    select /*+INDEX_DESC(vam_board pk_board) */rownum as rn, bno, title, content, writer, regdate, updatedate
    from lbi_board)
    --select rownum as rownum as rn, bno, title, content, writer, regdate, updatedate from
    --vam_board order by bno desc
where rn between 11 and 20;
--rn>10 and rn <=20;

--Rownum방식2
select rn, bno, title, content, writer, regdate, updatedate from(
    select /*+INDEX_DESC(lbi_board pk_board) */rownum as rn, bno, title, content, writer, regdate, updatedate
    from lbi_board where rownum <= 20)
where rn > 10;
