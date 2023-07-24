package edu.springStudy.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import edu.springStudy.vo.UserVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		// request.setAttribute()
		model.addAttribute("serverTime", formattedDate);
		
		return "home";
	}
	
	@RequestMapping(value="/sample.do", method=RequestMethod.GET)
	public String sample(Model model) {
		
		String name = "홍길동";
		int age = 20;
		String addr = "전주 덕진구";
		String phone = "010-1111-1111";
		
		model.addAttribute("name" , name);
		model.addAttribute("age"  , age);
		model.addAttribute("addr" , addr);
		model.addAttribute("phone", phone);
		
		return "ex01";
	}
	
	@RequestMapping(value="/sample.do", method=RequestMethod.POST)
	public String sample1(UserVO userVO) {
		System.out.println(userVO.getName());
		System.out.println(userVO.getAge());
		System.out.println(userVO.getAddr());
		System.out.println(userVO.getPhone());
		return "redirect:/board/list.do";
	}
	
	@RequestMapping(value="/fileupload.do", method=RequestMethod.GET)
	public String fileupload() {
		return "fileupload";
	}
	
	@RequestMapping(value="/fileupload.do", method=RequestMethod.POST)
	public String fileupload(MultipartFile uploadFile
			, String t1
			, String t2
			, HttpServletRequest req) throws Exception {
		
		String realPath = req.getSession().getServletContext().getRealPath("/resources/upload");
		System.out.println(realPath);
		
		String path = "D:/Woo/sts-workspace/fullstackStudy/springStudy/src/main/webapp/resources/upload";
		// 폴더 확인
		File dir = new File(path);
		if(!dir.exists()) {
			// 없으면 해당 경로에 해당하는 모든 폴더 생성
			dir.mkdirs();
		}
		if(!uploadFile.getOriginalFilename().isEmpty()) {
			String fileNM = uploadFile.getOriginalFilename();
			// uploadFile.transferTo(new File(path,fileNM));
			
			String fileNMArray[] = fileNM.split("\\.");
			String etc = fileNMArray[fileNMArray.length-1]; // 확장자
			long timeMilis = System.currentTimeMillis();
			String newFileNM = fileNM.substring(0,fileNM.length()-etc.length()-1)+timeMilis+"."+etc;
			uploadFile.transferTo(new File(path,newFileNM));
			
			return "redirect:/?fileNM="+newFileNM;
		}
		return "redirect:/";
	}
}
