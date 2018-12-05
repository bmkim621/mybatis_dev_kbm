package kr.or.yi.mybatis_dev_kbm.dao;

import java.util.List;

import javax.xml.stream.events.Namespace;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.mybatis_dev_kbm.dto.Course;
import kr.or.yi.mybatis_dev_kbm.jdbc.MyBatisSqlSessionFactory;

public class CourseMapperImpl implements CourseMapper {
	private static final String namespace = "kr.or.yi.mybatis_dev_kbm.dao.CourseMapper";

	@Override
	public List<Course> selectCoursesByTutorId(int tutorId) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(namespace + ".selectCoursesByTutorId", tutorId);
		}
	}

}
