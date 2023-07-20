package edu.springStudy.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.springStudy.vo.UserVO;

@Repository
public class UserDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<UserVO> list() {
		return sqlSession.selectList("edu.springStudy.mapper.userMapper.selectAll");
	}
	
	public UserVO selectUserByLogin(UserVO vo) {
		return sqlSession.selectOne("edu.springStudy.mapper.userMapper.selectUserByLogin", vo);
	}
	
	public int join(UserVO vo) {
		return sqlSession.insert("edu.springStudy.mapper.userMapper.join", vo);
	}
}
