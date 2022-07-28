package com.spring.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.board.dao.BoardDao;
import com.spring.board.service.BoardService;
import com.spring.board.vo.BoardVo;
import com.spring.board.vo.CodeVo;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardDao boardDao;

	@Override
	public int selectBoardCnt(BoardVo boardVo) throws Exception {

		return boardDao.selectBoardCnt(boardVo);
	}

	@Override
	public List<BoardVo> boardList(BoardVo boardVo) throws Exception {

		return boardDao.boardList(boardVo);
	}

	@Override
	public BoardVo boardView(String boardType, int boardNum) throws Exception {
		
		BoardVo boardVo = new BoardVo();
		
		boardVo.setBoardType(boardType);
		boardVo.setBoardNum(boardNum);
		
		return boardDao.boardView(boardVo);
	}

	@Override
	public int boardInsert(BoardVo boardVo) throws Exception {

		return boardDao.boardInsert(boardVo);
	}

	@Override
	public int boardDelete(BoardVo boardVo) throws Exception {

		return boardDao.boardDelete(boardVo);
	}

	@Override
	public int boardUpdate(BoardVo boardVo) throws Exception {

		return boardDao.boardUpdate(boardVo);
	}

	@Override
	public List<CodeVo> codeList(CodeVo codeVo) throws Exception {

		return boardDao.codeList(codeVo);
	}

}
