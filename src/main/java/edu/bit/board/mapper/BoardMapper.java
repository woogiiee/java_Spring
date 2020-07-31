package edu.bit.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import edu.bit.board.vo.BoardVO;

public interface BoardMapper {
	public abstract List<BoardVO> getList();

	public abstract BoardVO read(int bno);
	
	@Delete("Delete from mvc_board where bId = #{bno}")//������ ���� �̷��� �ص� �������.
	public abstract void delete(int bno);

	
	public abstract void insertBoard(BoardVO boardVO);

	void updateShape(@Param("boardVO")BoardVO boardVO);//boardVO�Ķ���͸� "boardVO"�Ķ���ͷ� �����Ѵ�.
	//@param�� boardvo1�� boardvo2 ��ü�� 2���� �����Ҷ� ���� ��ü�� xml���� ���� �ְԲ� ���ش�.
	void insertReply(BoardVO boardVO);

	void modify(@Param("boardVO")BoardVO boardVO);



}