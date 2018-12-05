package kr.or.yi.mybatis_dev_kbm.dao;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import kr.or.yi.mybatis_dev_kbm.dto.Tutor;

public interface TutorMapper {
	@Select("SELECT TUTOR_ID, NAME AS TUTOR_NAME, EMAIL, ADDR_ID FROM TUTORS WHERE TUTOR_ID = #{tutorId}")
	@Results(id="TutorResult", value = {
			@Result(id=true, column="tutor_id", property="tutorId"),
			@Result(column="tutor_name", property="name"),
			@Result(column="email", property="email"),
			@Result(property="address", column="addr_id",
					one = @One(select = "kr.or.yi.mybatis_dev_kbm.dao.AddressMapper.selectAddressById")),
			@Result(property="courses", column="tutor_id",
					many = @Many(select = "kr.or.yi.mybatis_dev_kbm.dao.CourseMapper.selectCoursesByTutorId"))
			
	})
	Tutor selectTutorById(int tutorId);
	
	
	@Select("SELECT TUTOR_ID, NAME AS TUTOR_NAME, EMAIL, ADDR_ID FROM TUTORS WHERE TUTOR_ID = #{tutorId}")
	@Results({
			@Result(id=true, column="tutor_id", property="tutorId"),
			@Result(column="tutor_name", property="name"),
			@Result(column="email", property="email"),
			@Result(property="address", column="addr_id",
					one = @One(select = "kr.or.yi.mybatis_dev_kbm.dao.AddressMapper.selectAddressById")),
			@Result(property="courses", column="tutor_id",
					many = @Many(select = "kr.or.yi.mybatis_dev_kbm.dao.CourseMapper.selectCoursesByTutorId"))
			
	})
	Tutor selectTutorByTutorId(Tutor tutor);
	
	
	//매퍼 인터페이스 - 일대다 매핑
	@Select("SELECT T.TUTOR_ID, T.NAME AS TUTOR_NAME, EMAIL, A.ADDR_ID, STREET, CITY, STATE, ZIP, COUNTRY, COURSE_ID, C.NAME, DESCRIPTION, START_DATE, END_DATE "
			+ "FROM TUTORS T LEFT JOIN ADDRESSES A ON T.ADDR_ID = A.ADDR_ID "
			+ "LEFT JOIN COURSES C ON T.TUTOR_ID = C.TUTOR_ID "
			+ "WHERE T.TUTOR_ID = #{tutorId}")
	@ResultMap("mappers.TutorMapper.TutorWithAddressAndCourseResult")
	Tutor selectTutorMyIdForResultMap(int tutorId);
}
