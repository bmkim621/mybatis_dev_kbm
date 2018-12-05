package kr.or.yi.mybatis_dev_kbm;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.mybatis_dev_kbm.dao.CourseMapper;
import kr.or.yi.mybatis_dev_kbm.dao.CourseMapperImpl;
import kr.or.yi.mybatis_dev_kbm.dto.Course;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CourseMapperTest extends AbstractTest {
	private static CourseMapper dao = new CourseMapperImpl();

	@Test
	public void test01SelectStudentById() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		List<Course> searchStd = dao.selectCoursesByTutorId(1);
		Assert.assertNotNull(searchStd);
	}

}
