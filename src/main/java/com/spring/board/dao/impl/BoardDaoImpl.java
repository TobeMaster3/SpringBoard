package com.spring.board.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.board.dao.BoardDao;
import com.spring.board.vo.BoardVo;
import com.spring.board.vo.CodeVo;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	@Autowired
	private SqlSession sqlSession;



	@Override
	public int selectBoardCnt(BoardVo boardVo) throws Exception {

		return sqlSession.selectOne("board.boardTotal", boardVo);
	}
	
	@Override
	public List<BoardVo> boardList(BoardVo boardVo) throws Exception {

		return sqlSession.selectList("board.boardList", boardVo);
	}
	
	@Override
	public BoardVo boardView(BoardVo boardVo) throws Exception {

		return sqlSession.selectOne("board.boardView", boardVo);
	}

	@Override
	public int boardInsert(BoardVo boardVo) throws Exception {

		return sqlSession.insert("board.boardInsert", boardVo);
	}

	@Override
	public int boardDelete(BoardVo boardVo) throws Exception {

		return sqlSession.delete("board.boardDelete", boardVo);
	}

	@Override
	public int boardUpdate(BoardVo boardVo) throws Exception {

		return sqlSession.update("board.boardUpdate", boardVo);
	}

	@Override
	public List<CodeVo> codeList(CodeVo codeVo) throws Exception {

		return sqlSession.selectList("board.codeList", codeVo);
	}

}
