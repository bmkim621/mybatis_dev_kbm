show tables;

select * from courses;

select stud_id, name, email, phone, dob from students where stud_id = 1;

insert into students(stud_id, name, email, phone, dob) values (#{studId}, #{name}, #{email}, #{phone}, #{dob});

select * from students;
delete from students where stud_id = 3;

select addr_id as addrid, street, city, state, zip, country from addresses where addr_id=1;