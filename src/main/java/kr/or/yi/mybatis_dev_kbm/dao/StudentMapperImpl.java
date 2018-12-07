package kr.or.yi.mybatis_dev_kbm.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
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

	@Override
	public int insertStudent(Student student) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			int res = sqlSession.insert(Namespace + ".insertStudent", student);
			sqlSession.commit();
			
			return res;
		}
	}

	@Override
	public int updateStudent(Student student) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			int res = sqlSession.update(Namespace + ".updateStudent", student);
			sqlSession.commit();
			
			return res;
		}
	}

	@Override
	public int deleteStudent(int id) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			int res = sqlSession.delete(Namespace + ".deleteStudent", id);
			sqlSession.commit();
			
			return res;
		}
		
	}

	@Override
	public List<Student> selectStudentByAllForResultMap() {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(Namespace + ".selectStudentByAllForResultMap");
		}
	}

	@Override
	public List<Map<String, Object>> selectStudentByAllforHashMap() {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(Namespace + ".selectStudentByAllforHashMap");
		}
	}

	@Override
	public Student selectStudentByNoForResultMapExtends(Student student) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectOne(Namespace + ".selectStudentByNoForResultMapExtends", student);
		}
	}

	@Override
	public Student selectStudentByNoForResultMapExtends2(int studId) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectOne(Namespace + ".selectStudentByNoForResultMapExtends2", studId);
		}
	}

	@Override
	public Student selectStudentByNoAssociation(Student student) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectOne(Namespace + ".selectStudentByNoAssociation", student);
		}
	}

	@Override
	public int insertEnumStudent(Student student) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			int res = sqlSession.delete(Namespace + ".insertEnumStudent", student);
			sqlSession.commit();
			
			return res;
		}
	}

	@Override
	public List<Student> selectStudentWithGender() {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(Namespace + ".selectStudentWithGender");
		}
	}

	//여러 개의 입력 파라미터
	@Override
	public List<Student> selectAllStudentByMap(Map<String, String> map) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(Namespace + ".selectAllStudentByMap", map);
		}
	}

	
	//ResultSet 처리 방식의 재정의
	@Override
	//아이디, 이름
	public Map<Integer, String> selectStudentForMap() {
		Map<Integer, String> map = new HashMap<>();
		
		ResultHandler<Student> resultHandler = new ResultHandler<Student>() {
			@Override
			public void handleResult(ResultContext<? extends Student> resultContext) {
				Student student = resultContext.getResultObject();
				System.out.println("---- " + student);
				map.put(student.getStudId(), student.getName());
			}
		};
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			sqlSession.select(Namespace + ".selectStudentForMap", resultHandler);
			return map;
		}
	}

	@Override
	//아이디와 student 객체
	public Map<Integer, Student> selectStudentAllForMap() {
		Map<Integer, Student> map = new HashMap<>();
		ResultHandler<Student> resultHandler = new ResultHandler<Student>() {
			@Override
			public void handleResult(ResultContext<? extends Student> resultContext) {
				Student student = resultContext.getResultObject();
				System.out.println("---- " + student);
				map.put(student.getStudId(), student);
			}
		};
		
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			sqlSession.select(Namespace + ".selectStudentAllForMap", resultHandler);
			return map;
		}
	}
}
