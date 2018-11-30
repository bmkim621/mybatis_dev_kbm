show tables;

select * from courses;

select stud_id as studId, name, email, dob, phone
from students
where stud_id = 1;

select * from students;

insert into students(name, email, phone, dob)
values('홍길동', 'test@gmail.com', '010-123-1234', '2018-11-29');

update students
set name = '홍길동2', email = 'test@testtest.co.kr', phone = '987-654-3210', dob = '1988-04-25'
where stud_id = 4;

delete from students
where stud_id = 4;

select * from addresses;
select * from students;

select stud_id, name, email, phone, a.addr_id, street, city, state, zip, country
from students s left outer join addresses a
on s.ADDR_ID = a.ADDR_ID;