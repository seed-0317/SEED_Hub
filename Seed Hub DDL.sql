CREATE TABLE seedhub.roles (
  r_id    serial PRIMARY KEY ,
  r_role  varchar(20) not null UNIQUE,
  admin_FLAG boolean not null
);

CREATE TABLE seedhub.stages (
  s_id  serial PRIMARY KEY ,
  s_stage varchar(20) not null unique
);

CREATE TABLE seedhub.users (
  u_id    serial PRIMARY KEY ,
  eid     varchar(6) UNIQUE ,
  email   varchar(30),
  fname varchar(30),
  lname  varchar(30),
  role_id   integer references seedhub.roles(r_id),
  stage_id  integer references seedhub.stages(s_id)
);

CREATE TABLE seedhub.status_hist (
  sh_id serial PRIMARY KEY ,
  u_id INTEGER references seedhub.users(u_id) not null,
  old_s INTEGER references seedhub.stages(s_id) not null,
  new_s INTEGER references seedhub.stages(s_id) not null,
  change_ts timestamp NOT NULL
);

CREATE TABLE seedhub.seedclass (
  c_id           SERIAL PRIMARY KEY,
  c_yr           INTEGER NOT NULL,
  c_num          INTEGER NOT NULL,
  c_loc          VARCHAR(30),
  c_app_open_dt  TIMESTAMP,
  c_app_deadline TIMESTAMP,
  c_bootcamp_dt  TIMESTAMP
);

create table seedhub.rating_types (
  rt_id    SERIAL PRIMARY KEY,
  rt_desc  VARCHAR(100),
  rt_scale INTEGER,
  rt_txt_flag boolean
);

create table seedhub.questions (
  q_id  serial PRIMARY KEY ,
  c_id  INTEGER references seedhub.seedclass(c_id),
  q_seq integer not null,
  q_text varchar(100) not null,
  rating_type  integer references seedhub.rating_types(rt_id)
);

alter table seedhub.questions add column q_type varchar(20);

create table seedhub.interview (
  int_id  serial PRIMARY KEY ,
  class_id integer references seedhub.seedclass(c_id),
  applicant_id  integer references seedhub.users(u_id) not null,
  interviewer_id  INTEGER REFERENCES seedhub.users(u_id) not null,
  interview_dt  TIMESTAMP
);

alter table seedhub.interview add column int_type varchar(20);

create table seedhub.interview_ratings (
  rat_id  serial PRIMARY KEY ,
  int_id integer references seedhub.interview(int_id),
  q_id integer references seedhub.questions(q_id) not null,
  rating INTEGER,
  comments varchar(200)
);


create table seedhub.application (
   app_id serial primary key
  ,u_id integer  references seedhub.users(u_id) not null
  ,mgr_id integer references seedhub.users(u_id) not null
  ,c_id integer references seedhub.seedclass(c_id) not null
  ,dept Varchar(30)
  ,techskills_languages Varchar(500)
  ,education  Varchar(500)
  ,tech_orgs  Varchar(500)
  ,seed_success  Varchar(1000)
  ,comments Varchar(1000)
);

alter table seedhub.application add column curr_role varchar(30);
alter table seedhub.application add column curr_level varchar(30);
alter table seedhub.application add column strong_plus boolean;
alter table seedhub.application add column mgr_approval boolean;

insert into seedhub.roles (r_role, admin_flag) values ('Applicant', FALSE );
insert into seedhub.roles (r_role,  admin_flag) values ('Manager', FALSE );
insert into seedhub.roles (r_role, admin_flag) values ('Program Team', TRUE);
insert into seedhub.roles (r_role, admin_flag) values ('Interviewer', FALSE);

insert into seedhub.stages (s_stage) values('Registered');
insert into seedhub.stages (s_stage) values('Applied');
insert into seedhub.stages (s_stage) values('Job Fitted');
insert into seedhub.stages (s_stage) values('Tech Screened');
insert into seedhub.stages (s_stage) values('Approved');
insert into seedhub.stages (s_stage) values('Not Approved');
insert into seedhub.stages (s_stage) values('Withdrawn');
insert into seedhub.stages (s_stage) values('Accepted');
insert into seedhub.stages (s_stage) values('Pre Boot Camp');
insert into seedhub.stages (s_stage) values('Boot Camp');
insert into seedhub.stages (s_stage) values('Tech Team');
insert into seedhub.stages (s_stage) values('Alumni');

insert into seedhub.users(eid,email,fname,lname,role_id) values
  ('QZH225', 'steve.morris2@capitalone.com', 'Steve', 'Morris', 3);

insert into seedhub.users(eid,email,fname,lname,role_id) values
  ('xyz123', 'steve.morris1@capitalone.com', 'Steve', 'Morris', 4);

insert into seedhub.rating_types (rt_desc, rt_scale, rt_txt_flag) VALUES
  ('Text only', 0, TRUE);
insert into seedhub.rating_types (rt_desc, rt_scale, rt_txt_flag) VALUES
  ('4 point scale with text', 4, TRUE);
insert into seedhub.rating_types (rt_desc, rt_scale, rt_txt_flag) VALUES
  ('4 point scale', 4, FALSE);
insert into seedhub.rating_types (rt_desc, rt_scale, rt_txt_flag) VALUES
  ('2 point scale', 2, FALSE);
insert into seedhub.rating_types (rt_desc, rt_scale, rt_txt_flag) VALUES
  ('2 point scale with text', 2, TRUE);

insert into seedhub.seedclass (c_yr, c_num, c_loc, c_app_open_dt, c_app_deadline, c_bootcamp_dt) VALUES
  (2016, 1, 'Richmond', '2016-04-01', '2016-05-01', '2016-06-01');

insert into questions (c_id, q_seq, q_text, rating_type, q_type) values
  (1,1,'Applicant Name', 1,'Test');