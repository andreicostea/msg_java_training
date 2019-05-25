-- drop tables

drop table roles_permissions;
drop table users_roles;
drop table attachments;
drop table comments;
drop table notifications;
drop table bugs;
drop table users;
drop table roles;
drop table permissions;


-- create tables

create table users
(
	ID bigint auto_increment primary key,
	counter int,
	email varchar(255) not null,
	first_name varchar(255) not null,
	last_name varchar(255) not null,
	mobile_number varchar(255) not null,
	password varchar(255) not null,
	username varchar(255) not null,
	status boolean not null default true
);


create table roles
(
	ID bigint auto_increment primary key,
	type varchar(255) not null
);


create table users_roles
(
	user_id bigint not null,
	role_id bigint not null,
	primary key (user_id, role_id),
	constraint FK_users_roles_role_id
		foreign key (role_id) references roles (ID),
	constraint FK_users_roles_user_id
		foreign key (user_id) references users (ID)
);


create table permissions
(
	ID bigint auto_increment primary key,
	description varchar(255) not null,
	type varchar(255) not null
)
;

create table roles_permissions
(
	role_id bigint not null,
	permission_id bigint not null,
	primary key (role_id, permission_id),
	constraint FK_roles_permissions_permission_id
		foreign key (permission_id) references permissions (ID),
	constraint FK_roles_permissions_role_id
		foreign key (role_id) references roles (ID)
);


create table notifications
(
	ID bigint auto_increment primary key,
	date datetime not null,
	message varchar(255) not null,
	type varchar(255) not null,
	url varchar(255) not null,
	user_id bigint not null
);


create table bugs
(
    ID bigint auto_increment primary key,
    title varchar(255) not null,
    description varchar(255) not null,
    version varchar(255),
    targetDate datetime,
    status varchar(255) not null,
    fixedVersion varchar(255),
    severity varchar(255) not null,
    user_id bigint not null,
    createdBy bigint not null,
    assignedBy bigint not null,
    constraint FK_bugs_createdBy
        foreign key (createdBy) references users (ID),
    constraint FK_bugs_assignedBy
        foreign key (assignedBy) references users (ID)
);


create table comments
(
    user_id bigint not null,
    bugs_id bigint not null,
    primary key (user_id, bugs_id),
    constraint FK_comments_user_id
        foreign key (user_id) references users (ID),
    constraint FK_comments_bugs_id
        foreign key (bugs_id) references bugs (ID),
    text varchar(1000) not null,
    date datetime not null
);


create table attachments
(
    ID bigint auto_increment primary key,
    attContent varchar(255) not null,
    id_bug bigint not null,
    constraint FK_attachments_id_bug
        foreign key (id_bug) references bugs (ID)

);
<-- ADD STATUS TO USER -->

ALTER TABLE msg_training.users
ADD status BOOLEAN NOT NULL DEFAULT 1;
ALTER TABLE msg_training.permission
ADD status BOOLEAN NOT NULL DEFAULT 1;

-- insert data

INSERT INTO users (ID, counter, email, first_name, last_name, mobile_number, password, username) VALUES (1, 0, 'admin@admin.com', 'Viorica', 'Administrator', '0700000000', 'admin', 'admin');
INSERT INTO users (ID, counter, email, first_name, last_name, mobile_number, password, username) VALUES (5, 0, 'pm@pm.com', 'Serban', 'Manager', '0700000000', 'pm', 'pm');
INSERT INTO users (ID, counter, email, first_name, last_name, mobile_number, password, username) VALUES (6, 0, 'tm@tm.com', 'Mihai', 'TestManager', '0700000000', 'tm', 'tm');
INSERT INTO users (ID, counter, email, first_name, last_name, mobile_number, password, username) VALUES (7, 0, 'dev@dev.com', 'Andreea', 'Developer', '0700000000', 'dev', 'dev');
INSERT INTO users (ID, counter, email, first_name, last_name, mobile_number, password, username) VALUES (8, 0, 'tst@tst.com', 'Gheorghe', 'Tester', '0700000000', 'tester', 'tester');

INSERT INTO roles (ID, type) VALUES (1, 'ADMINISTRATOR');
INSERT INTO roles (ID, type) VALUES (2, 'PROJECT MANAGER');
INSERT INTO roles (ID, type) VALUES (3, 'TEST MANAGER');
INSERT INTO roles (ID, type) VALUES (4, 'DEVELOPER');
INSERT INTO roles (ID, type) VALUES (5, 'TESTER');

INSERT INTO users_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO users_roles (user_id, role_id) VALUES (5, 2);
INSERT INTO users_roles (user_id, role_id) VALUES (6, 3);
INSERT INTO users_roles (user_id, role_id) VALUES (7, 4);
INSERT INTO users_roles (user_id, role_id) VALUES (8, 5);

INSERT INTO permissions (ID, description, type) VALUES (1, 'Can modify role assignment.', 'PERMISSION_MANAGEMENT');
INSERT INTO permissions (ID, description, type) VALUES (2, 'Can modify users.', 'USER_MANAGEMENT');
INSERT INTO permissions (ID, description, type) VALUES (3, 'Can modify bugs.', 'BUG_MANAGEMENT');

INSERT INTO roles_permissions (role_id, permission_id) VALUES (1, 1);
INSERT INTO roles_permissions (role_id, permission_id) VALUES (1, 2);
INSERT INTO roles_permissions (role_id, permission_id) VALUES (2, 2);
INSERT INTO roles_permissions (role_id, permission_id) VALUES (2, 3);
