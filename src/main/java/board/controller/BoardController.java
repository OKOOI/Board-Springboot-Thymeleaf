package board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.dto.BoardDto;
import board.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping("/board/openBoardList.do")
	public ModelAndView openBoardList() throws Exception {
		ModelAndView mv = new ModelAndView("/board/boardList");
		
		List<BoardDto> list = boardService.selectBoardList();
		mv.addObject("list", list);
		
		return mv;
	}
	
	// 글쓰기 페이지에 대한 요청을 처리
		@GetMapping("/board/openBoardWrite.do")
		public String openBoardWrite() throws Exception {
			return "/board/boardWrite";
		}
		
		// 글 저장 처리에 대한 요청을 처리
		@PostMapping("/board/insertBoard.do")
		public String insertBoard(BoardDto boardDto) throws Exception {
			boardService.insertBoard(boardDto);
			return "redirect:/board/openBoardList.do";
		}
		
		@GetMapping("/board/openBoardDetail.do")
		public ModelAndView openBoardDetail(@RequestParam int boardIdx) throws Exception { 	// /board/openBoardDetail.do?boardIdx=100 형태의 요청에서
			ModelAndView mv = new ModelAndView("/board/boardDetail");						// 100값을 boardIdx 변수에 맵핑
			
			BoardDto boardDto = boardService.selectBoardDetail(boardIdx);
			mv.addObject("board", boardDto);
			
			return mv;
		}
		
		@PostMapping("/board/updateBoard.do")
		public String updateBoard(BoardDto boardDto) throws Exception {
			boardService.updateBoard(boardDto);
			return "redirect:/board/openBoardList.do";
		}
		
		@PostMapping("/board/deleteBoard.do")
		public String deleteBoard(BoardDto boardDto) throws Exception {
			boardService.deleteBoard(boardDto.getBoardIdx());
			return "redirect:/board/openBoardList.do";
		}
}
