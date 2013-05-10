insert into sm_user select * from csvread('classpath:/csv/sm_user.csv',null,'charset=GBK');
insert into sm_menu select * from csvread('classpath:/csv/sm_menu.csv',null,'charset=GBK');
insert into sm_role select * from csvread('classpath:/csv/sm_role.csv',null,'charset=GBK');
insert into sm_standard_code select * from csvread('classpath:/csv/sm_standard_code.csv',null,'charset=GBK');
insert into sm_menu_permission select * from csvread('classpath:/csv/sm_menu_permission.csv',null,'charset=GBK');

insert into in_1_1 select * from csvread('classpath:/csv/in_1_1.csv',null,'charset=GBK');
insert into in_2_2_1 select * from csvread('classpath:/csv/in_2_2_1.csv',null,'charset=GBK');

insert into out_1_1 select * from csvread('classpath:/csv/out_1_1.csv',null,'charset=GBK');
commit;