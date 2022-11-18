connect 'jdbc:derby://localhost:1527/data/gc-production;create=true;user=gc;password=pwd1234';

drop table tasks;
drop table status;
drop table priority;
drop table users ;

create table users (
   user_id int not null UNIQUE,
   user_name varchar(25) not null UNIQUE,
   first_name varchar(25) not null,
   last_name varchar(25) not null    
 );   
    
create table priority (
   priority_code varchar(3) not null,
   description varchar(20),
   primary key (priority_code)
);


create table status (
   status_code varchar(3) not null,
   description varchar(20),
   primary key (status_code)
);

create table tasks (
   task_id int not null,
   user_id int not null,
   description varchar(50) not null,
   priority_code varchar(3) not null,
   status_code varchar(3) not null, 
   start_date varchar(10) not null,
   end_date varchar(10) not null,
   complete int not null,
   notes varchar(150),
   primary key (task_id),   
   FOREIGN KEY (user_id) REFERENCES users(user_id),
   FOREIGN KEY (priority_code) REFERENCES priority(priority_code),
   FOREIGN KEY (status_code) REFERENCES status(status_code)
   
);

---
---		The following code below was used to insert data into the 3 tables
---  	co.grandcircus.grandcircus.T1_InsertPriorities: run this class to insert data to priority table
---  	co.grandcircus.grandcircus.T2_InsertUsers: run this class to insert data to User table
---  	co.grandcircus.grandcircus.entity.Status: run this class to insert data to Status table
---

INSERT INTO tasks VALUES (100,1,'Project 1','P1','ns','2022.09.12','2022.09.19',78,'note 1');
INSERT INTO tasks VALUES (101,2,'Project 2','P2','ip','2022.09.11','2022.09.20',86,'note 2');
INSERT INTO tasks VALUES (102,3,'Project 3','P3','c','2022.09.10','2022.09.21',69,'note 3');
INSERT INTO tasks VALUES (103,4,'Project 4','P1','d','2022.09.09','2022.09.22',68,'note 4');
INSERT INTO tasks VALUES (104,5,'Project 5','P2','d','2022.09.08','2022.09.23',68,'note 5');
INSERT INTO tasks VALUES (105,6,'Project 6','P3','ns','2022.09.07','2022.09.24',62,'note 6');
INSERT INTO tasks VALUES (106,7,'Project 7','P1','ip','2022.09.06','2022.09.25',75,'note 7');
INSERT INTO tasks VALUES (107,8,'Project 8','P2','c','2022.09.05','2022.09.26',89,'note 8');
INSERT INTO tasks VALUES (108,9,'Project 9','P3','ns','2022.09.04','2022.09.27',73,'note 9');
INSERT INTO tasks VALUES (109,10,'Project 10','P1','ip','2022.09.03','2022.09.28',94,'note 10');
INSERT INTO tasks VALUES (110,1,'Project 11','P2','ns','2022.10.12','2022.10.19',93,'note 11');
INSERT INTO tasks VALUES (111,2,'Project 12','P3','ip','2022.10.11','2022.10.20',87,'note 12');
INSERT INTO tasks VALUES (112,3,'Project 13','P1','c','2022.10.10','2022.10.21',83,'note 13');
INSERT INTO tasks VALUES (113,4,'Project 14','P2','d','2022.10.09','2022.10.22',83,'note 14');
INSERT INTO tasks VALUES (114,5,'Project 15','P3','d','2022.10.08','2022.10.23',85,'note 15');
INSERT INTO tasks VALUES (115,6,'Project 16','P3','ns','2022.10.07','2022.10.24',94,'note 16');
INSERT INTO tasks VALUES (116,7,'Project 17','P3','ip','2022.10.06','2022.10.25',65,'note 17');
INSERT INTO tasks VALUES (117,8,'Project 18','P3','c','2022.10.05','2022.10.26',82,'note 18');
INSERT INTO tasks VALUES (118,9,'Project 19','P1','ns','2022.10.04','2022.10.27',99,'note 19');
INSERT INTO tasks VALUES (119,10,'Project 20','P2','ip','2022.10.03','2022.10.28',63,'note 20');
INSERT INTO tasks VALUES (120,1,'Project 21','P1','ns','2022.11.12','2022.11.19',84,'note 21');
INSERT INTO tasks VALUES (121,2,'Project 22','P2','ip','2022.11.11','2022.11.20',76,'note 22');
INSERT INTO tasks VALUES (122,3,'Project 23','P1','c','2022.11.10','2022.11.21',75,'note 23');
INSERT INTO tasks VALUES (123,4,'Project 24','P2','d','2022.11.09','2022.11.22',66,'note 24');
INSERT INTO tasks VALUES (124,5,'Project 25','P1','d','2022.11.08','2022.11.23',99,'note 25');
INSERT INTO tasks VALUES (125,6,'Project 26','P2','ns','2022.11.07','2022.11.24',71,'note 26');
INSERT INTO tasks VALUES (126,7,'Project 27','P1','ip','2022.11.06','2022.11.25',74,'note 27');
INSERT INTO tasks VALUES (127,8,'Project 28','P2','c','2022.11.05','2022.11.26',63,'note 28');
INSERT INTO tasks VALUES (128,9,'Project 29','P1','ns','2022.11.04','2022.11.27',90,'note 29');
INSERT INTO tasks VALUES (129,10,'Project 30','P2','ip','2022.11.03','2022.11.28',68,'note 30');