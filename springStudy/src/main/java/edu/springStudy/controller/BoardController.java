package edu.springStudy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.springStudy.service.BoardService;
import edu.springStudy.vo.BoardVO;
import edu.springStudy.vo.UserVO;

@Controller
@RequestMapping(value="/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/list.do")
	public String list(Model model) {
		
		/*
		 * List<String> list = new ArrayList<String>();
		 * 
		 * list.add("첫번째 게시물입니다."); list.add("두번째 게시물입니다."); list.add("세번째 게시물입니다.");
		 * list.add("네번째 게시물입니다.");
		 */
		
		List<BoardVO> list = boardService.list();
		
		model.addAttribute("list", list);
		
		return "board/list";
	}
	
	@RequestMapping(value="/view.do")
	public String view(int bidx, Model model) {
		BoardVO vo = boardService.selectOneByBidx(bidx);
		model.addAttribute("vo", vo);
		return "board/view";
	}
	
	@RequestMapping(value="/write.do", method=RequestMethod.GET)
	public String write(HttpServletRequest req) {
		HttpSession session = req.getSession();
		UserVO loginVO = (UserVO)session.getAttribute("login");
		if(loginVO == null) {
			return "redirect:list.do";
		}
		return "board/write";
	}
	
	/* RequestParam -> 파라미터 이름과 매개변수명이 다를 때 특정짓기 위해 사용 가능 */
	@RequestMapping(value="/write.do", method=RequestMethod.POST)
	public String write(BoardVO vo, HttpServletRequest req) {
		// 세팅
		HttpSession session = req.getSession();
		UserVO loginVO = (UserVO)session.getAttribute("login");
		if(loginVO == null) {
			return "redirect:list.do";
		}
		vo.setId(loginVO.getId());
		// 세팅 끝
		// 등록
		System.out.println(vo.toString());
		int result = boardService.insert(vo);
		if(result>0) {
			return "redirect:view.do?bidx="+vo.getBidx();
		}else {
			return "redirect:list.do";
		}
	}
	
	@RequestMapping(value="/modify.do", method=RequestMethod.GET)
	public String modify(int bidx, Model model) {
		BoardVO vo = boardService.selectOneByBidx(bidx);
		model.addAttribute("vo", vo);
		return "board/modify";
	}
	
	@RequestMapping(value="/modify.do", method=RequestMethod.POST)
	public String modify(BoardVO vo) {
		int result = boardService.update(vo);
		if(result>0) {
			// 수정 성공
			return "redirect:view.do?bidx="+vo.getBidx();
		}else {
			// 수정 실패
			return "redirect:list.do";
		}
	}
	
	@RequestMapping(value="/delete.do", method=RequestMethod.POST)
	public void delete(int bidx, HttpServletResponse res) throws IOException {
		int result = boardService.delete(bidx);
		res.setContentType("text/html;chars=UTF-8");
		PrintWriter pw = res.getWriter();
		if(result>0) {
			pw.append("<script>alert('삭제되었습니다');location.href='list.do';</script>");
		}else {
			pw.append("<script>alert('삭제되지 않았습니다');location.href='list.do';</script>");
		}
		pw.flush();
	}
}
