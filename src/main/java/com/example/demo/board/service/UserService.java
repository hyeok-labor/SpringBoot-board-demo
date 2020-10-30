package com.example.demo.board.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.board.domain.UserVO;
import com.example.demo.board.mapper.UserMapper;

@Service("com.example.demo.board.service.UserService")
public class UserService {

	@Resource(name="com.example.demo.board.mapper.UserMapper")
	UserMapper mUserMapper;

	// 유저 목록
	public List<UserVO> userListService() throws Exception {
		return mUserMapper.userList();
	}

	// 유저 상세
	public UserVO userDetailService(String uid) throws Exception{
		return mUserMapper.userDetail(uid);
	}

	// 유저 생성
	public int userInsertService(UserVO user) throws Exception{
		return mUserMapper.userInsert(user);
	}

	// 유저 정보 변경
	public int userUpdateService(UserVO user) throws Exception{
		return mUserMapper.userUpdate(user);
	}

	// 유저 삭제
	public int userDeleteService(String uid) throws Exception{
		return mUserMapper.userDelete(uid);
	}

}
