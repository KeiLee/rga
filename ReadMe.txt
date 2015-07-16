
- This project is implemented in Spring MVC + Maven + Hibernate + MySQL(local) + Tomcat(local)
- This project was created by Eclipse IDE  
 
=== MySQL table structure ====
create table USER (
    id bigint not null auto_increment,
    name varchar(255),
	email varchar(255),
	password varchar(255),
	usertype varchar(40),
    primary key (id)
);

create table CUSTOMER (
    id bigint not null,
    phone varchar(255),
	address varchar(255),
    primary key (id)
);

create table SYSTEMUSER (
    id bigint not null,
    title varchar(255),
	level varchar(255),
    primary key (id)
);

alter table CUSTOMER
    add constraint id
    foreign key (id)
    references USER (id);

alter table SYSTEMUSER
    add constraint sysid
    foreign key (id)
    references USER (id);