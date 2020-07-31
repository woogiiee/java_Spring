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


//spring v4.0 ���� ����(@controller + @ResponseBody)

@Controller
@Log4j
@AllArgsConstructor
public class RestBoardSpring4BeforeController {
	//�ڹ� ��ü�� XML�� �ٲ��ִ� ����(��ü)�� �ִ�.

	private BoardService boardService;

	@ResponseBody//�޼����� ����Ÿ���� ������ �ٸ��� ó�� �Ѵٴ� ���� ���
	@RequestMapping("/restful/before")
	public List<BoardVO> before(){

		log.info("/restful/before");
		List<BoardVO> list = boardService.getList();

		return list;
	}
}
