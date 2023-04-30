package board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.dto.BoardDto;
import board.mapper.BoardMapper;

@Service
//@Transactional
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public List<BoardDto> selectBoardList() throws Exception {
		return boardMapper.selectBoardList();
	}
	
	@Override
	public void insertBoard(BoardDto boardDto) throws Exception {
		boardMapper.insertBoard(boardDto);		
	}

	@Override
	public BoardDto selectBoardDetail(int boardIdx) throws Exception {
		boardMapper.updateHitCount(boardIdx);				// 조회수를 증가
		return boardMapper.selectBoardDetail(boardIdx);		// 게시판 상세 내용을 조회
	}

	@Override
	public void updateBoard(BoardDto boardDto) throws Exception {
		boardMapper.updateBoard(boardDto);
		
	}

	@Override
	public void deleteBoard(int boardIdx) throws Exception {
		boardMapper.deleteBoard(boardIdx);
		
	}
}
