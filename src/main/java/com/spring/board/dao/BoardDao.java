package com.spring.board.dao;

import java.util.List;

import com.spring.board.vo.BoardVo;
import com.spring.board.vo.CodeVo;

public interface BoardDao {
	
	public int selectBoardCnt(BoardVo boardVo) throws Exception;
	
	public List<BoardVo> boardList(BoardVo boardVo) throws Exception;
	
	public BoardVo boardView(BoardVo boardVo) throws Exception;
	
	public int boardInsert( BoardVo boardVo ) throws Exception;
	
	public int boardDelete( BoardVo boardVo ) throws Exception;
	
	public int boardUpdate( BoardVo boardVo ) throws Exception;
	
	public List<CodeVo> codeList( CodeVo codeVo ) throws Exception;
}