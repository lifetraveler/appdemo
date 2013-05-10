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




drop table if exists in_1_1;
drop table if exists in_2_2_1;
drop table if exists out_1_1;
CREATE TABLE in_1_1(
c1 INT,
c2 NUMERIC(20,2),
c3 VARCHAR(20),
c4 VARCHAR(20),
c5 VARCHAR(20),
c6 VARCHAR(20),
c7 VARCHAR(20),
c8 VARCHAR(20),
c9 VARCHAR(20),
c10 VARCHAR(20),
c11 VARCHAR(20),
c12 VARCHAR(20),
c13 VARCHAR(20),
c14 VARCHAR(20),
c15 VARCHAR(20)
);

CREATE TABLE in_2_2_1(
c0 INT,
c1 VARCHAR(50),
c2 NUMERIC(20,2),
c3 NUMERIC(20,2),
c4 NUMERIC(20,2),
c5 NUMERIC(20,2),
c6 NUMERIC(20,2),
c7 NUMERIC(20,2),
c8 NUMERIC(20,2),
loc_id VARCHAR(20),
year VARCHAR(4)
);

CREATE TABLE out_1_1(
c1 INT,
c2 NUMERIC(20,2),
c3 NUMERIC(20,2),
c4 NUMERIC(20,2),
c5 NUMERIC(20,2),
c6 NUMERIC(20,2),
c7 NUMERIC(20,2),
c8 NUMERIC(20,2),
c9 NUMERIC(20,2),
c10 NUMERIC(20,2),
loc_id VARCHAR(20)
);


