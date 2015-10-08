drop Database bankDatabase;

create Database bankDatabase;

use bankDatabase;

create table account (id int primary key auto_increment, firstName varchar(20), surName varchar (20), accountType int, balance int);

create table accountType (id int primary key auto_increment, accountName varchar(8), overdraft int, transactionFee int);  

alter table accountTable add constraint fk_accountType_id foreign key(accountType) references accountType (id); 

