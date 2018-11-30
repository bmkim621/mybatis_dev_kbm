package kr.or.yi.mybatis_dev_kbm;

import java.util.Calendar;
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
	private static StudentMapper dao = new StudentMapperImpl();

	@Test
	public void test01SelectStudentById() {
		log.debug("test01SelectStudentById()");
		Student newStd = new Student();
		newStd.setStudId(2);
		
		Student searchStd = dao.selectStudentById(newStd);
		Assert.assertNotNull(searchStd);
	}
	
	@Test
	public void test02SelectStudentByAll() {
		log.debug("test02SelectStudentByAll()");
		List<Student> list = dao.selectStudentByAll();
		Assert.assertNotNull(list);
	}
	
	@Test
	public void test03InsertStudentAnnotation() {
		Calendar newDate = GregorianCalendar.getInstance();
		newDate.set(1990, 4, 28);
		
		Student student = new Student();
		student.setStudId(3);
		student.setName("홍길동");
		student.setEmail("test@google.co.kr");
		student.setPhone(new PhoneNumber("010-123-1234"));
		student.setDob(newDate.getTime());
		
//		System.out.println(student);
		int res = dao.insertStudent(student);
		Assert.assertEquals(1, res);
	}

	@Test
	public void test04UpdateStudent() {
		Calendar newDate = GregorianCalendar.getInstance();
		newDate.set(2000, 4, 28);
		
		Student student = new Student();
		student.setStudId(3);
		student.setName("홍길동5");
		student.setEmail("hong@test.co.kr");
		student.setPhone(new PhoneNumber("010-111-2222"));
		student.setDob(newDate.getTime());
		
		int res = dao.updateStudent(student);
		Assert.assertEquals(1, res);
	}
	
	@Test
	public void test05DeleteStudent() {
		int res = dao.deleteStudent(3);
		Assert.assertEquals(1, res);
	}
}
