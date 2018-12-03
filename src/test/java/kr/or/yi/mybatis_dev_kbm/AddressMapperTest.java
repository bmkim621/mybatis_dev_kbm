package kr.or.yi.mybatis_dev_kbm;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.mybatis_dev_kbm.dao.AddressMapper;
import kr.or.yi.mybatis_dev_kbm.dao.AddressMapperImpl;
import kr.or.yi.mybatis_dev_kbm.dto.Address;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AddressMapperTest extends AbstractTest {
	private static AddressMapper dao = new AddressMapperImpl();

	@Test
	public void test01SelectStudentById() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Address searchStd = dao.selectAddressById(3);
		Assert.assertNotNull(searchStd);
	}

}
