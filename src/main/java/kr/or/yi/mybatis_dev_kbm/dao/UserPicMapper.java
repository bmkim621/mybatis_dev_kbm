package kr.or.yi.mybatis_dev_kbm.dao;

import kr.or.yi.mybatis_dev_kbm.dto.UserPic;

public interface UserPicMapper {
	int insertUserPic(UserPic userPic);
	UserPic getUserPic(int id);
}
