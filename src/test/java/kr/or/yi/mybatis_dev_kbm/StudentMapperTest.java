package kr.or.yi.mybatis_dev_kbm;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.mybatis_dev_kbm.dao.StudentMapper;
import kr.or.yi.mybatis_dev_kbm.dao.StudentMapperImpl;
import kr.or.yi.mybatis_dev_kbm.dto.Student;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentMapperTest extends AbstractTest {
	private StudentMapper dao = new StudentMapperImpl();
	
	@Test
	public void test01selectStudentByNo() {
		log.debug("test01selectStudentByNo()");
		Student searchStd = new Student();
		searchStd.setStudId(1);	//id가 1번
		
		//return : Student(1번에 해당하는 Student 리턴)
		Student searchedStd = dao.selectStudentByNo(searchStd);
		Assert.assertNotNull(searchedStd);
	}
	
	@Test
	public void test02selectByAll() {
		log.debug("test02selectByAll()");
		List<Student> list = dao.selectStudentByAll();
		Assert.assertNotNull(list);
	}

}
