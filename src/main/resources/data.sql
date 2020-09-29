insert into course(id, name, created_date, last_updated_date,is_deleted)
values(1001,'JPA Course', sysdate(), sysdate(),false);
insert into course(id, name, created_date, last_updated_date,is_deleted)
values(1002,'Spring Course', sysdate(), sysdate(),false);
insert into course(id, name, created_date, last_updated_date,is_deleted)
values(1003,'Cooking Course', sysdate(), sysdate(),false);


insert into passport(id,number)
values(4001,'C123456');
insert into passport(id,number)
values(4002,'12345RD6');
insert into passport(id,number)
values(4003,'0987654F');

insert into student(id,name,passport_id)
values(2001,'David',4001);
insert into student(id,name,passport_id)
values(2002,'Ruri',4002);
insert into student(id,name,passport_id)
values(2003,'Peter',4003);

insert into review(id,rating,description,course_id)
values(5001,'FOUR', 'Great Course',1001);
insert into review(id,rating,description,course_id)
values(5002,'FOUR', 'Good Course',1001);
insert into review(id,rating,description,course_id)
values(5003,'FIVE', 'Awesome Course',1003);

insert into student_course(student_id,course_id)
values(2001,1001);
insert into student_course(student_id,course_id)
values(2002,1001);
insert into student_course(student_id,course_id)
values(2003,1001);
insert into student_course(student_id,course_id)
values(2001,1003);