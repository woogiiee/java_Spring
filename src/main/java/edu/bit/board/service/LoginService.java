package edu.bit.board.service;

import java.util.List;


import org.springframework.stereotype.Service;

import edu.bit.board.mapper.BoardMapper;
import edu.bit.board.mapper.LoginMapper;
import edu.bit.board.vo.BoardVO;
import edu.bit.board.vo.UserVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
public class LoginService{
	
	LoginMapper logInMapper;
	
	public UserVO loginUser(String id, String pw) {
		return logInMapper.logInUser(id, pw);
	}


}
