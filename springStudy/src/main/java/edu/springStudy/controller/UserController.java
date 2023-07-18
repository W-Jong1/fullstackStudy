package edu.springStudy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.springStudy.service.UserService;
import edu.springStudy.vo.UserVO;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/list.do")
	public String list(Model model) {
		List<UserVO> list = userService.list();
		model.addAttribute("list", list);
		return "user/list";
	}
}
