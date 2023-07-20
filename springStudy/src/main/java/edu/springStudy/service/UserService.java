package edu.springStudy.service;

import java.util.List;

import edu.springStudy.vo.UserVO;

public interface UserService {
	List<UserVO> list();
	UserVO selectUserByLogin(UserVO vo);
	int join(UserVO vo);
}
