package edu.bit.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.bit.board.mapper.BoardMapper;
import edu.bit.board.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{
	
	private BoardMapper mapper;//이전의 DAO//mapper는 무조건 interface
	

	@Override
	public List<BoardVO> getList() {
		log.info("getList..........");
		
		return mapper.getList();
	}


	@Override
	public BoardVO get(int bno) {
		
		log.info("get.........");
		
		return mapper.read(bno);
	}


	@Override
	public void remove(int bno) {
		log.info("remove.........");
		
		mapper.delete(bno);
	}


	@Override
	public void writeBoard(BoardVO boardVO) {
		
		log.info("writeBoard...........");
		
		mapper.insertBoard(boardVO);
	}


	@Override
	public void writeReply(BoardVO boardVO) {
		mapper.updateShape(boardVO);
		mapper.insertReply(boardVO);
	}


	@Override
	public void writeModify(BoardVO boardVO) {
		mapper.modify(boardVO);
	}




	


	

}
