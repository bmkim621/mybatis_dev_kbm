package kr.or.yi.mybatis_dev_kbm.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
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
	
	//ResultMapping
	@Select("select stud_id, name, email, phone, dob from students")
	@Results(id="StudentResult", value = {
		@Result(id = true, column = "stud_id", property = "studId"),
		@Result(column = "name", property = "name"),
		@Result(column = "email", property = "email"),
		@Result(column = "phone", property = "phone"),
		@Result(column = "dob", property = "dob")
	})
	List<Student> selectStudentByAllForResults();
	
	//XML MAPPER를 이용 및 재사용
	@Select("select stud_id, name, email, phone, dob from students")
	@Results({
			@Result(id = true, column = "stud_id", property = "studId"),
			@Result(column = "name", property = "name"),
			@Result(column = "email", property = "email"),
			@Result(column = "phone", property = "phone"),
			@Result(column = "dob", property = "dob")
		})
	List<Map<String, Object>> selectStudentByAllForResultMap();
	
	@Select("select stud_id, name, email, phone, dob from students")
	@ResultMap("mappers.StudentMapper.StudentResult")
	List<Student> selectStudentByAllForMapper();
}
