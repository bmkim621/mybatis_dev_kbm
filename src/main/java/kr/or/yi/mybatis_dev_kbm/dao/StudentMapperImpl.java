package kr.or.yi.mybatis_dev_kbm.dao;

import java.util.List;

import javax.xml.stream.events.Namespace;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.mybatis_dev_kbm.dto.Student;
import kr.or.yi.mybatis_dev_kbm.jdbc.MyBatisSqlSessionFactory;

public class StudentMapperImpl implements StudentMapper {
	private static final String Namespace = "kr.or.yi.mybatis_dev_kbm.dao.StudentMapper";
	
	@Override
	public Student selectStudentByNo(Student student) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectOne(Namespace + ".selectStudentByNo", student);
		}
	}

	@Override
	public List<Student> selectStudentByAll() {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(Namespace + ".selectStudentByAll");
		}
	}

}
