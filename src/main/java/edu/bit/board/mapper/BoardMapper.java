package edu.bit.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import edu.bit.board.vo.BoardVO;

public interface BoardMapper {
	public abstract List<BoardVO> getList();

	public abstract BoardVO read(int bno);
	
	@Delete("Delete from mvc_board where bId = #{bno}")//간단한 것은 이렇게 해도 상관없다.
	public abstract void delete(int bno);

	
	public abstract void insertBoard(BoardVO boardVO);

	void updateShape(@Param("boardVO")BoardVO boardVO);//boardVO파라미터를 "boardVO"파라미터로 전달한다.
	//@param은 boardvo1과 boardvo2 객체가 2개가 존재할때 각각 객체를 xml에서 쓸수 있게끔 해준다.
	void insertReply(BoardVO boardVO);

	void modify(@Param("boardVO")BoardVO boardVO);



}