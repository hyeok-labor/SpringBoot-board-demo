package com.example.demo.board.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.board.domain.UserVO;
import com.example.demo.board.service.UserService;

// Controller ==> Interface 에서 정의된 메서드에 대해 Service 에서 구현 후 Contorller 에서 views 와 연결
@Controller
public class UserController {
	@Resource(name="com.example.demo.board.service.UserService")
	UserService mUserService;

	@RequestMapping("/ulist")	// 유저 리스트 화면 호출
	private String userList(Model model) throws Exception{

		model.addAttribute("ulist", mUserService.userListService());
		return "ulist";
	}

	@RequestMapping("/udetail/{uid}")
	private String userDetail(@PathVariable String uid, Model model) throws Exception {

		model.addAttribute("udetail", mUserService.userDetailService(uid));
		return "udetail";
	}

	@RequestMapping("/uinsert") //게시글 작성폼 호출
	private String userInsertForm(){

		return "uinsert";
	}

	@RequestMapping("/uinsertProc")
	private String userInsertProc(HttpServletRequest request) throws Exception{

		UserVO user = new UserVO();

		user.setUid(request.getParameter("uid"));
		user.setUpw(request.getParameter("upw"));
		user.setUname(request.getParameter("uname"));
		user.setEmail(request.getParameter("email"));
		user.setGoogleid(request.getParameter("googleid"));
		user.setNaverid(request.getParameter("naverid"));
		user.setNickname(request.getParameter("nickname"));

		mUserService.userInsertService(user); //게시글 insert

		return "redirect:/ulist";
	}

	@RequestMapping("/uupdate/{uid}")	// 유저 정보 변경 폼 호출
	private String UserUpdateForm(@PathVariable String uid, Model model) throws Exception{

		model.addAttribute("udetail", mUserService.userDetailService(uid));

		return "uupdate";
	}

	@RequestMapping("/userupdateProc")
	private String userUpdateProc(HttpServletRequest request) throws Exception{

		UserVO user = new UserVO();
		user.setUpw(request.getParameter("upw"));
		user.setEmail(request.getParameter("email"));
		user.setGoogleid(request.getParameter("googleid"));
		user.setNaverid(request.getParameter("naverid"));
		user.setNickname(request.getParameter("nickname"));
		user.setUid(request.getParameter("uid"));

		mUserService.userUpdateService(user);

		System.out.println("setUpw:"+request.getParameter("upw"));
		System.out.println("setEmail:"+request.getParameter("email"));
		System.out.println("setGoogleid:"+request.getParameter("googleid"));
		System.out.println("user.setUpw:"+user.getUpw());
		System.out.println("user.setEmail:"+user.getEmail());
		System.out.println("user.setGoogleid:"+user.getGoogleid());
		return "redirect:/udetail/"+request.getParameter("uid");
	}

	@RequestMapping("/udelete/{uid}")
	private String userDelete(@PathVariable String uid) throws Exception{

		mUserService.userDeleteService(uid);

		return "redirect:/ulist";
	}





}
