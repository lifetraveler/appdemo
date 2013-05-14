insert into sm_user select * from csvread('classpath:/csv/sm_user.csv',null,'charset=GBK');
insert into sm_menu select * from csvread('classpath:/csv/sm_menu.csv',null,'charset=GBK');
insert into sm_role select * from csvread('classpath:/csv/sm_role.csv',null,'charset=GBK');
insert into sm_standard_code select * from csvread('classpath:/csv/sm_standard_code.csv',null,'charset=GBK');
insert into sm_menu_permission select * from csvread('classpath:/csv/sm_menu_permission.csv',null,'charset=GBK');

/**
 * act module
 */
insert into ACT_CNSZRRSZ select * from csvread('classpath:/csv/act/act_cnszrrsz.csv',null,'charset=GBK');
insert into ACT_CNSZRRSX select * from csvread('classpath:/csv/act/act_cnszrrsx.csv',null,'charset=GBK');
insert into ACT_CNSZRXCB select * from csvread('classpath:/csv/act/act_cnszrxcb.csv',null,'charset=GBK');

insert into act_upload_param select * from csvread('classpath:/csv/act/act_upload_param.csv',null,'charset=GBK');

commit;