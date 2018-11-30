show tables;

select * from courses;

select stud_id, name, email, phone, dob from students where stud_id = 1;

insert into students(stud_id, name, email, phone, dob) values (#{studId}, #{name}, #{email}, #{phone}, #{dob});

select * from students;
delete from students where stud_id = 3;