package kr.or.yi.mybatis_dev_kbm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.or.yi.mybatis_dev_kbm.dto.Student;

public interface StudentMapper {
	@Select("select stud_id, name, email, phone, dob from students where stud_id = #{studId}")
	Student selectStudentById(Student student);
	
	@Select("select stud_id, name, email, phone, dob from students")
	List<Student> selectStudentByAll();
	
	@Insert("insert into students(stud_id, name, email, phone, dob) values (#{studId}, #{name}, #{email}, #{phone}, #{dob})")
	int insertStudent(Student student);
	
	@Update("update students set name = #{name}, email = #{email}, phone = #{phone}, dob = #{dob} where stud_id = #{studId}")
	int updateStudent(Student student);
	
	@Delete("delete from students where stud_id = #{studId}")
	int deleteStudent(int studId);
	
}
