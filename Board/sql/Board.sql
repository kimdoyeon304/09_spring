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
