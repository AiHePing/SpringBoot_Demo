create table DEPT
(
  deptno NUMBER(2) not null,
  dname  VARCHAR2(50),
  loc    VARCHAR2(50)
)

-- Add comments to the columns 
comment on column DEPT.deptno
  is '部门id';
comment on column DEPT.dname
  is '部门名称';
comment on column DEPT.loc
  is '地区';
  
  
insert into dept (DEPTNO, DNAME, LOC)
values (10, 'ACCOUNTING', 'NEW YORK');

insert into dept (DEPTNO, DNAME, LOC)
values (20, 'RESEARCH', 'DALLAS');

insert into dept (DEPTNO, DNAME, LOC)
values (30, 'SALES', 'CHICAGO');

insert into dept (DEPTNO, DNAME, LOC)
values (40, 'OPERATIONS', 'BOSTON');