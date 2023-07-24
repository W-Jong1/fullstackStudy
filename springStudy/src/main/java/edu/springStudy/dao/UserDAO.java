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
	
	private static final String namespace = "edu.springStudy.mapper.userMapper";
	public List<UserVO> list() {
		return sqlSession.selectList(namespace+".selectAll");
	}
	
	public UserVO selectUserByLogin(UserVO vo) {
		return sqlSession.selectOne(namespace+".selectUserByLogin", vo);
	}
	
	public int insert(UserVO vo) {
		return sqlSession.insert(namespace+".insert", vo);
	}
	
	public int selectCntById(String id) {
		return sqlSession.selectOne(namespace+".selectCntById", id);
	}
}
