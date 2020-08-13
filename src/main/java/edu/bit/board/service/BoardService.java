package edu.bit.board.service;

import java.util.List;

import edu.bit.board.vo.BoardVO;

public interface BoardService {
	public abstract List<BoardVO> getList();

	public abstract BoardVO get(int bno);

	public abstract int remove(int bno);

	public abstract void writeBoard(BoardVO boardVO);

	public abstract void writeReply(BoardVO boardVO);

	public abstract void writeModify(BoardVO boardVO);

	
	

}
