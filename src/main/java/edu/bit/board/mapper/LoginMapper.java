package edu.bit.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import edu.bit.board.vo.UserVO;

public interface LoginMapper {
	
	@Select("select * from users where username = #{username} and password= #{password}")
	UserVO logInUser(@Param("username") String username, @Param("password") String password);

}