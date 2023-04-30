package board.service;

import java.util.List;

import board.dto.BoardDto;

public interface BoardService {

	public List<BoardDto> selectBoardList() throws Exception;
	void insertBoard(BoardDto boardDto) throws Exception;
	public BoardDto selectBoardDetail(int boardIdx) throws Exception;
	void updateBoard(BoardDto boardDto) throws Exception;
	void deleteBoard(int boardIdx) throws Exception;
}
