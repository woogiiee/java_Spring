package edu.bit.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.bit.board.service.BoardService;
import edu.bit.board.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


//spring v4.0 이전 버전(@controller + @ResponseBody)

@Controller
@Log4j
@AllArgsConstructor
@RestController//(Controller + @ResponseBody)     //기존문법 무시
public class RestBoardSpring4AfterController {
	//자바 객체를 XML로 바꿔주는 뭔가(객체)가 있다.

	private BoardService boardService;

	//@responsebody를 자동적으로 붙여주기때문에 따로 쓸필요가 없다. 붙여주는것이 좋기는 함.
	@RequestMapping("/restful/after")
	public List<BoardVO> after(){

		log.info("/restful/after");
		List<BoardVO> list = boardService.getList();

		return list;
	}
}
