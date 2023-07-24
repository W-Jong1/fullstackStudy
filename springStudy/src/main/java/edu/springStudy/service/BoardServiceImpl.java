package edu.springStudy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.springStudy.dao.BoardDAO;
import edu.springStudy.vo.BoardVO;
import edu.springStudy.vo.SearchVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public List<BoardVO> list(SearchVO searchVO) {
		// 게시글 목록 db에서 가져오기
		return boardDAO.list(searchVO);
	}

	@Override
	public BoardVO selectOneByBidx(int bidx) {
		return boardDAO.selectOneByBidx(bidx);
	}

	@Override
	public int update(BoardVO vo) {
		return boardDAO.update(vo);
	}

	@Override
	public int delete(int bidx) {
		return boardDAO.delete(bidx);
	}

	@Override
	public int insert(BoardVO vo) {
		return boardDAO.insert(vo);
	}
}
