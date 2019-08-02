create table t_json_template
(
   id                   varchar(32) not null,
   template_id          varchar(32) not null,
   template_name        varchar(32),
   entitie_id           varchar(32),
   template_version     varchar(32),
   template_content     varchar(1024),
   c_uid                varchar(32),
   c_time               datetime,
   e_uid                varchar(32),
   e_time               datetime,
   description               varchar(64),
   primary key (id)
);

drop table if exists t_config;

/*==============================================================*/
/* Table: t_config                                              */
/*==============================================================*/
create table t_config
(
   id                   varchar(32) not null,
   `key`                  varchar(64),
   value                varchar(128),
   c_uid                varchar(32),
   c_time               datetime,
   e_uid                varchar(32),
   e_time               datetime,
   description               varchar(64),
   primary key (id),
   unique(`key`)
);
drop table if exists t_dict_relation;

/*==============================================================*/
/* Table: t_dict_relation                                       */
/*==============================================================*/
create table t_dict_relation
(
   id                   varchar(32) not null,
   en_relation_name     varchar(32),
   cn_relation_name     varchar(32),
   parent_id            varchar(32),
   tags                 varchar(32),
   level                int(11),
   c_uid                varchar(32),
   c_time               datetime,
   e_uid                varchar(32),
   e_time               datetime,
   description               varchar(64),
   primary key (id),
   unique(en_relation_name)
);

drop table if exists t_relation;

/*==============================================================*/
/* Table: t_relation                                            */
/*==============================================================*/
create table t_relation
(
   id                   varchar(32) not null,
   template_id          varchar(32),
   en_relation_name     varchar(32),
   cn_relation_name     varchar(32),
   parent_id            varchar(32),
   s_entity_id          varchar(32),
   t_entity_id          varchar(32),
   s_entity_name        varchar(32),
   t_entity_name        varchar(32),
   c_uid                varchar(32),
   c_time               datetime,
   e_uid                varchar(32),
   e_time               datetime,
   description               varchar(64),
   primary key (id)
);

alter table t_relation add constraint FK_Reference_2 foreign key (template_id)
      references t_template (id) on delete restrict on update restrict;
drop table if exists t_entity;

/*==============================================================*/
/* Table: t_entity                                              */
/*==============================================================*/
create table t_entity
(
   id                   varchar(32) not null,
   template_id          varchar(32),
   en_entitie_name      varchar(32),
   cn_entitie_name      varchar(32),
   tags                 varchar(32),
   parent_id            varchar(32),
   level                int(11),
   c_uid                varchar(32),
   c_time               datetime,
   e_uid                varchar(32),
   e_time               datetime,
   description               varchar(64),
   primary key (id),
   unique(en_entitie_name)
);

alter table t_entity add constraint FK_Reference_1 foreign key (template_id)
      references t_template (id) on delete restrict on update restrict;
drop table if exists t_attribute;

/*==============================================================*/
/* Table: t_attribute                                           */
/*==============================================================*/
create table t_attribute
(
   id                   varchar(32) not null,
   template_id          varchar(32),
   entity_id            varchar(32),
   en_attribute_name    varchar(32),
   cn_attribute_name    varchar(32),
   entity_name          varchar(32),
   c_uid                varchar(32),
   c_time               datetime,
   e_uid                varchar(32),
   e_time               datetime,
   description               varchar(64),
   primary key (id)
);

alter table t_attribute add constraint FK_Reference_3 foreign key (template_id)
      references t_template (id) on delete restrict on update restrict;

alter table t_attribute add constraint FK_Reference_6 foreign key (entity_id)
      references t_entity (id) on delete restrict on update restrict;
drop table if exists t_transform;

/*==============================================================*/
/* Table: t_transform                                           */
/*==============================================================*/
create table t_transform
(
   id                   varchar(32) not null,
   template_id          varchar(32) not null,
   source_name          varchar(32),
   ann_name             varchar(32),
   json_name            varchar(32),
   status               varchar(32),
   mark_uid             varchar(32),
   type                 varchar(32),
   c_uid                varchar(32),
   c_time               datetime,
   e_uid                varchar(32),
   e_time               datetime,
   description               varchar(64),
   primary key (id),

);

alter table t_transform add constraint FK_Reference_5 foreign key (template_id)
      references t_template (id) on delete restrict on update restrict;
drop table if exists t_dict_attribute;

/*==============================================================*/
/* Table: t_dict_attribute                                      */
/*==============================================================*/
create table t_dict_attribute
(
   id                   varchar(32) not null,
   en_attribute_name    varchar(32),
   cn_attribute_name    varchar(32),
   attribute_type       tinyint,
   en_attribute_value   varchar(32),
   cn_attribute_value   varchar(32),
   tags                 varchar(32),
   c_uid                varchar(32),
   c_time               datetime,
   e_uid                varchar(32),
   e_time               datetime,
   description               varchar(64),
   primary key (id),
   unique(en_attribute_name)
);
drop table if exists t_template;

/*==============================================================*/
/* Table: t_template                                            */
/*==============================================================*/
create table t_template
(
   id                   varchar(32) not null,
   template_name        varchar(64),
   template_version     varchar(32),
   file_path            varchar(128),
   deploy_path          varchar(128),
   status               tinyint,
   c_uid                varchar(32),
   c_time               datetime,
   e_uid                varchar(32),
   e_time               datetime,
   description               varchar(64),
   primary key (id),
   unique(template_name,template_version);
);

drop table if exists t_user;

/*==============================================================*/
/* Table: t_user                                                */
/*==============================================================*/
create table t_user
(
   id                   varchar(32) not null,
   username             varchar(32),
   password             varchar(32),
   mobile               varchar(32),
   email                varchar(64),
   Token                varchar(32),
   login_time           datetime,
   c_uid                varchar(32),
   c_time               datetime,
   e_uid                varchar(32),
   e_time               datetime,
   description               varchar(64),
   primary key (id)
);
alter table t_user add unique uniq_username (username);