package kr.or.yi.mybatis_dev_kbm;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.mybatis_dev_kbm.dao.TutorMapper;
import kr.or.yi.mybatis_dev_kbm.dao.TutorMapperImpl;
import kr.or.yi.mybatis_dev_kbm.dto.Tutor;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TutorMapperTest extends AbstractTest {
	private static TutorMapper dao = new TutorMapperImpl();

	@Test
	public void test01selectTutorByNo() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Tutor selTutor1 = dao.selectTutorById(1);
		
		Tutor tutor = new Tutor();
		tutor.setTutorId(1);
		Tutor selTutor2 = dao.selectTutorByTutorId(tutor);
		
		Assert.assertEquals(selTutor1.getTutorId(), selTutor2.getTutorId());
	}
	
	@Test
	public void test02selectTutorByIdForResultMap() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		dao.selectTutorMyIdForResultMap(1);
	}

}
