package kr.or.yi.mybatis_dev_kbm.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
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
	
	
	//
	@Select("select stud_id, name, email, phone, a.addr_id, street, city, state, zip, country from students s join addresses a on s.addr_id = a.addr_id")
	@Results({
			@Result(id = true, column = "stud_id", property = "studId"),
			@Result(column = "name", property = "name"),
			@Result(column = "email", property = "email"),
			@Result(column = "phone", property = "phone"),
			@Result(column = "dob", property = "dob"),
			@Result(column = "addr_id", property = "address.addrId"),
			@Result(column = "street", property = "address.street"),
			@Result(column = "city", property = "address.city"),
			@Result(column = "state", property = "address.state"),
			@Result(column = "zip", property = "address.zip"),
			@Result(column = "country", property = "address.country")
	})
	List<Student> selectStudentByAllForResultMaxExt();
	
	
	//결과 매핑 확장
	@Select("select stud_id, name, email, phone, a.addr_id, street, city, state, zip, country from students s join addresses a on s.addr_id = a.addr_id")
	@ResultMap("mappers.StudentMapper.StudentWithAddressResult")
	List<Student> selectStudentByAllForResultMapExtXML();
	
	
	//매퍼 인터페이스 - 내표된 결과 매핑을 사용한 일대일 매핑
	@Select("select stud_id, name, email, phone, addr_id from students where stud_id = #{studId}")
	@Results({
		@Result(id=true, column="stud_id", property="studId"),
		@Result(column="name", property="name"),
		@Result(column="email", property="email"),
		@Result(column="phone", property="phone"),
		@Result(column="dob", property="dob"),
		@Result(column="addr_id", property="address",
		one=@One(select="kr.or.yi.mybatis_dev_kbm.dao.AddressMapper.selectAddressById"))
	})
	Student selectStudentOneToOne(int studId);
}
