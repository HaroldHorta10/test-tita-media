drop database test;
create database test;
use test;

CREATE TABLE bank
(
    id   int NOT NULL auto_increment,
    code varchar(100) unique ,
    name varchar(100),
    CONSTRAINT PK_id PRIMARY KEY CLUSTERED (id)
);
insert into bank (code, name) value ('001', 'BankOpita');
insert into bank (code, name) value ('002', 'BankJuarez');

CREATE TABLE client
(
    document_type   varchar(100),
    document_number varchar(20),
    name            varchar(100),
    CONSTRAINT PK_document_number PRIMARY KEY CLUSTERED (document_number)
);

insert into client (document_type, document_number, name) value ('CC', '1234', 'Pepito');
insert into client (document_type, document_number, name) value ('CC', '9874', 'Juan');


CREATE TABLE credit
(
    code               varchar(100),
    balance_total      decimal,
    credit_fee         int,
    financial_interest decimal,
    value_fee          decimal,
    CONSTRAINT PK_id_credit PRIMARY KEY CLUSTERED (code)
);
insert into credit (balance_total, credit_fee, financial_interest, value_fee, code) values (100000, 5, 10, 22000, 1);
select *
from credit;
CREATE TABLE client_bank_credit
(
    id              int auto_increment primary key not null,
    document_number varchar(20)                    NOT NULL,
    id_bank         int                            NOT NULL,
    id_credit       varchar(100)                   not null,
    CONSTRAINT FK_document_number_id_bank FOREIGN KEY (document_number) REFERENCES client (document_number),
    CONSTRAINT FK_id_bank FOREIGN KEY (id_bank) REFERENCES bank (id),
    CONSTRAINT FK_id_credit FOREIGN KEY (id_credit) REFERENCES credit (code)
);

insert into client_bank_credit (document_number, id_bank, id_credit) values ('1234', 1, 1);

CREATE TABLE movement
(
    id         int NOT NULL auto_increment,
    balance    decimal,
    credit_id  varchar(100),
    credit_fee int,
    CONSTRAINT PK_id_movement PRIMARY KEY CLUSTERED (id),
    CONSTRAINT FK_credit_id_movement FOREIGN KEY (credit_id) REFERENCES credit (code)
);

create or replace view all_credit as
select b.id               as id,
       b.name             as name_bank,
       b.code             as code_bank,
       c.code             as credit_code,
       cl.document_number as document_number
from credit c
         JOIN client_bank_credit cbc on c.code = cbc.id_credit
         JOIN bank b on b.id = cbc.id_bank
         join client cl on cbc.document_number = cl.document_number;

create or replace view all_movement as
select m.id               as id,
       m.balance          as balance,
       m.credit_fee       as fee,
       cl.document_number as document_number,
       c.code             as code,
       b.code             as code_bank,
       b.name             as name_bank
from movement m
         left join credit c
                   on c.code = m.credit_id
         left join client_bank_credit cbc on c.code = cbc.id_credit
         left join bank b on b.id = cbc.id_bank
         left join client cl on cbc.document_number = cl.document_number;

