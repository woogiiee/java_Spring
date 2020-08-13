package edu.bit.board.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bit.board.mapper.BoardMapper;
import edu.bit.board.mapper.LoginMapper;
import edu.bit.board.vo.BoardVO;
import edu.bit.board.vo.UserVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class TransactionService{
	
	private BoardMapper boardMapper;
	
	public void transactionTest1() {
		log.info("transactionTest1()테스트");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setbContent("트랜잭션1");
		boardVO.setbName("트랜잭션1");
		boardVO.setbTitle("트랜잭션1");
		
		boardMapper.insertBoard(boardVO);
		
		boardVO.setbContent("트랜잭션2");
		boardVO.setbName("트랜잭션2");
		boardVO.setbTitle("트랜잭션2");
		
		boardMapper.insertBoard(boardVO);
		
	}
	
	public void transactionTest2() {
		log.info("transactionTest2()테스트");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setbContent("트랜잭션1");
		boardVO.setbName("트랜잭션1");
		boardVO.setbTitle("트랜잭션1");
		
		boardMapper.insertBoard(boardVO);
		
		boardVO.setbContent("트랜잭션2");
		boardVO.setbName("트랜잭션2");
		boardVO.setbTitle("트랜잭션2");
		
		boardVO = null;
		
		boardMapper.insertBoard(boardVO);
		
	}
	
	@Transactional
	public void transactionTest3() {
		log.info("transactionTest3()테스트");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setbContent("트랜잭션1");
		boardVO.setbName("트랜잭션1");
		boardVO.setbTitle("트랜잭션1");
		
		boardMapper.insertBoard(boardVO);
		
		boardVO.setbContent("트랜잭션2");
		boardVO.setbName("트랜잭션2");
		boardVO.setbTitle("트랜잭션2");
		
		//일부러 에러를 내게함. 트랜잭션을 위한 것.
		boardVO = null;
		
		boardMapper.insertBoard(boardVO);
		
	}
	
	@Transactional
	public void transactionTest4() {
		log.info("transactionTest4()테스트");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setbContent("트랜잭션4");
		boardVO.setbName("트랜잭션4");
		boardVO.setbTitle("트랜잭션4");
		
		boardMapper.insertBoard(boardVO);
		
		
		throw new RuntimeException("RuntimeException for rollback");
		
	}
	
	@Transactional
	public void transactionTest5() throws IOException{
		log.info("transactionTest5()테스트");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setbContent("트랜잭션5");
		boardVO.setbName("트랜잭션5");
		boardVO.setbTitle("트랜잭션5");
		
		boardMapper.insertBoard(boardVO);
		
		
		throw new IOException("IOException for rollback");
		
	}
	//@Transactional의 rollbackFor 옵션을 이용하면 Rollback이 되는 클래스를 지정가능함.
	//Exception예외로 롤백을 하려면 다음과 같이 지정하면 된다.
	//@Transactional(rollbackFor=Exception.class)
	//여러개의 예외를 지정할 수도 있다.
	//@Transactional(rollbackFor=Exception.class,Exception
	@Transactional(rollbackFor = Exception.class)//5번 함수와 달리 IOException을 해도 롤백을 할 수 있게 만드는 방법
	public void transactionTest6() throws IOException{
		log.info("transactionTest6()테스트");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setbContent("트랜잭션6");
		boardVO.setbName("트랜잭션6");
		boardVO.setbTitle("트랜잭션6");
		
		boardMapper.insertBoard(boardVO);
		
		
		throw new IOException("IOException for rollback");
		
	}
}
