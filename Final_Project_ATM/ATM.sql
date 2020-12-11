
create table user_info(
id varchar2(20) ,
password varchar2(20),
name varchar2(20) ,
account number(20)) ,
constraint user_id_pk primary key(account)
);

create table transaction(
account number(20)
CONSTRAINT tran_account_fk REFERENCES user_info(account),
balance NUMBER(10) ,
t_info varchar2(20),
t_date date
); 

insert into transaction
values(12345678,10000,'10000입금',sysdate)
