
drop database if exists hb_minecraft_server;
create database hb_minecraft_server;
use hb_minecraft_server;

create table `user`
(
   user_id              int not null  comment '' AUTO_INCREMENT,
   perm_id             int not null  comment '',
   nickname             varchar(100) not null  comment '',
   `password`           varchar(100) not null  comment '',
   primary key (user_id)
);

create table opencase
(
   case_id             int not null  comment '',
   case_name           varchar(100) not null  comment '',
   case_description    varchar(300) not null  comment '',
   case_cost           int not null  comment '',
   primary key (case_id)
);

create table permission
(
   perm_id             int not null  comment '',
   perm_name           varchar(100) not null  comment '',
   perm_description    varchar(300) not null  comment '',
   perm_cost           int not null  comment '',
   primary key (perm_id)
);

create table news
(
   news_id             int not null  comment '' AUTO_INCREMENT,
   news_title          varchar(100) not null  comment '',
   news_text           varchar(300) not null  comment '',
   news_photo          varchar(100) not null  comment '',
   primary key (news_id)
);

create table `history`
(
   history_id           int not null  comment '' AUTO_INCREMENT,
   user_id              int not null  comment '' ,
   history_desc         varchar(300) not null  comment '',
   primary key (history_id)
);


alter table `user` add constraint FK_USER_US_RELATIONS_PERMISSION foreign key (user_id)
      references permission (perm_id) on delete restrict on update restrict;
alter table `history` add constraint FK_HISTORY_US_RELATIONS_USER foreign key (history_id)
      references `user` (user_id) on delete restrict on update restrict;

INSERT INTO hb_minecraft_server.permission (`perm_id`,`perm_name`, `perm_description`,`perm_cost`) VALUES ('1','Admin', 'Some desc','0');
INSERT INTO hb_minecraft_server.permission (`perm_id`,`perm_name`, `perm_description`,`perm_cost`) VALUES ('2','Premium', 'Some desc','200');
INSERT INTO hb_minecraft_server.permission (`perm_id`,`perm_name`, `perm_description`,`perm_cost`) VALUES ('3','Creative', 'Some desc','120');
INSERT INTO hb_minecraft_server.permission (`perm_id`,`perm_name`, `perm_description`,`perm_cost`) VALUES ('4','Vip', 'Some desc','80');
INSERT INTO hb_minecraft_server.permission (`perm_id`,`perm_name`, `perm_description`,`perm_cost`) VALUES ('5','Fly', 'Some desc','30');
INSERT INTO hb_minecraft_server.permission (`perm_id`,`perm_name`, `perm_description`,`perm_cost`) VALUES ('6','Standart', 'Some desc','0');

INSERT INTO hb_minecraft_server.opencase (`case_id`,`case_name`, `case_description`,`case_cost`) VALUES ('1','God case', 'Some desc','0');
INSERT INTO hb_minecraft_server.opencase (`case_id`,`case_name`, `case_description`,`case_cost`) VALUES ('2','Pro case', 'Some desc','0');
INSERT INTO hb_minecraft_server.opencase (`case_id`,`case_name`, `case_description`,`case_cost`) VALUES ('3','Warrior case', 'Some desc','0');
INSERT INTO hb_minecraft_server.opencase (`case_id`,`case_name`, `case_description`,`case_cost`) VALUES ('4','Noob case', 'Some desc','0');

INSERT INTO hb_minecraft_server.`user` (`user_id`,`perm_id`, `nickname`,`password`) VALUES ('1','1', 'Vetalya_Pupkin','12345');
INSERT INTO hb_minecraft_server.`user` (`user_id`,`perm_id`, `nickname`,`password`) VALUES ('2','1', 'OptimusPrrime69','Doritte123');

