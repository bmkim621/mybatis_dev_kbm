show tables;

select * from courses;

select stud_id, name, email, phone, dob from students where stud_id = 1;

insert into students(stud_id, name, email, phone, dob) values (#{studId}, #{name}, #{email}, #{phone}, #{dob});

select * from students;
delete from students where stud_id = 3;

select addr_id as addrid, street, city, state, zip, country from addresses where addr_id=1;

SELECT TUTOR_ID, NAME AS TUTOR_NAME, EMAIL, ADDR_ID FROM TUTORS WHERE TUTOR_ID = 1;
SELECT COURSE_ID, NAME, DESCRIPTION, START_DATE, END_DATE FROM COURSES WHERE TUTOR_ID =1;