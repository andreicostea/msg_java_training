-- drop tables

drop table roles_permissions;
drop table users_roles;
drop table comments;
drop table notifications;
drop table bugs;
drop table users;
drop table roles;
drop table permissions;

-- create tables
CREATE TABLE `users` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `counter` int(11) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `mobile_number` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`ID`)
);


CREATE TABLE `roles` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;



CREATE TABLE `users_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FK_users_roles_role_id` (`role_id`),
  CONSTRAINT `FK_users_roles_role_id` FOREIGN KEY (`role_id`) REFERENCES `roles` (`ID`),
  CONSTRAINT `FK_users_roles_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `permissions` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;


CREATE TABLE `roles_permissions` (
  `role_id` bigint(20) NOT NULL,
  `permission_id` bigint(20) NOT NULL,
  PRIMARY KEY (`role_id`,`permission_id`),
  KEY `FK_roles_permissions_permission_id` (`permission_id`),
  CONSTRAINT `FK_roles_permissions_permission_id` FOREIGN KEY (`permission_id`) REFERENCES `permissions` (`ID`),
  CONSTRAINT `FK_roles_permissions_role_id` FOREIGN KEY (`role_id`) REFERENCES `roles` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `notifications` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=latin1;


CREATE TABLE `bugs` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `version` varchar(255) DEFAULT NULL,
  `targetDate` datetime DEFAULT NULL,
  `status` varchar(255) NOT NULL,
  `fixedVersion` varchar(255) DEFAULT NULL,
  `severity` varchar(255) NOT NULL,
  `CREATED_ID` bigint(20) NOT NULL,
  `ASSIGNED_ID` bigint(20) DEFAULT '0',
  PRIMARY KEY (`ID`),
  KEY ` FK_bugs_CREATED_ID_idx` (`CREATED_ID`),
  KEY `FK_bugs_ASSIGNED_ID_idx` (`ASSIGNED_ID`),
  CONSTRAINT ` FK_bugs_CREATED_ID` FOREIGN KEY (`CREATED_ID`) REFERENCES `users` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_bugs_ASSIGNED_ID` FOREIGN KEY (`ASSIGNED_ID`) REFERENCES `users` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=latin1;


CREATE TABLE `comments` (
  `text` varchar(1000) NOT NULL,
  `date` datetime NOT NULL,
  `ID` bigint(20) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `bug_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_comments_user_id_idx` (`user_id`),
  KEY `FK_comments_bug_id_idx` (`bug_id`),
  CONSTRAINT `FK_comments_bug_id` FOREIGN KEY (`bug_id`) REFERENCES `bugs` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_comments_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `attachments` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `attContent` varchar(255) NOT NULL,
  `id_bug` bigint(20) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_attachments_id_bug` (`id_bug`),
  CONSTRAINT `FK_attachments_id_bug` FOREIGN KEY (`id_bug`) REFERENCES `bugs` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- insert data

INSERT INTO users (ID, counter, email, first_name, last_name, mobile_number, password, username)
VALUES (1, 0, 'admin@admin.com', 'Viorica', 'Administrator', '0700000000', 'admin', 'admin');
INSERT INTO users (ID, counter, email, first_name, last_name, mobile_number, password, username)
VALUES (5, 0, 'pm@pm.com', 'Serban', 'Manager', '0700000000', 'pm', 'pm');
INSERT INTO users (ID, counter, email, first_name, last_name, mobile_number, password, username)
VALUES (6, 0, 'tm@tm.com', 'Mihai', 'TestManager', '0700000000', 'tm', 'tm');
INSERT INTO users (ID, counter, email, first_name, last_name, mobile_number, password, username)
VALUES (7, 0, 'dev@dev.com', 'Andreea', 'Developer', '0700000000', 'dev', 'dev');
INSERT INTO users (ID, counter, email, first_name, last_name, mobile_number, password, username)
VALUES (8, 0, 'tst@tst.com', 'Gheorghe', 'Tester', '0700000000', 'tester', 'tester');

INSERT INTO roles (ID, type)
VALUES (1, 'ADMINISTRATOR');
INSERT INTO roles (ID, type)
VALUES (2, 'PROJECT MANAGER');
INSERT INTO roles (ID, type)
VALUES (3, 'TEST MANAGER');
INSERT INTO roles (ID, type)
VALUES (4, 'DEVELOPER');
INSERT INTO roles (ID, type)
VALUES (5, 'TESTER');

INSERT INTO users_roles (user_id, role_id)
VALUES (1, 1);
INSERT INTO users_roles (user_id, role_id)
VALUES (5, 2);
INSERT INTO users_roles (user_id, role_id)
VALUES (6, 3);
INSERT INTO users_roles (user_id, role_id)
VALUES (7, 4);
INSERT INTO users_roles (user_id, role_id)
VALUES (8, 5);

INSERT INTO permissions (ID, description, type)
VALUES (1, 'CRUD on permissions', 'PERMISSION_MANAGEMENT');
INSERT INTO permissions (ID, description, type)
VALUES (2, 'CRUD on users', 'USER_MANAGEMENT');
INSERT INTO permissions (ID, description, type)
VALUES (3, 'CRUD on bugs', 'BUG_MANAGEMENT');

INSERT INTO roles_permissions (role_id, permission_id)
VALUES (1, 1);
INSERT INTO roles_permissions (role_id, permission_id)
VALUES (1, 2);
INSERT INTO roles_permissions (role_id, permission_id)
VALUES (2, 2);
INSERT INTO roles_permissions (role_id, permission_id)
VALUES (2, 3);

INSERT INTO bugs(title, description, version, targetDate, status, fixedVersion, severity, CREATED_ID, ASSIGNED_ID)
VALUES ('bug1', 'description1', 'v1.2', '2019-05-30 20:13:55', 'NEW', 'v7.2', 'low', 1, 5)
