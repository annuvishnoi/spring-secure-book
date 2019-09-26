create table anurag.users(
	username varchar(50) not null primary key,
	password varchar(100) not null,
	enabled boolean not null
);
create table anurag.authorities (
	username varchar(50) not null,
	authority varchar(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username)
);
create unique index ix_auth_username on authorities (username,authority);

  
INSERT INTO users(username,password,enabled)
VALUES ('mkyong','$2a$10$GVao8i13Hddh2RHYCKAExexOU/g010V3wsn/CXCi4ZGkP95idxGsW', true);
INSERT INTO users(username,password,enabled)
VALUES ('alex','$2a$10$GVao8i13Hddh2RHYCKAExexOU/g010V3wsn/CXCi4ZGkP95idxGsW', true);
INSERT INTO users(username,password,enabled)
VALUES ('test','$2a$10$GVao8i13Hddh2RHYCKAExexOU/g010V3wsn/CXCi4ZGkP95idxGsW', true);



INSERT INTO authorities (username, authority)
VALUES ('test', 'EMPLOYEE');
INSERT INTO authorities (username, authority)
VALUES ('alex', 'ADMIN');
INSERT INTO authorities (username, authority)
VALUES ('mkyong', 'MANAGER');

