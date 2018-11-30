package kr.or.yi.mybatis_dev_kbm.dao;

import java.util.List;
import java.util.Map;

import kr.or.yi.mybatis_dev_kbm.dto.Student;

public interface StudentMapper {
	Student selectStudentByNo(Student student);
	
	List<Student> selectStudentByAll();
	
	int insertStudent(Student student);
	
	int updateStudent(Student student);
	
	int deleteStudent(int id);
	
	//ResultMap
	List<Student> selectStudentByAllForResultMap();
	//HashMap
	List<Map<String, Object>> selectStudentByAllforHashMap();
	
	//resultMap Extends
	Student selectStudentByNoForResultMapExtends(Student student);
	
	Student selectStudentByNoForResultMapExtends2(int studId);
}
