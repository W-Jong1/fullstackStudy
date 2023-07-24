package edu.springStudy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.springStudy.dao.UserDAO;
import edu.springStudy.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public List<UserVO> list() {
		return userDAO.list();
	}

	@Override
	public UserVO selectUserByLogin(UserVO vo) {
		return userDAO.selectUserByLogin(vo);
	}

	@Override
	public int insert(UserVO vo) {
		return userDAO.insert(vo);
	}

	@Override
	public int selectCntById(String id) {
		return userDAO.selectCntById(id);
	}
}
