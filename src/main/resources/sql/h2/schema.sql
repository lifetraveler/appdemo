drop table if exists sm_user;

create table sm_user (
	username varchar(64) ,
	password varchar(64),
	realname varchar(100),
	salt varchar(64),
	status varchar(1),
	location varchar(10),
	primary key (username)
);

drop table if exists sm_role;

create table sm_role(
	role_id varchar(20),
	role_desc varchar(200),
	primary key(role_id)
);

drop table if exists sm_menu;

create table sm_menu(
	menu_id varchar(20),
	menu_desc varchar(200),
	parent_id	varchar(20),
	menu_order INT,
	menu_url	varchar(100),
	primary key(menu_id)
);

drop table if exists sm_permissions;

create table sm_permissions(
permission varchar(100),
primary key(permission)
);

drop table if exists sm_standard_code;

CREATE TABLE sm_standard_code(
code_name VARCHAR(50),
code_type VARCHAR(50),
code_value VARCHAR(50),
code_order INT,
primary key (code_name,code_type)
);

drop table if exists sm_menu_permission;
create table sm_menu_permission(
menu_id varchar(20),
permission varchar(100)
);


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
primary key(menu_id)
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


