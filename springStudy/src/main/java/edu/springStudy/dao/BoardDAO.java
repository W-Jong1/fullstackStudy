package edu.springStudy.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.springStudy.vo.BoardVO;
import edu.springStudy.vo.SearchVO;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<BoardVO> list(SearchVO searchVO) {
		return sqlSession.selectList("edu.springStudy.mapper.boardMapper.selectAll", searchVO);
	}
	
	public BoardVO selectOneByBidx(int bidx) {
		return sqlSession.selectOne("edu.springStudy.mapper.boardMapper.selectOneByBidx", bidx);
	}
	
	public int update(BoardVO vo) {
		return sqlSession.update("edu.springStudy.mapper.boardMapper.update", vo);
	}
	
	public int delete(int bidx) {
		return sqlSession.delete("edu.springStudy.mapper.boardMapper.delete", bidx);
	}
	
	public int insert(BoardVO vo) {
		return sqlSession.insert("edu.springStudy.mapper.boardMapper.insert", vo);
	}
}
