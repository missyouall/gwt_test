--------------------------------------------------
-- Export file for user PMS@192.168.219.45/ORCL --
-- Created by admin on 2018/5/30, 14:43:14 -------
--------------------------------------------------

set define off
spool rr.log

prompt
prompt Creating table TEST_STU
prompt =======================
prompt
create table PMS.TEST_STU
(
  id   NUMBER(20) not null,
  name VARCHAR2(20) not null,
  sex  NUMBER(8) not null,
  age  NUMBER(10) default 20
)
tablespace FRAMEWORK_DATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table PMS.TEST_STU
  add primary key (ID)
  using index 
  tablespace FRAMEWORK_DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );


spool off
