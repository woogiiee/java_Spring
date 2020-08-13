package edu.bit.board.vo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor//디폴트 생성자
@Getter
@Setter
public class UserVO {
	private String username;
	private String password;
	private char enabled;
	
}
