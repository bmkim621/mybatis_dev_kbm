package kr.or.yi.mybatis_dev_kbm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import kr.or.yi.mybatis_dev_kbm.dto.Course;

public interface CourseMapper {
	@Select("SELECT COURSE_ID, NAME, DESCRIPTION, START_DATE, END_DATE FROM COURSES WHERE TUTOR_ID = #{tutorId}")
	@Results({
		@Result(id = true, column = "course_id", property = "courseId"),
		@Result(column="name", property="name"),
		@Result(column="description", property="description"),
		@Result(column="start_date", property="startDate"),
		@Result(column="end_date", property="endDate")
	})
	List<Course> selectCoursesByTutorId(int tutorId);
}
