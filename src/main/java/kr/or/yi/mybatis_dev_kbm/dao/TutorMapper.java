package kr.or.yi.mybatis_dev_kbm.dao;

import kr.or.yi.mybatis_dev_kbm.dto.Tutor;

public interface TutorMapper {
	Tutor selectTutorById(int tutorId);
	Tutor selectTutorByTutorId(Tutor tutor);
}
