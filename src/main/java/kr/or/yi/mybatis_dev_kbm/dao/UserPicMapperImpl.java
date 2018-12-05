package kr.or.yi.mybatis_dev_kbm.dao;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.mybatis_dev_kbm.dto.UserPic;
import kr.or.yi.mybatis_dev_kbm.jdbc.MyBatisSqlSessionFactory;

public class UserPicMapperImpl implements UserPicMapper {
	private String namespace = "kr.or.yi.mybatis_dev_kbm.dao.UserPicMapper";

	@Override
	public int insertUserPic(UserPic userPic) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			int res = sqlSession.insert(namespace + ".insertUserPic", userPic);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public UserPic getUserPic(int id) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectOne(namespace + ".getUserPic", id);
		}
	}

}
