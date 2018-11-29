package kr.or.yi.mybatis_dev_kbm;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.mybatis_dev_kbm.dao.StudentMapper;
import kr.or.yi.mybatis_dev_kbm.dao.StudentMapperImpl;
import kr.or.yi.mybatis_dev_kbm.dto.PhoneNumber;
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
	
	@Test
	public void test03insertStudent() {
		Calendar newDate = GregorianCalendar.getInstance();
		newDate.set(1990, 2, 28);
		Student student = new Student();
		student.setStudId(4);
		student.setName("홍길동1");
		student.setEmail("test@test.co.kr");
		student.setPhone(new PhoneNumber("010-456-7890"));
		student.setDob(newDate.getTime());
		
		int res = dao.insertStudent(student);
		Assert.assertEquals(1, res);
	}

	@Test
	public void test04updateStudent() {
		Student student = new Student();
		student.setStudId(4);
		student.setName("Timothy");
		student.setEmail("test@test.co.kr");
		student.setPhone(new PhoneNumber("123-123-1234"));
		student.setDob(new Date());
		
		int result = dao.updateStudent(student);
		Assert.assertEquals(1, result);
	}
	
	@Test
	public void test05deleteStudent() {
		int deleteStudent = dao.deleteStudent(4);
		Assert.assertSame(1, deleteStudent);
	}
}
