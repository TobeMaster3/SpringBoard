package com.spring.board.service;

import java.util.List;

import com.spring.board.vo.BoardVo;
import com.spring.board.vo.CodeVo;

public interface BoardService {
	
	public int selectBoardCnt(BoardVo boardVo) throws Exception;
	
	public List<BoardVo> boardList(BoardVo boardVo) throws Exception;
	
	public BoardVo boardView(String boardType, int boardNum) throws Exception;
	
	public int boardInsert( BoardVo boardVo ) throws Exception;
	
	public int boardDelete( BoardVo boardVo ) throws Exception;
	
	public int boardUpdate( BoardVo boardVo ) throws Exception;
	
	public List<CodeVo> codeList( CodeVo codeVo ) throws Exception;
}