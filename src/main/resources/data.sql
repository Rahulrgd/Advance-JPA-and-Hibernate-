insert into course(id, fullname, created_date, last_updated_date) values(10001, 'AWS in 100 steps', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
insert into course(id, fullname, created_date, last_updated_date) values(10002, 'MicroServices in 100 steps', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
insert into course(id, fullname, created_date, last_updated_date) values(10003, 'SQL in 50 steps', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

insert into passport(id, number) values(40001, 'E123456');
insert into passport(id, number) values(40002, 'N123456');
insert into passport(id, number) values(40003, 'C123456');

insert into student(id, name, passport_id) values(20001, 'Rahul', 40001);
insert into student(id, name, passport_id) values(20002, 'Rahi', 40002);
insert into student(id, name, passport_id) values(20003, 'Satendra', 40003);

insert into review(id, rating, description, course_id) values(50001, 5, 'Great Course', 10001);
insert into review(id, rating, description, course_id) values(50002, 4, 'Good Course', 10001);
insert into review(id, rating, description, course_id) values(50003, 5, 'Very Good Course', 10003);

insert into student_course(student_id, course_id) values(20001, 10001);
insert into student_course(student_id, course_id) values(20002, 10001);
insert into student_course(student_id, course_id) values(20003, 10001);
insert into student_course(student_id, course_id) values(20001, 10003);