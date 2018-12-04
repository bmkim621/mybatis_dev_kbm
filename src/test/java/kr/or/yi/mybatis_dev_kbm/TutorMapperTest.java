package kr.or.yi.mybatis_dev_kbm;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.mybatis_dev_kbm.dao.TutorMapper;
import kr.or.yi.mybatis_dev_kbm.dao.TutorMapperImpl;
import kr.or.yi.mybatis_dev_kbm.dto.Course;
import kr.or.yi.mybatis_dev_kbm.dto.Tutor;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TutorMapperTest {
	private static TutorMapper dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = new TutorMapperImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dao = null;
	}

	@Test
	public void test01SelectTutorByCode() {
		Tutor tutor = dao.selectTutorById(1);
		
		Tutor findTutor = new Tutor();
		findTutor.setTutorId(1);
		
		Tutor tutor2 = dao.selectTutorByTutorId(findTutor);
		
		Assert.assertEquals(tutor.getTutorId(), tutor2.getTutorId());
		System.out.println(tutor2.getName() + "강좌");
		for(Course c : tutor2.getCourses()) {
			System.out.println(c);
		}
		System.out.println(tutor.getName() + "강좌");
		for(Course c : tutor.getCourses()) {
			System.out.println(c);
		}
	}

}
