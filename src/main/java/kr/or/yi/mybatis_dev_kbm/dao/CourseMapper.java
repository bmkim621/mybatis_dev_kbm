package kr.or.yi.mybatis_dev_kbm.dao;

import java.util.List;
import java.util.Map;

import kr.or.yi.mybatis_dev_kbm.dto.Course;

public interface CourseMapper {
	List<Course> selectCourseByCondition(Map<String, Object> map);
}
