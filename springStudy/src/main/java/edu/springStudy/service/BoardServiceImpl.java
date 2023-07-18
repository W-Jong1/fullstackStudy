package edu.springStudy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.springStudy.dao.BoardDAO;
import edu.springStudy.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public List<BoardVO> list() {
		// 게시글 목록 db에서 가져오기
		return boardDAO.list();
	}
}
