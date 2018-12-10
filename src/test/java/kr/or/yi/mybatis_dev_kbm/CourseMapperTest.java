package kr.or.yi.mybatis_dev_kbm;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import kr.or.yi.mybatis_dev_kbm.dao.CourseMapper;
import kr.or.yi.mybatis_dev_kbm.dao.CourseMapperImpl;
import kr.or.yi.mybatis_dev_kbm.dto.Course;

public class CourseMapperTest extends AbstractTest {
	private static CourseMapper dao = new CourseMapperImpl();
	
	@Test
	public void test01SelectCoursesByCondition() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Map<String, Object> map = new HashMap<String, Object>();
		/*map.put("tutorId", 1);
		List<Course> list = dao.selectCourseByCondition(map);
		
		map.put("courseName", "%java%");
		list = dao.selectCourseByCondition(map);*/
		
		GregorianCalendar cal = new GregorianCalendar(2013, 1, 1);
		map.put("startDate", cal.getTime());
		List<Course> list = dao.selectCourseByCondition(map);
		
		cal.add(Calendar.MONTH, 4);
		map.put("endDate", cal.getTime());
		list = dao.selectCourseByCondition(map);
		
		Assert.assertNotNull(list);
	}

}
