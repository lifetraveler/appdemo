--
--drop table if exists sm_user;
--
--create table sm_user (
--	username varchar(64) ,
--	password varchar(64),
--	realname varchar(100),
--	salt varchar(64),
--	status varchar(1),
--	location varchar(10),
--	home_branch varchar(20),
--	primary key (username)
--);
--
--drop table if exists sm_role;
--
--create table sm_role(
--	role_id varchar(20),
--	role_desc varchar(200),
--	primary key(role_id)
--);
--
--drop table if exists sm_user_role;
--
--create table sm_user_role(
--	username varchar(20),
--	role_id varchar(200),
--	branch_code varchar(10),
--	primary key(username,role_id,branch_code)
--);
--
--
--
drop table if exists sm_menu;

create table sm_menu(
	menu_id varchar(20),
	menu_desc varchar(200),
	parent_id	varchar(20),
	menu_order INT,
	menu_url	varchar(100),
	primary key(menu_id)
);
--
--drop table if exists sm_branch;
--
--create table sm_branch(
--	branch_code varchar(20),
--	branch_name varchar(200),
--	parent_branch varchar(20),
--	branch_order INT,
--	primary key(branch_code)
--);
--
--
--drop table if exists sm_permissions;
--
--create table sm_permissions(
--permission varchar(100),
--primary key(permission)
--);
--
--drop table if exists sm_standard_code;
--
--CREATE TABLE sm_standard_code(
--code_name VARCHAR(50),
--code_type VARCHAR(50),
--code_value VARCHAR(50),
--code_order INT,
--primary key (code_name,code_type)
--);
--
--drop table if exists sm_menu_permission;
--create table sm_menu_permission(
--menu_id varchar(20),
--permission varchar(100)
--);
--
--drop table if exists sm_role_menu_permission;
--
--create table sm_role_menu_permission(
--role_id varchar(20),
--menu_id varchar(20),
--permission varchar(100),
--primary key(role_id,menu_id,permission)
--);
--


/**
 * WorkFlow Moudle
 */

--drop table siwc_person exists;
--create table siwc_person 
--(
--   ID                   bigint   not null,
--   PROCESS_INSTANCE_ID  VARCHAR2(64),
--   person_id              VARCHAR2(20)           not null,
--   person_name           VARCHAR2(200),            
--   constraint PK_SIWC_PERSON primary key (ID)
--);


/**
 * Act Moudle
 */


drop table if exists act_upload_param;

create table act_upload_param(
menu_id	varchar(50),
template_path varchar(100),
work_book varchar(100),
sheet_name	varchar(100),
row_start int,
row_end int,
col_start int,
col_end int,
row_year int,
col_year int,
row_check char(1),
primary key(menu_id)
);



drop table if exists ACT_CWSJHGJJ;

CREATE TABLE ACT_CWSJHGJJ(
year INT,
c2 DECIMAL(20,2),
c3 DECIMAL(20,2),
c4 DECIMAL(20,2),
c5 DECIMAL(20,2),
c6 DECIMAL(20,2),
c7 DECIMAL(20,2),
c8 DECIMAL(20,2),
c9 DECIMAL(20,2),
c10 DECIMAL(20,2),
c11 DECIMAL(20,2),
c12 DECIMAL(20,2),
c13 DECIMAL(20,2),
c14 DECIMAL(20,2),
c15 DECIMAL(20,2),
location VARCHAR(20),
primary key(year,location)
);


drop table if exists ACT_CWSJRKSJ;

CREATE TABLE ACT_CWSJRKSJ(
year INT,
c2 INT,
c3 INT,
c4 INT,
c5 INT,
c6 INT,
c7 INT,
c8 INT,
c9 INT,
c10 INT,
c11 INT,
c12 DECIMAL(20,2),
c13 DECIMAL(20,2),
c14 DECIMAL(20,2),
location VARCHAR(20),
primary key(year,location)
);


drop table if exists ACT_CWSJLDJY;

CREATE TABLE ACT_CWSJLDJY(
year INT,
c2 INT,
c3 DECIMAL(20,2),
c4 INT,
c5 INT,
c6 INT,
c7 INT,
c8 INT,
c9 INT,
c10 INT,
c11 INT,
c12 INT,
c13 INT,
c14 INT,
c15 INT,
c16 INT,
location VARCHAR(20),
primary key(year,location)
);


drop table if exists ACT_CWSJSRGZ;

CREATE TABLE ACT_CWSJSRGZ(
year INT,
c2 DECIMAL(20,2),
c3 DECIMAL(20,2),
c4 DECIMAL(20,2),
c5 DECIMAL(20,2),
c6 DECIMAL(20,2),
c7 DECIMAL(20,2),
c8 DECIMAL(20,2),
c9 DECIMAL(20,2),
c10 DECIMAL(20,2),
c11 DECIMAL(20,2),
c12 DECIMAL(20,2),
c13 DECIMAL(20,2),
c14 DECIMAL(20,2),
c15 DECIMAL(20,2),
c16 DECIMAL(20,2),
c17 DECIMAL(20,2),
location VARCHAR(20),
primary key(year,location)
);

drop table if exists ACT_CNSZRRSZ;

CREATE TABLE ACT_CNSZRRSZ(
c1 VARCHAR(50),
c2 INT,
c3 INT,
c4 INT,
c5 INT,
c6 INT,
c7 INT,
c8 INT,
location VARCHAR(20),
year	INT,
c0	INT,
primary key(c1,location,year)
);

drop table if exists ACT_CNSZRRSX;

CREATE TABLE ACT_CNSZRRSX(
c1 VARCHAR(50),
c2 INT,
c3 INT,
c4 INT,
c5 INT,
c6 INT,
c7 INT,
c8 INT,
location VARCHAR(20),
year	INT,
c0	INT,
primary key(c1,location,year)
);

drop table if exists ACT_CNSZRXCB;

CREATE TABLE ACT_CNSZRXCB(
c1 VARCHAR(50),
c2 INT,
c3 INT,
c4 INT,
c5 INT,
c6 INT,
c7 INT,
c8 INT,
location VARCHAR(20),
year	INT,
c0	INT,
primary key(c1,location,year)
);

drop table if exists ACT_CNSZJJSQ;

CREATE TABLE ACT_CNSZJJSQ(
c1 VARCHAR(50),
c2 DECIMAL(20,2),
c3 DECIMAL(20,2),
c4 DECIMAL(20,2),
c5 DECIMAL(20,2),
c6 DECIMAL(20,2),
c7 DECIMAL(20,2),
c8 DECIMAL(20,2),
location VARCHAR(20),
year	INT,
c0	INT,
primary key(c1,location,year)
);

drop table if exists ACT_CNSZJZSZ;

CREATE TABLE ACT_CNSZJZSZ(
c1 VARCHAR(50),
c2 DECIMAL(20,2),
c3 DECIMAL(20,2),
c4 DECIMAL(20,2),
c5 DECIMAL(20,2),
c6 DECIMAL(20,2),
c7 DECIMAL(20,2),
c8 DECIMAL(20,2),
location VARCHAR(20),
year	INT,
c0	INT,
primary key(c1,location,year)
);

drop table if exists ACT_CNSZJZSX;

CREATE TABLE ACT_CNSZJZSX(
c1 VARCHAR(50),
c2 DECIMAL(20,2),
c3 DECIMAL(20,2),
c4 DECIMAL(20,2),
c5 DECIMAL(20,2),
c6 DECIMAL(20,2),
c7 DECIMAL(20,2),
c8 DECIMAL(20,2),
location VARCHAR(20),
year	INT,
c0	INT,
primary key(c1,location,year)
);


drop table if exists ACT_CNSZJNXZ;

CREATE TABLE ACT_CNSZJNXZ(
c1 VARCHAR(50),
c2 INT,
c3 INT,
c4 INT,
c5 INT,
c6 INT,
c7 INT,
c8 INT,
location VARCHAR(20),
year	INT,
c0	INT,
primary key(c1,location,year)
);

drop table if exists ACT_CNSZJNXX;

CREATE TABLE ACT_CNSZJNXX(
c1 VARCHAR(50),
c2 INT,
c3 INT,
c4 INT,
c5 INT,
c6 INT,
c7 INT,
c8 INT,
location VARCHAR(20),
year	INT,
c0	INT,
primary key(c1,location,year)
);


drop table if exists ACT_CNSZZKZZ;

CREATE TABLE ACT_CNSZZKZZ(
c1 VARCHAR(50),
c2 DECIMAL(20,2),
c3 DECIMAL(20,2),
c4 DECIMAL(20,2),
c5 DECIMAL(20,2),
c6 DECIMAL(20,2),
c7 DECIMAL(20,2),
c8 DECIMAL(20,2),
location VARCHAR(20),
year	INT,
c0	INT,
primary key(c1,location,year)
);

drop table if exists ACT_CNSZZKZX;

CREATE TABLE ACT_CNSZZKZX(
c1 VARCHAR(50),
c2 DECIMAL(20,2),
c3 DECIMAL(20,2),
c4 DECIMAL(20,2),
c5 DECIMAL(20,2),
c6 DECIMAL(20,2),
c7 DECIMAL(20,2),
c8 DECIMAL(20,2),
location VARCHAR(20),
year	INT,
c0	INT,
primary key(c1,location,year)
);

drop table if exists ACT_CNSZZSZZ;

CREATE TABLE ACT_CNSZZSZZ(
c1 VARCHAR(50),
c2 DECIMAL(20,2),
c3 DECIMAL(20,2),
c4 DECIMAL(20,2),
c5 DECIMAL(20,2),
c6 DECIMAL(20,2),
c7 DECIMAL(20,2),
c8 DECIMAL(20,2),
location VARCHAR(20),
year	INT,
c0	INT,
primary key(c1,location,year)
);

drop table if exists ACT_CNSZZSZX;

CREATE TABLE ACT_CNSZZSZX(
c1 VARCHAR(50),
c2 DECIMAL(20,2),
c3 DECIMAL(20,2),
c4 DECIMAL(20,2),
c5 DECIMAL(20,2),
c6 DECIMAL(20,2),
c7 DECIMAL(20,2),
c8 DECIMAL(20,2),
location VARCHAR(20),
year	INT,
c0	INT,
primary key(c1,location,year)
);


drop table if exists ACT_CNSTRNMQ;

CREATE TABLE ACT_CNSTRNMQ(
c1 VARCHAR(50),
c2 INT,
c3 INT,
c4 INT,
c5 INT,
c6 INT,
c7 INT,
c8 INT,
location VARCHAR(20),
year	INT,
c0	INT,
primary key(c1,location,year)
);

drop table if exists ACT_CNSTRNXQ;

CREATE TABLE ACT_CNSTRNXQ(
c1 VARCHAR(50),
c2 INT,
c3 INT,
c4 INT,
c5 INT,
c6 INT,
c7 INT,
c8 INT,
location VARCHAR(20),
year	INT,
c0	INT,
primary key(c1,location,year)
);

drop table if exists ACT_CNSTYYPJ;

CREATE TABLE ACT_CNSTYYPJ(
c1 VARCHAR(50),
c2 DECIMAL(20,2),
c3 DECIMAL(20,2),
c4 DECIMAL(20,2),
c5 DECIMAL(20,2),
c6 DECIMAL(20,2),
c7 DECIMAL(20,2),
c8 DECIMAL(20,2),
location VARCHAR(20),
year	INT,
c0	INT,
primary key(c1,location,year)
);

drop table if exists ACT_CNSTYYGP;

CREATE TABLE ACT_CNSTYYGP(
c1 VARCHAR(50),
c2 DECIMAL(20,2),
c3 DECIMAL(20,2),
c4 DECIMAL(20,2),
c5 DECIMAL(20,2),
c6 DECIMAL(20,2),
c7 DECIMAL(20,2),
c8 DECIMAL(20,2),
location VARCHAR(20),
year	INT,
c0	INT,
primary key(c1,location,year)
);

drop table if exists ACT_CNSTYXYP;

CREATE TABLE ACT_CNSTYXYP(
c1 VARCHAR(50),
c2 DECIMAL(20,2),
c3 DECIMAL(20,2),
c4 DECIMAL(20,2),
c5 DECIMAL(20,2),
c6 DECIMAL(20,2),
c7 DECIMAL(20,2),
c8 DECIMAL(20,2),
location VARCHAR(20),
year	INT,
c0	INT,
primary key(c1,location,year)
);

drop table if exists ACT_CNSTZSZQ;

CREATE TABLE ACT_CNSTZSZQ(
c1 VARCHAR(50),
c2 DECIMAL(20,2),
c3 DECIMAL(20,2),
c4 DECIMAL(20,2),
c5 DECIMAL(20,2),
c6 DECIMAL(20,2),
c7 DECIMAL(20,2),
c8 DECIMAL(20,2),
location VARCHAR(20),
year	INT,
c0	INT,
primary key(c1,location,year)
);

drop table if exists ACT_CNSTZKZQ;

CREATE TABLE ACT_CNSTZKZQ(
c1 VARCHAR(50),
c2 DECIMAL(20,2),
c3 DECIMAL(20,2),
c4 DECIMAL(20,2),
c5 DECIMAL(20,2),
c6 DECIMAL(20,2),
c7 DECIMAL(20,2),
c8 DECIMAL(20,2),
location VARCHAR(20),
year	INT,
c0	INT,
primary key(c1,location,year)
);

drop table if exists ACT_YCRQQSRK;

CREATE TABLE ACT_YCRQQSRK(
c1 INT,
c2 INT,
c3 INT,
c4 INT,
c5 INT,
location VARCHAR(20),
c0	INT,
primary key(c1,location)
);

--PENSION

drop table if exists ACT_CNNSDDYQ;

CREATE TABLE ACT_CNNSDDYQ(
c1 varchar(20),
c2 DECIMAL(20,0),
c3 DECIMAL(20,0),
c4 DECIMAL(20,2),
c5 DECIMAL(20,0),
c6 DECIMAL(20,0),
c7 DECIMAL(20,2),
c8 DECIMAL(20,2),
c9 DECIMAL(20,2),
c10 DECIMAL(20,2),
c11 DECIMAL(20,2),
c12 DECIMAL(20,2),
c13 DECIMAL(20,2),
location VARCHAR(20),
year INT,
c0	INT,
primary key(year,location)
);

drop table if exists ACT_CNNSDJYQ;

CREATE TABLE ACT_CNNSDJYQ(
c1 varchar(20),
c2 DECIMAL(20,0),
c3 DECIMAL(20,0),
c4 DECIMAL(20,2),
c5 DECIMAL(20,0),
c6 DECIMAL(20,0),
c7 DECIMAL(20,2),
c8 DECIMAL(20,2),
c9 DECIMAL(20,2),
c10 DECIMAL(20,2),
c11 DECIMAL(20,2),
c12 DECIMAL(20,2),
c13 DECIMAL(20,2),
location VARCHAR(20),
year INT,
c0	INT,
primary key(year,location)
);

drop table if exists ACT_CNNSDQYQ;

CREATE TABLE ACT_CNNSDQYQ(
c1 varchar(20),
c2 DECIMAL(20,0),
c3 DECIMAL(20,0),
c4 DECIMAL(20,2),
c5 DECIMAL(20,0),
c6 DECIMAL(20,0),
c7 DECIMAL(20,2),
c8 DECIMAL(20,2),
c9 DECIMAL(20,2),
c10 DECIMAL(20,2),
c11 DECIMAL(20,2),
c12 DECIMAL(20,2),
c13 DECIMAL(20,2),
location VARCHAR(20),
year INT,
c0	INT,
primary key(year,location)
);

drop table if exists ACT_CNNSDQYZ;

CREATE TABLE ACT_CNNSDQYZ(
c1 varchar(20),
c2 DECIMAL(20,0),
c3 DECIMAL(20,0),
c4 DECIMAL(20,2),
c5 DECIMAL(20,0),
c6 DECIMAL(20,0),
c7 DECIMAL(20,2),
c8 DECIMAL(20,2),
c9 DECIMAL(20,2),
c10 DECIMAL(20,2),
c11 DECIMAL(20,2),
c12 DECIMAL(20,2),
c13 DECIMAL(20,2),
location VARCHAR(20),
year INT,
c0	INT,
primary key(year,location)
);

drop table if exists ACT_CNNSDQQY;

CREATE TABLE ACT_CNNSDQQY(
c1 varchar(20),
c2 DECIMAL(20,0),
c3 DECIMAL(20,0),
c4 DECIMAL(20,2),
c5 DECIMAL(20,0),
c6 DECIMAL(20,0),
c7 DECIMAL(20,2),
c8 DECIMAL(20,2),
c9 DECIMAL(20,2),
c10 DECIMAL(20,2),
c11 DECIMAL(20,2),
c12 DECIMAL(20,2),
c13 DECIMAL(20,2),
location VARCHAR(20),
year INT,
c0	INT,
primary key(year,location)
);

drop table if exists ACT_CNNSDYCQ;

CREATE TABLE ACT_CNNSDYCQ(
c1 varchar(20),
c2 DECIMAL(20,0),
c3 DECIMAL(20,0),
c4 DECIMAL(20,0),
c5 DECIMAL(20,2),
c6 DECIMAL(20,0),
c7 DECIMAL(20,0),
c8 DECIMAL(20,0),
c9 DECIMAL(20,2),
c10 DECIMAL(20,0),
c11 DECIMAL(20,0),
c12 DECIMAL(20,0),
c13 DECIMAL(20,2),
c14 DECIMAL(20,0),
c15 DECIMAL(20,0),
c16 DECIMAL(20,0),
c17 DECIMAL(20,2),
location VARCHAR(20),
year INT,
c0	INT,
primary key(year,location)
);

drop table if exists ACT_CNNSDYCN;

CREATE TABLE ACT_CNNSDYCN(
c1 varchar(20),
c2 DECIMAL(20,0),
c3 DECIMAL(20,0),
c4 DECIMAL(20,0),
c5 DECIMAL(20,2),
location VARCHAR(20),
year INT,
c0	INT,
primary key(year,location)
);

drop table if exists ACT_CNNSDYJQ;

CREATE TABLE ACT_CNNSDYJQ(
c1 varchar(20),
c2 DECIMAL(20,0),
c3 DECIMAL(20,2),
c4 DECIMAL(20,0),
c5 DECIMAL(20,2),
c6 DECIMAL(20,0),
c7 DECIMAL(20,2),
c8 DECIMAL(20,0),
c9 DECIMAL(20,2),
c10 DECIMAL(20,0),
c11 DECIMAL(20,2),
c12 DECIMAL(20,0),
c13 DECIMAL(20,2),
c14 DECIMAL(20,0),
c15 DECIMAL(20,2),
c16 DECIMAL(20,0),
c17 DECIMAL(20,2),
location VARCHAR(20),
year INT,
c0	INT,
primary key(year,location)
);

drop table if exists ACT_CNNSDYTQ;

CREATE TABLE ACT_CNNSDYTQ(
c1 varchar(20),
c2 DECIMAL(20,0),
c3 DECIMAL(20,0),
c4 DECIMAL(20,0),
c5 DECIMAL(20,2),
c6 DECIMAL(20,0),
c7 DECIMAL(20,0),
c8 DECIMAL(20,0),
c9 DECIMAL(20,2),
c10 DECIMAL(20,0),
c11 DECIMAL(20,0),
c12 DECIMAL(20,0),
c13 DECIMAL(20,2),
c14 DECIMAL(20,0),
c15 DECIMAL(20,0),
c16 DECIMAL(20,0),
c17 DECIMAL(20,2),
location VARCHAR(20),
year INT,
c0	INT,
primary key(year,location)
);

drop table if exists ACT_CNNSDYLQ;

CREATE TABLE ACT_CNNSDYLQ(
c1 varchar(20),
c2 DECIMAL(20,0),
c3 DECIMAL(20,0),
c4 DECIMAL(20,0),
c5 DECIMAL(20,2),
c6 DECIMAL(20,2),
c7 DECIMAL(20,2),
c8 DECIMAL(20,0),
c9 DECIMAL(20,0),
c10 DECIMAL(20,0),
c11 DECIMAL(20,2),
c12 DECIMAL(20,2),
c13 DECIMAL(20,2),
location VARCHAR(20),
year INT,
c0	INT,
primary key(year,location)
);

drop table if exists ACT_CNNSDYSQ;

CREATE TABLE ACT_CNNSDYSQ(
c1 varchar(20),
c2 DECIMAL(20,0),
c3 DECIMAL(20,0),
c4 DECIMAL(20,0),
c5 DECIMAL(20,0),
c6 DECIMAL(20,0),
c7 DECIMAL(20,0),
c8 DECIMAL(20,2),
c9 DECIMAL(20,2),
c10 DECIMAL(20,2),
c11 DECIMAL(20,0),
c12 DECIMAL(20,0),
c13 DECIMAL(20,0),
c14 DECIMAL(20,0),
c15 DECIMAL(20,0),
c16 DECIMAL(20,0),
c17 DECIMAL(20,0),
c18 DECIMAL(20,0),
c19 DECIMAL(20,0),
c20 DECIMAL(20,2),
c21 DECIMAL(20,2),
c22 DECIMAL(20,2),
c23 DECIMAL(20,0),
c24 DECIMAL(20,0),
c25 DECIMAL(20,0),
location VARCHAR(20),
year INT,
c0	INT,
primary key(year,location)
);





































