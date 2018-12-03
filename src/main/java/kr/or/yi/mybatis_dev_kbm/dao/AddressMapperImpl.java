package kr.or.yi.mybatis_dev_kbm.dao;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.mybatis_dev_kbm.dto.Address;
import kr.or.yi.mybatis_dev_kbm.jdbc.MyBatisSqlSessionFactory;

public class AddressMapperImpl implements AddressMapper {
	private static final String namespace = "kr.or.yi.mybatis_dev_kbm.dao.AddressMapper";
	
	@Override
	public Address selectAddressById(int addrId) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectOne(namespace + ".selectAddressById", addrId);
		}
	}

}
