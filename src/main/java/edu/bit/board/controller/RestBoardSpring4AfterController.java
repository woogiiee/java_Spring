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


//spring v4.0 ���� ����(@controller + @ResponseBody)

@Controller
@Log4j
@AllArgsConstructor
@RestController//(Controller + @ResponseBody)     //�������� ����
public class RestBoardSpring4AfterController {
	//�ڹ� ��ü�� XML�� �ٲ��ִ� ����(��ü)�� �ִ�.

	private BoardService boardService;

	//@responsebody�� �ڵ������� �ٿ��ֱ⶧���� ���� ���ʿ䰡 ����. �ٿ��ִ°��� ����� ��.
	@RequestMapping("/restful/after")
	public List<BoardVO> after(){

		log.info("/restful/after");
		List<BoardVO> list = boardService.getList();

		return list;
	}
}
