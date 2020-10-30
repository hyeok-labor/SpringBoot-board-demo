package com.example.demo.board.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.board.domain.UserVO;



@Repository("com.example.demo.board.mapper.UserMapper")
public interface UserMapper {

	// 유저 목록
	public List<UserVO> userList() throws Exception;

	// 유저 상세
	public UserVO userDetail(String uid) throws Exception;

	// 유저 생성
	public int userInsert(UserVO user) throws Exception;

	// 유저 정보 변경
	public int userUpdate(UserVO user) throws Exception;

	// 유저 삭제
	public int userDelete(String uid) throws Exception;

}
