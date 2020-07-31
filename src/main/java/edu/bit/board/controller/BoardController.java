package edu.bit.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.bit.board.service.BoardService;
import edu.bit.board.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
public class BoardController {
	
	//스프링5.0부터는 생성자가 있으면 Auto(자동으로 넣어줌)
	private BoardService service;// 비즈니스 로직이 service에 들어간다.

	@RequestMapping("/list") // list를 받아내는 주체는 톰캣
	public void list(Model model) {
		log.info("list");
		model.addAttribute("list", service.getList());
	}

	@GetMapping("/content_view")//post는 왜 안돼요?
	
	public String content_view(BoardVO boardVO, Model model) {
		log.info("content_view");

		model.addAttribute("content_view", service.get(boardVO.getbId()));

		return "content_view";
	}

	@GetMapping("/delete")
	public String delete(BoardVO boardVO) {
		log.info("delete");

		service.remove(boardVO.getbId());

		return "redirect:list";
	}

	///////////////////////////////////////////////////////////////
	@RequestMapping("write_view")
	public String write_view() {
		log.info("write_view()");
		return "write_view";
	}

	@RequestMapping("write")
	public String write(BoardVO boardVO) throws Exception {
		log.info("write()");
		service.writeBoard(boardVO);
		return "redirect:list";
	}

	@RequestMapping("reply_view")
	public String reply_view(BoardVO boardVO, Model model) {
		log.info("reply_view()");
		model.addAttribute("reply_view", service.get(boardVO.getbId()));
		return "reply_view";
	}

	@RequestMapping("reply")
	public String reply(BoardVO boardVO, Model model) throws Exception {
		log.info("reply()");
		
		service.writeReply(boardVO);
		
		return "redirect:list";
	}
	
	@RequestMapping("modify")
	public String modify(BoardVO boardVO, Model model) throws Exception {
		log.info("modify()");
		
		service.writeModify(boardVO);
		
		return "redirect:list";
	}
	
	//ajax 통신
	@RequestMapping("/ajax/list")
	public String ajaxList() {
		log.info("ajaxList()");
		return "ajaxlist";
	}
}
