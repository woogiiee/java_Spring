package edu.bit.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.bit.board.service.BoardService;
import edu.bit.board.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


//spring v4.0 이전 버전(@controller + @ResponseBody)

@Controller
@Log4j
@AllArgsConstructor
public class RestBoardSpring4BeforeController {
	//자바 객체를 XML로 바꿔주는 뭔가(객체)가 있다.

	private BoardService boardService;

	@ResponseBody//메서드의 리턴타입을 기존과 다르게 처리 한다는 것을 명시
	@RequestMapping("/restful/before")
	public List<BoardVO> before(){

		log.info("/restful/before");
		List<BoardVO> list = boardService.getList();

		return list;
	}
}
