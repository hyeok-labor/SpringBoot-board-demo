package com.example.demo.board.controller;

import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.board.domain.BoardVO;
import com.example.demo.board.domain.FileVO;
import com.example.demo.board.service.BoardService;

@Controller
public class BoardController {

	@Resource(name="com.example.demo.board.service.BoardService")
	BoardService mBoardService;

	@RequestMapping("/list") //게시판 리스트 화면 호출
	private String boardList(Model model) throws Exception{

		model.addAttribute("list", mBoardService.boardListService());

		return "list"; //생성할 jsp
	}

	@RequestMapping("/detail/{bno}")
	private String boardDetail(@PathVariable int bno, Model model) throws Exception{

		model.addAttribute("detail", mBoardService.boardDetailService(bno));

		return "detail";
	}

	@RequestMapping("/insert") //게시글 작성폼 호출
	private String boardInsertForm(){

		return "insert";
	}

	@RequestMapping("/insertProc")
	private String boardInsertProc(HttpServletRequest request, @RequestPart MultipartFile files) throws Exception{

		BoardVO board = new BoardVO();
		FileVO  file  = new FileVO();

		board.setSubject(request.getParameter("subject"));
		board.setContent(request.getParameter("content"));
		board.setWriter(request.getParameter("writer"));


		if(files.isEmpty()){ //업로드할 파일이 없을 시
			mBoardService.boardInsertService(board); //게시글 insert
		}else{
			String fileName = files.getOriginalFilename();
			String fileNameExtension = FilenameUtils.getExtension(fileName).toLowerCase();
			File destinationFile;
			String destinationFileName;
			String fileUrl = "C:/workspace/SpringBoot/demo/src/main/webapp/WEB-INF/uploadFiles/";

			do {
				destinationFileName = RandomStringUtils.randomAlphanumeric(32) + "." + fileNameExtension;
				destinationFile = new File(fileUrl+ destinationFileName);
			} while (destinationFile.exists());

			destinationFile.getParentFile().mkdirs();
			// MultipartFile.transferTo() 는 요청 시점의 임시 파일을 로컬 파일 시스템에 영구적으로 복사해줍니다. 단 한번만 실행되며 두번째 실행부터는 성공을 보장할 수 없습니다.
			files.transferTo(destinationFile);

			mBoardService.boardInsertService(board); //게시글 insert

			file.setBno(board.getBno());
			file.setFileName(destinationFileName);
			file.setFileOriName(fileName);
			file.setFileUrl(fileUrl);

			mBoardService.fileInsertService(file);//file insert
		}


		return "redirect:/list";
	}

	@RequestMapping("/update/{bno}") //게시글 수정폼 호출
	private String boardUpdateForm(@PathVariable int bno, Model model) throws Exception{

		model.addAttribute("detail", mBoardService.boardDetailService(bno));

		return "update";
	}

	@RequestMapping("/updateProc")
	private String boardUpdateProc(HttpServletRequest request) throws Exception{

		BoardVO board = new BoardVO();
		board.setSubject(request.getParameter("subject"));
		board.setContent(request.getParameter("content"));
		board.setBno(Integer.parseInt(request.getParameter("bno")));

		mBoardService.boardUpdateService(board);

		return "redirect:/detail/"+request.getParameter("bno");
	}

	@RequestMapping("/delete/{bno}")
	private String boardDelete(@PathVariable int bno) throws Exception{

		mBoardService.boardDeleteService(bno);

		return "redirect:/list";
	}
}